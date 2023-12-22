package com.informatorio.streamingMusic.service.cancion.impl;

import com.informatorio.streamingMusic.dominio.Cancion;
import com.informatorio.streamingMusic.dto.cancion.CancionDto;
import com.informatorio.streamingMusic.mapper.cancion.CancionMapper;
import com.informatorio.streamingMusic.repository.cancion.CancionRepository;
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
    private final UsuarioRepository usuarioRepository;

    @Override
    public void crearCancion(CancionDto cancionDto) {
        Cancion nuevaCancion = CancionMapper.mapToCancion(cancionDto, new Cancion());
        nuevaCancion.setIdCancion(UUID.randomUUID());
        nuevaCancion.setCreadoPor("Anónimo");
        nuevaCancion.setCreadoEn(LocalDateTime.now());

        cancionRepository.save(nuevaCancion);
    }

    @Override
    public List<CancionDto> buscarCancionPorTitulo(String nombreCancion) {
        List<Cancion> canciones = cancionRepository.findAll();
        List<CancionDto> cancionesDto = new ArrayList<>();

        for(Cancion cancion: canciones){
            if(cancion.getNombreCancion().equals(nombreCancion)){
                cancionesDto.add(CancionMapper.mapToCancionDto(cancion, new CancionDto()));
            }
        }
        return cancionesDto;
    }

    @Override
    public List<CancionDto> buscarCancionPorGenero(String genero) {
        List<Cancion> canciones = cancionRepository.findAll();
        List<CancionDto> cancionesDto = new ArrayList<>();

        for(Cancion cancion: canciones){
            if(cancion.getGenero().getNombreGenero().equals(genero)){
                cancionesDto.add(CancionMapper.mapToCancionDto(cancion, new CancionDto()));
            }
        }
        return cancionesDto;
    }

    @Override
    public List<CancionDto> buscarCancionPorArtista(String artista) {
        List<Cancion> canciones = cancionRepository.findAll();
        List<CancionDto> cancionesDto = new ArrayList<>();

        for(Cancion cancion: canciones){
            if(cancion.getArtista().getNombreArtista().equals(artista)){
                cancionesDto.add(CancionMapper.mapToCancionDto(cancion, new CancionDto()));
            }
        }
        return cancionesDto;
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


}
