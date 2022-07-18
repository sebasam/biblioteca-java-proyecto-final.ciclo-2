/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import java.util.Date;

/**
 *
 * @author SEBASXD
 */
public class Autor {
    private int id_autor;
    private String nombre;
    private String nacionalidad;
    private Date fecha_nacimiento;

    public Autor(int id_autor, String nombre, String nacionalidad, Date fecha_nacimiento) {
        this.id_autor = id_autor;
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public Autor(String nombre, String nacionalidad, Date fecha_nacimiento) {
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public Autor(int id_autor, String nombre) {
        this.id_autor = id_autor;
        this.nombre = nombre;
    }   

    public Autor(int id_autor) {
        this.id_autor = id_autor;
    }    

    public Autor() {
    }   

    public int getId_autor() {
        return id_autor;
    }

    public void setId_autor(int id_autor) {
        this.id_autor = id_autor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    @Override
    public String toString() {
        return nombre;
    }    
    
}
