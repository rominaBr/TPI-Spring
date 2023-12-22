package com.informatorio.streamingMusic.service.listadereproduccion;


import com.informatorio.streamingMusic.dominio.ListaDeReproduccion;
import com.informatorio.streamingMusic.dominio.Usuario;
import com.informatorio.streamingMusic.dto.listadereproduccion.ListaDeReproduccionDto;

import java.util.List;
import java.util.UUID;

public interface ListaDeReproduccionService {

    List<ListaDeReproduccion> crearListasDeReproduccion(List<ListaDeReproduccionDto> listasDeReproduccionDto, Usuario usuario);

    List<ListaDeReproduccionDto> buscarListaDeReproduccionPorNombre(String nombre);


    void agregarListaDeReproduccion(UUID idUsusario, ListaDeReproduccionDto listaDeReproduccionDto);

    List<ListaDeReproduccionDto> listarListasPorUsuario(UUID idUsuario);

    void actualizarListaDeReproduccion(ListaDeReproduccionDto listaDeReproduccionDto);

    boolean actualizarEstadoDeListas(UUID idLista, boolean repetir, boolean aleatoria, boolean publica);
}
