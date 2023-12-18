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
import java.util.logging.Level;
import java.util.logging.Logger;

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
     // Implement user menu options
      // Example: Fetch user data from the database
    private static void userMenu (Connection connection) {
        
        System.out.println("User Menu:");
        System.out.println("1:Existing User");
        System.out.println("2:Create an account");
        Scanner scanner=new Scanner(System.in);
        String selection =scanner.nextLine();
        
        System.out.println("What is your login name?");
        String name=scanner.nextLine();
         try {
             if(parseInt(selection)==1&&userExists(name, connection))
                 
                fetchUserloginData(connection,name);
             else if(parseInt(selection)==2){
               
                 userInput();
                 
             
             }
             else{
                 System.out.println("Name: "+name +" does not exist in database, try again!");
                 
                 }
                //handles exceptions
         } catch (SQLException ex) {
             Logger.getLogger(DatabaseMenu.class.getName()).log(Level.SEVERE, null, ex);
         } catch (ClassNotFoundException ex) {
             Logger.getLogger(DatabaseMenu.class.getName()).log(Level.SEVERE, null, ex);
         } catch (InstantiationException ex) {
             Logger.getLogger(DatabaseMenu.class.getName()).log(Level.SEVERE, null, ex);
         } catch (IllegalAccessException ex) {
             Logger.getLogger(DatabaseMenu.class.getName()).log(Level.SEVERE, null, ex);
         }
        
    
    }
              // Implement & display admin menu options
         // Example: Update database or perform administrative tasks
    private static void adminMenu (Connection connection, Scanner scanner) {
     
 boolean loggedIn = false;
    
    //When the user login granted displays the Admin Menu
    while (!loggedIn) {
        System.out.println("Admin Menu:");

      
        // gets the username and password
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        //If the userinput matches with the correct username and password
        if (loginAuthenticator.authenticate(username, password)) {
            System.out.println("Login successful. Welcome, " + username + "!");
            loggedIn = true; // Set to true to break out of the login loop

            boolean validChoice = false;

          
            // displays the available options in the Admin Menu
            while (!validChoice) {
                try {
                    System.out.println("1. Modify Own Profile");
                    System.out.println("2. List All Users");
                    System.out.println("3. Remove User");
                    System.out.println("4. Update User");
                    System.out.println("5. Exit Admin Menu");
                    System.out.print("Enter your choice: ");

                   
                    //admin's selection
                    //int adminChoice;
                    
 //reads the admin's input as a String then parses as an integer into the switch                    

    
    String input = scanner.nextLine();
   
    int adminChoice = Integer.parseInt(input.trim());
   
 
  
//this switch calls the methods depending the admin's input
switch (adminChoice) {
    case 1:
        modifyOwnProfile(username, connection);
        break;
    case 2:
        fetchUserData(connection);
        break;
    case 3:
        removeUser(connection, scanner);
        break;
    case 4:
        updateDatabase(connection, scanner);
        break;
    case 5:
        System.out.println("Exiting Admin Menu.");
        return;
    default:
        System.out.println("Invalid choice. Please try again.");
        
}

                } catch (SQLException ex) {
                    Logger.getLogger(DatabaseMenu.class.getName()).log(Level.SEVERE, null, ex);
                }
                catch (NumberFormatException e) {
        }
            }
        // if the username or password incorrect
        } else {
            System.out.println("Login failed. Invalid username or password.");
            System.out.println("Please try again.");
        }
    }

        
    } 
    
}
