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

import model.Participante;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ParticipantesDAO {

    private PreparedStatement statement;
    private Connection connection;
    private static final Logger logger
            = Logger.getLogger(ParticipantesDAO.class.getName());

    public ParticipantesDAO() {

    }

    public ParticipantesDAO(Connection connection) {
        this.connection = connection;
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public ArrayList<Participante> getparticipantesList() {
        ArrayList<Participante> participantesList = new ArrayList<Participante>();
        try {
            statement = connection.prepareStatement(" SELECT * FROM participante");
            //obtain list of guard 
            synchronized (statement) {
                ResultSet results = statement.executeQuery();
                //get rows data
                while (results.next()) {
                    //aqui se agregan los atributos de la base de datos
                    Participante participante = new Participante();
                    participante.setIdMatricula(results.getString("idMatricula"));
                    participante.setNombre(results.getString("Nombre"));
                    participante.setApellidoP(results.getString("ApellidoP"));
                    participante.setApellidoM(results.getString("ApellidoM"));
                    participante.setCorreo(results.getString("Correo"));
                    participante.setEdad(results.getString("Edad"));
                    participante.setGenero(results.getString("Genero"));
                    participante.setTelefono(results.getString("Telefono"));
                    participante.setNivelEstudio(results.getString("NivelEstudio"));
                    participante.setProyecto(results.getString("Proyecto"));
                    participantesList.add(participante);
                }

            }
            statement.close();

        } catch (SQLException sqle) {
            logger.log(Level.SEVERE, sqle.toString(),
                    sqle);
            throw new RuntimeException(sqle);
        }
        return participantesList;
    }

    public void addParticipantes(Participante participante) {
        try {
            statement
                    = connection.prepareStatement("INSERT INTO participante VALUES(?,?,?,?,?,?,?,?,?,?)");
            synchronized (statement) {
                statement.setString(1, participante.getidMatricula());
                statement.setString(2, participante.getNombre());
                statement.setString(3, participante.getApellidoP());
                statement.setString(4, participante.getApellidoM());
                statement.setString(5, participante.getCorreo());
                statement.setString(6, participante.getEdad());
                statement.setString(7, participante.getGenero());
                statement.setString(8, participante.getTelefono());
                statement.setString(9, participante.getNivelEstudio());
                statement.setString(10, participante.getProyecto());
                statement.executeUpdate();
            }
            statement.close();
        } catch (SQLException sqle) {
            logger.log(Level.SEVERE,
                    sqle.toString(), sqle);
            throw new RuntimeException(sqle);
        }
    }

    public void updateParticipante(Participante update) {
        try {
            statement
                    = connection.prepareStatement("UPDATE elpoderdeuno.participante SET Nombre=?,ApellidoP=?,"
                            + "ApellidoM=?,Correo=?,Edad=?,Genero=?,"
                            + "Telefono=?,NivelEstudio=?,Proyecto=? WHERE IdMatricula=?");
            synchronized (statement) {
                statement.setString(1, update.getNombre());
                statement.setString(2, update.getApellidoP());
                statement.setString(3, update.getApellidoM());
                statement.setString(4, update.getCorreo());
                statement.setString(5, update.getEdad());
                statement.setString(6, update.getGenero());
                statement.setString(7, update.getTelefono());
                statement.setString(8, update.getNivelEstudio());
                statement.setString(9, update.getProyecto());
                statement.setString(10, update.getidMatricula());
                statement.executeUpdate();
            }
            statement.close();
        } catch (SQLException sqle) {
            logger.log(Level.SEVERE,
                    sqle.toString(), sqle);
            throw new RuntimeException(sqle);
        }
    }
    
    public void deleteParticipante(String idMatricula) {
        try {
            statement
                    = connection.prepareStatement("DELETE FROM elpoderdeuno.participante WHERE idMatricula=?;");
            synchronized (statement) {
                statement.setString(1, idMatricula);
                statement.executeUpdate();
            }
            statement.close();
        } catch (SQLException sqle) {
            logger.log(Level.SEVERE,
                    sqle.toString(), sqle);
            throw new RuntimeException(sqle);
        }
    }
    
    public Participante getParticipante(String matricula) {
        Participante participante = new Participante();

        try {
            statement
                    = connection.prepareStatement("SELECT * FROM participante WHERE idMatricula=?;");
            synchronized (statement) {
                statement.setString(1, matricula);
                statement.executeQuery();
                ResultSet results = statement.executeQuery();

                while (results.next()) {
                    participante.setIdMatricula(results.getString("idMatricula"));
                    participante.setNombre(results.getString("Nombre"));
                    participante.setApellidoP(results.getString("ApellidoP"));
                    participante.setApellidoM(results.getString("ApellidoM"));
                    participante.setCorreo(results.getString("Correo"));
                    participante.setEdad(results.getString("Edad"));
                    participante.setGenero(results.getString("Genero"));
                    participante.setTelefono(results.getString("Telefono"));
                    participante.setNivelEstudio(results.getString("NivelEstudio"));
                    participante.setProyecto(results.getString("Proyecto"));
                }

            }
            statement.close();
        } catch (SQLException sqle) {
            logger.log(Level.SEVERE,
                    sqle.toString(), sqle);
            throw new RuntimeException(sqle);
        }

        return participante;
    }

}
