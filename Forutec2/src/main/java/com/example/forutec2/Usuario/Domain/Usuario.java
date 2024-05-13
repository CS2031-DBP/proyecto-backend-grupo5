package com.example.forutec2.Usuario.Domain;

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

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "apellido")
    private String apellido;

    @Column(name = "correo", nullable = false)
    private String correo;

    @Column(name = "rol_universitario")
    private String rolUniversitario;

    @Column(name = "fecha_creacion_perfil")
    private ZonedDateTime fechaCreacionPerfil;

    @Column(name = "celular")
    private String celular;
}

    /*
    @OneToMany(mappedBy = "author") // un usuario puede tener varias publicaciones, se escribe al reves
    private List<Publicacion> publicaciones = new ArrayList<>();

    @OneToMany(mappedBy = "autor", cascade = CascadeType.ALL, orphanRemoval = true) //comentarios
    private List<Comentario> comentarios = new ArrayList<>();

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true) //notificaciones
    private List<Notificacion> notificaciones;
*/