// Assignment #: 2
// Arizona State University - CSE205
//         Name: Raghav Aggarwal
//    StudentID: 1215935292
//      Lecture: 4:35-5:50 
/* Description: A java programm to input integers till 0 is entered and perform various calculations ie. finding min, even min, count of negative and sum of odd no's on inputed data.*/



import java.util.Scanner;
public class Assignment2 
{
	
    // Meathod to find the minimum value out of all the nos entered
	public static int getMin(int [] data) {
		int min = data[0];     //Intially assigning the first value so that all the values acan be compared
		
        //using for loop to runn the array of numbers
        for (int i=0 ; i<data.length ; i++) 
        {
            //using if to find the number smaller than the current number
			if(data[i] < min) 
            {
				min = data[i];
			}
		}
		return min;
	}
    //End of the meathod getMin


	// Meathod to find minimum even number out of all the nos entered

	public static int getMinEven(int [] data) {
		int minEven = 0;      // initially min value set to 0

        //since we only want a even number, we need to assign min value to the first even number out of all no's entered.
        for (int i=0 ;i<data.length;i++){
            if(data[i]%2==0){
                minEven = data[i];
            }
        }

		for (int i=0 ;i<data.length;i++) {
            //using if to find a even number smaller than the current number
			if(data[i]<minEven && data[i]%2==0) {
				minEven = data[i];
			}
		}
		return minEven;
	}
    //end of getMinEven Meathod
	

    //Starting the main function.
	public static void main(String[]args){

        //Declaring an array
		int data[]= new int[20];
		int capacity = 0;                       //capacity to manage the capacity of the array
		Scanner in = new Scanner(System.in);    //Creating an object of scanner
        
        //Taking the input of numbers till 0 is entered
        do {
        	data[capacity]=in.nextInt();        //Increasing the capacity each time as we add a new number
        }while(data[capacity++]!=0);

        //calling the function by 'PASS BY VALUE' meathod.
		System.out.println( "The minimum integer is " + getMin(data));     // prints the minimum number 
		System.out.println( "The smallest even integer in the sequence is " + getMinEven(data));   // prints the minimum even number

		// Counting the no. of Negative Numbers Entered
        int count_neg = 0;          //setting count to 0
		for (int i=0 ; i<data.length ; i++) {
			if (data[i] < 0) {
				count_neg++;
			}	
		}
		System.out.println("The count of negative integers in the sequence is "+ count_neg); // prints the count of negative numbers
		
        
        // Printing the sum of odd Nos
		int sum_odd = 0;    //setting the sum to 0
		for(int i=0 ; i<data.length ; i++) {
            //checking if the no's are odd 
			if(data[i]%2==1||data[i]%2==-1) {
				sum_odd+=data[i];
			}
		}
		System.out.println("The sum of odd integers is " + sum_odd); // prints the sum of odd number 
	}
	//End of Main Meathod
	
}   //End of class Assignment 2