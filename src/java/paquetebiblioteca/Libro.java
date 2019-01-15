/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquetebiblioteca;

/**
 *
 * @author Mañanas
 */
public class Libro {
    private String nombre, autor, isbn;
    private boolean prestado; 

    public Libro(String nombre, String autor, String isbn, boolean prestado) {
        this.nombre = nombre;
        this.autor = autor;
        this.isbn = isbn;
        this.prestado = prestado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public boolean isPrestado() {
        return prestado;
    }

    public void setPrestado(boolean prestado) {
        this.prestado = prestado;
    }
    
}
