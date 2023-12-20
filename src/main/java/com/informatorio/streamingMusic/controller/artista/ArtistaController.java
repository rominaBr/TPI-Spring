package com.informatorio.streamingMusic.controller.artista;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/v1/artistas", produces = {MediaType.APPLICATION_JSON_VALUE})
public class ArtistaController {


}
