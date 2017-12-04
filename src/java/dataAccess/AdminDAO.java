package dataAccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Admin;
import java.util.logging.Level;
import java.util.logging.Logger;


public class AdminDAO{

private PreparedStatement statement;
private Connection connection;
private static final Logger logger
            = Logger.getLogger(AdminDAO.class.getName());

	public AdminDAO(){

	}

	public AdminDAO(Connection connection){
		this.connection = connection;
	}

   

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection){
		this.connection = connection;
	}

        public boolean findAdmin(String usuario, String pass) {
        Admin admin = null;
        try {
            statement = connection.prepareStatement("SELECT * FROM marcadores.admin WHERE usuario = ? AND pass = ?");
            statement.setString(1, usuario);
            statement.setString(2, pass);
            synchronized (statement) {
                ResultSet results = statement.executeQuery();

                while (results.next()) {
                    admin = new Admin();
                    admin.setUsuario(results.getString("usuario"));
                    admin.setPass(results.getString("pass"));
                }
            }
            statement.close();
        } catch (SQLException e) {
            System.err.println(e);
        }
        if (admin != null) {
            return true;
        }
        return false;
    }
	

}

    
        
        
	


