package com.biblioteca.cl.pruebaBiblioteca.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.biblioteca.cl.pruebaBiblioteca.modelo.Libro;
import com.biblioteca.cl.pruebaBiblioteca.repositorio.LibroRepositorioInterface;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class LibroServicio {

    @Autowired
    private LibroRepositorioInterface libRepoInter;

    // Guardar un libro , de paso el save actualiza
    public Libro save(Libro lib){
        return libRepoInter.save(lib);
    }

    // Buscar un Libro en especifico 
    public Libro findById(Integer id_libro){
        return libRepoInter.findById(id_libro).get();
    }

    // Listar todos los libros
    public List<Libro> findAll(){
        return libRepoInter.findAll();
    }

    // Borra los Libros 1 por 1 segun su Id
    public void delete(Integer id_libro){
        libRepoInter.deleteById(id_libro);
    }
}
