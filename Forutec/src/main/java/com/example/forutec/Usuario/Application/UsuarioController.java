package com.example.forutec.Usuario.Application;

import com.example.forutec.Usuario.DTO.UsuarioDto;
import com.example.forutec.Usuario.Domain.Usuario;
import com.example.forutec.Usuario.Domain.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Usuario")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("{id}")
    public ResponseEntity<UsuarioDto> getUsuarioDTO(@PathVariable Long id) {
        return ResponseEntity.ok(usuarioService.getUsuarioDto(id));
    }
/*
    @PostMapping()
    public ResponseEntity<Void> postUsuarioDto(@RequestBody UsuarioDto usuarioDto) {
        String uri = usuarioService.postUsuarioDto()
    }

 */

}
