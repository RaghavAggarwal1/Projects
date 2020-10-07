// Assignment #: 5
//         Name: Raghav Aggarwal
//    StudentID: 1215935292
//      Lecture: MW 4:35 - 5:50
//  Description: it resturns an employee object from the string

import java.util.Scanner;
import java.util.ArrayList;

public class EmployeeParser
{
    public static Employee parseStringToEmployee(String lineToParse)
    {
        Scanner outSc = new Scanner(lineToParse);   //creating scanner object
        outSc.useDelimiter(":");     //using delimeter ":" for " "
        
        ArrayList attrs = new ArrayList();
        
        for(int i = 1 ; i <= 4 ; i++)
        {
            attrs.add(outSc.next());
        }
        attrs.add(outSc.nextDouble());
        
        if(attrs.get(0).equals("FullTime"))
        {
            attrs.add(outSc.nextDouble());
            return new FullTimeEmployee((String)attrs.get(1), (String)attrs.get(2), (String)attrs.get(3), (double)attrs.get(4), (double)attrs.get(5));
        }
        else
        {
            attrs.add(outSc.nextInt());
            return new PartTimeEmployee((String)attrs.get(1), (String)attrs.get(2), (String)attrs.get(3), (double)attrs.get(4), (int)attrs.get(5));
        }
    }

}