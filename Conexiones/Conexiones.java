package Conexiones;

import java.sql.*; //complementos sql
import java.util.logging.Level; //excepciones try
import java.util.logging.Logger; //excepciones try
import javax.swing.JOptionPane;//para avisar errores

public class Conexiones {

Connection ccn =null;
    
    

//Connection ccn = null;
Statement st = null;

    public Conexiones(){
        try 
            { 
                String direccion = System.getProperty("user.dir")+"\\Floresdb.accdb";
             
//                String rutafile = "C:\\VentaFlores\\Floresdb.accdb";
                String Url = "jdbc:ucanaccess://" + direccion;
//                String Url = "jdbc:ucanaccess://" + rutafile;

                ccn = DriverManager.getConnection(Url);
                st = ccn.createStatement();
            } catch (SQLException e) 
                {
                    JOptionPane.showMessageDialog(null, "CONEXION ERRONEA " + e);  
                }
    }
    
    public Connection getConnection(){
        return ccn;
    }
    
    public void Desconexion(){
        try 
            {
                ccn.close();            
                System.exit(0);
            } catch (SQLException ex) 
                {
                    Logger.getLogger(Conexiones.class.getName()).log(Level.SEVERE, null, ex);
                }
    }
    
}
