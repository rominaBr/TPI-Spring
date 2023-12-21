package com.informatorio.streamingMusic.controller.cancion;

import com.informatorio.streamingMusic.constantes.ConstantsUtils;
import com.informatorio.streamingMusic.dto.cancion.CancionDto;
import com.informatorio.streamingMusic.dto.respuesta.RespuestaDto;
import com.informatorio.streamingMusic.service.cancion.CancionService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(value = "api/v1/canciones")
public class CancionController {

    private final CancionService cancionService;
    @PostMapping
    public ResponseEntity<RespuestaDto> crearCancion(@RequestBody CancionDto cancionDto){

        cancionService.crearCancion(cancionDto);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new RespuestaDto(ConstantsUtils.STATUS_201, ConstantsUtils.MESSAGE_201));
    }

    @GetMapping("/titulo/{nombreCancion}")
    public List<CancionDto> buscarCancionPorTitulo(@PathVariable(name = "nombreCancion")String nombreCancion){
        return cancionService.buscarCancionPorTitulo(nombreCancion);
    }

    @GetMapping("/genero/{genero}")
    public List<CancionDto> buscarCancionPorGenero(@PathVariable(name = "genero")String genero){
        return cancionService.buscarCancionPorGenero(genero);
    }

    @GetMapping("/artista/{artista}")
    public List<CancionDto> buscarCancionPorArtista(@PathVariable(name = "artista")String artista){
        return cancionService.buscarCancionPorArtista(artista);
    }

    @GetMapping("/artista/ranking/{artista}")
    public List<CancionDto> buscarCancionPorArtistaOrdenadaPorRanking(@PathVariable(name = "artista")String artista){
        return cancionService.buscarCancionPorArtistaOrdenadaPorRanking(artista);
    }

    @GetMapping("/album/{album}")
    public List<CancionDto> buscarCancionPorAlbum(@PathVariable(name = "album")String album){
        return cancionService.buscarCancionPorAlbum(album);
    }
}
