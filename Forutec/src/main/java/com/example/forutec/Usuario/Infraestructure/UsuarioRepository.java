package com.example.forutec.Usuario.Infraestructure;

import com.example.forutec.Usuario.Domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
