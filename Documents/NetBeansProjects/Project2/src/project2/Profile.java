/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project2;

/**
 * The profile class keeps track of basic employee information for the purpose
 * of identifying an employee in the list of employees
 * @author Matthew Schilling and Gordon Miller
 */
public class Profile {
    private String name;
    private String department;
    private Date dateHired;
    
    /**
     * The toString method formats the profile information neatly into a string
     * @return the string containing the profile information
     */
    @Override
    public String toString(){
        String empProfile = "Profile toString";
        return empProfile;
    }
    /**
     * The equals method compares two employee profiles
     * @param obj the profile we are searching for
     * @return true if this profile is a match, false otherwise
     */
    @Override
    public boolean equals(Object obj){
        return true;
    }
}
