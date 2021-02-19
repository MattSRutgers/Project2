/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project2;

/**
 *The Company class uses an array as a container to manage an employee database
 * @author Matthew Schilling and Gordon Miller
 * 
 */
public class Company {
    private Employee[] emplist;
    private int numEmployee;
    
    /**
     * The find employee method searches for a given employee in the list
     * @param employee the employee we are looking for
     * @return the index of the employee in the list, or -1 if not found
     */
    private int find (Employee employee) {
        int index = 0;
        return index;
    }
    
    /**
     * The grow method is automatically called when the employee list is full
     */
    private void grow(){
    
    }
    
    /**
     * The add method first checks the list to make sure employee doesn't 
     * already exist, then adds them if they don't exist.
     * @param employee the employee to be added
     * @return true if successfully added, false if they already existed.
     */
    public boolean add(Employee employee){
        return true;
    }
    
    /**
     * The remove method searches the employee list and removes the given 
     * employee if found
     * @param employee the employee we are looking for to remove
     * @return true if found and removed, false if they did not exist.
     */
    public boolean remove(Employee employee){
        return true;
    }
    
    /**
     * The setHours method sets the hours worked for a part time employee
     * @param employee the employee who's hours we are adjusting
     * @return true if successfully found and updated. False otherwise
     */
    public boolean setHours(Employee employee){
        return true;
    }
    
    
    public void processPayments(){
        
    } //process payments for all employees
    
    
    public void print(){
        
    } //print earning statements for all employees
    
    
    public void printByDepartment(){
        
    } //print earning statements by department
    
    
    public void printByDate(){
        
    } //print earning statements by date hired
}
