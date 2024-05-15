package com.example.forutec2.Comentario.Domain;

import com.example.forutec2.Publicacion.Domain.Publicacion;
import com.example.forutec2.Publicacion.Infraestructure.PublicacionRepository;
import com.example.forutec2.Comentario.Infraestructure.ComentarioRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComentarioService {
    @Autowired
    private ComentarioRespository comentarioRepository;

    @Autowired
    private PublicacionRepository publicacionRepository;

    public Comentario obtenerComentarioPorId(Long id) {
        return comentarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Comentario no encontrado"));
    }

    public Comentario guardarComentario(Comentario comentario, Long publicacionId) {
        Publicacion publicacion = publicacionRepository.findById(publicacionId)
                .orElseThrow(() -> new RuntimeException("Publicación no encontrada"));
        comentario.setPublicacion(publicacion);
        return comentarioRepository.save(comentario);
    }

    public Comentario actualizarComentario(Long id, Comentario comentarioDetalles) {
        Comentario comentario = comentarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Comentario no encontrado"));

        comentario.setComentario(comentarioDetalles.getComentario());
        comentario.setFechaPublicacion(comentarioDetalles.getFechaPublicacion());
        return comentarioRepository.save(comentario);
    }

    public void eliminarComentario(Long id) {
        Comentario comentario = comentarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Comentario no encontrado"));
        comentarioRepository.delete(comentario);
    }
    public List<Comentario> obtenerComentariosPorPublicacion(Long publicacionId) {
        Publicacion publicacion = publicacionRepository.findById(publicacionId)
                .orElseThrow(() -> new RuntimeException("Publicación no encontrada"));
        return comentarioRepository.findByPublicacion(publicacion);
    }
}
