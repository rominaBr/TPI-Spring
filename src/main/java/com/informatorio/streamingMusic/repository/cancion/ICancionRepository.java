package com.informatorio.streamingMusic.repository.cancion;

import com.informatorio.streamingMusic.dominio.Cancion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ICancionRepository extends JpaRepository<Cancion, UUID> {
}
