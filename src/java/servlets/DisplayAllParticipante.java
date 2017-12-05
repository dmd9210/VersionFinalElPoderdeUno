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
import dataAccess.ProyectosDAO;
import model.Proyecto;
import model.Participante;


/**
 *
 * @author usuario
 */
@WebServlet("/displayAllParticipante")
public class DisplayAllParticipante extends HttpServlet{
	@Override 
	public void doGet(HttpServletRequest request,
		HttpServletResponse response)
	throws ServletException, IOException {
            response.setCharacterEncoding("utf-8");
		//buscar usuario en base de datos
		ConnectionDB connectionDB = new ConnectionDB();
		Connection connection = 
		connectionDB.getConnectionDB();

		ParticipantesDAO participantesDAO = new ParticipantesDAO(connection);
		ProyectosDAO proyectosDAO = new ProyectosDAO(connection);
		ArrayList<Participante> participantesList = participantesDAO.getparticipantesList();
		ArrayList<Proyecto> proyectosList = proyectosDAO.getProyectosList();

		//guardar instancia

		request.setAttribute("ParticipantesList", participantesList);
		request.setAttribute("proyectosList", proyectosList);

		//Mandar llamar a la pagina
		String address = "/WEB-INF/displayParticipante.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(address);
		dispatcher.forward(request,response);
	}
	public void doPost(HttpServletRequest request,
		HttpServletResponse response)
	throws ServletException, IOException {
		doGet(request, response);
	}
}