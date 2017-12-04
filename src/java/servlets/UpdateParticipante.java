/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.*;
import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import dataAccess.ConnectionDB;
import dataAccess.ParticipantesDAO;

import model.Participante;

/**
 *
 * @author usuario
 */
@WebServlet("/updateParticipante")
public class UpdateParticipante extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");

        String idMatricula = request.getParameter("idMatricula");

        //buscar usuario en base de datos
        ConnectionDB connectionDB = new ConnectionDB();
        Connection connection
                = connectionDB.getConnectionDB();

        ParticipantesDAO participantesDAO = new ParticipantesDAO(connection);

        Participante participante = participantesDAO.getParticipante(idMatricula);

        request.setAttribute("participante", participante);
        //Mandar llamar a la pagina
        String address = "/WEB-INF/participaUpdate.jsp";
        RequestDispatcher dispatcher = request.getRequestDispatcher(address);
        dispatcher.forward(request, response);
    }

    public void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        // obtener todos los parametros para el usuario del request
        ConnectionDB connectionDB = new ConnectionDB();
        Connection connection
                = connectionDB.getConnectionDB();

        ParticipantesDAO participantesDAO = new ParticipantesDAO(connection);
        Participante participante = new Participante();
        participante.setIdMatricula(request.getParameter("idMatricula"));
        participante.setNombre(request.getParameter("Nombre"));
        participante.setApellidoP(request.getParameter("ApellidoP"));
        participante.setApellidoM(request.getParameter("ApellidoM"));
        participante.setCorreo(request.getParameter("Correo"));
        participante.setEdad(request.getParameter("Edad"));
        participante.setGenero(request.getParameter("Genero"));
        participante.setTelefono(request.getParameter("Telefono"));
        participante.setNivelEstudio(request.getParameter("NivelEstudio"));
        participante.setProyecto(request.getParameter("Proyecto"));
        participantesDAO.updateParticipante(participante);
        response.sendRedirect("/Proyecto_Final_ElPoderdeUno/displayAllParticipante");
    }
}
