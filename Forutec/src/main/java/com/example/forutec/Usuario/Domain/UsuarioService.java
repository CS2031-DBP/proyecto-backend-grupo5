package com.example.forutec.Usuario.Domain;

import com.example.forutec.Usuario.DTO.UsuarioDto;
import com.example.forutec.Usuario.Infraestructure.UsuarioRepository;
import com.example.forutec.exceptions.ResourceNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private ModelMapper modelMapper;
/*
    public UsuarioDto getUsuarioDto(Long id){
        Usuario usuario = usuarioRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado"));

        UsuarioDto usuarioDto = modelMapper.map(usuario, UsuarioDto.class);
        usuarioDto.set
    }

 */

}
