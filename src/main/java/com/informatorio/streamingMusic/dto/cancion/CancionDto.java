package com.informatorio.streamingMusic.dto.cancion;

import com.informatorio.streamingMusic.dominio.Artista;
import com.informatorio.streamingMusic.dominio.Genero;
import com.informatorio.streamingMusic.dto.artista.ArtistaDto;
import com.informatorio.streamingMusic.dto.genero.GeneroDto;
import lombok.Data;

@Data
public class CancionDto {

    private String nombreCancion;

    private double duracion;

    private int ranking;

    private ArtistaDto artistaDto;

    private GeneroDto generoDto;

}
