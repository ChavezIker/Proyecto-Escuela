<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Catálogo Alumno Materia</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="container mt-4">
    <h2>Catálogo Alumno Materia</h2>
    <a href="AlumnoMateriaServlet?action=new" class="btn btn-primary mb-3">Nuevo Registro</a>
    <a href="index.jsp" class="btn btn-secondary mb-3">Regresar al Menú</a>
    
    <table class="table table-striped">
        <thead>
            <tr>
                <th>ID</th>
                <th>Alumno</th>
                <th>Materia</th>
                <th>Calificación</th>
                <th>Acciones</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="am" items="${listAlumnoMateria}">
                <tr>
                    <td>${am.id}</td>
                    <td>${am.alumno.nombre}</td>
                    <td>${am.materia.nombre}</td>
                    <td>${am.calificacion}</td>
                    <td>
                        <a href="AlumnoMateriaServlet?action=edit&id=${am.id}" class="btn btn-warning btn-sm">Editar</a>
                        <a href="AlumnoMateriaServlet?action=delete&id=${am.id}" class="btn btn-danger btn-sm" onclick="return confirm('¿Estás seguro?')">Eliminar</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
