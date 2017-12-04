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

import model.Comentario;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ComentariosDAO {

    private PreparedStatement statement;
    private Connection connection;
    private static final Logger logger
            = Logger.getLogger(ParticipantesDAO.class.getName());

    public ComentariosDAO() {

    }

    public ComentariosDAO(Connection connection) {
        this.connection = connection;
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public ArrayList<Comentario> getcomentariosList() {
        ArrayList<Comentario> comentariosList = new ArrayList<Comentario>();
        try {
            statement = connection.prepareStatement(" SELECT * FROM comentarios");
            //obtain list of guard 
            synchronized (statement) {
                ResultSet results = statement.executeQuery();
                //get rows data
                while (results.next()) {
                    //aqui se agregan los atributos de la base de datos
                    Comentario comentario = new Comentario();
                    comentario.setNombre(results.getString("Nombre"));
                    comentario.setEmail(results.getString("Email"));
                    comentario.setTema(results.getString("Tema"));
                    comentario.setAsunto(results.getString("Asunto"));
                    comentario.setComentario(results.getString("Comentario"));
                    comentariosList.add(comentario);
                }

            }
            statement.close();

        } catch (SQLException sqle) {
            logger.log(Level.SEVERE, sqle.toString(),
                    sqle);
            throw new RuntimeException(sqle);
        }
        return comentariosList;
    }

    public void addComentarios(Comentario comentario) {
        try {
            statement
                    = connection.prepareStatement("INSERT INTO comentarios VALUES(?,?,?,?,?)");
            synchronized (statement) {
                statement.setString(1, comentario.getNombre());
                statement.setString(2, comentario.getEmail());
                statement.setString(3, comentario.getTema());
                statement.setString(4, comentario.getAsunto());
                statement.setString(5, comentario.getComentario());
                statement.executeUpdate();
            }
            statement.close();
        } catch (SQLException sqle) {
            logger.log(Level.SEVERE,
                    sqle.toString(), sqle);
            throw new RuntimeException(sqle);
        }
    }

    public void updateComentario(Comentario update) {
        try {
            statement
                    = connection.prepareStatement("UPDATE elpoderdeuno.comentarios SET Nombre=?,Tema=?,"
                            + "Asunto=?,Comentario=? WHERE Correo=?");
            synchronized (statement) {
                statement.setString(1, update.getNombre());
                statement.setString(2, update.getEmail());
                statement.setString(3, update.getTema());
                statement.setString(4, update.getAsunto());
                statement.setString(5, update.getComentario());
                statement.executeUpdate();
            }
            statement.close();
        } catch (SQLException sqle) {
            logger.log(Level.SEVERE,
                    sqle.toString(), sqle);
            throw new RuntimeException(sqle);
        }
    }
    
    public void deleteComentario(String Email) {
        try {
            statement
                    = connection.prepareStatement("DELETE FROM elpoderdeuno.comentarios WHERE Email=?;");
            synchronized (statement) {
                statement.setString(1, Email);
                statement.executeUpdate();
            }
            statement.close();
        } catch (SQLException sqle) {
            logger.log(Level.SEVERE,
                    sqle.toString(), sqle);
            throw new RuntimeException(sqle);
        }
    }
    
    public Comentario getComentario(String email) {
        Comentario comentario = new Comentario();

        try {
            statement
                    = connection.prepareStatement("SELECT * FROM comentarios WHERE Email=?;");
            synchronized (statement) {
                statement.setString(1, email);
                statement.executeQuery();
                ResultSet results = statement.executeQuery();

                while (results.next()) {
                    comentario.setNombre(results.getString("Nombre"));
                    comentario.setEmail(results.getString("Email"));
                    comentario.setTema(results.getString("Tema"));
                    comentario.setAsunto(results.getString("Asunto"));
                    comentario.setComentario(results.getString("Comentario"));
                    
                }

            }
            statement.close();
        } catch (SQLException sqle) {
            logger.log(Level.SEVERE,
                    sqle.toString(), sqle);
            throw new RuntimeException(sqle);
        }

        return comentario;
    }

}
