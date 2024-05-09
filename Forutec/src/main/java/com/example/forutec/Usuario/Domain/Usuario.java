package com.example.forutec.Usuario.Domain;

import com.example.forutec.Comentario.Domain.Comentario;
import com.example.forutec.Publicacion.Domain.Publicacion;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String correo;
    private String RolUniversitario; //estudiante,profesor etc??
    private ZonedDateTime FechaCreacionPerfil;

    @OneToMany(mappedBy = "author") // un usuario puede tener varias publicaciones, se escribe al reves
    private List<Publicacion> publicaciones = new ArrayList<>();

    @OneToMany(mappedBy = "autor", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comentario> comentarios = new ArrayList<>();
}
