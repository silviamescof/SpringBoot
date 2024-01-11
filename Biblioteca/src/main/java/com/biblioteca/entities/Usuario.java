package com.biblioteca.entities;

import jakarta.persistence.*;

@Entity
@Table(name="usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private Integer edad;

    ////////////CONSTRUCTOR//////////////


    public Usuario(String nombre, Integer edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    /////////////SETTER/////////////////////////


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    ///////////GETTERS//////////////////////

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public Integer getEdad() {
        return edad;
    }
    ///////////////////TOSTRING////////////////////


    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", edad=" + edad +
                '}';
    }
}
