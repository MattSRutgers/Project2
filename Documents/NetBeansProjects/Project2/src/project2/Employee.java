/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project2;

import java.text.DecimalFormat;

/**
 *
 * @author Matthew Schilling and Gordon Miller
 */
public class Employee {
    //private final String FIST_NAME;
    //private final String LAST_NAME;
    private final String EMPLOYEE_NAME;
    private final String DEPARTMENT_CODE;
    private final Date HIRE_DATE;
    private double paymentDue;
    private final Profile employeeProfile;

    /**
     * The 3 param constructor will be called when an employee is added
     * @param employeeName
     * @param deptCode employees department code
     * @param hireDate employees date hired
     */
    public Employee(String employeeName, String deptCode, Date hireDate){
        this.EMPLOYEE_NAME = employeeName;
        this.DEPARTMENT_CODE = deptCode;
        this.HIRE_DATE = hireDate;
        employeeProfile = new Profile(employeeName, deptCode, hireDate);
    }

    /**
     * The toString method formats the employees data neatly and returns it as
     * one string object
     * @return a string containing the employees details.
     */
    @Override
    public String toString(){
    	this.calculatePayment();
        String empDetails = EMPLOYEE_NAME + "::" + DEPARTMENT_CODE
        		+ "::" + HIRE_DATE + "::Payment $" + doubleToDollar(this.paymentDue);
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
    	if(this.employeeProfile.equals(object.employeeProfile))
    		return true;

    	return false;
    }

	public void calculatePayment() {

	}

	public double getPayment() {
		return this.paymentDue;
	}

	public void setPayment(double paymentDue) {
		this.paymentDue = paymentDue;
	}

	/**
	 * @return the profile
	 */
	public Profile getProfile() {
		return employeeProfile;
	}

	public static String doubleToDollar(double value) {
		DecimalFormat dollarFormatter = new DecimalFormat("#.00");
    	dollarFormatter.setGroupingUsed(true);
    	dollarFormatter.setGroupingSize(3);
    	String valueStr = dollarFormatter.format(value);
    	return valueStr;
	}

    public String getDepartment(){
        return this.DEPARTMENT_CODE;
    }

    public Date getDate(){
        return this.HIRE_DATE;
    }

}
