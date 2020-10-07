// Assignment #: 11
// Name: Raghav Aggarwal
// StudentID: 1215935292
// Lecture: CSE 205; MW 4:35pm to 5:30 pm; Class NO: 16715
// Description: Assignment 11 class displays a menu of choices to a user
//        and performs the chosen task. It will keep asking a user to
//      enter the next choice until the choice of 'Q' (Quit) is entered.

import java.io.*;

public class Assignment11
 {
  public static void main (String[] args) throws IOException
   {
       char input1;
       String line = new String();

       printMenu();

       InputStreamReader isr = new InputStreamReader(System.in);
       BufferedReader stdin = new BufferedReader(isr);

       do  // will ask for user input
        {
         System.out.println("What action would you like to perform?");
         line = stdin.readLine(); //reading the line
         input1 = line.charAt(0); //taking the char at first position of the line
         input1 = Character.toUpperCase(input1);  //converting that char to uppercase

         if (line.length() == 1)
          {
           // matches one of the case statements
           switch (input1)
            {
             case 'C':   //Specify Problem parameters
               try
                {
                 System.out.print("Please specify how many characters will be used (the maximum is 26):\n");
                 int stackSize = Integer.parseInt(stdin.readLine().trim());

                 System.out.print("Please specify how many supporting stacks to use:\n");
                 int numberOfSupportingStacks = Integer.parseInt(stdin.readLine().trim());

                 if (stackSize > 0 && stackSize <= 26 && numberOfSupportingStacks > 0)
                  {
                   //Create an organizer object
                   CharacterOrganizer organizer = new CharacterOrganizer(stackSize, numberOfSupportingStacks);

                   //Read-in characters and add them to the stack
                   for (int i = 0; i < stackSize; i++)
                    {
                      System.out.print("Please enter a character:\n");
                      char character1 = stdin.readLine().trim().charAt(0);
                      organizer.addCharacterToStack(character1);
                    }

                   //sort the elements using stacks
                   boolean success = organizer.organizeCharacters();

                   if (success == true)
                    {
                     System.out.print("\norganization completed\n");
                    }
                   else
                    {
                     System.out.print("\norganization not completed\n");
                    }
                  }
                 else
                  {
                    System.out.print("Please enter a valid integer\n");
                  }
                }
               catch(NumberFormatException ex)
                {
                    System.out.print("Please enter a valid number\n");
                }
               break;
             case 'Q':   //Quit
               break;
             case '?':   //Display Menu
               printMenu();
               break;
             default:
               System.out.print("Unknown action\n");
               break;
            }
          }
         else
          {
           System.out.print("Unknown action\n");
          }
        } while (input1 != 'Q' || line.length() != 1);
   }


  /** The method printMenu displays the menu to a user**/
  public static void printMenu()
   {
     System.out.print("Choice\t\tAction\n" +
                      "------\t\t------\n" +
                      "C\t\tSpecify Problem Parameters\n" +
                      "Q\t\tQuit\n" +
                      "?\t\tDisplay Help\n\n");
  }
}
