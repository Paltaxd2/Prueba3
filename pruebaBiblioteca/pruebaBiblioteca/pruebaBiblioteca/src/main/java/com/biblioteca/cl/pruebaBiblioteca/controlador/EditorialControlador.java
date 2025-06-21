package com.biblioteca.cl.pruebaBiblioteca.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.biblioteca.cl.pruebaBiblioteca.modelo.Editorial;
import com.biblioteca.cl.pruebaBiblioteca.modelo.Libro;
import com.biblioteca.cl.pruebaBiblioteca.servicio.EditorialServicio;

@RestController
@RequestMapping("/api/v3/editorial")
public class EditorialControlador {

    @Autowired
    private EditorialServicio editServ;

    // Nuevamente , ahora los edit y edito 1 y 2 y 3 y tal , son para evitar problemas en el codigo
    @PostMapping()
    public ResponseEntity<Editorial> agregarEditorial(@RequestBody Editorial edito1) {
        Editorial edit1 = editServ.save(edito1);
        return ResponseEntity.status(HttpStatus.CREATED).body(edit1);
    }

    @PutMapping("/{id_editorial}")
    public ResponseEntity<Editorial> acutualizarEditorial(@PathVariable Integer id_editorial, @RequestBody Editorial edito2) {
        try {
            Editorial edit2 = editServ.findById(id_editorial);
            edit2.setNombreEditorial(edito2.getNombreEditorial());

            editServ.save(edit2);
            return ResponseEntity.ok(edito2);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id_editorial}")
    public ResponseEntity<Editorial> buscarEditorialEspecifica(@PathVariable Integer id_editorial) {
        try {
            Editorial edit3 = editServ.findById(id_editorial);
            return ResponseEntity.ok(edit3);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
    
    @GetMapping()
    public ResponseEntity<List<Editorial>> listarEditoriales() {
        List<Editorial> edit4 = editServ.findAll();
        if(edit4.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(edit4);
    }
    
    @DeleteMapping("/{id_editorial}")
    public ResponseEntity<?> eliminarEditorial(@PathVariable Integer id_editorial){
        try {
            editServ.delete(id_editorial);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
