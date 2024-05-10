package com.example.forutec.Publicacion.Dto;

import com.example.forutec.Comentario.Dto.ComentarioDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class PublicacionDto {
    private int id;
    private String contenido;
    private String fechaPublicacion;
    private List<ComentarioDto> comentarios;

}
