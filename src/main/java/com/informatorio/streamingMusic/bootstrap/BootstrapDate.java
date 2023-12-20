package com.informatorio.streamingMusic.bootstrap;

import com.informatorio.streamingMusic.dominio.*;
import com.informatorio.streamingMusic.repository.artista.IArtistaRepository;
import com.informatorio.streamingMusic.repository.cancion.ICancionRepository;
import com.informatorio.streamingMusic.repository.genero.IGeneroRepository;
import com.informatorio.streamingMusic.repository.listadereproduccion.IListaDeReproduccionRepository;
import com.informatorio.streamingMusic.repository.usuario.IUsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@AllArgsConstructor
public class BootstrapDate implements CommandLineRunner {

    private IUsuarioRepository usuarioRepository;

    private IArtistaRepository artistaRepository;

    private ICancionRepository cancionRepository;

    private IGeneroRepository generoRepository;

    private IListaDeReproduccionRepository listaDeReproduccionRepository;

    @Override
    public void run(String... args) throws Exception {
        cargarArtistas();
        cargarGeneros();
        cargarCanciones();
        cargarUsuario();
        cargarListasReproduccion();
    }

    void cargarArtistas(){
        Artista artista1 = new Artista();
        artista1.setIdArtista(UUID.randomUUID());
        artista1.setNombreArtista("Ramones");

        artistaRepository.save(artista1);

        Artista artista2 = new Artista();
        artista2.setIdArtista(UUID.randomUUID());
        artista2.setNombreArtista("AC/DC");

        artistaRepository.save(artista2);

    }

    void cargarGeneros(){
        Genero genero1 = new Genero();
        genero1.setIdGenero(UUID.randomUUID());
        genero1.setNombreGenero("Rock");

        generoRepository.save(genero1);

        Genero genero2 = new Genero();
        genero2.setIdGenero(UUID.randomUUID());
        genero2.setNombreGenero("Punk");

        generoRepository.save(genero2);
    }

    void cargarCanciones(){

        Cancion cancion1 = new Cancion();
        cancion1.setIdCancion(UUID.randomUUID());
        cancion1.setNombreCancion("Thunderstruck");
        cancion1.setDuracion(4.52);
        cancion1.setRanking(5);
        cancion1.setAlbum("The razors edge");
        cancion1.setArtista(artistaRepository.findAll().get(1));
        cancion1.setGenero(generoRepository.findAll().get(0));

        cancionRepository.save(cancion1);

        Cancion cancion2 = new Cancion();
        cancion2.setIdCancion(UUID.randomUUID());
        cancion2.setNombreCancion("Pet Sematary");
        cancion2.setDuracion(3.29);
        cancion2.setRanking(5);
        cancion2.setAlbum("Brain Drain");
        cancion2.setArtista(artistaRepository.findAll().get(0));
        cancion2.setGenero(generoRepository.findAll().get(1));

        cancionRepository.save(cancion2);

    }

    void cargarListasReproduccion(){
        ListaDeReproduccion listaDeReproduccion = new ListaDeReproduccion();
        listaDeReproduccion.setIdLista(UUID.randomUUID());
        listaDeReproduccion.setNombreLista("Clásicos");
        listaDeReproduccion.setListaDeCanciones(cancionRepository.findAll());
        listaDeReproduccion.setUsuario(usuarioRepository.findAll().get(0));

        listaDeReproduccionRepository.save(listaDeReproduccion);
    }

    void cargarUsuario(){
        Usuario usuario1 = new Usuario();
        usuario1.setIdUsuario(UUID.randomUUID());
        usuario1.setNombre("Juan Gómez");
        usuario1.setNombreUsuario("jgomez");


        usuario1.setListasDeReproduccion(listaDeReproduccionRepository.findAll());

        usuarioRepository.save(usuario1);

    }
}
