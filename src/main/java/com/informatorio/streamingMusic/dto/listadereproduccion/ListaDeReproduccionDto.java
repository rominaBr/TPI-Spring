package com.informatorio.streamingMusic.dto.listadereproduccion;

import com.informatorio.streamingMusic.dominio.Cancion;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
public class ListaDeReproduccionDto {

    private UUID idLista;

    private String nombreLista;

    private int cantidadCanciones;

}
