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
public class Prestamo {
    private int id_prestamo;
    private Date fecha_entrega;
    private int id_socio;

    public Prestamo() {
    }

    public Prestamo(int id_prestamo) {
        this.id_prestamo = id_prestamo;
    }   

    public Prestamo(Date fecha_entrega, int id_socio) {
        this.fecha_entrega = fecha_entrega;
        this.id_socio = id_socio;
    }   

    public int getId_prestamo() {
        return id_prestamo;
    }

    public void setId_prestamo(int id_prestamo) {
        this.id_prestamo = id_prestamo;
    }

    public Date getFecha_entrega() {
        return fecha_entrega;
    }

    public void setFecha_entrega(Date fecha_entrega) {
        this.fecha_entrega = fecha_entrega;
    }

    public int getId_socio() {
        return id_socio;
    }

    public void setId_socio(int id_socio) {
        this.id_socio = id_socio;
    }

    @Override
    public String toString() {
        return "" + id_socio;
    }
    
    
    
    
    
}
