package com.example.forutec2.Usuario.Domain;

import com.example.forutec2.Usuario.Infraestructure.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario guardarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }
    public Usuario obtenerPorId(Long id) {
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        return usuario.orElse(null);
    }
    public Usuario actualizarUsuario(Long id, Usuario usuarioDatos) {
        return usuarioRepository.findById(id)
                .map(usuarioExistente -> {
                    usuarioExistente.setNombre(usuarioDatos.getNombre());
                    usuarioExistente.setApellido(usuarioDatos.getApellido());
                    usuarioExistente.setCorreo(usuarioDatos.getCorreo());
                    usuarioExistente.setContrasenia(usuarioDatos.getContrasenia());
                    return usuarioRepository.save(usuarioExistente);
                }).orElse(null);
    }
    public void eliminarUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }
}
