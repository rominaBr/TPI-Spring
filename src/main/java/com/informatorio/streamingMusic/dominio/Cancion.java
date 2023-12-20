package com.informatorio.streamingMusic.dominio;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Cancion extends EntidadBase{

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @JdbcTypeCode(SqlTypes.CHAR)
    @Column(length = 36, columnDefinition = "varchar(36)", updatable = false, nullable = false)
    private UUID idCancion;

    @Column(nullable = false)
    private String nombreCancion;

    private int ranking;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "genero_id")
    private Genero genero;

    private double duracion;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "artista_id")
    private Artista artista;

    private String album;

    @ManyToMany
    @JoinTable(name = "lista_cancion", joinColumns = @JoinColumn(name = "cancion_id"),
            inverseJoinColumns = @JoinColumn(name = "lista_id"))
    private List<ListaDeReproduccion> listasDeReproducciones = new ArrayList<>();


}
