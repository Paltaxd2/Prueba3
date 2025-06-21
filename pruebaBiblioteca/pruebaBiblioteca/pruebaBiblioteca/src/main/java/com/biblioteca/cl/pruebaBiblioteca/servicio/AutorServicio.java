package com.biblioteca.cl.pruebaBiblioteca.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biblioteca.cl.pruebaBiblioteca.modelo.Autor;
import com.biblioteca.cl.pruebaBiblioteca.repositorio.AutorRepositorioInterface;

@Service
public class AutorServicio {

    @Autowired
    private AutorRepositorioInterface autRepoInter;

    // Guardar un Autor , de paso el save actualiza
    public Autor save(Autor aut){
        return autRepoInter.save(aut);
    }

    // Buscar un Autor en especifico 
    public Autor findById(Integer id_autor){
        return autRepoInter.findById(id_autor).get();
    }

    // Listar todos los Autores
    public List<Autor> findAll(){
        return autRepoInter.findAll();
    }

    // Borra los Autores 1 por 1 segun su Id)
    public void delete(Integer id_autor){
        autRepoInter.deleteById(id_autor);
    }

}
