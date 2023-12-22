package com.informatorio.streamingMusic.service.listadereproduccion;


import com.informatorio.streamingMusic.dominio.ListaDeReproduccion;
import com.informatorio.streamingMusic.dominio.Usuario;
import com.informatorio.streamingMusic.dto.listadereproduccion.ListaDeReproduccionDto;

import java.util.List;
import java.util.UUID;

public interface ListaDeReproduccionService {

    List<ListaDeReproduccion> crearListasDeReproduccion(List<ListaDeReproduccionDto> listasDeReproduccionDto, Usuario usuario);

    List<ListaDeReproduccionDto> buscarListaDeReproduccionPorNombre(String nombre);


    void crearListasDeReproduccionParaUsuario(UUID idUsuario, String nombreLista);

    List<ListaDeReproduccionDto> listarListasPorUsuario(UUID idUsuario);
}
