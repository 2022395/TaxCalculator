/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package taxcalculator;

import static java.lang.Integer.parseInt;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 *
 * @author Volkan Tibet Tuylu-2022395-
 */
public class DatabaseMenu {
    //main menu creation
    public static boolean menuDB() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
       
        try {
            Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);

            // Display the main menu
            while (true) {
                System.out.println("1. User Menu");
                System.out.println("2. Admin Menu");
                System.out.println("3. Exit");
                System.out.print("Enter your choice: ");

             
                Scanner scanner = new Scanner(System.in);  
                
                
            
             if(scanner.hasNextLine()){
                 int choice=parseInt(scanner.nextLine());
                 
               
                //switch calls the functions depends on the user's choice
                switch (choice) {
                    case 1:
                        userMenu(connection);
                        break;
                    case 2:
                        adminMenu(connection, scanner);
                        break;
                    case 3:
                        System.out.println("Exiting program.");
                        System.exit(0);
                    default:
                        System.out.println("Invalid choice. Please try again.");
                        
                }
            }
               
               else{
                   
                    System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // Consume invalid input
                //scanner.nextLine(); 
                }
          
            
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        catch (NoSuchElementException e) {
           // System.out.println("hi");
            e.printStackTrace();
                //System.out.println("No input found. Please try again.");
               // scanner.nextLine(); // Consume the entire line to clear the input
            }
        catch (NumberFormatException e) {
            System.out.println("NumberFormatException: " + e.getMessage());
            
        }
         return false;
         
 
     }
    
      // this method gets the user input,
     //checks the database whether successfully created or not
     //After the database creation, adds the new instance of TaxPayer to the database.
     public static void userInput() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException{
         try{
        Scanner scanner = new Scanner(System.in);
        System.out.println("What is your name");
        String name=scanner.nextLine();
        System.out.println("What is your annual income?");
        double income= scanner.nextDouble();
        

        //succesfully database and table created
        if (DatabaseSetup.setupDB()){
            System.out.println("Database and table created");
        
        }else {
            System.out.println("Oh no! There was a database creation problem...");
        }
        //Adding t1 to the database
        //creates new instance of TaxPayer
        TaxPayer t1=new TaxPayer(name,income,uscCalculator(income),68.26,calculateTax(income,name),prsiCalculator(income));
        
        //adds the new instance to the database
        DatabaseWriter dbw= new DatabaseWriter();
        if (dbw.addTaxPayer(t1)){
            System.out.println("New record added");
        }
         }
         catch(InputMismatchException e){
             System.out.println("Unexpected income type! try again");
             
         
         }
    
    }
}
