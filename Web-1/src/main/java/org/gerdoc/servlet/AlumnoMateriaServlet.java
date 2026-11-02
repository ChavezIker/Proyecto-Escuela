package org.gerdoc.servlet;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.gerdoc.model.Alumno;
import org.gerdoc.model.AlumnoMateria;
import org.gerdoc.model.Materia;
import org.gerdoc.service.AlumnoService;
import org.gerdoc.service.AlumnoMateriaService;
import org.gerdoc.service.MateriaService;
import org.gerdoc.service.impl.AlumnoServiceImpl;
import org.gerdoc.service.impl.AlumnoMateriaServiceImpl;
import org.gerdoc.service.impl.MateriaServiceImpl;

@WebServlet("/AlumnoMateriaServlet")
public class AlumnoMateriaServlet extends HttpServlet {

    private AlumnoMateriaService alumnoMateriaService = new AlumnoMateriaServiceImpl();
    private AlumnoService alumnoService = new AlumnoServiceImpl();
    private MateriaService materiaService = new MateriaServiceImpl();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "list";
        }

        switch (action) {
            case "new":
                showNewForm(request, response);
                break;
            case "insert":
                insertAlumnoMateria(request, response);
                break;
            case "delete":
                deleteAlumnoMateria(request, response);
                break;
            case "edit":
                showEditForm(request, response);
                break;
            case "update":
                updateAlumnoMateria(request, response);
                break;
            default:
                listAlumnoMateria(request, response);
                break;
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    private void listAlumnoMateria(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<AlumnoMateria> list = alumnoMateriaService.getAlumnoMateriaList();
        request.setAttribute("listAlumnoMateria", list);
        request.getRequestDispatcher("alumnoMateria.jsp").forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Alumno> alumnos = alumnoService.getAlumnoList();
        List<Materia> materias = materiaService.getMateriaList();
        request.setAttribute("alumnos", alumnos);
        request.setAttribute("materias", materias);
        request.getRequestDispatcher("alumnoMateriaForm.jsp").forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        AlumnoMateria existing = alumnoMateriaService.getAlumnoMateriaById(id);
        List<Alumno> alumnos = alumnoService.getAlumnoList();
        List<Materia> materias = materiaService.getMateriaList();
        request.setAttribute("alumnoMateria", existing);
        request.setAttribute("alumnos", alumnos);
        request.setAttribute("materias", materias);
        request.getRequestDispatcher("alumnoMateriaForm.jsp").forward(request, response);
    }

    private void insertAlumnoMateria(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Integer alumnoId = Integer.parseInt(request.getParameter("alumnoId"));
        Integer materiaId = Integer.parseInt(request.getParameter("materiaId"));
        BigDecimal calificacion = new BigDecimal(request.getParameter("calificacion"));

        Alumno alumno = alumnoService.getAlumnoById(alumnoId);
        Materia materia = materiaService.getMateriaById(materiaId);

        AlumnoMateria am = new AlumnoMateria();
        am.setAlumno(alumno);
        am.setMateria(materia);
        am.setCalificacion(calificacion);

        alumnoMateriaService.addAlumnoMateria(am);
        response.sendRedirect("AlumnoMateriaServlet");
    }

    private void updateAlumnoMateria(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        Integer alumnoId = Integer.parseInt(request.getParameter("alumnoId"));
        Integer materiaId = Integer.parseInt(request.getParameter("materiaId"));
        BigDecimal calificacion = new BigDecimal(request.getParameter("calificacion"));

        Alumno alumno = alumnoService.getAlumnoById(alumnoId);
        Materia materia = materiaService.getMateriaById(materiaId);

        AlumnoMateria am = new AlumnoMateria();
        am.setId(id);
        am.setAlumno(alumno);
        am.setMateria(materia);
        am.setCalificacion(calificacion);

        alumnoMateriaService.updateAlumnoMateria(am);
        response.sendRedirect("AlumnoMateriaServlet");
    }

    private void deleteAlumnoMateria(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        AlumnoMateria am = alumnoMateriaService.getAlumnoMateriaById(id);
        if (am != null) {
            alumnoMateriaService.deleteAlumnoMateria(am);
        }
        response.sendRedirect("AlumnoMateriaServlet");
    }
}
