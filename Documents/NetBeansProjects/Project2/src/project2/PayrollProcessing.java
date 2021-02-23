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
    Company company = new Company();
    private static final int MAX_MANAGER_CODE = 3;

    public void run(){
        System.out.println("Payroll Processsing starts.");

        do {
            String userInput = sc.nextLine();
            userCommand = userInput.split("\\s+");
            String hireDate;
            Date newHireDate = null;
            double payRate = 0;
            //Check the hire date is valid
            try {
	            hireDate = userCommand[3];
	            newHireDate = new Date(hireDate);
	            if (!newHireDate.isValid()){
	                System.out.println( userCommand[3] + " is not a valid date");
	                continue;
	            }
            }
            catch(IndexOutOfBoundsException e){}
            try{
            	payRate = Double.valueOf(userCommand[4]);
            }
            catch(IndexOutOfBoundsException e){}
            String curCommand = userCommand[0];

            switch (curCommand){
                case "AP":
                    //double payRate = Double.valueOf(userCommand[4]);
                    if(payRate < 0){
                        System.out.println("Pay Rate Cannot be zero");
                        break;
                    }
                    Employee newPartTimer = new Parttime(userCommand[1],
                    userCommand[2], newHireDate, payRate);
                    company.add(newPartTimer);
                    System.out.println("Part time employee added.");
                    break;

                case "AF":
                    if(payRate < 0){
                        System.out.println("Salary Cannot be negative");
                        break;
                    }
                    Employee newFullTimer = new Fulltime(userCommand[1],
                    userCommand[2], newHireDate, payRate);
                    company.add(newFullTimer);
                    System.out.println("Full time employee added.");
                    break;

                case "AM":
                    int managerCode = Integer.parseInt(userCommand[5]);
                    if(managerCode > MAX_MANAGER_CODE || managerCode == 0){
                        System.out.println("Invalid Manager Code");
                        break;
                    }
                    if(payRate < 0 ){
                        System.out.println("Salary cannot be negative");
                        break;
                    }
                    managerCode -= 1;
                    Employee newManager = new Management(userCommand[1],
                        userCommand[2], newHireDate, payRate,
                        managerCode);
                    company.add(newManager);
                    System.out.println("Manager Added.");
                    break;

                case "R":
                	System.out.println("Checking Date:" + newHireDate);
                    Employee removeEmployee = new Employee(userCommand[1],
                            userCommand[2], newHireDate);
                    if(company.remove(removeEmployee))
                        System.out.println("Employee removed");
                    else
                        System.out.println("Employee does not exist.");
                    break;

                case "C":
                    if (company.checkEmpty())
                        System.out.println("Employee database is empty");
                    company.processPayments();
                    System.out.println("Calculation of employee payments is"
                                        + " done");
                    break;

                case "S":
                    if (company.checkEmpty())
                        System.out.println("Employee database is empty");
                    int hoursWorked = (int) payRate;
                    System.out.println("Hours worked " + hoursWorked);
//                    try{
//                        hoursWorked = Integer.getInteger(userCommand[4]);
//                    }catch(IndexOutOfBoundsException event){}
                    Parttime updateHours = new Parttime(userCommand[1],
                        userCommand[2], newHireDate, hoursWorked);
                    updateHours.setHours(hoursWorked);
                    System.out.println("Part time hours worked" + hoursWorked);
                    if( ! company.setHours(updateHours))
                        System.out.println("Hours not updated");
                    break;

                case "PA":
                    if ( company.checkEmpty() ){
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

                case "Q" :
                    System.out.println("Payroll processing ended");
                    System.exit(0);

                default:
                    System.out.println("Command " + curCommand +
                                       " not supported");
            }
            //}catch (IndexOutOfBoundsException error){}
        }while(!"Q".equals(userCommand[0]));


    }
}
