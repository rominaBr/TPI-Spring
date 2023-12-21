package com.informatorio.streamingMusic.mapper.usuario;

import com.informatorio.streamingMusic.dominio.Usuario;
import com.informatorio.streamingMusic.dto.usuario.UsuarioDto;

public class UsuarioMapper {

    public static Usuario mapToUsuario(UsuarioDto usuarioDto, Usuario usuario){
        usuario.setNombre(usuarioDto.getNombre());
        usuario.setNombreUsuario(usuarioDto.getNombreUsuario());
        return usuario;
    }

    public static UsuarioDto mapToUsuarioDto(Usuario usuario, UsuarioDto usuarioDto){
        usuarioDto.setNombre(usuario.getNombre());
        usuarioDto.setNombreUsuario(usuario.getNombreUsuario());
        return usuarioDto;
    }
}
