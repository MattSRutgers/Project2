/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project2;

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
    private int payDueThisPeriod;
    private final Profile employeeProfile;
    
    /**
     * The 3 param constructor will be called when an employee is added
     * @param employeeName
     * @param deptCode employees department code
     * @param hireDate employees date hired
     */
    public Employee(String employeeName, String deptCode, Date hireDate){
        //this.FIST_NAME = firstName;
        //this.LAST_NAME = lastName;
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
        String empDetails = "Emp toString";
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
        return true;
    }
    
    /**
     * The calculatePayment method determines how much the employee should be 
     * paid for the 2 week pay period.
     * @param Paydue the amount due to the employee.
     */
    
    /**
     * The calculatePayment method enables subclasses to calculate how much 
     * the employee earned
     */
    public void calculatePayment(){
    }
    
    public String getDepartment(){
        return this.DEPARTMENT_CODE;
    }
    
    public Date getDate(){
        return this.HIRE_DATE;
    }

}
