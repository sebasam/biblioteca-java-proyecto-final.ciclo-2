/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package base_datos;

import clases.Conexion;
import clases.Libro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author SEBASXD
 */
public class LibroDao {
    public boolean guardar_libro(Libro libro){
        
        Connection conexionDB = null;
        boolean datos_guardados = true;
        conexionDB = Conexion.getConexion();
        
        //java la solicita para poder realizar peticiones con sql         
        PreparedStatement prdStmt = null;        
        try{
            String strSentencia = "insert into biblioteca_sebas.libro " +
                    "(nombre, editorial, año, estado, id_autor) " +
                    "values" +
                    "(?,?,?,?,?)";
            prdStmt = conexionDB.prepareStatement(strSentencia);
            prdStmt.setString(1, libro.getNombre());
            prdStmt.setString(2, libro.getEditorial());
            prdStmt.setInt(3, libro.getAño());
            prdStmt.setString(4, libro.getEstado());
            prdStmt.setInt(5, libro.getId_autor());
            datos_guardados = prdStmt.execute();
            System.out.println("Datos guardados: " + datos_guardados);
            
        }catch(Exception error){
           System.out.println("Se presento un error al guardar el libro" + error);          
        }finally{
            Conexion.cloConexion();
            try{
                prdStmt.close();
            }catch(Exception error){
                System.out.println("Error al cerrar la base de datos" + error);
            }
        }
        return datos_guardados;
    }
    
    //consultar cliente
    public Libro consultar_libro(Libro libro){
        Connection conexionDB = null;
        boolean datos_guardados = true;
        conexionDB = Conexion.getConexion();
        
        //java la solicita para poder realizar peticiones con sql         
        PreparedStatement  prdStmt = null;
        
        Libro obj_libro = new Libro();
        try{
            String strSentencia = "select id_libro, nombre, editorial, año, estado, id_autor " +
                                    "from biblioteca_sebas.libro " +
                                    "where id_libro = ?";
            prdStmt = conexionDB.prepareStatement(strSentencia);
            prdStmt.setInt(1, libro.getId_libro());
            
            ResultSet resultado = prdStmt.executeQuery();
            while(resultado.next()){
                int idTemp = resultado.getInt(1);
                String nombreTemp = resultado.getString(2);
                String editorialTemp = resultado.getString(3);
                int añoTemp = resultado.getInt(4);
                String estadoTemp = resultado.getString(5);
                int idAutorTemp = resultado.getInt(6);
                
                obj_libro = new Libro(idTemp, nombreTemp, editorialTemp, añoTemp, estadoTemp, idAutorTemp);
            }
            
        }catch(Exception error){
            System.out.println("Error al consultar el libro en la base de datos" + error);
        }finally{
            Conexion.cloConexion();
            try{
                prdStmt.close();
            }catch(Exception error){
                System.out.println("Error al cerrar la base de datos" + error);
            }
        }
        return obj_libro;
    }    
    
    public ArrayList<Libro> actualizar_tabla(){
        Connection conexionDB = null;
        conexionDB = Conexion.getConexion();
        PreparedStatement prdStmt = null;
        Libro libro = new Libro();
        ArrayList<Libro> arr_libros = new ArrayList<Libro>();
        
        try{
           String strSentencia;
           strSentencia = "select id_libro, nombre, editorial, año, estado\n" +
                    "from biblioteca_sebas.libro";
           prdStmt = conexionDB.prepareStatement(strSentencia);
           ResultSet resultado = prdStmt.executeQuery();
           
           while(resultado.next()){
               int idTemp = resultado.getInt(1);
               String nombreTemp = resultado.getString(2);
               String editorialTemp = resultado.getString(3);
               int añoTemp = resultado.getInt(4);
               String estadoTemp = resultado.getString(5);
               arr_libros.add(new Libro(idTemp, nombreTemp, editorialTemp, añoTemp, estadoTemp));
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
    
}
