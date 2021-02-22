package project2;

import java.text.DecimalFormat;

public class Parttime extends Employee {
	private double hourlyRate;
	private int hoursWorked;

	public Parttime(String firstName, String lastName, String deptCode, String hireDate) {
		super(firstName, lastName, deptCode, hireDate);
		this.hourlyRate = 0;
	}

	public Parttime(String firstName, String lastName, String deptCode, String hireDate, double rate) {
		super(firstName, lastName, deptCode, hireDate);
		this.hourlyRate = rate;
	}

	public double getHours() {
		return this.hoursWorked;
	}

	public void setHours(int hours) {
		this.hoursWorked = hours;
	}

	@Override
	public void calculatePayment() {
		double pay;
		if(this.hoursWorked <= 80) {
			pay = this.hoursWorked * this.hourlyRate;
		}
		else {
			pay = (80 * this.hourlyRate) + (((hoursWorked - 80) * this.hourlyRate) * 1.5);
		}
		super.setPayment(pay);
	}

	 /**
     * The toString method formats the employees data neatly and returns it as
     * one string object
     * @return a string containing the employees details.
     */
    @Override
    public String toString(){
        String empDetails = super.toString() + "::PART TIME::Hourly Rate $" +
        		doubleToDollar(this.hourlyRate) + "::Hours worked this period: " + hoursWorked;
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
    	Parttime object = (Parttime) obj;
    	if(this.getProfile().equals(object.getProfile()))
    		return true;

    	return false;
    }
}
