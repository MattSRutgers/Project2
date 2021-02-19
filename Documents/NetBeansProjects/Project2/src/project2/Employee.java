/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project2;

/**
 *
 * @author Matthew Schilling and Gordon Miller <your.name at your.org>
 */
public class Employee {
    private final String FIST_NAME;
    private final String LAST_NAME;
    private final String DEPARTMENT_CODE;
    private final String HIRE_DATE;
    
    /**
     * The 4 param constructor will be called when an employee is added
     * @param firstName employees first name
     * @param lastName employees last name
     * @param deptCode employees department code
     * @param hireDate employees date hired
     */
    public Employee(String firstName, String lastName, String deptCode,
                    String hireDate){
        this.FIST_NAME = firstName;
        this.LAST_NAME = lastName;
        this.DEPARTMENT_CODE = deptCode;
        this.HIRE_DATE = hireDate;
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
}
