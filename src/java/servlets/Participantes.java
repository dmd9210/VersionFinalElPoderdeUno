package servlets;

import java.io.*;
import java.sql.Connection;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import dataAccess.ConnectionDB;
import dataAccess.ParticipantesDAO;

import model.Participante;

@WebServlet("/participantes")
public class Participantes extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        //Leer datos de la forma
        String idMatricula = request.getParameter("idMatricula");
        String Nombre = request.getParameter("Nombre");
        String ApellidoP = request.getParameter("ApellidoP");
        String ApellidoM = request.getParameter("ApellidoM");
        String Correo = request.getParameter("Correo");
        String Edad = request.getParameter("Edad");
        String Genero = request.getParameter("Genero");
        String Telefono = request.getParameter("Telefono");
        String NivelEstudio = request.getParameter("NivelEstudio");
        String Proyecto = request.getParameter("Proyecto");

        //Crear instancia
        Participante participante = new Participante(idMatricula, Nombre, ApellidoP, ApellidoM, Correo, Edad, Genero, Telefono, NivelEstudio, Proyecto);

        //Guardar instancia en base de datos
        ConnectionDB connectionDB = new ConnectionDB();
        Connection connection = connectionDB.getConnectionDB();

        ParticipantesDAO participantesDAO = new ParticipantesDAO(connection);
        participantesDAO.addParticipantes(participante);

        //Guardar instancia en objeto request para usarse por jsp
        request.setAttribute("participante", participante);

        //Enviar control a displayEmail.jsp
        String address = "/WEB-INF/displayParticipante.jsp";
        RequestDispatcher dispatcher
                = request.getRequestDispatcher(address);
        dispatcher.forward(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}
