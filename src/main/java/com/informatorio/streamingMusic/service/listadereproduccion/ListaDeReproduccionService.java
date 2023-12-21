package com.informatorio.streamingMusic.service.listadereproduccion;


import com.informatorio.streamingMusic.dominio.Usuario;
import com.informatorio.streamingMusic.dto.listadereproduccion.ListaDeReproduccionDto;

public interface ListaDeReproduccionService {

    void crearListaDeReproduccion(ListaDeReproduccionDto listaDeReproduccionDto, Usuario usuario);

    ListaDeReproduccionDto buscarListaDeReproduccionPorNombre(String nombre);


}
