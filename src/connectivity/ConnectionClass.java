/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connectivity;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author masdev
 */
public class ConnectionClass {
    
    public Connection getConnetion() throws ClassNotFoundException{
       Class.forName("com.mysql.jdbc.Driver");
       java.sql.Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/forage","root", "root");
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionClass.class.getName()).log(Level.SEVERE, null, ex);
        }
        
         if (conn != null) {
		System.out.println("Vous etes connecte a la base!");
	} else {
		System.out.println("connection echoue!");
	}
        
        return null;
    }
    
}
