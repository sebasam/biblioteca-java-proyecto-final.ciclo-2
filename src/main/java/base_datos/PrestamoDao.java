/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package base_datos;

import clases.Conexion;
import clases.DetallePrestamo;
import clases.Prestamo;
import clases.Socio;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author SEBASXD
 */
public class PrestamoDao {
    public boolean generar_prestamo(Prestamo prestamo){
        Connection conexionDB = null;
        boolean prestamo_generado = true;
        conexionDB = Conexion.getConexion();
        
        PreparedStatement prdStmt = null;
        
        try{
            String strSentencia = "insert into biblioteca_sebas.prestamos\n" +
                                    "(fecha_entrega, id_socio)\n" +
                                    "values\n" +
                                    "(?,?)";
            
            prdStmt = conexionDB.prepareStatement(strSentencia);
            
            java.sql.Date dtFechaEntrega = new java.sql.Date(prestamo.getFecha_entrega().getTime());
            prdStmt.setDate(1, dtFechaEntrega);
            prdStmt.setInt(2, prestamo.getId_socio());
            
            
            prestamo_generado = prdStmt.execute();
            System.out.println("Prestamo generado: " + prestamo_generado);
            
        }catch(Exception error){
            System.out.println("Error al generar el prestamo: " + error);
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
    
    public ArrayList<DetallePrestamo> actualizar_prestamo(){
        Connection conexionDB = null;
        conexionDB = Conexion.getConexion();
        PreparedStatement prdStmt = null;
        Prestamo prestamo = new Prestamo();
        ArrayList<DetallePrestamo> arr_prestamos = new ArrayList<DetallePrestamo>();
        
        try{
           String strSentencia;
           strSentencia = "select id_libro, id_prestamo, fecha_devolucion, estado\n" +
                    "from biblioteca_sebas.detalle_prestamos";
           
           prdStmt = conexionDB.prepareStatement(strSentencia);
           ResultSet resultado = prdStmt.executeQuery();
           
           while(resultado.next()){
               int idLibroTemp = resultado.getInt(1);               
               int idTemp = resultado.getInt(2);               
               Date devolucionTemp = resultado.getDate(3);
               String estadoTemp = resultado.getNString(4);
               
               if(estadoTemp.contains("En curso")){
                   arr_prestamos.add(new DetallePrestamo(idLibroTemp, idTemp, devolucionTemp, estadoTemp));
               }
           }
        }catch(Exception error){
            System.out.println("Error al llenar la lista " + error);            
        }finally{
            Conexion.cloConexion();
            try{
                prdStmt.close();
            }catch(Exception error){
               System.out.println("Error al cerrar la base de datos " + error); 
            }
        }
        return arr_prestamos;
    }  
    
    public Prestamo consultar_socio(Prestamo prestamo){
        Connection conexionDB = null;
        conexionDB = Conexion.getConexion();
        boolean socio_consultado = true;
        PreparedStatement prdStmt = null;
        Prestamo obj_prestamo = new Prestamo();
        try{
            String strSentencia;
            strSentencia = "select id_socio\n" +
                                "from biblioteca_sebas.prestamos\n" +
                                "where id_prestamo = ?";
            prdStmt = conexionDB.prepareStatement(strSentencia);
            prdStmt.setInt(1, prestamo.getId_prestamo());
            
            ResultSet resultado = prdStmt.executeQuery();
            
            while(resultado.next()){
                int idTemp = resultado.getInt(1);
                obj_prestamo = new Prestamo(idTemp);
                
            }
            
        }catch( Exception error){
            System.out.println("Error al llenar la Lista!!" + error);
        }finally{
            Conexion.cloConexion();
            try{
                prdStmt.close();
            }catch(Exception error){
                System.out.println("Error al cerrar la base de datos" + error);
            }
        }
        return obj_prestamo;
    }
    
    
}
