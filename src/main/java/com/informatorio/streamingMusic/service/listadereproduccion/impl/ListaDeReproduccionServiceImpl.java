package com.informatorio.streamingMusic.service.listadereproduccion.impl;

import com.informatorio.streamingMusic.dominio.Cancion;
import com.informatorio.streamingMusic.dominio.ListaDeReproduccion;
import com.informatorio.streamingMusic.dominio.Usuario;
import com.informatorio.streamingMusic.dto.cancion.CancionDto;
import com.informatorio.streamingMusic.dto.listadereproduccion.ListaDeReproduccionDto;
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
    public void crearListasDeReproduccionParaUsuario(UUID idUsuario, String nombreLista) {
        Optional<Usuario> usuario = usuarioRepository.findById(idUsuario);

        ListaDeReproduccion nuevaListaDeReproduccion = new ListaDeReproduccion();
        nuevaListaDeReproduccion.setNombreLista(nombreLista);
        nuevaListaDeReproduccion.setUsuario(usuario.get());
        nuevaListaDeReproduccion.setCreadoPor(usuario.get().getNombre());
        nuevaListaDeReproduccion.setCreadoEn(LocalDateTime.now());

        listaDeReproduccionRepository.save(nuevaListaDeReproduccion);
        usuario.get().getListasDeReproduccion().add(nuevaListaDeReproduccion);
        usuarioRepository.save(usuario.get());
    }

    @Override
    public List<ListaDeReproduccionDto> listarListasPorUsuario(UUID idUsuario) {
        return ListaDeReproduccionMapper.mapToListasDeReproduccionDto(listaDeReproduccionRepository.listarListasPorUsuario(idUsuario), new ArrayList<>());
    }
}
