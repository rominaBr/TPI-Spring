package com.informatorio.streamingMusic.repository.listadereproduccion;

import com.informatorio.streamingMusic.dominio.ListaDeReproduccion;
import com.informatorio.streamingMusic.dto.listadereproduccion.ListaDeReproduccionDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ListaDeReproduccionRepository extends JpaRepository<ListaDeReproduccion, UUID> {

    @Query("SELECT l FROM ListaDeReproduccion l WHERE l.nombreLista = :nombre AND l.publica = true")
    List<ListaDeReproduccion> buscarListaDeReproduccionPorNombre(String nombre);

    @Query("SELECT l FROM ListaDeReproduccion l WHERE l.usuario.idUsuario = :idUsuario ORDER BY l.creadoEn DESC")
    List<ListaDeReproduccion> listarListasPorUsuario(UUID idUsuario);

    @Query("SELECT l FROM ListaDeReproduccion l LEFT JOIN FETCH l.usuario u WHERE u.idUsuario = :idUsuario AND l.idLista = :idLista")
    ListaDeReproduccion buscarListaPorIdYUsuario(UUID idUsuario, UUID idLista);

}
