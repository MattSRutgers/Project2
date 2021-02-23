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
    private Employee[] empList;
    private int numEmployee;
    private static final int GROW_SIZE = 4;
    private static final int EMPLOYEE_NOT_FOUND = -1;
    
    /**
     * The default constructor for the Company class creates a new array of
     * employee class objects and assigns it to the emplist variable.
     */
    public Company (){
        empList = new Employee[GROW_SIZE];
        numEmployee = 0;
    }
    
    /**
     * The find employee method searches for a given employee in the list. It 
     * assumes the employee is not in the list, and only updates its return
     * if the employee is found.
     * @param employee the employee we are looking for
     * @return the index of the employee in the list, or -1 if not found
     */
    private int find (Employee employee) {
        int index = EMPLOYEE_NOT_FOUND;
        Profile findEmployee = employee.getProfile();
        for (int i = 0; i <numEmployee; i++){
            Profile checkThisEmployee = empList[i].getProfile();
            if (checkThisEmployee.equals(findEmployee))
                index = i;
        }
        return index;
    }
    
    /**
     * The grow method is automatically called when the employee list is full
     */
    private void grow(){
        int newLength = empList.length + GROW_SIZE;
        Employee[] tempBag = new Employee[newLength];
        for(int i = 0; i<empList.length; i++){
        	tempBag[i] = empList[i];
        }
        empList = tempBag;
    }
    
    /**
     * The add method first checks the list to make sure employee doesn't 
     * already exist, then adds them if they don't exist.
     * @param employee the employee to be added
     * @return true if successfully added, false if they already existed.
     */
    public boolean add(Employee employee){
        int checkExists = find(employee);
        if(checkExists != EMPLOYEE_NOT_FOUND)
            return false;
        //Create a new instance of an employee and add it to the list
        empList[numEmployee] = employee;
        numEmployee += 1;
        return true;
    }
    
    /**
     * The remove method searches the employee list and removes the given 
     * employee if found
     * @param employee the employee we are looking for to remove
     * @return true if found and removed, false if they did not exist.
     */
    public boolean remove(Employee employee){
        int getIndex = find(employee);
        if(getIndex == -1)
            return false;
        Employee[] tempBag = new Employee[empList.length - 1];
        for(int i = 0, j = 0; i<empList.length; i++){
            if(i != getIndex)
                tempBag[j++] = empList[i];
        }
        empList = tempBag;
        numEmployee --;
    	return true;
    }
    
    /**
     * The setHours method sets the hours worked for a part time employee
     * @param employee the employee who's hours we are adjusting
     * @return true if successfully found and updated. False otherwise
     */
    public boolean setHours(Employee employee){
        int getIndex = find(employee);
        int workedHours;
        if(getIndex == -1)
            return false;
        Parttime tempEmp = (Parttime)empList[getIndex];
        return true;
    }
    
    /**
     * The processPayments method loops through the list of employees and 
     * calculates how much they should be paid this period.
     */
    public void processPayments(){
        for (int i = 0; i <numEmployee; i++){
            empList[i].calculatePayment();
        }
    } //process payments for all employees
    
    /**
     * The print method loops through the employee list and prints info for
     * each employee using the toString method.
     */
    public void print(){
        System.out.println("--Printing earning statements for all employees--");
        for (int i = 0; i < numEmployee; i++){
            System.out.println("Looping " + i);
            System.out.println(empList[i].toString());
        } 
    }
    
    /**
     * The printByDepartment method loops through the employee list and sorts
     * by the department code, and then prints all employees.
     */
    public void printByDepartment(){
        if(checkEmpty()){
            System.out.println("Employee Database is empty.");
            return;
        }
        Employee tempEmp;
        for(int i = 0; i<empList.length; i++){
            for(int j = 1; j<empList.length; j++){
                String empOneDeptCode = empList[j-1].getDepartment();
                String empTwoDeptCode = empList[j].getDepartment();
                if(empTwoDeptCode.compareToIgnoreCase(empOneDeptCode)<0){
                    tempEmp = empList[j-1];
                    empList[j-1] = empList[j];
                    empList[j] = tempEmp;
                }
            }
        }
        System.out.println("--Printing earning statements by department--");
        for (Employee employee : empList){
            System.out.println(employee.toString());
        }
    } //print earning statements by department
    
    /**
     * The printByDate method sorts the employee list by their hire date then
     * prints the list of employees using the .toString() method
     */
    public void printByDate(){
//        if(checkEmpty()){
//            System.out.println("Employee Database is empty.");
//            return;
//        }
//            
        Employee tempEmp;
        for( int i = 0; i<empList.length; i++ ){
            for( int j = 1; j<empList.length; j++ ){
                Date empOneDate = empList[j-1].getDate();
                Date empTwoDate = empList[j].getDate();
                if(empOneDate.compareTo(empTwoDate) < 0 ){
                    tempEmp = empList[j-1];
                    empList[j-1] = empList[j];
                    empList[j] = tempEmp;
            }
        }
        System.out.println("--Printing earning statements by date hired--");
        for (Employee employee : empList){
            System.out.println(employee.toString());
        }
    }
    }
    public boolean checkEmpty(){
        return numEmployee == 0;
    }
}
