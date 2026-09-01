package com.ni.edu.uam.api_cafeSoluble.models;
import jakarta.persistence.*;

@Entity
@Table(name = "producto")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // ID autonumérico
    private Long id;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(nullable = false, length = 50)
    private String presentacion;

    @Column(nullable = false, length = 50)
    private String categoria;

    @Column(nullable = false)
    private Boolean disponible;

    public Producto() {
    }

    public Producto(Long id, String nombre, String presentacion, String categoria, Boolean disponible) {
        this.id = id;
        this.nombre = nombre;
        this.presentacion = presentacion;
        this.categoria = categoria;
        this.disponible = disponible;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPresentacion() {
        return presentacion;
    }

    public void setPresentacion(String presentacion) {
        this.presentacion = presentacion;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Boolean getDisponible() {
        return disponible;
    }

    public void setDisponible(Boolean disponible) {
        this.disponible = disponible;
    }
}