package servlets;

import dataAccess.ConnectionDB;
import dataAccess.MarcadoresDAO;
import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Marcador;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;


@WebServlet(urlPatterns = {"/map"})
public class mapServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "inicio";
        }
        if (action.equals("inicio")) {

        } else if (action.equals("getMarcadorData")) {
            ConnectionDB connectionDB = new ConnectionDB();
            Connection connection = connectionDB.getConnectionDB();
            MarcadoresDAO marcadoresDAO = new MarcadoresDAO(connection);
            ArrayList<Marcador> marcadores = marcadoresDAO.getMarcadoresList();
            
            String json = new Gson().toJson(marcadores);
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(json);

       
    }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}