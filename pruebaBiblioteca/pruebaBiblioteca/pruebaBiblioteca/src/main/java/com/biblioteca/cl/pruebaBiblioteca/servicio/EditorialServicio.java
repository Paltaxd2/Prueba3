package com.biblioteca.cl.pruebaBiblioteca.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biblioteca.cl.pruebaBiblioteca.modelo.Autor;
import com.biblioteca.cl.pruebaBiblioteca.modelo.Editorial;
import com.biblioteca.cl.pruebaBiblioteca.repositorio.EditorialRepositorioInterface;

@Service
public class EditorialServicio {

    @Autowired
    private EditorialRepositorioInterface editRepoInter;

    // Guardar una Editorial , de paso el save actualiza
    public Editorial save(Editorial edit){
        return editRepoInter.save(edit);
    }

    // Buscar una Editorial en especifico 
    public Editorial findById(Integer id_editorial){
        return editRepoInter.findById(id_editorial).get();
    }

    // Listar todas las Editoriales
    public List<Editorial> findAll(){
        return editRepoInter.findAll();
    }

    // Borra las Editoriales 1 por 1 segun su Id)
    public void delete(Integer id_editorial){
        editRepoInter.deleteById(id_editorial);
    }
}
