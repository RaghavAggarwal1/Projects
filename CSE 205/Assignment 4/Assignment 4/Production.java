// Assignment #: 4
// Name: Raghav Aggarwal
// StudentID: 1215935292
// Lecture: MW  4:35 - 5:50
// Description: Assignment 4 : Production.java - 
//              class to store and update details of the movie's Production Company.

public class Production 
{

    //declaring Class Variables,can be accessed anywhere from the Class Production and object of Class Production
    private String companyName;
    private String locationCity;
    private String locationState;

    //Contructor of the Class
    public Production()
    {
        //initiallizing all variables to ?
        companyName = "?"; 
        locationCity = "?";
        locationState = "?";
    }

    //Accessor Meathod to return the Company Name 
    public String getCompanyName()
    {
        return companyName;
    }

    //Accessor Meathod to return the Location of the City
    public String getLocationCity()
    {
        return locationCity;
    }
    
    //Accessor Meathod to return the Location of the State
    public String getLocationState()
    {
        return locationState;
    }

    //Mutator Meathod to change the company name
    public void setCompanyName(String someName)
    {
        companyName = someName;
    }

    //Mutator Meathod to change the City Location
    public void setLocationCity(String someCity)
    {
        locationCity = someCity;
    }

    //Mutator Meathod to change the Location of the state
    public void setLocationState(String someState)
    {
        locationState = someState;
    }
    
    //toString Meathod to return the final result statement
    public String toString()
    {
        String line;
        line = companyName + " at " + locationCity + "," + locationState;
        return line;
    }

}//end of class Production

