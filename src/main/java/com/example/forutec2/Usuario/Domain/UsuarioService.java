package com.example.forutec2.Usuario.Domain;

import com.example.forutec2.Exception.ResourceNotFoundException;
import com.example.forutec2.Usuario.Dto.UsuarioDto;
import com.example.forutec2.Usuario.Infraestructure.UsuarioRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private ModelMapper modelMapper;

    public Usuario guardarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public UsuarioDto obtenerUsuarioDto(Long id) {
        Usuario usuario = usuarioRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado"));
        return modelMapper.map(usuario, UsuarioDto.class);
    }

    public Usuario obtenerPorId2(Long id) {
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

    public UsuarioDto actualizarParcialmenteUsuario(Long id, UsuarioDto usuarioPatchDto) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado"));

        if (usuarioPatchDto.getNombre() != null) {
            usuario.setNombre(usuarioPatchDto.getNombre());
        }
        if (usuarioPatchDto.getApellido() != null) {
            usuario.setApellido(usuarioPatchDto.getApellido());
        }
        if (usuarioPatchDto.getCorreo() != null) {
            usuario.setCorreo(usuarioPatchDto.getCorreo());
        }

        usuarioRepository.save(usuario);

        return modelMapper.map(usuario, UsuarioDto.class);
    }
}
