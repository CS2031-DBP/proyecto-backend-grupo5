package com.example.forutec2.Comentario.Application;

import com.example.forutec2.Comentario.Domain.Comentario;
import com.example.forutec2.Comentario.Domain.ComentarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comentario")
public class ComentarioController {
    @Autowired
    private ComentarioService comentarioService;

    @GetMapping("/publicacion/{publicacionId}")
    public ResponseEntity<List<Comentario>> obtenerComentariosPorPublicacion(@PathVariable Long publicacionId) {
        List<Comentario> comentarios = comentarioService.obtenerComentariosPorPublicacion(publicacionId);
        return ResponseEntity.ok(comentarios);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Comentario> obtenerComentarioPorId(@PathVariable Long id) {
        Comentario comentario = comentarioService.obtenerComentarioPorId(id);
        return ResponseEntity.ok(comentario);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Comentario> actualizarComentario(@PathVariable Long id, @RequestBody Comentario comentarioDetalles) {
        Comentario comentarioActualizado = comentarioService.actualizarComentario(id, comentarioDetalles);
        return ResponseEntity.ok(comentarioActualizado);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarComentario(@PathVariable Long id) {
        comentarioService.eliminarComentario(id);
        return ResponseEntity.noContent().build();
    }
    @PostMapping("/publicacion/{publicacionId}")
    public ResponseEntity<Comentario> crearComentario(@PathVariable Long publicacionId, @RequestBody Comentario comentario) {
        Comentario nuevoComentario = comentarioService.guardarComentario(comentario, publicacionId);
        return ResponseEntity.ok(nuevoComentario);
    }
}
