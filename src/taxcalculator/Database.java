/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package taxcalculator;

/**
 *
 * @author Clara
 */
public abstract class Database {
    
    protected final static String DB_BASE_URL= "jdbc:mysql://localhost";
    protected final static String USER = "ooc2023";
    protected final static String PASSWORD = "ooc2023";
    protected final static String DB_NAME= "tax";
    protected final static String TABLE_NAME= "taxPayerData";
    
    
    
    protected final static String DB_URL = DB_BASE_URL + "/" + DB_NAME;
    
    
    
}
