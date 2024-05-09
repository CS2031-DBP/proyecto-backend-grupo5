package com.example.forutec.Publicacion.Application;

import com.example.forutec.Publicacion.Domain.PublicacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Publicacion")
public class PublicacionController {
    @Autowired
    private PublicacionService publicacionService;

}
