package com.example.forutec2.Usuario.Infraestructure;

import com.example.forutec2.Usuario.Domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    // Método para buscar usuarios por su correo electrónico
    List<Usuario> findByCorreo(String correo);

    // Método para buscar usuarios cuyo nombre contenga una cadena específica
    List<Usuario> findByNombreContaining(String nombre);
}
