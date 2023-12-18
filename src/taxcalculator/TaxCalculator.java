/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package taxcalculator;

/**
 *https://github.com/2022395/TaxCalculator
 * @author Volkan Tibet Tuylu-2022395-
 * @author Ana Clara Quilapan-2022475-
 */
public class TaxCalculator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
    }
    //Calculates the usc
        public static Double uscCalculator(double income) {
        
 // €0 – €12,012 @ 0.5%  €12,013 – €22,920 @ 2% €22,921 – €70,044 @ 4.5%
        double uscRate = 0;
         if (income <= 12012) {
            uscRate = 0.005; // 0.5%
        } else if (income <= 22920) {
            uscRate = 0.02;  // 2%
        } else if (income <= 70044) {
            uscRate = 0.045; // 4.5%
        } else if (income>=70044.01){
            uscRate = 0.08;   // %8 for income above €70,044
        } 
        else{
            System.out.println("Make sure you've put correct income and try again!");
        
        }
        //convert to the weekly income
        double usc = income/52 * uscRate;

        System.out.println("Universal Social Charge is: " + usc +" Euro");
      
         return usc;
        

}
    
}
