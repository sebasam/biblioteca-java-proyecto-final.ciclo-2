/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package base_datos;

import clases.Conexion;
import clases.DetallePrestamo;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author SEBASXD
 */
public class DetallePrestamoDao {
    public boolean generar_prestamo(DetallePrestamo detallePrestamo){
        Connection conexionDB = null;
        boolean prestamo_generado = true;
        conexionDB = Conexion.getConexion();
        
        PreparedStatement prdStmt = null;
        
        try{
            String strSentencia = "insert into biblioteca_sebas.detalle_prestamos\n" +
                                    "(id_libro, fecha_devolucion, estado)\n" +
                                    "values\n" +
                                    "(?,?,'En curso')";
            
            prdStmt = conexionDB.prepareStatement(strSentencia);
            prdStmt.setInt(1, detallePrestamo.getId_libro());
            //prdStmt.setInt(2, detallePrestamo.getId_prestamo());
            java.sql.Date dtFechaDevolucion = new java.sql.Date(detallePrestamo.getFecha_devolucion().getTime());
            prdStmt.setDate(2, dtFechaDevolucion);            
            
            
            prestamo_generado = prdStmt.execute();
            System.out.println("Detalle de prestamo generado: " + prestamo_generado);
            
        }catch(Exception error){
            System.out.println("Error al generar el detalle prestamo: " + error);
        }finally{
            Conexion.cloConexion();
            try{
                prdStmt.close();
            }catch(Exception error){
                System.out.println("Error al cerrar la base de datos: " + error);
            }
        }
        return prestamo_generado;
    }
    
    public boolean editar_prestamo(DetallePrestamo prestamo){
        Connection conexionDB = null;
        boolean prestamo_eliminado = true;
        conexionDB = Conexion.getConexion();
        
        PreparedStatement prdStmt = null;
        try{
            String strSentencia = "update biblioteca_sebas.detalle_prestamos\n" +
                                    "set estado='Entregado'\n" +
                                    "where id_prestamo=?";
            prdStmt = conexionDB.prepareStatement(strSentencia);
            
            prdStmt.setInt(1, prestamo.getId_prestamo());
            prestamo_eliminado = prdStmt.execute();
            if(prestamo_eliminado){
               System.out.println("Libro entregado"); 
            }            
        }catch(Exception error){
            System.out.println("Error al Entregar el libro " + error);
        }finally{
            Conexion.cloConexion();
            try{
                prdStmt.close();
            }catch(Exception error){
                System.out.println("Error al cerrar la base de datos " + error);
            }
        }
        return prestamo_eliminado;
    }
}
