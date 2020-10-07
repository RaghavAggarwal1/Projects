// Assignment #: 9
//         Name: Raghav Aggarwal
//    StudentID: 1215935292
//      Lecture: MW 4:35-5:50
//  Description: Class implements recursion.

import java.io.*;

//import javax.swing.text.StyleContext.SmallAttributeSet;

//import apple.laf.JRSUIConstants.State;
public class Assignment9 {

    public static int findMin(int[] elements, int startIndex, int endIndex){
       if(endIndex < startIndex)
       {
        return Integer.min(elements[startIndex],findMin(elements, startIndex+1, endIndex));
       }
       return 0;
    }

    public static int computeSmallestEven(int[] elements, int startIndex, int endIndex)
    {
        if(startIndex<endIndex) //loop for running the function recursively for elements till the end element only
        {
            if(elements[startIndex]%2==0)
            {
            return Integer.min(elements[startIndex],computeSmallestEven(elements, startIndex+1, endIndex));   //runs recursively for each subsequent element and checks if the number is even returns the minimum even of the current and previous elements
            }
            else{
                return computeSmallestEven(elements, startIndex+1, endIndex);  
                
                //Returns the count of even numbers 
            } 
        }
        return 0;
    }

    public static int countNegativeNumbers(int[] elements, int startIndex, int endIndex)
    {
        if(endIndex>startIndex) 
        
        //loop for running the function 
        {
            if(elements[startIndex]<0){
                return 1+countNegativeNumbers(elements, startIndex+1, endIndex); 
                
                //runs recursively for each subsequent element and adds 1 
            } 
            else {
                return 0+countNegativeNumbers(elements, startIndex+1, endIndex);  
                
                //returns the count from previous elements
            }
        }
        return 0;
    }

    public static int computeSumOfNumbersDivisibleBy3(int[] elements, int startIndex, int endIndex)
    {
        if(endIndex>startIndex) //loop run recursively for elements till the end element 
        {
            if(elements[startIndex]%3==0){
                return elements[startIndex]+computeSumOfNumbersDivisibleBy3(elements, startIndex+1, endIndex);    //checks if the number is divisible by 3 and adds and returns it with previous sum
            } 
            else{
                return 0+computeSumOfNumbersDivisibleBy3(elements, startIndex+1, endIndex);    
            }
        }
        return 0;
    }
    public static void main(String args[]) throws IOException
    {
        int[] arr = new int[0];
        BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
        int currentIn = 0;
        do
        {
            currentIn = Integer.parseInt(scan.readLine());  //Takes input from user
            int[] temp = new int[arr.length+1]; //Creates new array with size 1 big so that inut can be added at the last
            for(int i = 0 ; i < arr.length ; i++)   
            {
                temp[i] = arr[i];               //Copies all elements to a temp array
            }
            temp[arr.length] = currentIn;       //Adds user inputted value to the end of array
            arr = temp;                         //Copies temp array into the main array
        }while(currentIn!=0);                   //Continues until the user inputed value becomes 0
        System.out.println("The minimum number is "+findMin(arr, 0, arr.length-1));                                                     //Calls function and prints minimum value in the array
        System.out.println("The smallest even integer in the sequence is "+computeSmallestEven(arr, 0, arr.length-1));                  //Calls function and prints smallest even integer in the array
        System.out.println("The count of negative integers in the sequence is "+countNegativeNumbers(arr, 0, arr.length-1));            //Calls function and prints the number of negative integers in the array
        System.out.println("The sum of numbers that are divisible by 3 is "+computeSumOfNumbersDivisibleBy3(arr, 0, arr.length-1));     //Calls function and prints sum of numbers divisible by 3 in the array
        scan.close();
    }

}
