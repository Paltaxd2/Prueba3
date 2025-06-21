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

    @PutMapping("/{id_libro}")
    public ResponseEntity<Libro> acutualizarLibro(@PathVariable Integer id_libro, @RequestBody Libro libr2) {
        try {
            Libro lib2 = libServ.findById(id_libro);
            lib2.setIsbn(libr2.getIsbn());
            lib2.setTitulo(libr2.getTitulo());
            lib2.setFechaIngreso(libr2.getFechaIngreso());
            lib2.setAutor(libr2.getAutor());
            lib2.setEditorial(libr2.getEditorial());
            lib2.setAnioPublicacion(libr2.getAnioPublicacion());

            libServ.save(lib2);
            return ResponseEntity.ok(libr2);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id_libro}")
    public ResponseEntity<Libro> buscarLibroEspecifico(@PathVariable Integer id_libro) {
        try {
            Libro lib3 = libServ.findById(id_libro);
            return ResponseEntity.ok(lib3);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
    
    @GetMapping()
    public ResponseEntity<List<Libro>> listarLibros() {
        List<Libro> lib4 = libServ.findAll();
        if(lib4.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(lib4);
    }
    
    @DeleteMapping("/{id_libro}")
    public ResponseEntity<?> eliminarLibro(@PathVariable Integer id_libro){
        try {
            libServ.delete(id_libro);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
