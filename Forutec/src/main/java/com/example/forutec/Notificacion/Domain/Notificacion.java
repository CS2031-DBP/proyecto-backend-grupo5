package com.example.forutec.Notificacion.Domain;

import com.example.forutec.Usuario.Domain.Usuario;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class Notificacion { // para que sea como su barra de notificaciones dentro de la web
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String mensaje;
    private Boolean leida;
    private LocalDateTime fechaNotificacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id", nullable = false) // Define la columna de clave foránea
    private Usuario usuario; // Usuario que recibe la notificación
}
