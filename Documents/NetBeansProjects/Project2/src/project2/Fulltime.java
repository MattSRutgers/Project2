package project2;

public class Fulltime extends Employee {
	private double annualSalary;
	private final int NUM_PAY_PERIODS = 26;
	
	public Fulltime(String firstName, String lastName, String deptCode, String hireDate) {
		super(firstName, lastName, deptCode, hireDate);
		this.setAnnualSalary(0);
	}
	
	public Fulltime(String firstName, String lastName, String deptCode, String hireDate, 
			double salary) {
		super(firstName, lastName, deptCode, hireDate);
		this.setAnnualSalary(salary);
	}

	/**
	 * @return the employee's annual salary
	 */
	public double getAnnualSalary() {
		return annualSalary;
	}

	/**
	 * @param annualSalary the salary to set
	 */
	public void setAnnualSalary(double annualSalary) {
		this.annualSalary = annualSalary;
	}
	
	public void calculatePayment() {
		double pay = this.annualSalary/NUM_PAY_PERIODS;
		super.setPayment(pay);
	}
	
	 /**
     * The toString method formats the employees data neatly and returns it as
     * one string object
     * @return a string containing the employees details.
     */
    @Override
    public String toString(){
        String empDetails = super.toString() + "::FULL TIME::Annual Salary " 
        		+ doubleToDollar(this.annualSalary);
        return empDetails;
    }
    
    /**
     * The equals method compares two full time employee profiles to determine if they
     * match
     * @param obj the employee we are looking for
     * @return true if this employee is a match, false otherwise
     */
    @Override
    public boolean equals(Object obj){
    	Fulltime object = (Fulltime) obj;
    	if(this.getProfile().equals(object.getProfile()))
    		return true;
    	
    	return false;
    }

}