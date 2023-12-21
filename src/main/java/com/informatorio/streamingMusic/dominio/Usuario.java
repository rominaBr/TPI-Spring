package com.informatorio.streamingMusic.dominio;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Usuario extends EntidadBase{

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @JdbcTypeCode(SqlTypes.CHAR)
    @Column(length = 36,columnDefinition = "varchar(36)",updatable = false,nullable = false)
    private UUID idUsuario;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false, unique = true)
    private String nombreUsuario;

    @OneToMany(fetch = FetchType.EAGER,mappedBy = "usuario", cascade = {CascadeType.REMOVE, CascadeType.PERSIST, CascadeType.REFRESH})
    private List<ListaDeReproduccion> listasDeReproduccion = new ArrayList<>();

}
