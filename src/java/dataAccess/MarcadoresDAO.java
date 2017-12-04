package dataAccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Marcador;
import java.util.logging.Level;
import java.util.logging.Logger;


public class MarcadoresDAO{

private PreparedStatement statement;
private Connection connection;
private static final Logger logger
            = Logger.getLogger(MarcadoresDAO.class.getName());

	public MarcadoresDAO(){

	}

	public MarcadoresDAO(Connection connection){
		this.connection = connection;
	}

   

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection){
		this.connection = connection;
	}

	public ArrayList<Marcador> getmarcadoresList() {
		ArrayList<Marcador> marcadoresList = new ArrayList<Marcador>();
		try {
			statement = connection.prepareStatement(" SELECT * FROM marcadores.marcador");
				//obtain list of guard 
			synchronized (statement) {
				ResultSet results = statement.executeQuery();
					//get rows data
					while (results.next()) {
                        //aqui se agregan los atributos de la base de datos
                        Marcador marcador = new Marcador();
                        marcador.setIdMarcadores(results.getString("idMarcadores"));
			marcador.setNombre(results.getString("Nombre"));
                        marcador.setLongitud(results.getString("Longitud"));
			marcador.setLatitud(results.getString("Latitud"));
                        marcadoresList.add(marcador);
			}

			}
			statement.close();

		} catch (SQLException sqle){
			logger.log(Level.SEVERE, sqle.toString(),
				sqle);
			throw new
			RuntimeException(sqle);
			}
			return marcadoresList;
	}
        
	public void addMarcadores (Marcador marcador){
		try{
			statement = 
			connection.prepareStatement("INSERT INTO marcadores.marcador VALUES(?,?,?,?)"); 
				synchronized(statement){
                                        statement.setString(1,marcador.getIdMarcadores());
					statement.setString(2,marcador.getNombre());
					statement.setString(3,marcador.getLatitud());
					statement.setString(4,marcador.getLongitud());
					
					statement.executeUpdate();
					}
					statement.close();
					} catch(SQLException sqle){
						logger.log( Level.SEVERE, 
							sqle.toString(),sqle);
						throw new
						RuntimeException(sqle);
						}
	}
        
         public void updateMarcador (Marcador marcador) {
        try {
            statement
                    = connection.prepareStatement("UPDATE marcadores.marcador SET nombre=?,latitud=?," 
                            + "longitud=? WHERE idMarcadores=?");
            synchronized (statement) {
                statement.setString(1, marcador.getNombre());
                statement.setString(2, marcador.getLatitud());
                statement.setString(3, marcador.getLongitud());
                statement.setString(4, marcador.getIdMarcadores());
                statement.executeUpdate();
            }
            statement.close();
        } catch (SQLException sqle) {
            logger.log(Level.SEVERE,
                    sqle.toString(), sqle);
            throw new RuntimeException(sqle);
        }
    }
    
    
        public void deleteMarcador(String idMarcadores) {
            try {
                statement
                        = connection.prepareStatement("DELETE FROM marcadores.marcador WHERE idMarcadores=?;");
                synchronized (statement) {
                    statement.setString(1,idMarcadores);
                    statement.executeUpdate();
                }
                statement.close();
            } catch (SQLException sqle) {
                logger.log(Level.SEVERE,
                        sqle.toString(), sqle);
                throw new RuntimeException(sqle);
            }
        }
    
    public Marcador getMarcador(String idMarcadores) {
        Marcador marcador = new Marcador();

        try {
            statement
                    = connection.prepareStatement("SELECT * FROM marcadores.marcador WHERE idMarcadores=?;");
            synchronized (statement) {
                statement.setString(1, idMarcadores);
                statement.executeQuery();
                ResultSet results = statement.executeQuery();

                while (results.next()) {
                    marcador.setIdMarcadores(results.getString("idMarcadores"));
                    marcador.setNombre(results.getString("Nombre"));
                    marcador.setLatitud(results.getString("Latitud"));
                    marcador.setLongitud(results.getString("Longitud"));
                    
                }

            }
            statement.close();
        } catch (SQLException sqle) {
            logger.log(Level.SEVERE,
                    sqle.toString(), sqle);
            throw new RuntimeException(sqle);
        }

        return marcador;
    }

    
    
    public ArrayList<Marcador> getMarcadoresList() {
        ArrayList<Marcador> marcadoresList = new ArrayList<Marcador>();
       
        try {
            statement = connection.prepareStatement("SELECT * FROM marcadores.marcador;");
            synchronized (statement) {
                ResultSet results = statement.executeQuery();
                while (results.next()) {
                    Marcador marcador = new Marcador();
                    marcador.setNombre(results.getString("nombre"));
                    marcador.setLatitud(results.getString("latitud"));
                    marcador.setLongitud(results.getString("longitud"));
                   
                    marcadoresList.add(marcador);
                }
            }
            statement.close();
        } catch (SQLException sqle) {
            logger.log(Level.SEVERE, sqle.toString(), sqle);
            throw new RuntimeException(sqle);
        }
        return marcadoresList;
    }
}

    
        
        
	



