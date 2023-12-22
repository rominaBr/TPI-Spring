package com.informatorio.streamingMusic.controller.listadereproduccion;

import com.informatorio.streamingMusic.constantes.ConstantsUtils;
import com.informatorio.streamingMusic.dominio.ListaDeReproduccion;
import com.informatorio.streamingMusic.dto.listadereproduccion.ListaDeReproduccionDto;
import com.informatorio.streamingMusic.dto.respuesta.RespuestaDto;
import com.informatorio.streamingMusic.repository.listadereproduccion.ListaDeReproduccionRepository;
import com.informatorio.streamingMusic.service.listadereproduccion.ListaDeReproduccionService;
import lombok.AllArgsConstructor;
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


}
