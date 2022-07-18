/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.TimeZone;
import javax.swing.JOptionPane;
/**
 *
 * @author SEBASXD
 */
public class Conexion {
     private static Connection cnx = null;
    public static Connection getConexion() 
    {
            //buscar driver
            try
            {
                    Class.forName("com.mysql.jdbc.Driver");
            }catch(Exception e){
                    JOptionPane.showMessageDialog(null, "Se presento error con el driver"+e);
            }
            
            try{
                    String url = "jdbc:mysql://127.0.0.1:3306/biblioteca_sebas?serverTimezone=" + TimeZone.getDefault().getID();
                    cnx = DriverManager.getConnection(url, "root", "Colombia005");
            } 
            catch (SQLException ex) {

                    JOptionPane.showMessageDialog(null, "Se presento error al conectar a la base de datos "+ex.getMessage());
            } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Se presento error al conectar a la base de datos "+ex.getMessage());
            }
            return cnx;
    }
    
    public static void cloConexion() 
    {
            //metodo que cierra la conexion a la base de datos
            if (cnx != null) 
            {
                try
                {
                    cnx.close();
                }catch(Exception error)
                {
                    System.out.println("Se presento error al cerrar la conexion "+error);
                }   
            }
    }
}
