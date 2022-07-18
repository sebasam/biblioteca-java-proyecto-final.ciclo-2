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
public class DetallePrestamo {
    private int id_libro;
    private int id_prestamo;
    private Date fecha_devolucion;
    private String estado;

    public DetallePrestamo() {
    }

    public DetallePrestamo(int id_prestamo) {
        this.id_prestamo = id_prestamo;
    }    
    

    public DetallePrestamo(int id_libro, Date fecha_devolucion) {
        this.id_libro = id_libro;
        this.fecha_devolucion = fecha_devolucion;
    }    

    public DetallePrestamo(int id_libro, int id_prestamo, Date fecha_devolucion, String estado) {
        this.id_libro = id_libro;
        this.id_prestamo = id_prestamo;
        this.fecha_devolucion = fecha_devolucion;
        this.estado = estado;
    }

    public DetallePrestamo(int id_libro, int id_prestamo, Date fecha_devolucion) {
        this.id_libro = id_libro;
        this.id_prestamo = id_prestamo;
        this.fecha_devolucion = fecha_devolucion;
    }
    
    

    public int getId_libro() {
        return id_libro;
    }

    public void setId_libro(int id_libro) {
        this.id_libro = id_libro;
    }

    public int getId_prestamo() {
        return id_prestamo;
    }

    public void setId_prestamo(int id_prestamo) {
        this.id_prestamo = id_prestamo;
    }

    public Date getFecha_devolucion() {
        return fecha_devolucion;
    }

    public void setFecha_devolucion(Date fecha_devolucion) {
        this.fecha_devolucion = fecha_devolucion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "detalle_prestamo{" + "id_libro=" + id_libro + ", id_prestamo=" + id_prestamo + ", fecha_devolucion=" + fecha_devolucion + ", estado=" + estado + '}';
    }
}
