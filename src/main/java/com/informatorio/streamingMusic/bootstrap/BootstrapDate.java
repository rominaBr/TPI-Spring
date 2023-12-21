package com.informatorio.streamingMusic.bootstrap;

import com.informatorio.streamingMusic.dominio.*;
import com.informatorio.streamingMusic.repository.artista.ArtistaRepository;
import com.informatorio.streamingMusic.repository.cancion.CancionRepository;
import com.informatorio.streamingMusic.repository.genero.GeneroRepository;
import com.informatorio.streamingMusic.repository.listadereproduccion.ListaDeReproduccionRepository;
import com.informatorio.streamingMusic.repository.usuario.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.UUID;

@Component
@AllArgsConstructor
public class BootstrapDate implements CommandLineRunner {

    private UsuarioRepository usuarioRepository;

    private ArtistaRepository artistaRepository;

    private CancionRepository cancionRepository;

    private GeneroRepository generoRepository;

    private ListaDeReproduccionRepository listaDeReproduccionRepository;

    @Override
    public void run(String... args) throws Exception {
        cargarArtistas();
        cargarGeneros();
        cargarCanciones();
        cargarUsuario();
        cargarListaReproduccion();
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
        cancion2.setRanking(10);
        cancion2.setAlbum("Brain Drain");
        cancion2.setArtista(artistaRepository.findAll().get(0));
        cancion2.setGenero(generoRepository.findAll().get(1));

        cancionRepository.save(cancion2);

        Cancion cancion3 = new Cancion();
        cancion3.setIdCancion(UUID.randomUUID());
        cancion3.setNombreCancion("Blitzkrieg Bop");
        cancion3.setDuracion(2.14);
        cancion3.setRanking(7);
        cancion3.setAlbum("Ramones");
        cancion3.setArtista(artistaRepository.findAll().get(0));
        cancion3.setGenero(generoRepository.findAll().get(1));

        cancionRepository.save(cancion3);

        Cancion cancion4 = new Cancion();
        cancion4.setIdCancion(UUID.randomUUID());
        cancion4.setNombreCancion("Judy is punk");
        cancion4.setDuracion(2.14);
        cancion4.setRanking(8);
        cancion4.setAlbum("Ramones");
        cancion4.setArtista(artistaRepository.findAll().get(0));
        cancion4.setGenero(generoRepository.findAll().get(1));

        cancionRepository.save(cancion4);

    }

    void cargarListaReproduccion(){
        ListaDeReproduccion listaDeReproduccion1 = new ListaDeReproduccion();
        listaDeReproduccion1.setIdLista(UUID.randomUUID());
        listaDeReproduccion1.setNombreLista("Clasicos");
        listaDeReproduccion1.setCreadoEn(LocalDateTime.now());
        listaDeReproduccion1.setPublica(true);
        listaDeReproduccion1.setListaDeCanciones(cancionRepository.findAll());
        listaDeReproduccion1.setUsuario(usuarioRepository.findAll().get(0));

        listaDeReproduccionRepository.save(listaDeReproduccion1);

        ListaDeReproduccion listaDeReproduccion2 = new ListaDeReproduccion();
        listaDeReproduccion2.setIdLista(UUID.randomUUID());
        listaDeReproduccion2.setNombreLista("80's");
        listaDeReproduccion2.setCreadoEn(LocalDateTime.now());
        listaDeReproduccion2.setListaDeCanciones(cancionRepository.findAll());
        listaDeReproduccion2.setUsuario(usuarioRepository.findAll().get(0));

        listaDeReproduccionRepository.save(listaDeReproduccion2);

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
