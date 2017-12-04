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
import dataAccess.MarcadoresDAO;

import model.Marcador;


/**
 *
 * @author usuario
 */
@WebServlet("/displayAllMarcadores")
public class DisplayAllMarcadores extends HttpServlet{
	@Override 
	public void doGet(HttpServletRequest request,
		HttpServletResponse response)
	throws ServletException, IOException {
            response.setCharacterEncoding("utf-8");
		//buscar usuario en base de datos
		ConnectionDB connectionDB = new ConnectionDB();
		Connection connection = 
		connectionDB.getConnectionDB();

		MarcadoresDAO marcadoresDAO = new MarcadoresDAO(connection);
		ArrayList<Marcador> marcadoresList = marcadoresDAO.getmarcadoresList();

		//guardar instancia

		request.setAttribute("MarcadoresList", marcadoresList);

		//Mandar llamar a la pagina
		String address = "/WEB-INF/displayMarcadores.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(address);
		dispatcher.forward(request,response);
	}
	public void doPost(HttpServletRequest request,
		HttpServletResponse response)
	throws ServletException, IOException {
		doGet(request, response);
	}
}