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
    public void run(){
        System.out.println("Library Kiosk running");
        
        do {
            String userInput = sc.nextLine();
            userCommand = userInput.split("\\s+");

            String curCommand = userCommand[0];
            
        }while(!"Q".equals(userCommand[0]));

    }
}
