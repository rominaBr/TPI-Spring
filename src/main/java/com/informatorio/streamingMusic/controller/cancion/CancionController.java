package com.informatorio.streamingMusic.controller.cancion;

import com.informatorio.streamingMusic.constantes.ConstantsUtils;
import com.informatorio.streamingMusic.dto.cancion.CancionDto;
import com.informatorio.streamingMusic.dto.respuesta.RespuestaDto;
import com.informatorio.streamingMusic.service.cancion.CancionService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping(value = "api/v1/canciones")
public class CancionController {

    private final CancionService cancionService;
    @PostMapping
    public ResponseEntity crearCancion(@RequestBody CancionDto cancionDto){

        cancionService.crearCancion(cancionDto);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new RespuestaDto(ConstantsUtils.STATUS_201, ConstantsUtils.MESSAGE_201));
    }
}
