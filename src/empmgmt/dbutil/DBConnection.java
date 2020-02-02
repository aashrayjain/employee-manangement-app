/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empmgmt.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author hp
 */
public class DBConnection {
    private static Connection conn;
    static{
        try{
            Class.forName("oracle.jdbc.OracleDriver");
            conn=DriverManager.getConnection("jdbc:oracle:thin:@//DESKTOP-Q9C3SPF:1521/xe", "aashrayj", "abcd");
            System.out.println("Connection opened!");
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null,"DB Error in opening connection in DBConnection","Error!",JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }
    public static Connection getConnection(){
        return conn;
    }
    public static void closeConnection(){
        try{
            conn.close();
            System.out.println("Connection closed!");
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"DB Error in closing connection in DBConnection","Error!",JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }
}
