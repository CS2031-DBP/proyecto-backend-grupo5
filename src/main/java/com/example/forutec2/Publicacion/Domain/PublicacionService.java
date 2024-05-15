package com.example.forutec2.Publicacion.Domain;

import com.example.forutec2.Publicacion.Infraestructure.PublicacionRepository;
import com.example.forutec2.Usuario.Domain.Usuario;
import com.example.forutec2.Usuario.Infraestructure.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class PublicacionService {

    @Autowired
    private PublicacionRepository publicacionRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;

    public Publicacion guardarPublicacion(Publicacion publicacion, Long usuarioId) {
        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        publicacion.setUsuario(usuario);
        return publicacionRepository.save(publicacion);
    }
    public Publicacion obtenerPublicacionPorId(Long id) {
        Optional<Publicacion> publicacion = publicacionRepository.findById(id);
        return publicacion.orElse(null);
    }
    public Publicacion actualizarPublicacion(Long id, Publicacion datosPublicacion) {
        return publicacionRepository.findById(id)
                .map(publicacionExistente -> {
                    publicacionExistente.setTitulo(datosPublicacion.getTitulo());
                    publicacionExistente.setContenido(datosPublicacion.getContenido());
                    return publicacionRepository.save(publicacionExistente);
                }).orElse(null);
    }
    public void eliminarPublicacion(Long id) {
        publicacionRepository.deleteById(id);
    }




}
