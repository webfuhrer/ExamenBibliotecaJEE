package paquetebiblioteca;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mañanas
 */
class AccesoBD {
    static String usuario="root";
    static String password="";
    static String url="jdbc:mysql://localhost:3306/biblioteca";

    
   /* static void insertarContacto(Contacto c) {
        Properties info=new Properties();
                info.setProperty("user", usuario);
                info.setProperty("password",password);
        try {
            Connection conexion=DriverManager.getConnection(url, info);
            Statement stmt=conexion.createStatement();
            String query="INSERT INTO agenda VALUES('"+c.getNombre()+"', '"+c.getEmail()+"', '"
                    + c.getTelefono()+"')";
            
            stmt.executeUpdate(query);
            stmt.close();
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(AccesoBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }*/

    static ArrayList<Libro> listarLibros(String nombre_buscado) {
        try {
            //Si nombre buscado está vacío realmente hay que ñistar todos
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AccesoBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        ArrayList<Libro> lista_libros=new ArrayList();
        Properties info=new Properties();
                info.setProperty("user", usuario);
                info.setProperty("password",password);
        try {
            Connection conexion=DriverManager.getConnection(url, info);
            Statement stmt=conexion.createStatement();
            String query ="SELECT * FROM libros ";
            if(nombre_buscado.equals(""))
            {}
            else
            {
                query=query+" WHERE nombre LIKE '%"+nombre_buscado+"%'";
            }
           
            ResultSet rs=stmt.executeQuery(query);
            while(rs.next())
            {
                String nombre=rs.getString("nombre");
                String autor=rs.getString("autor");
                String isbn=rs.getString("isbn");
                boolean prestado=rs.getBoolean("prestado");
                Libro c=new Libro(nombre, autor, isbn, prestado);
                lista_libros.add(c);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccesoBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return lista_libros;
    }

    static void cambiarEstadoLibro(String isbn, boolean prestado) {
       try {
           try {
               //Si nombre buscado está vacío realmente hay que ñistar todos
               Class.forName("com.mysql.jdbc.Driver");
           } catch (ClassNotFoundException ex) {
               Logger.getLogger(AccesoBD.class.getName()).log(Level.SEVERE, null, ex);
           }
           ArrayList<Libro> lista_libros=new ArrayList();
           Properties info=new Properties();
           info.setProperty("user", usuario);
           info.setProperty("password",password);
           
           Connection conexion=DriverManager.getConnection(url, info);
           Statement stmt=conexion.createStatement();
           String query="UPDATE libros SET prestado="+prestado+" WHERE isbn='"+isbn+"';";
           stmt.executeUpdate(query);
       } catch (SQLException ex) {
            Logger.getLogger(AccesoBD.class.getName()).log(Level.SEVERE, null, ex);
        }
      
        
    }

    
    
    
    
}
