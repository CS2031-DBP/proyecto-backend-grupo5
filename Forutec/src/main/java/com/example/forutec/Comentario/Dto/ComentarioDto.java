package com.example.forutec.Comentario.Dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ComentarioDto {
    private Long id;
    private String comentario;
    private String fehcaPublicacion;
}
