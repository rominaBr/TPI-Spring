package com.informatorio.streamingMusic.service.listadereproduccion.impl;

import com.informatorio.streamingMusic.dominio.Cancion;
import com.informatorio.streamingMusic.dominio.ListaDeReproduccion;
import com.informatorio.streamingMusic.dominio.Usuario;
import com.informatorio.streamingMusic.dto.cancion.CancionDto;
import com.informatorio.streamingMusic.dto.listadereproduccion.ListaDeReproduccionDto;
import com.informatorio.streamingMusic.exception.NotFoundException;
import com.informatorio.streamingMusic.mapper.cancion.CancionMapper;
import com.informatorio.streamingMusic.mapper.listadereproduccion.ListaDeReproduccionMapper;
import com.informatorio.streamingMusic.repository.listadereproduccion.ListaDeReproduccionRepository;
import com.informatorio.streamingMusic.repository.usuario.UsuarioRepository;
import com.informatorio.streamingMusic.service.listadereproduccion.ListaDeReproduccionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ListaDeReproduccionServiceImpl implements ListaDeReproduccionService {

    private final ListaDeReproduccionRepository listaDeReproduccionRepository;
    private final UsuarioRepository usuarioRepository;

    @Override
    public List<ListaDeReproduccion> crearListasDeReproduccion(List<ListaDeReproduccionDto> listasDeReproduccionDto, Usuario usuario) {
        ListaDeReproduccionMapper.mapToListasDeReproduccion(listasDeReproduccionDto, usuario.getListasDeReproduccion());

        for(int i = 0; i < listasDeReproduccionDto.size(); i++){
            usuario.getListasDeReproduccion().get(i).setIdLista(UUID.randomUUID());
            usuario.getListasDeReproduccion().get(i).setCreadoEn(LocalDateTime.now());
            usuario.getListasDeReproduccion().get(i).setCreadoPor(usuario.getNombre());
            usuario.getListasDeReproduccion().get(i).setUsuario(usuario);
        }
        return listaDeReproduccionRepository.saveAll(usuario.getListasDeReproduccion());
    }


    @Override
    public List<ListaDeReproduccionDto> buscarListaDeReproduccionPorNombre(String nombre) {
        return ListaDeReproduccionMapper.mapToListasDeReproduccionDto(listaDeReproduccionRepository.buscarListaDeReproduccionPorNombre(nombre), new ArrayList<>());

    }

    @Override
    public void agregarListaDeReproduccion(UUID idUsuario, ListaDeReproduccionDto listaDeReproduccionDto) {
        Usuario usuario = usuarioRepository.findById(idUsuario)
                .orElseThrow(()-> new NotFoundException("Usurio","idUsuario", idUsuario.toString()));

        actualizarListaDeReproduccion(listaDeReproduccionDto);
        ListaDeReproduccion nuevaLista = ListaDeReproduccionMapper.mapToListaDeReproduccion(listaDeReproduccionDto, new ListaDeReproduccion());

        nuevaLista.setUsuario(usuario);
        nuevaLista.setActualizadoEn(LocalDateTime.now());
        nuevaLista.setActualizadoPor(usuario.getNombre());
        nuevaLista.setCreadoEn(LocalDateTime.now());
        nuevaLista.setCreadoPor(usuario.getNombre());
        usuario.getListasDeReproduccion().add(nuevaLista);
        listaDeReproduccionRepository.save(nuevaLista);
        usuarioRepository.save(usuario);
    }

    @Override
    public List<ListaDeReproduccionDto> listarListasPorUsuario(UUID idUsuario) {
        return ListaDeReproduccionMapper.mapToListasDeReproduccionDto(listaDeReproduccionRepository.listarListasPorUsuario(idUsuario), new ArrayList<>());
    }

    @Override
    public void actualizarListaDeReproduccion(ListaDeReproduccionDto listaDeReproduccionDto) {

        listaDeReproduccionRepository.save(ListaDeReproduccionMapper.mapToListaDeReproduccion(listaDeReproduccionDto, new ListaDeReproduccion()));

    }

    @Override
    public boolean actualizarEstadoDeListas(UUID idLista, boolean repetir, boolean aleatoria, boolean publica) {
        ListaDeReproduccion listaDeReproduccion = listaDeReproduccionRepository.findById(idLista)
                .orElseThrow(()-> new NotFoundException("ListaDeReproduccion","idLista",idLista.toString()));
        listaDeReproduccion.setRepetir(repetir);
        listaDeReproduccion.setAleatoria(aleatoria);
        listaDeReproduccion.setPublica(publica);

        listaDeReproduccionRepository.save(listaDeReproduccion);

        return Boolean.TRUE;
    }
}
