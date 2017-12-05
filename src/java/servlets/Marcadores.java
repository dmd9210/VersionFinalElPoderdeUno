package servlets;

import java.io.*;
import java.sql.Connection;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import dataAccess.ConnectionDB;
import dataAccess.MarcadoresDAO;

import model.Marcador;

@WebServlet("/marcadores")
public class Marcadores extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        //Leer datos de la forma
        String idMarcadores = request.getParameter("idMarcadores");
        String Nombre = request.getParameter("Nombre");
        String Latitud = request.getParameter("Latitud");
        String Longitud = request.getParameter("Longitud");
      

        //Crear instancia
        Marcador marcador = new Marcador(idMarcadores, Nombre, Latitud, Longitud);

        //Guardar instancia en base de datos
        ConnectionDB connectionDB = new ConnectionDB();
        Connection connection = connectionDB.getConnectionDB();

        MarcadoresDAO marcadoresDAO = new MarcadoresDAO(connection);
        marcadoresDAO.addMarcadores(marcador);

        //Guardar instancia en objeto request para usarse por jsp
        request.setAttribute("marcador", marcador);

        //Enviar control a displayEmail.jsp
        String address = "/WEB-INF/displayMarcador.jsp";
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
