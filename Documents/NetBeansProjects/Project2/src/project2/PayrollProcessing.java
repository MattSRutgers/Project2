/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project2;
import java.util.Scanner;
/**
 * The payroll processing class handles input and output and command processing
 * @author Matthew Schilling and Gordon Milker
 * 
 */
public class PayrollProcessing {
    Scanner sc = new Scanner(System.in);
    private String[] userCommand;
    Company company = new Company();
    
    public void run(){
        System.out.println("Library Kiosk running");
        
        do {
            String userInput = sc.nextLine();
            userCommand = userInput.split("\\s+");
            String hireDate;
            Date newHireDate = null;
            //Check the hire date is valid
            try{
            hireDate = userCommand[3];
            
            newHireDate = new Date(hireDate);
            if (!newHireDate.isValid()){
                System.out.println( userCommand[3] + " is not a valid date");
                break;
            }
            }catch(IndexOutOfBoundsException e){}
            String curCommand = userCommand[0];
            
            switch (curCommand){
                case "AP":
                    double payRate = Double.valueOf(userCommand[4]);
                    Employee newPartTimer = new Parttime(userCommand[1],
                    userCommand[2], newHireDate, payRate);
                    company.add(newPartTimer);
                    System.out.println("Part time employee added.");
                    break;
                
                case "AF":
                    double salary = Double.valueOf(userCommand[4]);
                    Employee newFullTimer = new Fulltime(userCommand[1],
                    userCommand[2], newHireDate, salary);
                    company.add(newFullTimer);
                    System.out.println("Full time employee added.");
                    break;
                
                case "AM":
                    double managementSalary = Double.valueOf(userCommand[4]);
                    int managerCode = Integer.parseInt(userCommand[5]);
                    Employee newManager = new Management(userCommand[1],
                        userCommand[2], newHireDate, managementSalary, 
                        managerCode);
                    company.add(newManager);
                    System.out.println("Manager Added.");
                    break;
                
                case "R":
                    Employee removeEmployee = new Employee(userCommand[1], 
                            userCommand[2], newHireDate);
                    if(company.remove(removeEmployee))
                        System.out.println("Employee removed");
                    else
                        System.out.println("Employee does not exist.");
                    break;
                    
                case "C":
                    company.processPayments();
                    System.out.println("Calculation of employee payments is"
                                        + " done");
                    break;
                    
                case "S":
                    break;
                    
                case "PA":
                    if (company.checkEmpty()){
                        System.out.println("Employee database is empty ");
                        break;
                    }
                    company.print();
                    break;
                    
                case "PH":
                    if (company.checkEmpty()){
                        System.out.println("Employee database is empty ");
                        break;
                    }
                    company.printByDate();
                    break;
                    
                case "PD":
                    if (company.checkEmpty()){
                        System.out.println("Employee database is empty ");
                        break;
                    }
                    company.printByDepartment();
                    break;
                    
                default:
                    System.out.println("Command " + curCommand + 
                                       " not supported");
            }
            //}catch (IndexOutOfBoundsException error){}
        }while(!"Q".equals(userCommand[0]));
        

    }
}
