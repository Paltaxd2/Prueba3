package com.biblioteca.cl.pruebaBiblioteca.modelo;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Autor")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Autor {
    // En esta nueva vercion , si hay un problema al crear las tablas, solo hay que borrar las tablas existentes en XAMPP
    // Esto ya que spring.jpa.hibernate.ddl-auto= , esta definido como update , ya que la idea es retener la informacion
    // para despues manipularla, tambien el error puede deberse a que hay datos ingresados y dan problemas al hacer la relacion
    // entre llaves foranea , gracias

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_autor;

    @Column(nullable = false)
    private String pNombre;

    @Column(nullable = false)
    private String sNombre;

    @Column(nullable = false)
    private String apPaterno;

    @Column(nullable = false)
    private String apMaterno;
}
