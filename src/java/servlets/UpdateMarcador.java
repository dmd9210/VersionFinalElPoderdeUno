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
import dataAccess.MarcadoresDAO;

import model.Marcador;

/**
 *
 * @author usuario
 */
@WebServlet("/updateMarcador")
public class UpdateMarcador extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");

        String idMarcadores = request.getParameter("idMarcadores");

        //buscar usuario en base de datos
        ConnectionDB connectionDB = new ConnectionDB();
        Connection connection
                = connectionDB.getConnectionDB();

        MarcadoresDAO marcadoresDAO = new MarcadoresDAO(connection);

        Marcador marcador = marcadoresDAO.getMarcador(idMarcadores);

        request.setAttribute("marcador", marcador);
        //Mandar llamar a la pagina
        String address = "/WEB-INF/marcadorUpdate.jsp";
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

        MarcadoresDAO marcadoresDAO = new MarcadoresDAO(connection);
        Marcador marcador = new Marcador();
        marcador.setIdMarcadores(request.getParameter("IdMarcadores"));
        marcador.setNombre(request.getParameter("Nombre"));
        marcador.setLatitud(request.getParameter("Latitud"));
        marcador.setLongitud(request.getParameter("Longitud"));
       
        marcadoresDAO.updateMarcador(marcador);
        response.sendRedirect("/VersionFinalElPoderdeUno/displayAllMarcadores");
    }
}
