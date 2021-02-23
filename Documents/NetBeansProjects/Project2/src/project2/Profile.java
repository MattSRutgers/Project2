package project2;

/**
 * The profile class keeps track of basic employee information for the purpose
 * of identifying an employee in the list of employees
 * @author Matthew Schilling and Gordon Miller
 */
public class Profile {
    private final String NAME;
    private final String DEPARTMENT;
    private final Date DATEHIRED;

    public Profile (String name, String dept, Date dateHired){
        this.NAME = name;
        this.DEPARTMENT = dept;
        this.DATEHIRED = dateHired;

    }
    /**
     * The toString method formats the profile information neatly into a string
     * @return the string containing the profile information
     */
    @Override
    public String toString(){
        String empProfile = NAME + "::" + DEPARTMENT + "::" + "DATEHIRED";
        return empProfile;
    }
    /**
     * The equals method compares two employee profiles
     * @param obj the profile we are searching for
     * @return true if this profile is a match, false otherwise
     */
    @Override
    public boolean equals(Object obj){
        if (obj instanceof Profile){
            if (this.NAME.equalsIgnoreCase(((Profile) obj).NAME)){
                if(this.DEPARTMENT.equalsIgnoreCase(((Profile) obj).DEPARTMENT))
                    if(this.DATEHIRED.equals(((Profile) obj).DEPARTMENT))
                        return true;
            }
        }
        return false;
    }
}
