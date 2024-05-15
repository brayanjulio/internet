<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>
    </head>
    <body>
        <%@include file="menu.jsp"%>
        <div class="container col-7">
            <center><h1>Registro Dia del Internet</h1></center>
            <p><a href="inicio?action=add" class="btn btn-info">Nuevo</a></p>
        </div>
        <div class="container col-7">
            <table class="table table-dark table-hover">
                <tr>
                    <th>ID</th>
                    <th>NOMBRES</th>
                    <th>APELLIDOS</th>
                    <th>SEMINARIO</th>
                    <th>CONFIRMADO</th>
                    <th>FECHA</th>
                    <th></th>
                    <th></th>
                </tr>
                <c:forEach var="item" items="${estudiantes}">
                    <tr>
                        <td>${item.id}</td>
                        <td>${item.nombres}</td>
                        <td>${item.apellidos}</td>
                        <td>${item.seminario}</td>
                        <td>${item.confirmado}</td>
                        <td>${item.fecha}</td>
                        <td><a href="inicio?action=edit&id=${item.id}" class="btn btn-warning">Editar</a></td>
                        <td><a href="inicio?action=delete&id=${item.id}" onclick="return(confirm('Esta Seguro?'))" class="btn btn-danger">Eliminar</a></td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </body>
</html>
