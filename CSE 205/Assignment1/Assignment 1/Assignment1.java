// Assignment #: 1
// Arizona State University - CSE205
//         Name: Raghav Aggarwal 
//         StudentID: 1215935292
//         Lecture: MW 4:35 - 5:50 
//         Description: This Class takes an input from the 
//                      keyboard and prints the input with other messages. 

import java.util.Scanner;  // Importing/Calling Scanner class from "java.util" directory
 
public class Assignment1 
 {
  public static void main (String[] args) 
   {
     int number;                             //declaring Variable
   
     Scanner in = new Scanner(System.in);    //crating an object of Scanner

     number = in.nextInt();                  // read an integer entered by the user
      
    // display other messages with the number entered by the user
    System.out.print("This program reads an integer from a keybboard,\n"
                   + "and prints it out on the display screen.\n" 
                   + "Make sure that you get the exact same output as the expected one.\n"
                   + "The read number is " + number + ".\n");
   } // end of the main meathod
 } // end of the class Assignment1


