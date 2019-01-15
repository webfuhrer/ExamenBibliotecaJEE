<%-- 
    Document   : verlibros
    Created on : 15-ene-2019, 9:49:57
    Author     : Mañanas
--%>

<%@page import="paquetebiblioteca.PintarHTML"%>
<%@page import="java.util.ArrayList"%>
<%@page import="paquetebiblioteca.Libro"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    ArrayList<Libro> lista_libros=(ArrayList<Libro>)request.getAttribute("lista_libros");
    String html_tabla=PintarHTML.pintarTabla(lista_libros);
    %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <%=html_tabla%>
    </body>
</html>
