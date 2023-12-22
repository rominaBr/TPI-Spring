package com.informatorio.streamingMusic.service.cancion.impl;

import com.informatorio.streamingMusic.dominio.Cancion;
import com.informatorio.streamingMusic.dominio.ListaDeReproduccion;
import com.informatorio.streamingMusic.dominio.Usuario;
import com.informatorio.streamingMusic.dto.cancion.CancionDto;
import com.informatorio.streamingMusic.exception.NotFoundException;
import com.informatorio.streamingMusic.mapper.cancion.CancionMapper;
import com.informatorio.streamingMusic.repository.cancion.CancionRepository;
import com.informatorio.streamingMusic.repository.listadereproduccion.ListaDeReproduccionRepository;
import com.informatorio.streamingMusic.repository.usuario.UsuarioRepository;
import com.informatorio.streamingMusic.service.cancion.CancionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

@Service
@AllArgsConstructor
public class CancionServiceImpl implements CancionService {

    private final CancionRepository cancionRepository;
    private final ListaDeReproduccionRepository listaDeReproduccionRepository;

    @Override
    public void crearCancion(CancionDto cancionDto) {
        Cancion nuevaCancion = CancionMapper.mapToCancion(cancionDto, new Cancion());
        nuevaCancion.setIdCancion(UUID.randomUUID());
        nuevaCancion.setCreadoPor("Anónimo");
        nuevaCancion.setCreadoEn(LocalDateTime.now());

        cancionRepository.save(nuevaCancion);
    }


    @Override
    public List<CancionDto> buscarCancionPorAlbum(String album) {
        List<Cancion> canciones = cancionRepository.findAll();
        List<CancionDto> cancionesDto = new ArrayList<>();

        for(Cancion cancion: canciones){
            if(cancion.getAlbum().equals(album)){
                cancionesDto.add(CancionMapper.mapToCancionDto(cancion, new CancionDto()));
            }
        }
        return cancionesDto;
    }

    @Override
    public List<CancionDto> buscarCancionPorArtistaOrdenadaPorRanking(String artista) {

        return CancionMapper.mapToCancionesDto(cancionRepository.buscarCancionPorArtistaOrdenadaPorRanking(artista), new ArrayList<>());

    }

    @Override
    public List<CancionDto> buscarCancionesAleatorias(String titulo, String genero, String artista, String album) {
        List<Cancion> cancionesAleatorias = cancionRepository.buscarCancionesAleatorias(titulo, genero, artista, album);
        Collections.shuffle(cancionesAleatorias);
        return  CancionMapper.mapToCancionesDto(cancionesAleatorias, new ArrayList<>());
    }

    @Override
    public boolean agregarCacionesALista(UUID idLista, List<CancionDto> canciones) {
        ListaDeReproduccion listaDeReproduccion = listaDeReproduccionRepository.findById(idLista)
                .orElseThrow(() -> new NotFoundException("Lista", "idLista", idLista.toString()));

        List<Cancion> cancionesEntidad = CancionMapper.mapToCanciones(canciones, new ArrayList<>());

        cancionRepository.saveAll(cancionesEntidad);

        listaDeReproduccion.getListaDeCanciones().addAll(cancionesEntidad);

        listaDeReproduccionRepository.save(listaDeReproduccion);

        return Boolean.TRUE;
    }

    @Override
    public List<CancionDto> listarCancionesPorIdLista(UUID idLIsta) {
        ListaDeReproduccion listaDeReproduccion = listaDeReproduccionRepository.findById(idLIsta)
                .orElseThrow(() -> new NotFoundException("ListaDeReproduccion","idLista",idLIsta.toString()));

        return CancionMapper.mapToCancionesDto(listaDeReproduccion.getListaDeCanciones(), new ArrayList<>());


    }

    @Override
    public boolean eliminarCancionDeLista(UUID idLista, UUID idCancion) {
        ListaDeReproduccion listaDeReproduccion = listaDeReproduccionRepository.findById(idLista)
                .orElseThrow(()-> new NotFoundException("ListaDeReproduccion","idLista",idLista.toString()));
        List<Cancion> listaDeCanciones = listaDeReproduccion.getListaDeCanciones();
        Cancion cancionParaEliminar = null;

        for (Cancion cancion : listaDeCanciones) {
            if (cancion.getIdCancion().equals(idCancion)) {
                cancionParaEliminar = cancion;
                break;
            }
        }

        if (cancionParaEliminar != null) {
            listaDeCanciones.remove(cancionParaEliminar);

            cancionParaEliminar.getListasDeReproducciones().remove(listaDeReproduccion);

            listaDeReproduccionRepository.save(listaDeReproduccion);
            cancionRepository.save(cancionParaEliminar);

            return Boolean.TRUE;
        }

        return Boolean.FALSE;
    }


}
