package com.informatorio.streamingMusic.mapper.listadereproduccion;

import com.informatorio.streamingMusic.dominio.ListaDeReproduccion;
import com.informatorio.streamingMusic.dto.listadereproduccion.ListaDeReproduccionDto;

import java.util.Collection;
import java.util.List;

public class ListaDeReproduccionMapper {

    public static ListaDeReproduccion mapToListaDeReproduccion(ListaDeReproduccionDto listaDeReproduccionDto, ListaDeReproduccion listaDeReproduccion){
        listaDeReproduccion.setNombreLista(listaDeReproduccionDto.getNombreLista());
        listaDeReproduccion.setIdLista(listaDeReproduccionDto.getIdLista());
        listaDeReproduccion.setRepetir(listaDeReproduccionDto.isRepetir());
        listaDeReproduccion.setAleatoria(listaDeReproduccionDto.isAleatoria());
        listaDeReproduccion.setPublica(listaDeReproduccionDto.isPublica());

        return listaDeReproduccion;
    }

    public static ListaDeReproduccionDto mapToListaDeReproduccionDto(ListaDeReproduccion listaDeReproduccion, ListaDeReproduccionDto listaDeReproduccionDto){
        listaDeReproduccionDto.setIdLista(listaDeReproduccion.getIdLista());
        listaDeReproduccionDto.setNombreLista(listaDeReproduccion.getNombreLista());
        listaDeReproduccionDto.setCantidadCanciones(listaDeReproduccion.getListaDeCanciones().size());
        listaDeReproduccionDto.setRepetir(listaDeReproduccionDto.isRepetir());
        listaDeReproduccionDto.setAleatoria(listaDeReproduccionDto.isAleatoria());
        listaDeReproduccionDto.setPublica(listaDeReproduccionDto.isPublica());

        return listaDeReproduccionDto;
    }

    public static List<ListaDeReproduccion> mapToListasDeReproduccion(Collection<ListaDeReproduccionDto> listasDeReproduccionDto, Collection<ListaDeReproduccion> listasDeReproduccion){

        for(ListaDeReproduccionDto listaDeReproduccionDto: listasDeReproduccionDto){
            listasDeReproduccion.add(
                    mapToListaDeReproduccion(listaDeReproduccionDto, new ListaDeReproduccion())
            );
        }

        return (List<ListaDeReproduccion>)listasDeReproduccion;
    }

    public static List<ListaDeReproduccionDto> mapToListasDeReproduccionDto(Collection<ListaDeReproduccion> listasDeReproduccion, Collection<ListaDeReproduccionDto> listasDeReproduccionDto){
        for(ListaDeReproduccion listaDeReproduccion: listasDeReproduccion){
            listasDeReproduccionDto.add(
                    mapToListaDeReproduccionDto(listaDeReproduccion, new ListaDeReproduccionDto())
            );
        }

        return (List<ListaDeReproduccionDto>)listasDeReproduccionDto;
    }

}
