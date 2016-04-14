package inm5151;

import java.sql.Connection;
import java.sql.DriverManager;
 
import javax.swing.JOptionPane;
 
public class javaconnect {
      Connection conn = null;
 
public static Connection ConnecrDB() {
 
    try {
               Class.forName("com.mysql.jdbc.Driver");
 
        Connection con = DriverManager.getConnection( "jdbc:mysql://localhost/stock","root", "root");
         
         
        return con;
 
    } catch (Exception e) {
        System.out.println("ERROR: " + e.getMessage());
    }
    return null;
}
     
}