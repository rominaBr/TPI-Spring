package com.informatorio.streamingMusic.repository.listadereproduccion;

import com.informatorio.streamingMusic.dominio.ListaDeReproduccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface IListaDeReproduccionRepository extends JpaRepository<ListaDeReproduccion, UUID> {
}
