package com.informatorio.streamingMusic.mapper.listadereproduccion;

import com.informatorio.streamingMusic.dominio.ListaDeReproduccion;
import com.informatorio.streamingMusic.dto.listadereproduccion.ListaDeReproduccionDto;

public class ListaDeReproduccionMapper {

    public static ListaDeReproduccion mapToListaDeReproduccion(ListaDeReproduccionDto listaDeReproduccionDto, ListaDeReproduccion listaDeReproduccion){
        listaDeReproduccion.setNombreLista(listaDeReproduccionDto.getNombreLista());
        listaDeReproduccion.setIdLista(listaDeReproduccionDto.getIdLista());

        return listaDeReproduccion;
    }

    public static ListaDeReproduccionDto mapToListaDeReproduccionDto(ListaDeReproduccion listaDeReproduccion, ListaDeReproduccionDto listaDeReproduccionDto){
        listaDeReproduccionDto.setIdLista(listaDeReproduccion.getIdLista());
        listaDeReproduccionDto.setNombreLista(listaDeReproduccion.getNombreLista());
        listaDeReproduccionDto.setCantidadCanciones(listaDeReproduccion.getListaDeCanciones().size());

        return listaDeReproduccionDto;
    }

}
