package com.informatorio.streamingMusic.mapper.genero;

import com.informatorio.streamingMusic.dominio.Genero;
import com.informatorio.streamingMusic.dto.genero.GeneroDto;

public class GeneroMapper {

    public static Genero mapToGenero(GeneroDto generoDto, Genero genero){
        genero.setNombreGenero(generoDto.getNombreGenero());
        return genero;
    }

    public static GeneroDto mapToGeneroDto(Genero genero, GeneroDto generoDto){
        generoDto.setNombreGenero(genero.getNombreGenero());
        return generoDto;
    }
}
