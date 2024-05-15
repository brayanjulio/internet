package com.emergentes.controlador;

import com.emergentes.dao.EstudianteDAO;
import com.emergentes.dao.EstudianteDAOimpl;
import com.emergentes.modelo.Estudiante;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Inicio", urlPatterns = {"/inicio"})
public class Inicio extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            EstudianteDAO dao = new EstudianteDAOimpl();
            int id;
            Estudiante est = new Estudiante();
            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";

            switch (action) {
                case "add":
                    request.setAttribute("estudiante", est);
                    request.getRequestDispatcher("formestudiante.jsp").forward(request, response);
                    break;
                case "edit":
                    id = Integer.parseInt(request.getParameter("id"));
                    est = dao.getById(id);
                    System.out.println(est);
                    request.setAttribute("estudiante", est);
                    request.getRequestDispatcher("formestudiante.jsp").forward(request, response);
                    break;
                case "delete":
                    id = Integer.parseInt(request.getParameter("id"));
                    dao.delete(id);
                    response.sendRedirect(request.getContextPath() + "/inicio");
                    break;
                case "view":
                    List<Estudiante> lista = dao.getAll();
                    request.setAttribute("estudiantes", lista);
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                default:
                    break;
            }
        } catch (Exception ex) {
            System.out.println("Error" + ex.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String nombres = request.getParameter("nombres");
        String apellidos = request.getParameter("apellidos");
        String seminario = request.getParameter("seminario");
        String confirmado = request.getParameter("confirmado");
        String fecha = request.getParameter("fecha");
        Estudiante est = new Estudiante();
        est.setId(id);
        est.setNombres(nombres);
        est.setApellidos(apellidos);
        est.setSeminario(seminario);
        est.setConfirmado(confirmado);
        est.setFecha(fecha);
        if (id == 0) {
            try {
                EstudianteDAO dao = new EstudianteDAOimpl();
                dao.insert(est);
                response.sendRedirect(request.getContextPath() + "/inicio");
            } catch (Exception ex) {
                System.out.println("Error" + ex.getMessage());
            }

        } else {
            try {
                EstudianteDAO dao = new EstudianteDAOimpl();
                dao.update(est);
                response.sendRedirect(request.getContextPath() + "/inicio");
            } catch (Exception ex) {
                System.out.println("Error" + ex.getMessage());
            }
        }
    }
}
