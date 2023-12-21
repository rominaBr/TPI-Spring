package com.informatorio.streamingMusic.dto.usuario;

import com.informatorio.streamingMusic.dominio.ListaDeReproduccion;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class UsuarioDto {

    private String nombre;

    private String nombreUsuario;

    private List<ListaDeReproduccion> listasDeReproduccion = new ArrayList<>();

}
