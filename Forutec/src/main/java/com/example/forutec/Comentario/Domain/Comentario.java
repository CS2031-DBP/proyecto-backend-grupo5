package com.example.forutec.Comentario.Domain;

import com.example.forutec.Publicacion.Domain.Publicacion;
import com.example.forutec.Usuario.Domain.Usuario;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.ZonedDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Comentario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String comentario;
    private ZonedDateTime FechaPublicacion;

    // Relación con Publicacion, para hallar a que publicacion se refiere
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "publicacion_id", nullable = false)
    private Publicacion publicacion;

    // Relación con Usuario, para hallar quien lo publico
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "autor_id", nullable = false)
    private Usuario autor;
}
