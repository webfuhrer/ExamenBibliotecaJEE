<%@page import="paquetebiblioteca.PintaXML"%>
<%@page import="paquetebiblioteca.Libro"%>
<%@page import="java.util.ArrayList"%>
<%    ArrayList<Libro> lista_libros=(ArrayList<Libro>)request.getAttribute("libros");    String xml=PintaXML.pintarXML(lista_libros);    %>
    <%=xml%>

