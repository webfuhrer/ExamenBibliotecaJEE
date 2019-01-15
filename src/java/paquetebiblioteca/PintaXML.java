/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquetebiblioteca;

import java.util.ArrayList;

/**
 *
 * @author Mañanas
 */
public class PintaXML {
    public static String pintarXML(ArrayList <Libro> lista_libros)
    {
        String xml="<xml>";
                xml+="<Libros>";
                for (Libro libro : lista_libros) {
                    xml+="<libro>";
                    xml+="<autor>"+libro.getAutor()+"</autor>";
                    xml+="<titulo>"+libro.getNombre()+"</titulo>";
                    xml+="<isbn>"+libro.getIsbn()+"</isbn>";
                    xml+="<prestado>"+libro.isPrestado()+"</autor>";
                    xml+="</libro>";
                    
        }
                xml+="</Libros>";
                return xml;
    }
    
    
}
