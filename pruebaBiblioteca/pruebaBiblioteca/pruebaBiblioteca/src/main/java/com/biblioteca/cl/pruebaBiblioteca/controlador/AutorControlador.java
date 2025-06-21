package com.biblioteca.cl.pruebaBiblioteca.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.biblioteca.cl.pruebaBiblioteca.modelo.Autor;
import com.biblioteca.cl.pruebaBiblioteca.modelo.Libro;
import com.biblioteca.cl.pruebaBiblioteca.servicio.AutorServicio;

@RestController
@RequestMapping("/api/v2/autor")
public class AutorControlador {

    @Autowired
    private AutorServicio autServ;

    // Al igual que libro , aca los Autores seran aut1, 2 , 3 , etc
    @PostMapping()
    public ResponseEntity<Autor> agregarAutor(@RequestBody Autor auto1) {
        Autor aut1 = autServ.save(auto1);
        return ResponseEntity.status(HttpStatus.CREATED).body(aut1);
    }

    @PutMapping("/{id_autor}")
    public ResponseEntity<Autor> acutualizarAutor(@PathVariable Integer id_autor, @RequestBody Autor auto2) {
        try {
            Autor aut2 = autServ.findById(id_autor);
            aut2.setPNombre(auto2.getPNombre());
            aut2.setSNombre(auto2.getSNombre());
            aut2.setApPaterno(auto2.getApPaterno());
            aut2.setApMaterno(auto2.getApMaterno());

            autServ.save(aut2);
            return ResponseEntity.ok(auto2);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id_autor}")
    public ResponseEntity<Autor> buscarAutorEspecifico(@PathVariable Integer id_autor) {
        try {
            Autor aut3 = autServ.findById(id_autor);
            return ResponseEntity.ok(aut3);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
    
    @GetMapping()
    public ResponseEntity<List<Autor>> listarAutor() {
        List<Autor> aut4 = autServ.findAll();
        if(aut4.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(aut4);
    }
    
    @DeleteMapping("/{id_autor}")
    public ResponseEntity<?> eliminarAutor(@PathVariable Integer id_autor){
        try {
            autServ.delete(id_autor);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
