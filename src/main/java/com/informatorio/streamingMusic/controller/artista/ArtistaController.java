package com.informatorio.streamingMusic.controller.artista;

import com.informatorio.streamingMusic.constantes.ConstantsUtils;
import com.informatorio.streamingMusic.dto.artista.ArtistaDto;
import com.informatorio.streamingMusic.dto.respuesta.RespuestaDto;
import com.informatorio.streamingMusic.service.artista.ArtistaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

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

    @GetMapping("/{idArtista}")
    public ResponseEntity<ArtistaDto> buscarArtistaPorId(@PathVariable(name="idArtista")UUID idArtista){
        ArtistaDto artistaDto = artistaService.buscarArtistaPorId(idArtista);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(artistaDto);
    }



}
