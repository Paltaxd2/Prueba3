package com.biblioteca.cl.pruebaBiblioteca.controlador;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.biblioteca.cl.pruebaBiblioteca.modelo.Libro;
import com.biblioteca.cl.pruebaBiblioteca.servicio.LibroServicio;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequestMapping("api/v1/libro")
public class LibroControlador {

    @Autowired
    private LibroServicio libServ;

    // Todos los lib , lib1, lib2, etc , son objetos de la clase Libro , llevan distinto apodo para que java no se confunda
    @PostMapping()
    public ResponseEntity<Libro> agregarLibro(@RequestBody Libro libr1) {
        Libro lib1 = libServ.save(libr1);
        return ResponseEntity.status(HttpStatus.CREATED).body(lib1);
    }
}
