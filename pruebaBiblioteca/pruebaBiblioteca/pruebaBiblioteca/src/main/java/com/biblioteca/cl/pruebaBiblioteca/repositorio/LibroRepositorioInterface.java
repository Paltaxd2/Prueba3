package com.biblioteca.cl.pruebaBiblioteca.repositorio;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.biblioteca.cl.pruebaBiblioteca.modelo.Libro;

import jakarta.persistence.Column;

@Repository
public interface LibroRepositorioInterface extends JpaRepository<Libro, Integer>{
    
}