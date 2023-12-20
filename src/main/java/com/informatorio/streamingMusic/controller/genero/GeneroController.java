package com.informatorio.streamingMusic.controller.genero;

import com.informatorio.streamingMusic.constantes.ConstantsUtils;
import com.informatorio.streamingMusic.dto.genero.GeneroDto;
import com.informatorio.streamingMusic.dto.respuesta.RespuestaDto;
import com.informatorio.streamingMusic.service.genero.GeneroService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping(value = "api/v1/generos", produces = {MediaType.APPLICATION_JSON_VALUE})
public class GeneroController {

    private final GeneroService generoService;
    @PostMapping
    public ResponseEntity crearGenero(@RequestBody GeneroDto generoDto){
        generoService.crearGenero(generoDto);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new RespuestaDto(ConstantsUtils.STATUS_201, ConstantsUtils.MESSAGE_201));
    }
}
