/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package taxcalculator;

import static java.lang.Integer.parseInt;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
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
}
