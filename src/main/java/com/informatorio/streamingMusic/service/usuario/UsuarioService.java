package com.informatorio.streamingMusic.service.usuario;

import com.informatorio.streamingMusic.dto.usuario.UsuarioDto;

import java.util.List;
import java.util.UUID;

public interface UsuarioService {

    void crearUsuario(UsuarioDto usuarioDto);

    UsuarioDto obtenerUsuarioPorId(UUID idUsuario);

    List<UsuarioDto> obtenerTodosLosUsuarios();

    boolean eliminarUsuarioPorId(UUID idUsuario);
}
