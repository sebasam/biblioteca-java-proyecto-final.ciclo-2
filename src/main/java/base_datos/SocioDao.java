/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package base_datos;

import clases.Conexion;
import clases.Libro;
import clases.Prestamo;
import clases.Socio;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author SEBASXD
 */
public class SocioDao {
    public boolean registrar_socio(Socio socio){
        Connection conexionDB = null;
        boolean socio_registrado = true;
        conexionDB = Conexion.getConexion();
        
        PreparedStatement prdStmt = null;
        try{
            String strSentencia = "insert into biblioteca_sebas.socios\n" +
                                    "(nombre, telefono, direccion, email, multa)\n" +
                                    "values\n" +
                                    "(?,?,?,?,?)";
            prdStmt = conexionDB.prepareStatement(strSentencia);
            prdStmt.setString(1, socio.getNombre());
            prdStmt.setString(2, socio.getTelefono());
            prdStmt.setString(3, socio.getDireccion());
            prdStmt.setString(4, socio.getEmail());
            prdStmt.setString(5, socio.getMulta());
            
            
            socio_registrado = prdStmt.execute();
            System.out.println("Socio registrado: " + socio_registrado);
        }catch(Exception error){
            System.out.println("Error al registrar al socio " + error);
        }finally{
            Conexion.cloConexion();
            try{
                prdStmt.close();
            }catch(Exception error){
                System.out.println("Error al cerrar la base de datos " + error);
            }
        }
        return socio_registrado;
    }
    
    public Socio consultar_socio(Socio socio){
        Connection conexionDB = null;
        conexionDB = Conexion.getConexion();
        
        PreparedStatement prdStmt = null;
        
        Socio obj_socio = new Socio();
        try{
            String sentencia = "select nombre, telefono, direccion, email, multa\n" +
                                "from biblioteca_sebas.socios\n" +
                                "where id_socio = ?";
            
            prdStmt = conexionDB.prepareStatement(sentencia);
            prdStmt.setInt(1, socio.getId_socio());
            
            ResultSet resultado = prdStmt.executeQuery();
            while(resultado.next()){
                String nombretemp = resultado.getString(1);
                String telefonoTemp = resultado.getString(2);
                String direccionTemp = resultado.getString(3);
                String emailTemp = resultado.getString(4);
                String multaTemp = resultado.getString(5);
                
                obj_socio = new Socio(nombretemp, telefonoTemp, direccionTemp, emailTemp, multaTemp);
            }            
        }catch( Exception error){
            System.out.println("Error al consultar al autor en la base de datos" + error);
        }finally{
            Conexion.cloConexion();
            try{
                prdStmt.close();
            }catch(Exception error){
                System.out.println("Error al cerrar la base de datos" + error);
            }
        }
        return obj_socio;
    }
    
    public ArrayList<Libro> actualizar_tabla(){
        Connection conexionDB = null;
        conexionDB = Conexion.getConexion();
        PreparedStatement prdStmt = null;
        Libro libro = new Libro();
        ArrayList<Libro> arr_libros = new ArrayList<Libro>();
        
        try{
           String strSentencia;
           strSentencia = "select id_libro, nombre, estado\n" +
                    "from biblioteca_sebas.libro";
           prdStmt = conexionDB.prepareStatement(strSentencia);
           ResultSet resultado = prdStmt.executeQuery();
           
           while(resultado.next()){               
               int idTemp = resultado.getInt(1);
               String nombreTemp = resultado.getString(2);
               String estadoTemp = resultado.getString(3);
               if(estadoTemp.equals("Disponible")){
                   arr_libros.add(new Libro(idTemp, nombreTemp, estadoTemp));
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
        return arr_libros;
    }    
    
    
    public boolean actualizar_libro(Libro libro){
        Connection conexionDB = null;
        boolean libro_actualizado = true;
        conexionDB = Conexion.getConexion();
        
        PreparedStatement prdStmt = null;
        try{
            String strSentencia = "update biblioteca_sebas.libro\n" +
                                    "set estado='Prestado'\n" +
                                    "where id_libro=?";
            prdStmt = conexionDB.prepareStatement(strSentencia);
            prdStmt.setInt(1, libro.getId_libro());
            libro_actualizado = prdStmt.execute();
            System.out.println("libro actualizado");
        }catch(Exception error){
            System.out.println("Error al actualizar el libro " + error);
        }finally{
            Conexion.cloConexion();
            try{
                prdStmt.close();
            }catch(Exception error){
                System.out.println("Error al cerrar la base de datos " + error);
            }
        }
        return libro_actualizado;
    }
    
    public boolean devolver_libro(Libro libro){
        Connection conexionDB = null;
        boolean libro_devuelto = true;
        conexionDB = Conexion.getConexion();
        
        PreparedStatement prdStmt = null;
        try{
            String strSentencia = "update biblioteca_sebas.libro\n" +
                                    "set estado='Disponible'\n" +
                                    "where id_libro=?";
            prdStmt = conexionDB.prepareStatement(strSentencia);
            prdStmt.setInt(1, libro.getId_libro());
            libro_devuelto = prdStmt.execute();
            System.out.println("libro devuelto");
        }catch(Exception error){
            System.out.println("Error al devolver el libro " + error);
        }finally{
            Conexion.cloConexion();
            try{
                prdStmt.close();
            }catch(Exception error){
                System.out.println("Error al cerrar la base de datos " + error);
            }
        }
        return libro_devuelto;
    }
    
    public boolean generar_multa(Socio socio){
        Connection conexionDB = null;
        boolean multa_generada = true;
        conexionDB = Conexion.getConexion();
        
        PreparedStatement prdStmt = null;
        try{
            String strSentencia = "update biblioteca_sebas.socios\n" +
                                    "set multa='Si'\n" +
                                    "where id_socio=?";
            
            prdStmt = conexionDB.prepareStatement(strSentencia);
            prdStmt.setInt(1, socio.getId_socio());
            
            multa_generada = prdStmt.execute();
            System.out.println("multa generada");
        }catch(Exception error){
            System.out.println("Error al actualizar el libro " + error);
        }finally{
            Conexion.cloConexion();
            try{
                prdStmt.close();
            }catch(Exception error){
                System.out.println("Error al cerrar la base de datos " + error);
            }
        }
        return multa_generada;
    }
    
    public boolean eliminar_socio(Socio socio){
        Connection conexionDB = null;
        boolean socio_eliminado = true;
        conexionDB = Conexion.getConexion();
        
        PreparedStatement prdStmt = null;
        try{
            String strSentencia = "delete from biblioteca_sebas.socios\n" +
                                    "where id_socio=?";
            prdStmt = conexionDB.prepareStatement(strSentencia);
            
            prdStmt.setInt(1, socio.getId_socio());
            socio_eliminado = prdStmt.execute();
            System.out.println("socio eliminado");
        }catch(Exception error){
            System.out.println("Error al eliminar al socio  " + error);
        }finally{
            Conexion.cloConexion();
            try{
                prdStmt.close();
            }catch(Exception error){
                System.out.println("Error al cerrar la base de datos " + error);
            }
        }
        return socio_eliminado;
    }
}
