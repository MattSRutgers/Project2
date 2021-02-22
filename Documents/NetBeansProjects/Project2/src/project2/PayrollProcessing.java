/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project2;
import java.util.Scanner;
/**
 * The payroll processing class handles input and output and command processing
 * @author Matthew Schilling and Gordon Miller
 * 
 */
public class PayrollProcessing {
    Scanner sc = new Scanner(System.in);
    private String[] userCommand;
    public void run(){
        System.out.println("Payroll Processing Starts");
        
        do {
            String userInput = sc.nextLine();
            userCommand = userInput.split("\\s+");

            String curCommand = userCommand[0];
            switch (curCommand){
                case "AP":
                    
                    break;
                
                case "AF":
                    break;
                
                case "AM":
                    break;
                
                case "R":
                    break;
                    
                case "C":
                    break;
                    
                case "S":
                    break;
                    
                case "PA":
                    break;
                    
                case "PH":
                    break;
                    
                case "PD":
                    break;
                    
                default:
                    System.out.println("Command " + curCommand + 
                                       " not supported");
            }
            
        }while(!"Q".equals(userCommand[0]));

    }
}
