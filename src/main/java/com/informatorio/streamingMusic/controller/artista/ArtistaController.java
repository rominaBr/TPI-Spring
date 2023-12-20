package com.informatorio.streamingMusic.controller.artista;

import com.informatorio.streamingMusic.constantes.ConstantsUtils;
import com.informatorio.streamingMusic.dto.artista.ArtistaDto;
import com.informatorio.streamingMusic.dto.respuesta.RespuestaDto;
import com.informatorio.streamingMusic.service.artista.ArtistaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping(value = "api/v1/artistas", produces = {MediaType.APPLICATION_JSON_VALUE})
public class ArtistaController {

    private final ArtistaService artistaService;
    @PostMapping
    public ResponseEntity<RespuestaDto> crearArtista(@RequestBody ArtistaDto artistaDto){

        artistaService.crearArtista(artistaDto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new RespuestaDto(ConstantsUtils.STATUS_201, ConstantsUtils.MESSAGE_201));
    }


}
