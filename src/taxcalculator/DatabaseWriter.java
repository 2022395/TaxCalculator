/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package taxcalculator;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 *
 * @author volkan Tibet Tuylu-2022395-
 */
public class DatabaseWriter extends Database {
      
    //add the new taxPayer as an instance of TaxPayer
    public boolean addTaxPayer(TaxPayer taxPayer) throws SQLException {
    try (
        Connection conn = DriverManager.getConnection(DB_BASE_URL, USER, PASSWORD);
        Statement stmt = conn.createStatement();
    ) {
        //get the values and send into the database
        stmt.execute("USE " + DB_NAME + ";");
        String sql = String.format("INSERT INTO %s (name, income, usc, paye, prsi, taxCredit) VALUES ('%s', %f, %f, %f, %f, %f);",
                TABLE_NAME,
                taxPayer.getName(),
                taxPayer.getIncome(),
                taxPayer.getUsc(),
                taxPayer.getPaye(),
                taxPayer.getPrsi(),
                taxPayer.getTaxCredit());
        

        stmt.execute(sql);
        return true;

    } catch (Exception e) {
        e.printStackTrace();
        return false;
    }
}
    public boolean addAllTaxPayers(List<TaxPayer> taxPayerList){
        return true;
       
    }
    
    
    
}
