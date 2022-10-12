package br.edu.infnet.bd.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
    private static Connection conn;
    
    public static Connection openConnection(){
        try{
            System.out.println("Connecting to DB..");
            Class.forName("com.mysql.cj.jdbc.Driver");
            String connectionString = "jdbc:mysql://localhost/my_bench";
            String userName = "root";
            String password = "hcb@2608";
            conn = DriverManager.getConnection(connectionString, userName, password);
            System.out.println("DB connected.");
        }
       catch(ClassNotFoundException ex){
           System.out.println("Error: Driver not found.");
       }
        catch(SQLException ex){System.out.println("Error: failed to connect.");}
    
       return conn;
}
    public static void closeConnection(){
        try{conn.close();}
        catch(SQLException ex){System.out.println(ex.getMessage());}
    }
}
