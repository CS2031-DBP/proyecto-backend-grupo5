package com.example.forutec2.Publicacion.Infraestructure;

import com.example.forutec2.Publicacion.Domain.Publicacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublicacionRepository extends JpaRepository<Publicacion, Long> {
}
