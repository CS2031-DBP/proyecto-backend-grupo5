package com.example.forutec2.Usuario.Domain;

import com.example.forutec2.Publicacion.Domain.Publicacion;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

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
    @Column(nullable = false)

    private String nombre;
    private String apellido;
    private String correo;
    private String contrasenia;



    private ZonedDateTime FechaCreacionPerfil;

    @PrePersist
    public void prePersist() {
        this.FechaCreacionPerfil = ZonedDateTime.now();
        // para crear la fecha automatico
    }
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Publicacion> publicaciones = new ArrayList<>();
}
