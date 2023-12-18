/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package taxcalculator;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Clara
 */
public class DatabaseSetup extends Database {
     
    
    public static  boolean setupDB() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException  {
     try {
        Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        try (
            Connection conn = DriverManager.getConnection(DB_BASE_URL, USER, PASSWORD);
            Statement stmt = conn.createStatement();
                
                
        ) {

            stmt.execute("CREATE DATABASE IF NOT EXISTS " + DB_NAME + ";");
            stmt.execute("USE " + DB_NAME + ";");
            String sql =
                "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " ("
                + "name VARCHAR(255),"
                + "income DOUBLE(10,2),"
                + "usc DOUBLE(10,2),"
                + "paye DOUBLE(10,2),"
                + "prsi DOUBLE(10,2),"
                + "taxCredit DOUBLE(10,2)"
                + ");";

            stmt.execute(sql);
            return true;

        } catch (SQLException e) {
            e.printStackTrace(); // Handle or log the exception appropriately
            return false;
        }
    } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
        e.printStackTrace(); // Handle or log the exception appropriately
        return false;
    }
    
    }
    
}
