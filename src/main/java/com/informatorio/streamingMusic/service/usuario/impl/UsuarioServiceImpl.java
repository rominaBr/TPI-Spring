package com.informatorio.streamingMusic.service.usuario.impl;

import com.informatorio.streamingMusic.dominio.Usuario;
import com.informatorio.streamingMusic.dto.usuario.UsuarioDto;
import com.informatorio.streamingMusic.exception.GlobalExceptionHandler;
import com.informatorio.streamingMusic.exception.NotFoundException;
import com.informatorio.streamingMusic.mapper.usuario.UsuarioMapper;
import com.informatorio.streamingMusic.repository.usuario.UsuarioRepository;
import com.informatorio.streamingMusic.service.usuario.UsuarioService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;


import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;

    @Override
    public void crearUsuario(UsuarioDto usuarioDto) {
        Usuario nuevoUsuario = UsuarioMapper.mapToUsuario(usuarioDto, new Usuario());
        nuevoUsuario.setIdUsuario(UUID.randomUUID());
        nuevoUsuario.setCreadoPor("Anónimo");
        nuevoUsuario.setCreadoEn(LocalDateTime.now());
        try {
            usuarioRepository.save(nuevoUsuario);
        }
        catch (DataIntegrityViolationException e){
            throw e;
        }


    }

    @Override
    public UsuarioDto obtenerUsuarioPorId(UUID idUsuario) {
        Usuario usuario = usuarioRepository.findById(idUsuario)
                .orElseThrow(()-> new NotFoundException("Usuario","idUsuario",idUsuario.toString()));

        UsuarioDto usuarioDto = UsuarioMapper.mapToUsuarioDto(usuario, new UsuarioDto());
        //cargar listas de reproduccion

        return usuarioDto;
    }

    @Override
    public List<UsuarioDto> obtenerTodosLosUsuarios() {

        return null;
    }

    @Override
    public boolean eliminarUsuarioPorId(UUID idUsuario) {
        Usuario usuario = usuarioRepository.findById(idUsuario)
                .orElseThrow(()-> new NotFoundException("Usuario","idUsuario",idUsuario.toString()));
        return false;
    }
}
