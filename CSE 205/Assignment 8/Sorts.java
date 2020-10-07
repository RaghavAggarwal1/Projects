// Assignment #: 8
//         Name: Raghav Aggarwal
//    StudentID: 1215935292
//      Lecture: MW 4:35-5:50

import java.util.Comparator;
public class Sorts
{
    public static void sort(Movie[] movieList,int size,Comparator fComp) 
    {
       //using Selection Sort
      int min;
      Movie temp;
      //running the whole Array
      for (int index = 0; index < size-1; index++)
      {
         min = index;
   
         for (int scan = index+1; scan < size ; scan++)
            if (fComp.compare(movieList[scan],movieList[min])<0)
               min = scan;

         // Swaping the values
         temp = movieList[min];
         movieList[min] = movieList[index];
         movieList[index] = temp;
      }
   }
}

    