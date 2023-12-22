package com.informatorio.streamingMusic.service.cancion;

import com.informatorio.streamingMusic.dominio.ListaDeReproduccion;
import com.informatorio.streamingMusic.dominio.Usuario;
import com.informatorio.streamingMusic.dto.cancion.CancionDto;

import java.util.List;
import java.util.UUID;

public interface CancionService {

    void crearCancion(CancionDto cancionDto);

    List<CancionDto> buscarCancionPorAlbum(String album);

    List<CancionDto> buscarCancionPorArtistaOrdenadaPorRanking(String artista);

    List<CancionDto> buscarCancionesAleatorias(String titulo, String genero, String artista, String album);

    boolean agregarCacionesAListaDeUsuario(UUID idUsuario,  UUID idLista, List<CancionDto> canciones);
    List<CancionDto> listarCancionesPorIdLista(UUID idLIsta);
}
