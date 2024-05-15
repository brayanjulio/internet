<%-- 
    Document   : scriptBD
    Created on : 15 may. de 2024, 03:08:39
    Author     : David

    CREATE DATABASE IF NOT EXISTS `bd_internet` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
    USE `bd_internet`;

    CREATE TABLE IF NOT EXISTS `estudiantes` (
      `id` int NOT NULL AUTO_INCREMENT,
      `nombres` varchar(50) NOT NULL DEFAULT '0',
      `apellidos` varchar(50) NOT NULL DEFAULT '0',
      `seminario` varchar(50) NOT NULL DEFAULT '0',
      `confirmado` varchar(50) NOT NULL DEFAULT '0',
      `fecha` date NOT NULL,
      PRIMARY KEY (`id`)
    ) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

    INSERT INTO `estudiantes` (`id`, `nombres`, `apellidos`, `seminario`, `confirmado`, `fecha`) VALUES
            (1, 'David Daniel', 'Condori Gomez', 'Base de Datos', 'No Confirmado', '2024-05-14'),
            (2, 'Ana Liz', 'Carrillo Campero', 'Base de Datos 2', 'No Confirmado', '2024-05-15');
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
    </body>
</html>
