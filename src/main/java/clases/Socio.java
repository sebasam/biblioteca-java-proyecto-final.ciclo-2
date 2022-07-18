/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

/**
 *
 * @author SEBASXD
 */
public class Socio {
    private int id_socio;
    private String nombre;
    private String telefono;
    private String direccion;
    private String email;
    private String multa;

    public Socio(String nombre, String telefono, String direccion, String email, String multa) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
        this.email = email;
        this.multa = multa;
    }
    
    

    public Socio(int id_socio, String nombre, String telefono, String direccion, String email) {
        this.id_socio = id_socio;
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
        this.email = email;
    }

    public Socio(String nombre, String telefono, String direccion, String email) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
        this.email = email;
    }

    public Socio(int id_socio) {
        this.id_socio = id_socio;
    }
    
    

    public Socio() {
    }

    

    public int getId_socio() {
        return id_socio;
    }

    public void setId_socio(int id_socio) {
        this.id_socio = id_socio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMulta() {
        return multa;
    }

    public void setMulta(String multa) {
        this.multa = multa;
    }
    

    @Override
    public String toString() {
        return "Socio{" + "id_socio=" + id_socio + ", nombre=" + nombre + ", telefono=" + telefono + ", direccion=" + direccion + ", email=" + email + '}';
    }    
    
}
