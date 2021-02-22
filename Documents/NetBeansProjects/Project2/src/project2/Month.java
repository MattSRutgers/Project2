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
public class Month {
    private static final int MAX_DAYS = 31;
    private final int USER_YEAR;
    private final int USER_MONTH;
    private final int USER_DAY;
    public static final int QUADRENNIAL = 4;
    public static final int CENTENNIAL = 100;
    public static final int QUATERCENTENNIAL = 400;
    private static final int FEB = 2;
    private static final int APR = 4;
    private static final int JUN = 6;
    private static final int SEP = 9;
    private static final int NOV = 11;
    private static final int FEB_DAYS = 28;
    private final int[] THIRTY_DAY_MONTHS = {APR, JUN, SEP, NOV};
    
    /**
     * The constructor for the Month class expects 3 int values representing
     * the day month and year of the books publication. 
     * @param days int representing day of the month.
     * @param month int representing month of the year.
     * @param year int representing the year.
     */
    public Month (int days, int month, int year){
        this.USER_DAY = days;
        this.USER_MONTH = month;
        this.USER_YEAR = year;
    }
    /**
     * The checkDate method assumes the date to be true, and only checks in 
     * situations where the date might be out of range, which is only when the
     * date is: above 31, at 31 for April, June, September or November, 
     * or more than 28 days in February, or beyond todays date.
     * @return true if the date is valid, false otherwise
     */
    public boolean checkDate(){
        boolean isValid = true;
        int checkLeap;
        Calendar today = Calendar.getInstance();
        Calendar bookDate = Calendar.getInstance();
        bookDate.set(USER_YEAR, USER_MONTH, USER_DAY);
        if(bookDate.after(today))
            return false;
        if(USER_DAY > MAX_DAYS)
            return false;
        else if(USER_DAY == MAX_DAYS){
            for(int month: THIRTY_DAY_MONTHS){
                if(USER_MONTH == month)
                    return false;
            }
        }
        else if (USER_MONTH == FEB){
            if (USER_DAY > FEB_DAYS){
                checkLeap = USER_YEAR % QUADRENNIAL;
                if ( checkLeap == 0){
                    checkLeap = USER_YEAR % CENTENNIAL;
                    if ( checkLeap == 0){
                        checkLeap = USER_YEAR % QUATERCENTENNIAL;
                        if ( checkLeap == 0)
                            isValid = true;
                    }
                }
                else
                    return false;
            }
        }
        return isValid;
    }
}
