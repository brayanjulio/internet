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
        <div class="container col-6">
            <center>
                <h1>
                    <c:if test="${estudiante.id == 0}">Nuevo</c:if>
                    <c:if test="${estudiante.id != 0}">Editar</c:if>
                        estudiante
                    </h1>
                </center>

            </div>
            <div class="container p-5 col-6 bg-dark text-white">
                <form action="inicio" method="post" id="myForm">
                    <input type="hidden" name="id" value="${estudiante.id}"/>
                <table class="table table-borderless">
                    <tr>
                        <td>NOMBRES:</td>
                        <td><input class="form-control" type="text" name="nombres" value="${estudiante.nombres}"/></td>
                    </tr>
                    <tr>
                        <td>APELLIDOS:</td>
                        <td><input class="form-control" type="text" name="apellidos" value="${estudiante.apellidos}"/></td>
                    </tr>
                    <tr>
                        <td>SEMINARIO:</td>
                        <td><input class="form-control" type="text" name="seminario" value="${estudiante.seminario}"/></td>
                    </tr>
                    <tr>
                        <td>CONFIRMADO:</td>
                        <td>
                            <input class="form-check-input" type="radio" name="confirmado" id="O1" value="Confirmado" checked="">
                            <label class="form-check-label" for="O1">Confirmar</label>
                            <input class="form-check-input" type="radio" name="confirmado" id="O2" value="No Confirmado" >
                            <label class="form-check-label" for="O2">Sin Corfirmar</label>
                        </td>
                    </tr>
                    <tr>
                        <td>FECHA INSCRIPCION:</td>
                        <td><input class="form-control" type="date" name="fecha" value="${estudiante.fecha}"/></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td><input class="btn btn-success" type="submit"/></td>
                    </tr>
                </table>
            </form>
        </div>
    </body>
</html>
