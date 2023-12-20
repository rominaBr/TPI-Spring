package com.informatorio.streamingMusic.service.artista.impl;

import com.informatorio.streamingMusic.dominio.Artista;
import com.informatorio.streamingMusic.dto.artista.ArtistaDto;
import com.informatorio.streamingMusic.mapper.artista.ArtistaMapper;
import com.informatorio.streamingMusic.repository.artista.IArtistaRepository;
import com.informatorio.streamingMusic.service.artista.ArtistaService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ArtistaServiceImpl implements ArtistaService {

    private final IArtistaRepository artistaRepository;
    @Override
    public void crearArtista(ArtistaDto artistaDto) {

        Artista nuevoArtista = ArtistaMapper.mapToArtista(artistaDto, new Artista());
        nuevoArtista.setIdArtista(UUID.randomUUID());
        nuevoArtista.setCreadoPor("Anónimo");
        nuevoArtista.setCreadoEn(LocalDateTime.now());

        artistaRepository.save(nuevoArtista);

    }
}
