package com.example.forutec.Publicacion.Domain;

import com.example.forutec.Comentario.Domain.Comentario;
import com.example.forutec.Usuario.Domain.Usuario;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "publicaciones")
public class Publicacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String Contenido;
    private String FechaPublicacion;

    @ManyToOne (fetch = FetchType.LAZY) // solo cuando sea necesario
    @JoinColumn(name = "author_id",nullable = false) //columna de llave foreana en publicacion
    private Usuario author;

    @OneToMany(mappedBy = "publicacion", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comentario> comentarios = new ArrayList<>();
}
