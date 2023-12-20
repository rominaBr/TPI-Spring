package com.informatorio.streamingMusic.mapper.artista;

import com.informatorio.streamingMusic.dominio.Artista;
import com.informatorio.streamingMusic.dto.artista.ArtistaDto;

public class ArtistaMapper {

    public static Artista mapToArtista(ArtistaDto artistaDto, Artista artista){
        artista.setNombreArtista(artistaDto.getNombreArtista());
        return artista;
    }

    public static ArtistaDto mapToArtistaDto(Artista artista, ArtistaDto artistaDto){
        artistaDto.setNombreArtista(artista.getNombreArtista());
        return artistaDto;
    }
}
