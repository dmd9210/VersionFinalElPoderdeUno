package servlets;

import java.io.*;
import java.sql.Connection;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import dataAccess.ConnectionDB;
import dataAccess.ParticipantesDAO;

import model.Participante;

@WebServlet("/comentarios")
public class Comentarios extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        //Leer datos de la forma
        String Nombre = request.getParameter("Nombre");
        String Email = request.getParameter("Email");
        String Tema = request.getParameter("Tema");
        String Asunto = request.getParameter("Asunto");
        String Comentario = request.getParameter("Comentario");
     

        //Crear instancia
        Comentario comentario = new Comentario(Nombre, Nombre, Email, Tema, Asunto, Comentario);

        //Guardar instancia en base de datos
        ConnectionDB connectionDB = new ConnectionDB();
        Connection connection = connectionDB.getConnectionDB();

        ParticipantesDAO participantesDAO = new ParticipantesDAO(connection);
        participantesDAO.addParticipantes(comentario);

        //Guardar instancia en objeto request para usarse por jsp
        request.setAttribute("comentario", comentario);

        //Enviar control a displayEmail.jsp
        String address = "/WEB-INF/displayAll.jsp";
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
