package com.informatorio.streamingMusic.controller.listadereproduccion;

import com.informatorio.streamingMusic.constantes.ConstantsUtils;
import com.informatorio.streamingMusic.dominio.ListaDeReproduccion;
import com.informatorio.streamingMusic.dto.listadereproduccion.ListaDeReproduccionDto;
import com.informatorio.streamingMusic.dto.respuesta.RespuestaDto;
import com.informatorio.streamingMusic.repository.listadereproduccion.ListaDeReproduccionRepository;
import com.informatorio.streamingMusic.service.listadereproduccion.ListaDeReproduccionService;
import lombok.AllArgsConstructor;
import org.hibernate.validator.cfg.defs.UUIDDef;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping(value = "api/v1/listas", produces = {MediaType.APPLICATION_JSON_VALUE})
public class ListaDeReproduccionController {

    private final ListaDeReproduccionService listaDeReproduccionService;

    @GetMapping
    @ResponseBody
    public List<ListaDeReproduccionDto> buscarListaDeReproduccionPorNombre(
            @RequestParam(name = "nombre", required = false) String nombre){
        return listaDeReproduccionService.buscarListaDeReproduccionPorNombre(nombre);
    }

    @GetMapping("/{idUsuario}")
    public List<ListaDeReproduccionDto> listarListasPorUsuario(@PathVariable(name="idUsuario")UUID idUsuario){
        return listaDeReproduccionService.listarListasPorUsuario(idUsuario);
    }

    @PutMapping("{idUsuario}")
    public ResponseEntity<RespuestaDto> agregarListaDeReproduccion(
            @PathVariable(name="idUsuario")UUID idLista,
            @RequestBody ListaDeReproduccionDto listaDeReproduccionDto){
        listaDeReproduccionService.agregarListaDeReproduccion(idLista, listaDeReproduccionDto);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new RespuestaDto(ConstantsUtils.STATUS_201,ConstantsUtils.MESSAGE_201));
    }

    @PutMapping("/estados/{idLista}")
    public ResponseEntity<RespuestaDto> actulizarEstadosDeListas(
            @PathVariable(name="idLista")UUID idLista,
            @RequestParam(name="repetir") boolean repetir,
            @RequestParam(name="aleatoria") boolean aleatoria ,
            @RequestParam(name="publica") boolean publica
    ){
        boolean fueActualizado = listaDeReproduccionService.actualizarEstadoDeListas(idLista,repetir, aleatoria, publica);

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


}
