// Assignment #: 11
// Name: Raghav Aggarwal
// StudentID: 1215935292
// Lecture: MW 4:35pm to 5:30 pm ; Class NO: 16715
// Description: This program will take out all characters in the start stack
// and put them into the final stack in their sorted order using supporting stacks.

import java.util.Stack;

//import com.sun.corba.se.spi.activation.BadServerDefinition;

//this is a class to organise a stack enetered by the user
//the stack eneterd by the user will be taken as startStack, the result would be saved in finalStack 
//all the sorting would be done with the help of supporting Stack
public class CharacterOrganizer
 {
  private Stack<Character> startStack; //stack contains characters in an order specified by a user
  private Stack<Character> finalStack; //stack to have characters in sorted order after running this algorithm
  private Stack<Character>[] supportingStacks; //stacks to hold some characters that are not in either start or final stack
  private int sizeOfStartStack; //the start stack size
  private int numberOfSupportingStacks; //number of supporting stacks, specified by a user
  private char smallestCharacter; //current smallest character that can be moved to the final stack
  private int stackWithNextSmallest; //the index of supporting stack that contains the next smallest character
  private final int ASCII_FOR_a = ((int) 'a'); //ASCII number for a, we can use it to keep track of smallest/largest characters


  //Constructor to initialize member variables
  public CharacterOrganizer(int sizeOfStartStack, int numOfSupportingStacks)
    {
      startStack = new Stack<Character>();
      finalStack = new Stack<Character>();
      this.sizeOfStartStack = sizeOfStartStack;
      this.numberOfSupportingStacks = numOfSupportingStacks;

      supportingStacks = new Stack[numberOfSupportingStacks];

      for (int i=0; i< numberOfSupportingStacks; i++)
        {
          supportingStacks[i] = new Stack<Character>();
        }
      smallestCharacter = (char) (sizeOfStartStack+1-ASCII_FOR_a); //itinialize to a large character
      stackWithNextSmallest = -1; //index of supporting stack containing the next smallest is unknown
    }

  //The addCharacterToStack adds the parameter character
  //to the start stack
  public void addCharacterToStack(char character1)
   {
       startStack.push(character1);
   }

 //The printSupportingStacks prints out the content
 //of the supporting stacks
 public void printSupportingStacks()
  {
    System.out.println("Supporting Stack Contents:\n");
    for (int i = 0; i < numberOfSupportingStacks; i++)
    {
      System.out.println("Supporting Stack " + i + ": " + supportingStacks[i].toString());
    }
    System.out.println();
  }

//The organizeCharacters method reorganizes the characters in the start stack
//into a sorted order in the final stack
public boolean organizeCharacters()
 {
   boolean success = true;

   //the next character that should move to final stack is initially 'a'
   char nextCharacterToFinalStack = 'a';

   //Print out the start stack content
   System.out.println("Start Stack Content:\n" + startStack.toString());

   while(startStack.empty() == false)
    {
	  //get the next character to move
      char nextCharacter;
        
      //get(pop) the next character to move from the start stack
      //and assign it to "nextCharacter"
      /****1. ADD Your Code Here ****/
      
      nextCharacter = startStack.peek();    //assining nextCharacter the top value of startStack
      startStack.pop();                     //removing the top character from startStack

      if (nextCharacter == nextCharacterToFinalStack)
      {       
       //if it is the next smallest character,
       //then push it onto the final stack
       /***2. ADD Your Code Here ****/
       finalStack.push(nextCharacter);    //adding the nextCharacter to the finalStack
          
       System.out.println("Move character " + nextCharacter
                        + " from start stack to final stack");

       //nextCharacterToOutputStack should be incremented now
       //to loop for the next smallest character.
       nextCharacterToFinalStack++;

       //As long as the smallest character among all supporting stacks
       //is same as the next character to move to final stack,
       //process the following:
       while (smallestCharacter == nextCharacterToFinalStack)
        {
          //look for the next smallest character among supporting stacks
          //This will compute the smallest character and which supporting stack it belongs
          fromSupportingStackToFinalStack();
          nextCharacterToFinalStack++;
        }
     }
     else
       {
		    //put the next character into one of the supporting stack
            if (putInSupportingStack(nextCharacter) == false)
              {
                success = false;
                return success;
              }
       }
    }

    System.out.println("Final Stack Content:\n" + finalStack.toString());

    return success;
 }

//The fromSupportingStackToFinalStack moves the smallest element among
//all supporting stacks into the final stack.
//It also keeps track of the next smallest character and the supporting stack
//that contains in it.
public void fromSupportingStackToFinalStack()
{
	if (stackWithNextSmallest >= 0 && supportingStacks[stackWithNextSmallest].isEmpty() == false)
	 {
      //remove(pop) the smallest character from its supporting stack
      //and move(push) to the final stack
      /****3. ADD Your Code Here ****/

      //running between the supporting stacks
      for(int i=0;i<numberOfSupportingStacks;i++)
      {
        if (supportingStacks[i].isEmpty() == false)   //if support stack at index i is not empty it will continue
        {
          if(supportingStacks[i].peek()==smallestCharacter)   //if the top element of that supportingStack is the smallest element 
          {
            supportingStacks[i].pop();        //it would be removed 
          }
        }
      }

      finalStack.push(smallestCharacter);   //and the smallest character would be added to the finalStack 
      
      System.out.println("Move character " + smallestCharacter + " from supporting stack#"
                     + stackWithNextSmallest + " to final stack");

      printSupportingStacks();
     }

    //Find the next smallest character and the supporting stack that contains it
    //by checking the top of all supporting stacks
    smallestCharacter = (char) (sizeOfStartStack + 1 - ASCII_FOR_a);
    for (int i = 0; i < numberOfSupportingStacks; i++)
     {
      if (supportingStacks[i].isEmpty() == false 
                    && (supportingStacks[i].peek()).charValue() < smallestCharacter)
         {
            smallestCharacter = supportingStacks[i].peek().charValue();
            stackWithNextSmallest = i;
         }
     }
    //After the above loop, the variable "stackWithNextSmallest" should have an index
    //of the holding stack contains the next smallest character
    //AND the variable "smallestCharacter" should have the next smallestCharacter
    //to move to the final stack.
}

//The putInSupportingStack tries to push the parameter character
//into the chosen stack, i.e., the one with the top element larger
//than the parameter character and also with the top element smallest among
//such supporting stacks.
//If it cannot find such supporting stack, it returns false.
public boolean putInSupportingStack(char character2)
 {
   int chosenStackIndex = -1; //initialize to a stack index that does not exists
   char bestTop = (char) (sizeOfStartStack + 1 + ASCII_FOR_a); //initialize a larger character

//look for a non-empty stack that contains its top character which is larger than
//the parameter character to push into.
//The index of the supporting stack with smallest top should be the chosenStackIndex
//If the stack that you check is empty, go ahead and pick that supporting
//stack's index as the chosenStackIndex if the chosenStackIndex was not
//selected yet.
/****4. ADD Your Code Here ****/
    //running between all the Supporting stacks
    for(int i=0;i<numberOfSupportingStacks;i++)
    {
      //finding the non empty supporting stack, which has its top character which is larger than
      //the parameter character to push into and also finding the stack with samllest top which would be the best top
      if(supportingStacks[i].empty()==false && (supportingStacks[i].peek()).charValue()>character2 && (supportingStacks[i].peek()).charValue() < bestTop)
      {
          bestTop =supportingStacks[i].peek().charValue();  //storing the top character of desired stack in best top
          chosenStackIndex = i;     //storing the index of the array as the choosenIndex
          break;                    //if we are able to find it we dont need to run loop any longer so we will come out of it
      }

      //if empty stack not found or the other conditions dont meet it will assign the first available empty stack
      else if(supportingStacks[i].empty()==true)
      {
        chosenStackIndex = i;
        break;
      }
    }
  
    //The process cannot be completed
    //since all supporting stacks have its top character being smaller than
    //the character to be inserted.
    if (chosenStackIndex == -1)
      return false;

    //The process can continue, by pushing the parameter "character2"
    //into the supporting stack of the chosenStackIndex
    /****5. ADD Your Code Here ****/
    supportingStacks[chosenStackIndex].add(character2);   //adding the character at top of choosen Supporting stack
     
    System.out.println("Move the character " + character2 + " from start stack " + "to supporting stack#" + chosenStackIndex);

    printSupportingStacks();

    //update the variable "smallestCharacter" to the parameter character2
    //and the variable "stackWithNextSmallest" to "chosenStackIndex"
    //if character2 is smaller than "smallestCharacter"
    /****6. ADD Your Code Here ****/
    if(character2 < smallestCharacter)    //checking if character2 is smaller than "smallestCharacter"
    {                                      //if it is then changing the smallestCharacter and stackWithNextSmallest accordingly.
        smallestCharacter = character2;
        stackWithNextSmallest = chosenStackIndex;
    }

    return true;
   }
 }

