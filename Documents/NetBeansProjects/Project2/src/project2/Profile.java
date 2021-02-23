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
        String empProfile = this.NAME + "::" + this.DEPARTMENT + "::" + this.DATEHIRED;
        return empProfile;
    }
    /**
     * The equals method compares two employee profiles
     * @param obj the profile we are searching for
     * @return true if this profile is a match, false otherwise
     */
    @Override
    public boolean equals(Object obj){
        //String date = DATEHIRED.toString();
        //System.out.println(date);
        //String findDate = ((Profile) obj).DATEHIRED.toString();
        if (obj instanceof Profile){
            if (this.NAME.equalsIgnoreCase(((Profile) obj).NAME)){
                System.out.println("Name equal");
                if(this.DEPARTMENT.equalsIgnoreCase(((Profile) obj).DEPARTMENT)){
                    System.out.println("Dept equal");
                    if(this.DATEHIRED.compareTo(((Profile) obj).DATEHIRED) == 0){
                        System.out.println("Date equal");
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
