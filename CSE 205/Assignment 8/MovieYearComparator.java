// Assignment #: 8
//         Name: Raghav Aggarwal
//    StudentID: 1215935292
//      Lecture: MW 4:35-5:50

import java.util.Comparator;
public class MovieYearComparator implements Comparator<Movie>
{
    public int compare(Movie first, Movie second)
    {
        int result;
         Movie firstMovie = (Movie)first;
         Movie secondMovie = (Movie)second;
         if (firstMovie.getYear()==(secondMovie.getYear())) //to return 0 if the year is exact same
            result = 0;
         else
            result =  firstMovie.getYear()-secondMovie.getYear(); //else return possitive or negative depending upon the difference
         return result;
        
    }
}

