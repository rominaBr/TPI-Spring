package com.informatorio.streamingMusic.mapper.cancion;

import com.informatorio.streamingMusic.dominio.Artista;
import com.informatorio.streamingMusic.dominio.Cancion;
import com.informatorio.streamingMusic.dominio.Genero;
import com.informatorio.streamingMusic.dto.artista.ArtistaDto;
import com.informatorio.streamingMusic.dto.cancion.CancionDto;
import com.informatorio.streamingMusic.dto.genero.GeneroDto;
import com.informatorio.streamingMusic.mapper.artista.ArtistaMapper;
import com.informatorio.streamingMusic.mapper.genero.GeneroMapper;

import java.util.Collection;
import java.util.List;

public class CancionMapper {

    public static Cancion mapToCancion(CancionDto cancionDto, Cancion cancion){
        cancion.setNombreCancion(cancionDto.getNombreCancion());
        cancion.setDuracion(cancionDto.getDuracion());
        cancion.setRanking(cancionDto.getRanking());
        cancion.setArtista(ArtistaMapper.mapToArtista(cancionDto.getArtistaDto(), new Artista()));
        cancion.setGenero(GeneroMapper.mapToGenero(cancionDto.getGeneroDto(), new Genero()));
        cancion.setAlbum(cancionDto.getAlbum());

        return cancion;
    }

    public static List<Cancion> mapToCanciones(Collection<CancionDto> cancionDtos, Collection<Cancion> canciones){
        for (CancionDto cancionDto: cancionDtos) {
            canciones.add(
                    mapToCancion(cancionDto,new Cancion())
            );
        }
        return (List<Cancion>) canciones;
    }

    public static List<CancionDto> mapToCancionesDto(Collection<Cancion> canciones, Collection<CancionDto> cancionesDto){
        for (Cancion cancion: canciones) {
            cancionesDto.add(
                    mapToCancionDto(cancion,new CancionDto())
            );
        }
        return (List<CancionDto>) cancionesDto;
    }

    public static CancionDto mapToCancionDto(Cancion cancion, CancionDto cancionDto){
        cancionDto.setNombreCancion(cancion.getNombreCancion());
        cancionDto.setDuracion(cancion.getDuracion());
        cancionDto.setRanking(cancion.getRanking());
        cancionDto.setArtistaDto(ArtistaMapper.mapToArtistaDto(cancion.getArtista(), new ArtistaDto()));
        cancionDto.setGeneroDto(GeneroMapper.mapToGeneroDto(cancion.getGenero(), new GeneroDto()));
        cancionDto.setAlbum(cancion.getAlbum());

        return cancionDto;
    }
}
