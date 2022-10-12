
package br.edu.infnet.bd.jdbc;

import com.mysql.cj.xdevapi.Result;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BDJDBC {

    public static void main(String[] args) {
        Connection conn = null;
        conn = ConnectionDB.openConnection();
        if (conn == null){
            System.out.println("Error: DB not connected");
            return;
        }
        System.out.println(getAllStudents(conn));
        //addStudent(conn);
        deleteStudent(conn);
        System.out.println(getAllStudents(conn));
        ConnectionDB.closeConnection();
    
    }
    
    public static String getAllStudents(Connection conn){
        String exit = "";
        String command = "SELECT * FROM my_bench.students";
        
        try{
            PreparedStatement ps = conn.prepareStatement(command);
            ResultSet result = ps.executeQuery();
            while(result.next()){
                String id = result.getString("id");
                String name = result.getString("name");
                String telphone = result.getString("telefone");
                
                exit += id + " " + name + " " + telphone + "\n";
            }
            
            result.close();
        }
        catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        
        return exit;
    }
    
    public static void addStudent(Connection conn){
        String command = "INSERT INTO my_bench.students(name, telefone) VALUES ('Pedro', '2154666666')";
        
        try{
            PreparedStatement ps = conn.prepareStatement(command);
            int status = ps.executeUpdate();
            
            if(status > 0)
                System.out.println("Student added");
            
            else System.out.println("Student can not be added");
            
        
        }
        
        catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
    }
    
    public static void updateStudent(Connection conn){
        String command = "UPDATE my_bench.students SET telefone='2122222222' WHERE id=4";
        
         try{
            PreparedStatement ps = conn.prepareStatement(command);
            int status = ps.executeUpdate();
            
            if(status > 0)
                System.out.println("Student updated");
            
            else System.out.println("Student can not be updated");
            
        
        }
        
        catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
    }
    
    public static void deleteStudent(Connection conn){
        String command = "DELETE FROM my_bench.students WHERE id = 5";
        
        try{
            PreparedStatement ps = conn.prepareStatement(command);
            int status = ps.executeUpdate();
            
            if(status > 0)
                System.out.println("Student deleted");
            
            else System.out.println("Student can not be deleted");
            
        
        }
        
        catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
    }
}
