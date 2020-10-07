// Assignment #: 8
//         Name: Raghav Aggarwal
//    StudentID: 1215935292
//      Lecture: MW 4:35-5:50


import java.io.Serializable;

public class MovieArrangement implements Serializable
{
   private Movie[] movieList;
   private int currentMovieCount;
   private int maxSize;

   public MovieArrangement(int maximumsize)
   {
       movieList=new Movie[maximumsize];
       currentMovieCount = 0;
       maxSize = maximumsize;

       //making the whole ARRAY AS NULL
       for (int i=0; i<maxSize ;i++)
        {
            movieList[i]=null;
        }
   }

   public int movieExists(String movieTitle, int year)
   {
    for (int i=0; i<currentMovieCount;i++)
    {
        if (movieList[i].getMovieTitle().equals(movieTitle) && movieList[i].getYear()==year ) 
            return i; //returns pos when element found
    }
    return -1; // returns -1 when the element is not found
   }

   public int productionExists(String companyName, String locationCity, String locationState)
   {
    for (int i=0; i<currentMovieCount;i++)
    {
        if (movieList[i].getProdCompany().getCompanyName().equals(companyName) && movieList[i].getProdCompany().getLocationCity().equals(locationCity) && movieList[i].getProdCompany().getLocationState().equals(locationState) ) 
            return i; //returns pos when element found
    }
    return -1; // returns -1 when the element is not found
   }

   public boolean addMovie(String title, int length, int year, String companyName, String locationCity, String locationState)
   {
       //making another obkect of movie to take in all the information
    Movie obj = new Movie();
    obj.setLength(length);
    obj.setMovieTitle(title);
    obj.setYear(year);
    obj.setProdCompany(companyName, locationCity, locationState);

    //checking the condition the size id in boundary and movie exists 
    if(currentMovieCount<maxSize && movieExists(title, year)==-1)
    {
        //the info will be added to the movielist in last pos
        movieList[currentMovieCount]= obj;
        //and so last count will increase 
        currentMovieCount++;
        return true;
    }
    else{
        return false;
       }
   }

   public boolean removeMovie(String movieTitle, int year)
   {
       //getting the position of the movie in the array
       int pos = movieExists(movieTitle, year);

       //creating a new array and coping movielist to it
       Movie[] toCopy = movieList;
       boolean bool = false;

       if(pos == -1){
           return false;
       }
       else
       {
           for(int i=0;i<currentMovieCount-1;i++)
           {
               if(i==pos){
                   bool = true;
               }
               if(!bool)//runs for elements before removing element
               movieList[i] = toCopy[i];
               
               if(bool)     //after element is removed shifting pos of all other element
               movieList[i] = toCopy[i+1];
           }
           currentMovieCount--;
           //decreasing the size of the movie count
           return true;
       }
   }

   public void sortByMovieTitles()
   {
        MovieTitleComparator com1 = new MovieTitleComparator();
        Sorts.sort(movieList,currentMovieCount,com1);   //function call
   }

   public void sortByMovieYears()
   {
    MovieYearComparator com2 = new MovieYearComparator();
    Sorts.sort(movieList,currentMovieCount,com2); //function call
   }

   public void sortByProductions()
   {
        ProductionLocationComparator com3 = new ProductionLocationComparator();
        Sorts.sort(movieList,currentMovieCount,com3); //function call
   }

   public String listMovies()
   {
       String result ="\n";
       if(currentMovieCount==0){    //if movie array is empty 
           result += "no movie\n\n";
           return result;
       }
       else{                //else displaying all the result
           for(int i=0;i<currentMovieCount;i++){
               result = result + movieList[i].toString();
           }
           result = result+"\n";
           return result;
       }
   }

   public void closeMovieArrangement()
   {
       //closes the movie arrangement and nullifies the movie array
       currentMovieCount = 0;
   }

} 