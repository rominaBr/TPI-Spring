package com.informatorio.streamingMusic.service.cancion;

import com.informatorio.streamingMusic.dto.cancion.CancionDto;

import java.util.List;

public interface CancionService {

    void crearCancion(CancionDto cancionDto);

    List<CancionDto> buscarCancionPorTitulo(String nombreCancion);

    List<CancionDto> buscarCancionPorGenero(String genero);

    List<CancionDto> buscarCancionPorArtista(String artista);

    List<CancionDto> buscarCancionPorAlbum(String album);

    List<CancionDto> buscarCancionPorArtistaOrdenadaPorRanking(String artista);

    List<CancionDto> buscarCancionesAleatorias(String titulo, String genero, String artista, String album);
}
