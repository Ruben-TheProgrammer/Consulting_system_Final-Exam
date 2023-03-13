
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Guillermo
 */
public class conectar {
    
    private static final String db = "consultorio";
    private static final String user = "root";
    private static final String password = "";
    private static final String url = "jdbc:mysql://127.0.0.1:3306/" + db;

    private static Connection conexion;

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(conectar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(conectar.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conexion;
    }   
}
