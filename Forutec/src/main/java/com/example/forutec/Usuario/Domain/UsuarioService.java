package com.example.forutec.Usuario.Domain;

import com.example.forutec.Comentario.Dto.ComentarioDto;
import com.example.forutec.Publicacion.Dto.PublicacionDto;
import com.example.forutec.Usuario.DTO.UsuarioDto;
import com.example.forutec.Usuario.Infraestructure.UsuarioRepository;
import com.example.forutec.exceptions.ResourceNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

import com.example.forutec.Usuario.Domain.Usuario;
import com.example.forutec.Usuario.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario guardarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public Usuario obtenerPorId(Long id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    public Usuario actualizarUsuario(Long id, Usuario usuario) {
        if (usuarioRepository.existsById(id)) {
            usuario.setId(id);
            return usuarioRepository.save(usuario);
        }
        return null;
    }

    public boolean eliminarUsuario(Long id) {
        if (usuarioRepository.existsById(id)) {
            usuarioRepository.deleteById(id);
            return true;
        }
        return false;
    }
}








/*
@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private ModelMapper modelMapper;

    public UsuarioDto getUsuarioDto(Long id){
        Usuario usuario = usuarioRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado"));

        UsuarioDto usuarioDto = modelMapper.map(usuario, UsuarioDto.class);
        usuarioDto.setPublicaciones(usuario.getPublicaciones().stream()
                .map(pub -> modelMapper.map(pub, PublicacionDto.class))
                .collect(Collectors.toList()));

        usuarioDto.setComentarios(usuario.getComentarios().stream()
                .map(com -> modelMapper.map(com, ComentarioDto.class))
                .collect(Collectors.toList()));

        return usuarioDto;
    }



}
 */