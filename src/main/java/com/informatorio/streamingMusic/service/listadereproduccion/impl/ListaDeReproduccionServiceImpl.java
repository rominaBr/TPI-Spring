package com.informatorio.streamingMusic.service.listadereproduccion.impl;

import com.informatorio.streamingMusic.dominio.ListaDeReproduccion;
import com.informatorio.streamingMusic.dominio.Usuario;
import com.informatorio.streamingMusic.dto.listadereproduccion.ListaDeReproduccionDto;
import com.informatorio.streamingMusic.mapper.listadereproduccion.ListaDeReproduccionMapper;
import com.informatorio.streamingMusic.repository.listadereproduccion.ListaDeReproduccionRepository;
import com.informatorio.streamingMusic.service.listadereproduccion.ListaDeReproduccionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ListaDeReproduccionServiceImpl implements ListaDeReproduccionService {

    private final ListaDeReproduccionRepository listaDeReproduccionRepository;

    @Override
    public void crearListaDeReproduccion(ListaDeReproduccionDto listaDeReproduccionDto, Usuario usuario) {

    }

    @Override
    public ListaDeReproduccionDto buscarListaDeReproduccionPorNombre(String nombre) {
        List<ListaDeReproduccion> listasDeReproduccion = listaDeReproduccionRepository.findAll();

        for(ListaDeReproduccion lista: listasDeReproduccion){
            if(lista.getNombreLista().equals(nombre) && lista.isPublica()){
                return ListaDeReproduccionMapper.mapToListaDeReproduccionDto(lista, new ListaDeReproduccionDto());
            }
        }

        return null;
    }
}
