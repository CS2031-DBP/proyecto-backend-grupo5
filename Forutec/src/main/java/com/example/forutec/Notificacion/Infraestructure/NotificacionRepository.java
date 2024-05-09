package com.example.forutec.Notificacion.Infraestructure;

import com.example.forutec.Notificacion.Domain.Notificacion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificacionRepository extends JpaRepository<Notificacion, Long> {
}
