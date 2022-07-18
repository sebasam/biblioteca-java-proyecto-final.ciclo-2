/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

/**
 *
 * @author SEBASXD
 */
public class Libro {
    private int id_libro;
    private String nombre;
    private String editorial;
    private int año;
    private String estado;
    private int id_autor;

    public Libro(int id_libro, String nombre, String editorial, int año, String estado, int id_autor) {
        this.id_libro = id_libro;
        this.nombre = nombre;
        this.editorial = editorial;
        this.año = año;
        this.estado = estado;
        this.id_autor = id_autor;
    }

    public Libro(String nombre, String editorial, int año, String estado, int id_autor) {
        this.nombre = nombre;
        this.editorial = editorial;
        this.año = año;
        this.estado = estado;
        this.id_autor = id_autor;
    }

    public Libro(int id_libro, String nombre, String editorial, int año, String estado) {
        this.id_libro = id_libro;
        this.nombre = nombre;
        this.editorial = editorial;
        this.año = año;
        this.estado = estado;
    }
    
    

    public Libro(int id_libro, String nombre, String editorial, int año) {
        this.id_libro = id_libro;
        this.nombre = nombre;
        this.editorial = editorial;
        this.año = año;
    }

    public Libro(int id_libro, String nombre, String estado) {
        this.id_libro = id_libro;
        this.nombre = nombre;
        this.estado = estado;
    }
    
    

    public Libro(int id_libro, String nombre) {
        this.id_libro = id_libro;
        this.nombre = nombre;
    }    

    public Libro(int id_libro) {
        this.id_libro = id_libro;
    }

    public Libro() {
    }

    
    

    public int getId_libro() {
        return id_libro;
    }

    public void setId_libro(int id_libro) {
        this.id_libro = id_libro;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getId_autor() {
        return id_autor;
    }

    public void setId_autor(int id_autor) {
        this.id_autor = id_autor;
    }
    
    

    @Override
    public String toString() {
        return "Libro{" + "id_libro=" + id_libro + ", nombre=" + nombre + ", editorial=" + editorial + ", a\u00f1o=" + año + ", estado=" + estado + '}';
    }

    
    
    
}
