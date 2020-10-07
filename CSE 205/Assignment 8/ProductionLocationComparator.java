// Assignment #: 8
//         Name: Raghav Aggarwal
//    StudentID: 1215935292
//      Lecture: MW 4:35-5:50

import java.util.Comparator;
public class ProductionLocationComparator implements Comparator<Movie>
{
    public int compare(Movie first,Movie second)
    {
        int result;
        Production firstProduction = first.getProdCompany();
        Production secondProduction = second.getProdCompany();
         if (firstProduction.getLocationState().equals(secondProduction.getLocationState()))        //if the state is same then it will check if city is same or not
            {
            if (firstProduction.getLocationCity().equals(secondProduction.getLocationCity()))       //if city is same return 0
                result = firstProduction.getLocationCity().compareTo(secondProduction.getLocationCity());
            else
                result =  firstProduction.getLocationCity().compareTo(secondProduction.getLocationCity());      //if city is diff return possitive or negative no
            }
         else
            result =  firstProduction.getLocationState().compareTo(secondProduction.getLocationState());        //if state is diff return possitive or negative no
         return result;
        
    }
}
