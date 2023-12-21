package com.informatorio.streamingMusic.service.genero.impl;

import com.informatorio.streamingMusic.dominio.Genero;
import com.informatorio.streamingMusic.dto.genero.GeneroDto;
import com.informatorio.streamingMusic.mapper.genero.GeneroMapper;
import com.informatorio.streamingMusic.repository.genero.GeneroRepository;
import com.informatorio.streamingMusic.service.genero.GeneroService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@AllArgsConstructor
public class GeneroServiceImpl implements GeneroService {

    private final GeneroRepository generoRepository;
    @Override
    public void crearGenero(GeneroDto generoDto) {

        Genero nuevoGenero = GeneroMapper.mapToGenero(generoDto, new Genero());
        nuevoGenero.setIdGenero(UUID.randomUUID());
        nuevoGenero.setCreadoPor("Anónimo");
        nuevoGenero.setCreadoEn(LocalDateTime.now());

        generoRepository.save(nuevoGenero);

    }
}
