package servlets;

import java.io.*;
import java.sql.Connection;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import dataAccess.ConnectionDB;
import dataAccess.AdminDAO;

import model.Admin;

@WebServlet("/login")
public class Login extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
      
           
            ConnectionDB connectionDB = new ConnectionDB();
            Connection connection = connectionDB.getConnectionDB();
            AdminDAO adminDAO = new AdminDAO(connection);
            String usuario = request.getParameter("usuario");
            String pass = request.getParameter("pass");
            boolean found = adminDAO.findAdmin(usuario, pass);
            if (found) {
               String address = "index.jsp";
                            RequestDispatcher dispatcher
                                    = request.getRequestDispatcher(address);
                            dispatcher.forward(request, response);
            } else {
                String address = "index1.jsp";
                            RequestDispatcher dispatcher
                                    = request.getRequestDispatcher(address);
                            dispatcher.forward(request, response);
            }
     }
    
    
       
    
    @Override
    public void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}

