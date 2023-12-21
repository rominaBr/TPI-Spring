package com.informatorio.streamingMusic.controller.listadereproduccion;

import com.informatorio.streamingMusic.dto.listadereproduccion.ListaDeReproduccionDto;
import com.informatorio.streamingMusic.repository.listadereproduccion.ListaDeReproduccionRepository;
import com.informatorio.streamingMusic.service.listadereproduccion.ListaDeReproduccionService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping(value = "api/v1/listas", produces = {MediaType.APPLICATION_JSON_VALUE})
public class ListaDeReproduccionController {

    private final ListaDeReproduccionService listaDeReproduccionService;
    @GetMapping("/{nombreLista}")
    public ResponseEntity<ListaDeReproduccionDto> buscarListaDeReproduccionPorNombre(@PathVariable(name="nombreLista")String nombreLista){
        ListaDeReproduccionDto listaDeReproduccionDto = listaDeReproduccionService.buscarListaDeReproduccionPorNombre(nombreLista);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(listaDeReproduccionDto);
    }

}
