package dataAccess;

import java.sql.*;
import java.util.logging.Logger;
import java.util.logging.Level;



public class ConnectionDB {
	
    private Connection connection = null;
    private static final Logger logger = Logger.getLogger( ConnectionDB.class.getName() );
	
    public ConnectionDB() {
     try {
    
    Class.forName("com.mysql.jdbc.Driver");
    String dbName = "elpoderdeuno";
    String host = "localhost";
    String url = "jdbc:mysql://"+host+":3306/"+dbName;
    String user = "root";
    String password = "Futbold1392#";
    connection= DriverManager.getConnection(url,user,password);
	 
     /* String host = "localhost"; 
      Class.forName("org.postgresql.Driver");
 	   String url = "jdbc:postgresql://"+host+":5432/tec", 
 	          user="postgres",
 	          password="postgres";  
		connection = DriverManager.getConnection(url, user, password);
	*/	
     } catch (SQLException sqle){
         logger.log( Level.SEVERE, sqle.toString(), sqle );
    	 throw new RuntimeException(sqle);
     } catch (Exception e){
         logger.log( Level.SEVERE, e.toString(), e );
     }
   }
	
    public ConnectionDB(String driver, String url, String user, String password) {
        try {
		Class.forName(driver);
		connection = DriverManager.getConnection(url, user, password);
	     } catch (SQLException sqle){
	    	 throw new RuntimeException(sqle);
	     } catch (Exception e){
	    	 logger.log( Level.SEVERE, e.toString(), e );
	     }
	   }
	
   public Connection getConnectionDB() {
	   return connection;
   }
   
   public void setConnectionDB(Connection connection) {
	   this.connection = connection;
   }
   
   public void closeConnectionDB(Connection connection){
      if (connection!=null) {
    	  try {
             connection.close();
          }
          // process SQLException on close operation
         catch ( SQLException sqle ) {
              logger.log( Level.SEVERE, sqle.toString(), sqle );
              throw new RuntimeException(sqle);
          }
      }
   }
}



