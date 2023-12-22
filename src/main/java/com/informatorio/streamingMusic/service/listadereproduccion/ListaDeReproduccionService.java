package com.informatorio.streamingMusic.service.listadereproduccion;


import com.informatorio.streamingMusic.dominio.ListaDeReproduccion;
import com.informatorio.streamingMusic.dominio.Usuario;
import com.informatorio.streamingMusic.dto.listadereproduccion.ListaDeReproduccionDto;

import java.util.List;

public interface ListaDeReproduccionService {

    List<ListaDeReproduccion> crearListasDeReproduccion(List<ListaDeReproduccionDto> listasDeReproduccionDto, Usuario usuario);

    List<ListaDeReproduccionDto> buscarListaDeReproduccionPorNombre(String nombre);


}
