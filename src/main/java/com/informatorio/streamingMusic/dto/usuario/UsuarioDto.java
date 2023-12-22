package com.informatorio.streamingMusic.dto.usuario;

import com.informatorio.streamingMusic.dominio.ListaDeReproduccion;
import com.informatorio.streamingMusic.dto.listadereproduccion.ListaDeReproduccionDto;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class UsuarioDto {

    private String nombre;

    private String nombreUsuario;

    private List<ListaDeReproduccionDto> listasDeReproduccionDto = new ArrayList<>();

}
