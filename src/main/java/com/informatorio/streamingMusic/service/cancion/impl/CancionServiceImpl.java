package com.informatorio.streamingMusic.service.cancion.impl;

import com.informatorio.streamingMusic.dominio.*;
import com.informatorio.streamingMusic.dto.artista.ArtistaDto;
import com.informatorio.streamingMusic.dto.cancion.CancionDto;
import com.informatorio.streamingMusic.exception.NotFoundException;
import com.informatorio.streamingMusic.mapper.artista.ArtistaMapper;
import com.informatorio.streamingMusic.mapper.cancion.CancionMapper;
import com.informatorio.streamingMusic.mapper.genero.GeneroMapper;
import com.informatorio.streamingMusic.repository.artista.ArtistaRepository;
import com.informatorio.streamingMusic.repository.cancion.CancionRepository;
import com.informatorio.streamingMusic.repository.genero.GeneroRepository;
import com.informatorio.streamingMusic.repository.listadereproduccion.ListaDeReproduccionRepository;
import com.informatorio.streamingMusic.repository.usuario.UsuarioRepository;
import com.informatorio.streamingMusic.service.cancion.CancionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

@Service
@AllArgsConstructor
public class CancionServiceImpl implements CancionService {

    private final CancionRepository cancionRepository;
    private final ListaDeReproduccionRepository listaDeReproduccionRepository;
    private final ArtistaRepository artistaRepository;
    private final GeneroRepository generoRepository;


    @Override
    public void crearCancion(CancionDto cancionDto){
        Cancion nuevaCancion = new Cancion();
        Optional<Artista> artista = artistaRepository.buscarArtistaPorNombre(cancionDto.getArtistaDto().getNombreArtista());
        if(artista.isPresent()){
            nuevaCancion.setArtista(artista.get());
        }else{
            nuevaCancion.setArtista(ArtistaMapper.mapToArtista(cancionDto.getArtistaDto(), new Artista()));
        }
        Optional<Genero> genero = generoRepository.buscarGeneroPorNombre(cancionDto.getGeneroDto().getNombreGenero());
        if(genero.isPresent()){
            nuevaCancion.setGenero(genero.get());
        }else{
            nuevaCancion.setGenero(GeneroMapper.mapToGenero(cancionDto.getGeneroDto(), new Genero()));
        }
        nuevaCancion.setNombreCancion(cancionDto.getNombreCancion());
        nuevaCancion.setDuracion(cancionDto.getDuracion());
        nuevaCancion.setRanking(cancionDto.getRanking());
        nuevaCancion.setAlbum(cancionDto.getAlbum());

        nuevaCancion.setIdCancion(UUID.randomUUID());
        nuevaCancion.setCreadoPor("Anónimo");
        nuevaCancion.setCreadoEn(LocalDateTime.now());

        cancionRepository.save(nuevaCancion);

    }
    @Override
    public List<CancionDto> buscarCancionPorAlbum(String album){
        return CancionMapper.mapToCancionesDto(cancionRepository.buscarCancionPorAlbum(album), new ArrayList<>());
    }

    @Override
    public List<CancionDto> buscarCancionPorArtistaOrdenadaPorRanking(String artista) {

        return CancionMapper.mapToCancionesDto(cancionRepository.buscarCancionPorArtistaOrdenadaPorRanking(artista), new ArrayList<>());

    }

    @Override
    public List<CancionDto> buscarCancionesAleatorias(String titulo, String genero, String artista, String album) {
        List<Cancion> cancionesAleatorias = cancionRepository.buscarCancionesAleatorias(titulo, genero, artista, album);
        Collections.shuffle(cancionesAleatorias);
        return  CancionMapper.mapToCancionesDto(cancionesAleatorias, new ArrayList<>());
    }


    @Override
    public boolean agregarCacionesALista(UUID idLista, List<CancionDto> cancionesDto) {
        ListaDeReproduccion listaDeReproduccion = listaDeReproduccionRepository.findById(idLista)
                .orElseThrow(() -> new NotFoundException("Lista", "idLista", idLista.toString()));


        List<Cancion> canciones = new ArrayList<>();

        for(CancionDto cancionDto: cancionesDto){
            crearCancion(cancionDto);
        }

        listaDeReproduccion.getListaDeCanciones().addAll(canciones);

        listaDeReproduccionRepository.save(listaDeReproduccion);

        return Boolean.TRUE;
    }

    @Override
    public List<CancionDto> listarCancionesPorIdLista(UUID idLIsta) {
        ListaDeReproduccion listaDeReproduccion = listaDeReproduccionRepository.findById(idLIsta)
                .orElseThrow(() -> new NotFoundException("ListaDeReproduccion","idLista",idLIsta.toString()));

        return CancionMapper.mapToCancionesDto(listaDeReproduccion.getListaDeCanciones(), new ArrayList<>());


    }

    @Override
    public boolean eliminarCancionDeLista(UUID idLista, UUID idCancion) {
        ListaDeReproduccion listaDeReproduccion = listaDeReproduccionRepository.findById(idLista)
                .orElseThrow(()-> new NotFoundException("ListaDeReproduccion","idLista",idLista.toString()));
        List<Cancion> listaDeCanciones = listaDeReproduccion.getListaDeCanciones();
        Cancion cancionAEliminar = null;

        for (Cancion cancion : listaDeCanciones) {
            if (cancion.getIdCancion().equals(idCancion)) {
                cancionAEliminar = cancion;
                break;
            }
        }

        if (cancionAEliminar != null) {
            listaDeCanciones.remove(cancionAEliminar);

            cancionAEliminar.getListasDeReproducciones().remove(listaDeReproduccion);

            listaDeReproduccionRepository.save(listaDeReproduccion);
            cancionRepository.save(cancionAEliminar);

            return Boolean.TRUE;
        }

        return Boolean.FALSE;
    }


}
