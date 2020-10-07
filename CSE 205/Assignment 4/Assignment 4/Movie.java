// Assignment #: 4
// Name: Raghav Aggarwal
// StudentID: 1215935292
// Lecture: MW  4:35 - 5:50
// Description: Assignment 4 : Movie.java - class to store and update details of the movie.

public class Movie
{
    //declaring Class Variables,can be accessed anywhere from the Class Movie and object of Class Movie
    private String movieTitle;
    private int year;
    private int length;
    private Production prodCompany;     //Creating variable prodCompany of type Production

    //Contructor of the Class
    public Movie()                      
    {
        movieTitle = "?";
        year = 0;
        length = 0;
        prodCompany = new Production();     //Creating an object of class Production
    }

    //Accessor Meathod to return the Title of the movie
    public String getMovieTitle()
    {
        return movieTitle;
    }

    //Accessor Meathod to return Year in which the movie was launched
    public int getYear()
    {
        return year;
    }

    //Accessor Meathod to return the Length of the movie
    public int getLength()
    {
        return length;
    }

    //Accessor Meathod to return Movie Production Details
    public Production getProdCompany()
    {
        return prodCompany;
    }

    //Mutator Meathod to change the Title of the movie
    public void setMovieTitle(String someTitle)
    {
        movieTitle = someTitle;
    }

    //Mutator Meathod to change the Year of the Movie
    public void setYear(int someYear)
    {
         year = someYear;
    }

    //Mutator Meathod to change the Length of the movie
    public void setLength(int someLength)
    {
        length = someLength;
    }

    //Mutator Meathod to change the Production Details of the movie
    public void setProdCompany (String someName, String someCity, String someState) 
    {
        //since the following variables are inherited from Parent Class PRODUCTION
        //they can only be called by the object of the class 
        //object_name.function_name(variable/data to be passed);
        prodCompany.setCompanyName(someName);   
        prodCompany.setLocationCity(someCity);
        prodCompany.setLocationState(someState);
    }
      
    //toString Meathod to return the final result statement
    public String toString()
    {
        String line;
        line =  "\nMovie Title:\t\t" + movieTitle +"\n"+"Movie Length:\t\t"+ length+ "\n" + "Movie Year:\t\t" + year + "\n"+"Movie Production:\t"+ prodCompany +"\n\n" ;
        return line;
    }
}//end of class Movie
