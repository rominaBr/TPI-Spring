package com.informatorio.streamingMusic.mapper.cancion;

import com.informatorio.streamingMusic.dominio.Artista;
import com.informatorio.streamingMusic.dominio.Cancion;
import com.informatorio.streamingMusic.dominio.Genero;
import com.informatorio.streamingMusic.dto.artista.ArtistaDto;
import com.informatorio.streamingMusic.dto.cancion.CancionDto;
import com.informatorio.streamingMusic.dto.genero.GeneroDto;
import com.informatorio.streamingMusic.mapper.artista.ArtistaMapper;
import com.informatorio.streamingMusic.mapper.genero.GeneroMapper;

public class CancionMapper {

    public static Cancion mapToCancion(CancionDto cancionDto, Cancion cancion){
        cancion.setNombreCancion(cancionDto.getNombreCancion());
        cancion.setDuracion(cancionDto.getDuracion());
        cancion.setRanking(cancionDto.getRanking());
        cancion.setArtista(ArtistaMapper.mapToArtista(cancionDto.getArtistaDto(), new Artista()));
        cancion.setGenero(GeneroMapper.mapToGenero(cancionDto.getGeneroDto(), new Genero()));

        return cancion;
    }

    public static CancionDto mapToCancionDto(Cancion cancion, CancionDto cancionDto){
        cancionDto.setNombreCancion(cancion.getNombreCancion());
        cancionDto.setDuracion(cancion.getDuracion());
        cancionDto.setRanking(cancion.getRanking());
        //cancionDto.setArtista(ArtistaMapper.mapToArtistaDto(cancion.getArtista(), new ArtistaDto()));
        //cancionDto.setGenero(GeneroMapper.mapToGeneroDto(cancion.getGenero(), new GeneroDto()));

        return cancionDto;
    }
}
