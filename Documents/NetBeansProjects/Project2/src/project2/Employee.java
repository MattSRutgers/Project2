/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project2;

import java.text.DecimalFormat;

/**
 *
 * @author Matthew Schilling and Gordon Miller <your.name at your.org>
 */
public class Employee {
    private final String FIRST_NAME;
    private final String LAST_NAME;
    private final String DEPARTMENT_CODE;
    private final String HIRE_DATE;
    private Profile profile;
    private double payment;
    
    /**
     * The 4 param constructor will be called when an employee is added
     * @param firstName employees first name
     * @param lastName employees last name
     * @param deptCode employees department code
     * @param hireDate employees date hired
     */
    public Employee(String firstName, String lastName, String deptCode,
                    String hireDate){
        this.FIRST_NAME = firstName;
        this.LAST_NAME = lastName;
        this.DEPARTMENT_CODE = deptCode;
        this.HIRE_DATE = hireDate;
        String name = lastName + "," + firstName;
        Date hireDateObj = new Date(hireDate);
        this.setProfile(new Profile(name, deptCode, hireDateObj));
        this.setPayment(0);
    }
    /**
     * The toString method formats the employees data neatly and returns it as
     * one string object
     * @return a string containing the employees details.
     */
    @Override
    public String toString(){
    	this.calculatePayment();
        String empDetails = LAST_NAME + "," + FIRST_NAME + "::" + DEPARTMENT_CODE 
        		+ "::" + HIRE_DATE + "::Payment $" + doubleToDollar(this.payment);
        return empDetails;
    }
    
    /**
     * The equals method compares two employee profiles to determine if they
     * match
     * @param obj the employee we are looking for
     * @return true if this employee is a match, false otherwise
     */
    @Override
    public boolean equals(Object obj){
    	Employee object = (Employee) obj;
    	if(this.profile.equals(object.profile))
    		return true;
    	
    	return false;
    }
    
	public void calculatePayment() {
		
	}
	
	public double getPayment() {
		return this.payment;
	}
	
	public void setPayment(double payment) {
		this.payment = payment;
	}
	
	/**
	 * @return the profile
	 */
	public Profile getProfile() {
		return profile;
	}
	
	/**
	 * @param profile the profile to set
	 */
	public void setProfile(Profile profile) {
		this.profile = profile;
	}
	
	public static String doubleToDollar(double value) {
		DecimalFormat dollarFormatter = new DecimalFormat("#.00");
    	dollarFormatter.setGroupingUsed(true);
    	dollarFormatter.setGroupingSize(3);
    	String valueStr = dollarFormatter.format(value);
    	return valueStr;
	}
	
}
