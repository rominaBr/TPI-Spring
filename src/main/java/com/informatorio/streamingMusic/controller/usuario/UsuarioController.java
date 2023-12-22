package com.informatorio.streamingMusic.controller.usuario;

import com.informatorio.streamingMusic.constantes.ConstantsUtils;
import com.informatorio.streamingMusic.dominio.Usuario;
import com.informatorio.streamingMusic.dto.respuesta.RespuestaDto;
import com.informatorio.streamingMusic.dto.usuario.UsuarioDto;
import com.informatorio.streamingMusic.service.usuario.UsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping(value = "api/v1/usuarios", produces = {MediaType.APPLICATION_JSON_VALUE})
public class UsuarioController {

    private final UsuarioService usuarioService;
    @PostMapping
    public ResponseEntity<RespuestaDto> crearUsuario(@RequestBody UsuarioDto usuarioDto){

        usuarioService.crearUsuario(usuarioDto);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new RespuestaDto(ConstantsUtils.STATUS_201,ConstantsUtils.MESSAGE_201));
    }



    @GetMapping("/{idUsuario}")
    public ResponseEntity<UsuarioDto> obtenerUsuarioPorId(@PathVariable(name="idUsuario")UUID idUsuario){
        UsuarioDto usuarioDto = usuarioService.obtenerUsuarioPorId(idUsuario);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(usuarioDto);
    }

    @DeleteMapping("{idUsuario}")
    public ResponseEntity<RespuestaDto> eliminarUsuarioPorId(@PathVariable(name="idUsuario")UUID idUsuario){

        return null;
    }

}
