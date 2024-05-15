package com.example.forutec2.Comentario.Infraestructure;

import com.example.forutec2.Comentario.Domain.Comentario;
import com.example.forutec2.Publicacion.Domain.Publicacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ComentarioRespository extends JpaRepository<Comentario, Long> {
    List<Comentario> findByPublicacion(Publicacion publicacion);
}
