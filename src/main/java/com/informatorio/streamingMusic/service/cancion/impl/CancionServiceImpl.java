package com.informatorio.streamingMusic.service.cancion.impl;

import com.informatorio.streamingMusic.dominio.Cancion;
import com.informatorio.streamingMusic.dto.cancion.CancionDto;
import com.informatorio.streamingMusic.mapper.cancion.CancionMapper;
import com.informatorio.streamingMusic.repository.cancion.ICancionRepository;
import com.informatorio.streamingMusic.service.cancion.CancionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@AllArgsConstructor
public class CancionServiceImpl implements CancionService {

    private final ICancionRepository cancionRepository;
    @Override
    public void crearCancion(CancionDto cancionDto) {
        Cancion nuevaCancion = CancionMapper.mapToCancion(cancionDto, new Cancion());
        nuevaCancion.setIdCancion(UUID.randomUUID());
        nuevaCancion.setCreadoPor("Anónimo");
        nuevaCancion.setCreadoEn(LocalDateTime.now());

        cancionRepository.save(nuevaCancion);
    }
}
