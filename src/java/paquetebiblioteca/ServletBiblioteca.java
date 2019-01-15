/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquetebiblioteca;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Mañanas
 */
@WebServlet(name = "ServletBiblioteca", urlPatterns = {"/ServletBiblioteca"})
public class ServletBiblioteca extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      String accion=request.getParameter("accion");
      if (accion.equals("xml"))
      {
          //1-Recupero datos de BD
          //2-Los envío a verxml.jsp
          //3-En verxml.jsp salen los datos
          ArrayList<Libro> lista_libros=AccesoBD.listarLibros("");
          request.setAttribute("libros", lista_libros);
          request.getRequestDispatcher("verxml.jsp").forward(request, response);
          
      }else if (accion.equals("buscar"))
      {
          //Recupero el nombre para buscar
          String nombre_buscado=request.getParameter("nombre_buscado");
           ArrayList<Libro> lista_libros=AccesoBD.listarLibros(nombre_buscado);
           request.setAttribute("lista_libros", lista_libros);
           request.getRequestDispatcher("verlibros.jsp").forward(request, response);
      }else if (accion.equals("prestar"))
      {
      String isbn=request.getParameter("isbn");
      AccesoBD.cambiarEstadoLibro(isbn, true);//UPDATE libros SET prestado =true WHERE ISBN=isbn
       ArrayList<Libro> lista_libros=AccesoBD.listarLibros("");
       request.setAttribute("lista_libros", lista_libros);
           request.getRequestDispatcher("verlibros.jsp").forward(request, response);
      }else if(accion.equals("recuperar"))
      {
          String isbn=request.getParameter("isbn");
      AccesoBD.cambiarEstadoLibro(isbn, false);//UPDATE libros SET prestado =true WHERE ISBN=isbn
       ArrayList<Libro> lista_libros=AccesoBD.listarLibros("");
       request.setAttribute("lista_libros", lista_libros);
           request.getRequestDispatcher("verlibros.jsp").forward(request, response);
      }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
