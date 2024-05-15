package com.example.forutec2.Usuario.Application;

import com.example.forutec2.Usuario.Domain.Usuario;
import com.example.forutec2.Usuario.Domain.UsuarioService;
import com.example.forutec2.Usuario.Dto.UsuarioDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/Usuario")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/profile/{id}")
    public ResponseEntity<UsuarioDto> obtenerUsuarioDto(@PathVariable Long id) {
        UsuarioDto usuarioDto = usuarioService.obtenerUsuarioDto(id);
        return ResponseEntity.ok(usuarioDto);
    }
    @GetMapping("{id}")
    public ResponseEntity<Usuario> obtenerUsuarioPorId2(@PathVariable Long id) {
        Usuario usuario = usuarioService.obtenerPorId2(id);
        return usuario != null ? ResponseEntity.ok(usuario) : ResponseEntity.notFound().build();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDriver(@PathVariable Long id) {
        usuarioService.eliminarUsuario(id);
        return ResponseEntity.noContent().build();
    }
    @PostMapping
    public ResponseEntity<Usuario> crearUsuario(@RequestBody Usuario usuario) {
        return new ResponseEntity<>(usuarioService.guardarUsuario(usuario), HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Usuario> actualizarUsuario(@PathVariable Long id, @RequestBody Usuario usuario) {
        Usuario usuarioActualizado = usuarioService.actualizarUsuario(id, usuario);
        return usuarioActualizado != null ? ResponseEntity.ok(usuarioActualizado) : ResponseEntity.notFound().build();
    }
    @PatchMapping("/{id}")
    public ResponseEntity<UsuarioDto> actualizarParcialmenteUsuario(@PathVariable Long id, @RequestBody UsuarioDto usuarioDto) {
        UsuarioDto usuarioActualizado = usuarioService.actualizarParcialmenteUsuario(id, usuarioDto);
        return usuarioActualizado != null ? ResponseEntity.ok(usuarioActualizado) : ResponseEntity.notFound().build();
    }
}
