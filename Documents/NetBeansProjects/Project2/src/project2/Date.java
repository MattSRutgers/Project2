/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project2;

import java.util.Calendar;

/**
 *
 * @author Matthew Schilling and Gordon Miller
 */
public class Date implements Comparable<Date> {
    private int year;
    private int month;
    private int day;
    private static final int MAX_MONTH = 12;
    private static final int MIN_YEAR = 1900;
    private static final int DATE_BEFORE = -1;
    /**
     * Constructor for the date class. Converts string representation into int
     * @param date a String representing the date in mm/dd/yyyy format
     */
    public Date(String date) {
        String dateFormatter[] = date.split("/");
        this.month = Integer.parseInt(dateFormatter[0]);
        this.day = Integer.parseInt(dateFormatter[1]);
        this.year = Integer.parseInt(dateFormatter[2]);
    }
    /**
     * Default constructor for the Date class that creates and object with 
     * todays date.
     */
    public Date() { 
        Calendar today = Calendar.getInstance();
        today.getTime();
    }
    
    /**
     * The compareTo method compares two date objects to see if they are the 
     * same. It assumes the passed date is past this date, and checks if the
     * passed date is equal or before this date.
     * @param date the date object we are comparing
     * @return compareDate, which is -1 if the passed date is before this date,
     * 0 if the two dates are equal and 1 if the passed date is after
     * and 1 if it matches
     */
    @Override
    public int compareTo(Date date){
        int compareDate = 1;
        if(this.year == date.year)
            if(this.month > date.month)
                compareDate = DATE_BEFORE;
            else if( this.month == date.month)
                if( this.day > date.day)
                    compareDate = DATE_BEFORE;
                else if( this.day == date.day)
                    compareDate = 0;
        return compareDate;
    }
    /**
     * isValid method ensures the date supplied by the user is a valid date.
     * @return false if the date is not valid, true if it is
     */
    public boolean isValid() {
        boolean validDay;
        if ( year < MIN_YEAR || month > MAX_MONTH)
            return false;
        else{
            Month checkDate = new Month(this.day, this.month, this.year);
            validDay = checkDate.checkDate();
        }
        return validDay;
    }
    /**
     * allows access to dates year value as a int
     * @return int representing the year, 1900-2021 are valid
     */
//    public int getYear() {
//    	return this.year;
//    }
//    /**
//     * allows access to dates month value as a int
//     * @return int representing the month of the year, 1-12 are valid
//     */
//    public int getMonth() {
//    	return this.month;
//    }/**
//     * allows access to a dates day value as a int
//     * @return int representing the day of the month, 1-31 are valid
//     */
//    public int getDay() {
//    	return this.day;
//    }
}
