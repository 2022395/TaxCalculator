/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package taxcalculator;

/**
 *
 * @author Clara
 */
public class TaxPayer {
    
    
    private String name;
    private double income;
    private double usc;
    private double paye;
    private double prsi;
    private double taxCredit=68.25;//weekly
    
 
    //constructor
    public TaxPayer(String name,double income, double usc, double taxCredit, double paye, double prsi ) {
        this.name = name;
        this.income=income;
        this.usc=usc;
        this.paye=paye;
        this.prsi=prsi;
        this.taxCredit=taxCredit;
    }
    

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Double getUsc() {
        return usc;
    }

    public void setUsc(Double usc) {
        this.usc = usc;
    }

    public Double getPaye() {
        return paye;
    }

    public void setPaye(Double paye) {
        this.paye = paye;
    }

    public Double getIncome() {
        return income;
    }

    public void setIncome(Double income) {
        this.income = income;
    }

    public double getPrsi() {
        return prsi;
    }

    public void setPrsi(double prsi) {
        this.prsi = prsi;
    }

    public double getTaxCredit() {
        return taxCredit;
    }

    public void setTaxCredit(double taxCredit) {
        this.taxCredit = taxCredit;
    }
    
    
    
}
