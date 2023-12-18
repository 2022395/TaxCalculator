/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package taxcalculator;

/**
 *
 * @author Clara
 */
public class LoginAuthenticator {
    
    public static boolean authenticate(String username, String password) {
        // Hardcoded admin credentials (for educational purposes only)
        String adminUsername = "CCT";
        String adminPassword = "Dublin";

        // Check if the provided username and password match the admin credentials
        return username.equals(adminUsername) && password.equals(adminPassword);
    }
    
}
