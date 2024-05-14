package com.example.forutec2.Publicacion.Application;

import com.example.forutec2.Publicacion.Domain.Publicacion;
import com.example.forutec2.Publicacion.Domain.PublicacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Publicacion")
public class PublicacionController {
    @Autowired
    private PublicacionService publicacionService;

    @PostMapping("/usuarios/{usuarioId}")
    public ResponseEntity<Publicacion> crearPublicacionParaUsuario(@PathVariable Long usuarioId, @RequestBody Publicacion publicacion) {
        Publicacion nuevaPublicacion = publicacionService.guardarPublicacion(publicacion, usuarioId);
        return ResponseEntity.ok(nuevaPublicacion);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Publicacion> obtenerPublicacionPorId(@PathVariable Long id) {
        Publicacion publicacion = publicacionService.obtenerPublicacionPorId(id);
        return publicacion != null ? ResponseEntity.ok(publicacion) : ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Publicacion> actualizarPublicacion(@PathVariable Long id, @RequestBody Publicacion publicacion) {
        Publicacion publicacionActualizada = publicacionService.actualizarPublicacion(id, publicacion);
        return publicacionActualizada != null ? ResponseEntity.ok(publicacionActualizada) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPublicacion(@PathVariable Long id) {
        publicacionService.eliminarPublicacion(id);
        return ResponseEntity.noContent().build();
    }

}

