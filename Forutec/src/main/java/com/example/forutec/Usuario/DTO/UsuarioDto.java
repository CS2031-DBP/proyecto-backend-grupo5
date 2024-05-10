package com.example.forutec.Usuario.DTO;

import com.example.forutec.Publicacion.Dto.PublicacionDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;
import com.example.forutec.Comentario.Dto.ComentarioDto;

import java.util.List;
@Getter
@Setter
@NoArgsConstructor
public class UsuarioDto {
    @NotNull
    //@Size(min = 2, max = 50)
    private String nombre;
    @NotNull
    private String correo;
    @NotNull
    private String rolUniversitario;
    private List<PublicacionDto> publicaciones;
    private List<ComentarioDto> comentarios;

}
