/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataAccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Proyecto;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProyectosDAO {

    private PreparedStatement statement;
    private Connection connection;
    private static final Logger logger
            = Logger.getLogger(ProyectosDAO.class.getName());

    public ProyectosDAO() {

    }

    public ProyectosDAO(Connection connection) {
        this.connection = connection;
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public ArrayList<Proyecto> getProyectosList() {
        ArrayList<Proyecto> proyectosList = new ArrayList<Proyecto>();
        try {
            statement = connection.prepareStatement(" SELECT * FROM elpoderdeuno.proyecto");
            //obtain list of guard 
            synchronized (statement) {
                ResultSet results = statement.executeQuery();
                //get rows data
                while (results.next()) {
                    //aqui se agregan los atributos de la base de datos
                    Proyecto proyecto = new Proyecto();
                    proyecto.setId(results.getString("id"));
                    proyecto.setNombre(results.getString("nombre"));
                    proyectosList.add(proyecto);
                }

            }
            statement.close();

        } catch (SQLException sqle) {
            logger.log(Level.SEVERE, sqle.toString(),
                    sqle);
            throw new RuntimeException(sqle);
        }
        return proyectosList;
    }
}