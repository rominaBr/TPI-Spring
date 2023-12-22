package com.informatorio.streamingMusic.controller.cancion;

import com.informatorio.streamingMusic.constantes.ConstantsUtils;
import com.informatorio.streamingMusic.dto.cancion.CancionDto;
import com.informatorio.streamingMusic.dto.respuesta.RespuestaDto;
import com.informatorio.streamingMusic.repository.listadereproduccion.ListaDeReproduccionRepository;
import com.informatorio.streamingMusic.service.cancion.CancionService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

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

    @Transactional
    @PutMapping
    public ResponseEntity<RespuestaDto> agregarCacionesALista(
            @RequestBody List<CancionDto> cancionDto,
            @RequestParam(name="idLista")UUID idLista
            ){
        boolean fueActualizado = cancionService.agregarCacionesALista(idLista, cancionDto);

        if (fueActualizado){
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new RespuestaDto(ConstantsUtils.STATUS_200,ConstantsUtils.MESSAGE_200));
        }else {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new RespuestaDto(ConstantsUtils.STATUS_500,ConstantsUtils.MESSAGE_500));
        }
    }

    @DeleteMapping
    public ResponseEntity<RespuestaDto> eliminarCancionDeLista(
            @RequestParam(name="idLista") UUID idLista,
            @RequestParam(name="idCancion") UUID idCancion
    ){
        boolean fueEliminado = cancionService.eliminarCancionDeLista(idLista, idCancion);

        if (fueEliminado){
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new RespuestaDto(ConstantsUtils.STATUS_200,ConstantsUtils.MESSAGE_200));
        }else {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new RespuestaDto(ConstantsUtils.STATUS_500,ConstantsUtils.MESSAGE_500));
        }
    }

    @GetMapping("/artista/ranking/{artista}")
    public List<CancionDto> buscarCancionPorArtistaOrdenadaPorRanking(@PathVariable(name = "artista")String artista){
        return cancionService.buscarCancionPorArtistaOrdenadaPorRanking(artista);
    }

    @GetMapping
    public List<CancionDto> buscarCancionesAleatorias(
            @RequestParam(name="titulo", required = false) String titulo,
            @RequestParam(name="genero", required = false) String genero,
            @RequestParam(name="artista", required = false) String artista,
            @RequestParam(name="album", required = false) String album){

        return cancionService.buscarCancionesAleatorias(titulo, genero, artista,album);
    }


    @GetMapping("/album/{album}")
    public List<CancionDto> buscarCancionPorAlbum(@PathVariable(name = "album")String album){
        return cancionService.buscarCancionPorAlbum(album);
    }

    @GetMapping("{idLista}")
    public List<CancionDto> listarCancionesPorIdLista(@PathVariable(name="idLista") UUID idLIsta){
        return cancionService.listarCancionesPorIdLista(idLIsta);
    }
}
