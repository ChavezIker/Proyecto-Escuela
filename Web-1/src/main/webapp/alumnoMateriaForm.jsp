<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Formulario Alumno Materia</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="container mt-4">
    <h2><c:out value="${alumnoMateria != null ? 'Editar Registro' : 'Nuevo Registro'}"/></h2>
    
    <form action="AlumnoMateriaServlet" method="post">
        <input type="hidden" name="action" value="${alumnoMateria != null ? 'update' : 'insert'}">
        <c:if test="${alumnoMateria != null}">
            <input type="hidden" name="id" value="${alumnoMateria.id}">
        </c:if>

        <div class="mb-3">
            <label class="form-label">Alumno:</label>
            <select name="alumnoId" class="form-control" required>
                <option value="">Seleccione un alumno</option>
                <c:forEach var="a" items="${alumnos}">
                    <option value="${a.id}" <c:if test="${alumnoMateria != null && alumnoMateria.alumno.id == a.id}">selected</c:if>>
                        ${a.nombre}
                    </option>
                </c:forEach>
            </select>
        </div>

        <div class="mb-3">
            <label class="form-label">Materia:</label>
            <select name="materiaId" class="form-control" required>
                <option value="">Seleccione una materia</option>
                <c:forEach var="m" items="${materias}">
                    <option value="${m.id}" <c:if test="${alumnoMateria != null && alumnoMateria.materia.id == m.id}">selected</c:if>>
                        ${m.nombre}
                    </option>
                </c:forEach>
            </select>
        </div>

        <div class="mb-3">
            <label class="form-label">Calificación:</label>
            <input type="number" step="0.01" name="calificacion" class="form-control" value="${alumnoMateria != null ? alumnoMateria.calificacion : ''}" required>
        </div>

        <button type="submit" class="btn btn-success">Guardar</button>
        <a href="AlumnoMateriaServlet" class="btn btn-secondary">Cancelar</a>
    </form>
</body>
</html>
