package com.example.forutec.Publicacion.Infraestructure;

import com.example.forutec.Publicacion.Domain.Publicacion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublicacionRepository extends JpaRepository<Publicacion, Long> {
}
