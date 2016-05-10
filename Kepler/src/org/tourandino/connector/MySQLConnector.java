package org.tourandino.connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnector {

	public static Connection getConnection() throws ClassNotFoundException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/KEPLER_TEST",
                    "root", "argentina");
            return con;
        } catch (SQLException ex) {
            System.out.println("Database.getConnection() Error -->" + ex.getMessage());
            return null;
        }
    }
 
    public static void close(Connection con) {
        try {
            con.close();
        } catch (SQLException ex) {
        }
    }
}
