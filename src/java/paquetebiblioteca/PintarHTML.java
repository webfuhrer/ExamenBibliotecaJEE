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
public class PintarHTML {
    public static String pintarTabla(ArrayList<Libro> lista_libros)
    {
        String aux="<table>";
        for (Libro libro : lista_libros) {
            aux+="<tr>";
            aux+="<td>"+libro.getNombre()+"</td>";
            aux+="<td>"+libro.getAutor()+"</td>";
            aux+="<td>"+libro.getIsbn()+"</td>";
            //En el campo prestado pondremos "prestar" si el libro no está prestado
            //y recuperar si está prestado
           //   <a href="ServletBiblioteca?accion=prestar&isbn=56565">Prestar</a>
           String enlace="";
           if (libro.isPrestado())
           {
              // enlace="<a href='ServletBiblioteca?accion=recuperar&isbn="+libro.getIsbn()+"'>Recuperar</a>";
               enlace="<form action='ServletBiblioteca' method='GET'>";
               enlace+="<input type='hidden' name='accion' value='recuperar'>";
               enlace+="<input type='hidden' name='isbn' value='"+libro.getIsbn()+"'>";
               enlace+="<input type='submit' value='Recuperar'>";
               enlace+="</form>";
           }
           else
           {
               //Libro que alguien quiere llevarse
                enlace="<form action='ServletBiblioteca' method='GET'>";
               enlace+="<input type='hidden' name='accion' value='prestar'>";
               enlace+="<input type='hidden' name='isbn' value='"+libro.getIsbn()+"'>";
               enlace+="<input type='submit' value='Prestar'>";
               enlace+="</form>";
           }
            aux+="<td>"+enlace+"</td>";
            aux+="</tr>";
        }
        aux+="</table>";
        return aux;
    }
}
