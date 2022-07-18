/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package base_datos;

import clases.Autor;
import clases.Conexion;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author SEBASXD
 */
public class AutorDao {
    public boolean guardar_autor(Autor autor){
        
        Connection conexionDB = null;
        boolean autor_guardado = true;
        conexionDB = Conexion.getConexion();
        
        PreparedStatement prdStmt = null;
        try{
            String strSentencia = "insert into biblioteca_sebas.autor\n" +
                                "(nombre, nacionalidad, fecha_nacimiento)\n" +
                                "values\n" +
                                "(?, ?, ?)";
            prdStmt = conexionDB.prepareStatement(strSentencia);
            prdStmt.setString(1, autor.getNombre());
            prdStmt.setString(2, autor.getNacionalidad());
            java.sql.Date fecha = new java.sql.Date(autor.getFecha_nacimiento().getTime());
            prdStmt.setDate(3, fecha);
            autor_guardado = prdStmt.execute();
            System.out.println("Autor guardado: " + autor_guardado);
        }catch(Exception error){
            System.out.println("Error al guardar al autor " + error);
            
        }finally{
            Conexion.cloConexion();
            try{
                prdStmt.close();
            }catch(Exception error){
                System.out.println("Error al cerrar la base de datos " + error);
            }
        }
        
        return autor_guardado;
    }
    
    public Autor consultar_autor(Autor autor){
        Connection conexionDB = null;
        boolean autor_guardado = true;
        conexionDB = Conexion.getConexion();
        
        PreparedStatement prdStmt = null;
        
        Autor obj_autor = new Autor();
        try{
            String sentencia = "select id_autor, nombre, nacionalidad, fecha_nacimiento\n" +
                                "from biblioteca_sebas.autor\n" +
                                "where id_autor = ?";
            prdStmt = conexionDB.prepareStatement(sentencia);
            prdStmt.setInt(1,autor.getId_autor());
            
            ResultSet resultado = prdStmt.executeQuery();
            while(resultado.next()){
                int idTemp = resultado.getInt(1);
                String nombreTemp = resultado.getString(2);
                String nacionalidadTemp = resultado.getString(3);
                Date fechaTemp = resultado.getDate(4);
                
                obj_autor = new Autor(idTemp, nombreTemp, nacionalidadTemp, fechaTemp);
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
        return obj_autor;
    }
    
    public ArrayList<Autor> actualizar_tabla(){
        Connection conexionDB = null;
        conexionDB = Conexion.getConexion();
        PreparedStatement prdStmt = null;
        Autor autor = new Autor();
        
        ArrayList<Autor> arr_autores = new ArrayList<Autor>();
        try{
            String strSentencia;
            strSentencia = "select id_autor, nombre, nacionalidad, fecha_nacimiento\n" +
                    "from biblioteca_sebas.autor";
            prdStmt = conexionDB.prepareStatement(strSentencia);
            ResultSet resultado = prdStmt.executeQuery();
            
            while(resultado.next()){
                int idTemp = resultado.getInt(1);
                String nombreTemp = resultado.getString(2);
                String nacionalidadTemp = resultado.getString(3);
                Date fechaTemp = resultado.getDate(4);
                arr_autores.add(new Autor(idTemp, nombreTemp, nacionalidadTemp, fechaTemp));
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
        return arr_autores;
    }
    
    public ArrayList<Autor> autores_libro(){
        Connection conexionDB = null;
        conexionDB = Conexion.getConexion();
        PreparedStatement prdStmt = null;
        Autor autor = new Autor();
        
        ArrayList<Autor> arr_autores = new ArrayList<Autor>();
        try{
            String strSentencia;
            strSentencia = "select id_autor, nombre\n" +
                    "from biblioteca_sebas.autor";
            prdStmt = conexionDB.prepareStatement(strSentencia);
            ResultSet resultado = prdStmt.executeQuery();
            
            while(resultado.next()){
                int idTemp = resultado.getInt(1);
                String nombreTemp = resultado.getString(2);
                arr_autores.add(new Autor(idTemp, nombreTemp));
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
        return arr_autores;
    }
    
}
