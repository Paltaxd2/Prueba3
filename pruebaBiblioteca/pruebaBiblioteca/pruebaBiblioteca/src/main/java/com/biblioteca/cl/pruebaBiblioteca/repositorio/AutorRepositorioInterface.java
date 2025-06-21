package com.biblioteca.cl.pruebaBiblioteca.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.biblioteca.cl.pruebaBiblioteca.modelo.Autor;

@Repository
public interface AutorRepositorioInterface extends JpaRepository<Autor, Integer>{

}
