/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project2;

/**
 *The Parttime class is a concrete subset of the employee class and expects
 * an additional instance variable for the employee's hourly rate.
 * @author Matthew Schilling and Gordon Miller
 */
public class Parttime extends Employee{
    private double payRate;
    private int hoursWorked;
    
    
    public Parttime(String employeeName, String deptCode, Date hireDate,
                    double payRate){
        super (employeeName, deptCode, hireDate);
        this.payRate = payRate;
    }
    
    @Override
    public String toString(){
        String empDetails = "Part Time To String";
        
        super.toString();
        return empDetails;
    }
    public void setHours(int hoursWorked){
        this.hoursWorked = hoursWorked;
    }
}
