<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Sistema Escolar</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="container mt-5">
    <div class="text-center">
        <h1 class="mb-4">Sistema de Gestión Escolar</h1>
        <div class="list-group w-50 mx-auto">
            <a href="Alumnos.jsp" class="list-group-item list-group-item-action">Catálogo Alumnos</a>
            <a href="Materias.jsp" class="list-group-item list-group-item-action">Catálogo Materias</a>
            <a href="Profesores.jsp" class="list-group-item list-group-item-action">Catálogo Profesores</a>
            <a href="ProfesorMaterias.jsp" class="list-group-item list-group-item-action">Catálogo Profesor Materia</a>
            <a href="AlumnoMateriaServlet" class="list-group-item list-group-item-action">Catálogo Alumno Materia</a>
        </div>
    </div>
</body>
</html>
