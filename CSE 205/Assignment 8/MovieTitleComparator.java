// Assignment #: 8
//         Name: Raghav Aggarwal
//    StudentID: 1215935292
//      Lecture: MW 4:35-5:50

import java.util.Comparator;
public class MovieTitleComparator implements Comparator<Movie> 
{
    public int compare(Movie first, Movie second)
    {
        int result;
         Movie firstMovie = (Movie)first;
         Movie secondMovie = (Movie)second;
         //tocampare for checking the movie title
         if (firstMovie.getMovieTitle().equals(secondMovie.getMovieTitle()))  //to return 0 if the title is exact same
            result = firstMovie.getMovieTitle().compareTo(secondMovie.getMovieTitle());
         else
            result =  firstMovie.getMovieTitle().compareTo(secondMovie.getMovieTitle());  //to return possitive or negative no.
         return result;
        
    }
}

