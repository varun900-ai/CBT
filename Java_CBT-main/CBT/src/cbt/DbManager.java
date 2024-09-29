/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cbt;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author HP
 */
public class DbManager 
{ //  class begin
    // Connection  =  interface
    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    // constructor conncetion ko stablish kr rhe hai java and database mai 
    public DbManager()  // constructor
            {  // constructor begin
        try{ // try begin
            Class.forName("com.mysql.jdbc.Driver"); 
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cbtdb?characterEncoding=utf8","root","");
        }// try end    
        catch(ClassNotFoundException ex1)
        { // catch1 begin
        ex1.printStackTrace();
        } // catch1 end
        catch(SQLException ex2)
        { // catch12 begin
        ex2.printStackTrace();
        } // catch2 end
        } //  constructor end
    // this method will help in insert update and delete 
    public boolean insertUpdateDelete(String query)
    {  //  method begin 
        try{
     ps = con.prepareStatement(query);
     ps.executeUpdate();
     return true;
        }
        catch(SQLException ex1)
                {
                ex1 .printStackTrace();
                return false;
                }
    } // method end
    public ResultSet select(String query)
    {  //  method being
        try{
    ps = con.prepareStatement(query);
    rs = ps.executeQuery();
    return rs;
        }
        catch(SQLException ex1)
        {
        ex1.printStackTrace();
        return rs;
        }
    } //  method end
} //  end of the class