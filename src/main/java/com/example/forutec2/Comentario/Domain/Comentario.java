package com.example.forutec2.Comentario.Domain;

import com.example.forutec2.Publicacion.Domain.Publicacion;
import com.example.forutec2.Usuario.Domain.Usuario;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
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
    @PrePersist
    public void prePersist() {
        this.FechaPublicacion = ZonedDateTime.now();
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Publicacion_id", nullable = false)
    @JsonBackReference
    private Publicacion publicacion;
/*
    private String estado;
    private int likes;
    private int dislikes;
    private ZonedDateTime fechaActualizacion;
    */

}
