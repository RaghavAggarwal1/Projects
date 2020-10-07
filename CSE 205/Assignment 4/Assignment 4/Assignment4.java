// Assignment #: 4
// Name: Raghav Aggarwal
// StudentID: 1215935292
// Lecture: MW  4:35 - 5:50
// Description: Assignment 4 class displays a menu of choices to a user
//        and performs the chosen task. It will keep asking a user to
//        enter the next choice until the choice of 'Q' (Quit) is entered.

import java.util.*;

public class Assignment4
 {
  public static void main (String[] args)
   {
       // local variables, can be accessed anywhere from the main method
       char input1 = 'Z';
       String inputInfo;
       String title, yearStr, lengthStr, prodName, prodCity, prodState;
       int year, length;
       String line = new String();

       // instantiate a Movie object
       Movie movie1 = new Movie();

       //calling the printMenu Meathod to display meathod
       printMenu();

       //Create a Scanner object to read user input
       Scanner scan = new Scanner(System.in);

       //using do-while so that the input is atleast runned once
       //And will ask in the end if the user wants to continue.
       do  // will ask for user input
        {
            System.out.println("What action would you like to perform?");
            line = scan.nextLine();
            
            //Checking if the user has entered 1 digit or not
            if (line.length() == 1)
            {
                input1 = line.charAt(0);    //we will only take the first Letter entered by user
                input1 = Character.toUpperCase(input1); //converting the first letter to uppercase

                // matches one of the case statement
                switch (input1)
                {
                    case 'A':   //Add Movie
                        System.out.print("Please enter the Movie information:\n");
                        System.out.print("Enter its title:\n");
                        title = scan.nextLine();
                        movie1.setMovieTitle(title);    //calling meathod of the class movie through the object of class movie

                        System.out.print("Enter its length:\n");
                        lengthStr = scan.nextLine();
                        length = Integer.parseInt(lengthStr);
                        movie1.setLength(length);
                    
                        System.out.print("Enter its year:\n");
                        yearStr = scan.nextLine();
                        year = Integer.parseInt(yearStr);
                        movie1.setYear(year);
                        
                        System.out.print("Enter its production company name:\n");
                        prodName = scan.nextLine();
                        System.out.print("Enter its production company's city:\n");
                        prodCity = scan.nextLine();
                        System.out.print("Enter its production company's state:\n");
                        prodState = scan.nextLine();
                        movie1.setProdCompany(prodName, prodCity, prodState);
                        break;
                    case 'D':   //Display Movie
                        System.out.print(movie1);   //Displaying Movie Details
                        break;
                    case 'Q':   //Quit
                        break;
                    case '?':   //Display Menu
                        printMenu();
                        break;
                    default:
                        System.out.print("Unknown action\n");   //If any other letter was entered
                        break;
                }
          }
         else   //If multiple letters are entered
          {
              System.out.print("Unknown action\n");
          }
        } while (input1 != 'Q' || line.length() != 1);  //will only continue if letter is not Q and the input is 1 letter
   }

  /** The method printMenu displays the menu to a user **/
  public static void printMenu()
   {
     System.out.print("Choice\t\tAction\n" +
                        "------\t\t------\n" +
                        "A\t\tAdd Movie\n" +
                        "D\t\tDisplay Movie\n" +
                        "Q\t\tQuit\n" +
                        "?\t\tDisplay Help\n\n");
  }
}
