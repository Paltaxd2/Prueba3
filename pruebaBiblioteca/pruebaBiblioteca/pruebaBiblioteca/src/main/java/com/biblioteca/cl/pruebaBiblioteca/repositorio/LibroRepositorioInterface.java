package com.biblioteca.cl.pruebaBiblioteca.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.biblioteca.cl.pruebaBiblioteca.modelo.Libro;

@Repository
public interface LibroRepositorioInterface extends JpaRepository<Libro, Integer>{
    
}