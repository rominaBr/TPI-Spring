package com.informatorio.streamingMusic.mapper.usuario;

import com.informatorio.streamingMusic.dominio.Usuario;
import com.informatorio.streamingMusic.dto.usuario.UsuarioDto;
import com.informatorio.streamingMusic.mapper.listadereproduccion.ListaDeReproduccionMapper;

import java.util.ArrayList;

public class UsuarioMapper {

    public static Usuario mapToUsuario(UsuarioDto usuarioDto, Usuario usuario){
        usuario.setNombre(usuarioDto.getNombre());
        usuario.setNombreUsuario(usuarioDto.getNombreUsuario());
        usuario.setListasDeReproduccion(
                ListaDeReproduccionMapper.mapToListasDeReproduccion(usuarioDto.getListasDeReproduccionDto(), new ArrayList<>())
        );
        return usuario;
    }

    public static UsuarioDto mapToUsuarioDto(Usuario usuario, UsuarioDto usuarioDto){
        usuarioDto.setNombre(usuario.getNombre());
        usuarioDto.setNombreUsuario(usuario.getNombreUsuario());
        usuarioDto.setListasDeReproduccionDto(
                ListaDeReproduccionMapper.mapToListasDeReproduccionDto(usuario.getListasDeReproduccion(), new ArrayList<>())
        );
        return usuarioDto;
    }
}
