/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package clases;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Usuario Autorizado
 */
public class prueba {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try{
            Connection cnx = Conexion.getConexion();
            Statement stmt = cnx.createStatement();
            ResultSet rs =stmt.executeQuery("Show databases");
            System.out.println("Conectado a BD");
            while(rs.next()){
                String nombreTemp = rs.getString(1);
                System.out.println("nombreTemp "+nombreTemp);
            }
                    
            
        }catch(Exception e){
            System.out.println("error "+e);
            
        }
        
    }
    
}
