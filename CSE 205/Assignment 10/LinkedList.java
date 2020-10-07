// Assignment #: 10
//         Name: Raghav Aggarwal
//    StudentID: 1215935292
//  Lab Lecture: MW 4:35pm - 5:50pm
// A linked list is a sequence of nodes with efficient
// element insertion and removal.
// This class contains a subset of the methods of the
// standard java.util.LinkedList class.

import java.util.NoSuchElementException;
import java.util.ArrayList;
//import java.util.Comparator;
import java.util.Currency;

public class LinkedList 
{
   //nested class to represent a node
   private class Node
   {
          public Object data;
          public Node next;
   }

   //only instance variable that points to the first node.
   private Node first;

   // Constructs an empty linked list.
   public LinkedList()
   {
      first = null;
   }


   // Returns the first element in the linked list.
   public Object getFirst()
   {
      if (first == null)
       {
         NoSuchElementException ex
             = new NoSuchElementException();
         throw ex;
       }
      else
         return first.data;
   }

   // Removes the first element in the linked list.
   public Object removeFirst()
   {
      if (first == null)
       {
         NoSuchElementException ex = new NoSuchElementException();
         throw ex;
       }
      else
       {
         Object element = first.data;
         first = first.next;  //change the reference since it's removed.
         return element;
       }
   }

   // Adds an element to the front of the linked list.
   public void addFirst(Object element)
   {
      //create a new node
      Node newNode = new Node();
      newNode.data = element;
      newNode.next = first;
      //change the first reference to the new node.
      first = newNode;
   }

   // Returns an iterator for iterating through this list.
   public ListIterator listIterator()
   {
      return new LinkedListIterator();
   }

/*********************************************************
 * ********************************************************
                     Add your methods here
   ********************************************************
   *********************************************************/

   //************************************************
   //******************* Count element ******************* 
   //************************************************

   //meathod to count total no of element in the linked list
   public int countElement()
   {
      ListIterator list = listIterator();
      int count =0;
      while (list.hasNext()){
         list.next();                                    //will traverse through the whole list
         count++;                                        //will count thow many time it traversed
      }
      return count;
   }
   //************************************************
   //******************* ToString ******************* 
   //************************************************

   // Return the Output of the Linked List In the format of { .. }
   public String toString()
   {
    ListIterator iterator =  listIterator();
    String result;
        result = "{ ";                                       //adding the starting {
           
        while(iterator.hasNext())                            //implementing a while loop to add all the nos 
            result += (String)iterator.next()+" ";
            
         result += "}"+"\n";  //closing the string with }

      return result;
   }
      
   //************************************************
   //******************* IsEmpty ******************* 
   //************************************************

      //Returns true is list empty otherwise returns False
       public boolean isEmpty()
       {          
           return(first == null);                                     //if first == null then list is empty and will return true  //else it will return false  
        }

   
   //***************************************************** 
   //******************* AddElementsAt ******************* 
   //***************************************************** 

        //meathod to add an element at a given location in the linked list
        public void addElementAt(Object element, int index)
        {
           if(index > countElement()+1 || index<0)                       //Checking if the index is in range
           {   
              throw new IndexOutOfBoundsException();                    //throwing the exception if it is not in range
           }

           ListIterator list = listIterator();  

            int count = 0;                  
            while(count < index)
            {
                list.next();                                             //placing the next right before the index we need to add the element
                count++;
            }
            list.add(element);                                           //adding the element
        }      

   //********************************************************* 
   //******************* AddSomeElementsAt ******************* 
   //********************************************************* 

        //meathod to add elements at a given location in the linked list
        public void addSomeElementsAt(Object element, int index, int howMany)
        {
            if(index > countElement()+1 || index<0)                      //Checking if the index is in range
            {
               throw new IndexOutOfBoundsException();                     //throwing the exception if it is not in range
            }

            ListIterator list = listIterator();

            int count = 0;
            while(count < index)                                           //placing the next right before the index we need to add the element
            {
                list.next();                            
                count++;
            }
            for(int i=0;i<howMany;i++)                                    //adding the element howMany times at the destined place
            {
               list.add(element);
            }
        }

   //********************************************************* 
   //******************* GetElement ******************* 
   //********************************************************* 

        //Meathod to get the object at a particular index of the linked list
         public String getElement(int index)
         {
            if(index > countElement() || index<0)                       //Checking if the index is in range
            {               
               throw new IndexOutOfBoundsException();                   //throwing the exception if it is not in range
            }

            ListIterator list = listIterator();
            
            int count = 0;
            while(count < index)
            {                                                         //placing the next right before the index we need to add the element
               list.next();
                count++;
            }

            return (String)list.next();                                 //returning the node as a string
         }     

   //********************************************************* 
   //******************* findLargestAndRemove ******************* 
   //********************************************************* 

         //Meathod to find and remove the largest
         public String findLargestAndRemove()
         {
            if(isEmpty())
            {
               return null;                                             //returning null if the Linked list is empty
            }
            
            ListIterator list = listIterator();
            String max = (String)list.next();
            String current;
            //finding max
            while(list.hasNext())                                    //traversing the whole linked list
            {
               current = (String)list.next();                 //entering the data of current node to string current

                  if(max.compareTo(current)<0)                 //finding max 
                  {
                     max = current;
                  }  
            }
              
            list = listIterator();

            int count = 0;
            
            while(count < countElement())                            //making the list traversae agin till the end
            {           
               list.next();          
               if(max.equals(getElement(count)))                     //finding the biggest no
               {
                  list.remove();                                     //and removing it
                  count--;                                           //decreasing the count as the size of list got decreased
               }
               
               count++;
            }

            return max;                                        //returning max
         }
         
   //********************************************************* 
   //******************* Count How Many ******************* 
   //********************************************************* 

         //meathod to count occurance of the elements 
         public int countHowMany(Object element)
         {
            ListIterator list = listIterator();
            int count = 0;

            while(list.hasNext())                                    //traversing through the whole linked list
            {
              if(element.equals(list.next()))                        //checking if the element is equal to the current node
               {
                  count++;                                           // if it is than increasing the counter count
               }
            }
            return count;
         }

   //********************************************************* 
   //******************* Reverse Last Nodes ******************* 
   //********************************************************* 

         //meathod to reverse the last no of nodes of the list
         public void reverseLastSome(int howMany)
         {
            if(howMany<=0)                      //if mo given is 0 or negative it will not be changed
            {
               
            }
            else
            {                                       //if no passed is greater than 0
               ListIterator list = listIterator();
               ArrayList arr = new ArrayList();
               
               if(howMany>countElement())          //if the number is greater than the length of the list; it will be made equal to the list
               {
                  howMany = countElement();
               }
                  
               int count = 0;
               int noElement = countElement() - howMany;       // the no of elements which will need to be traveresed in order to reach to the number we want to start edditing from

               while (count < noElement)                    //moving the next to right before the number to be eddited
               {
                  list.next();
                  count++;
               } 
               
               for(int i=0 ; i < howMany ; i++)       //adding all the number that needs to re reversed in a string
               {
                  arr.add(list.next());               //adding the element from linked list to the array list
                  list.remove();                      //also removing them from the Linked List
               }
               
            ListIterator list1 = listIterator();    
               count =0;
               while (count < noElement)              //moving the next to right before the number to be eddited again
               {
                  list1.next();
                  count++;
               } 

               for(int i = arr.size()-1; i >= 0 ; i--)   //adding the array list elements to the Linked List but in reverse order
               {
                  list1.add(arr.get(i));                    //adding elements from arraylist to Linked List
               }
            }
         }

   /*********************************************************
    *********************************************************
                    End of my methods 
   *********************************************************
   *********************************************************/


   //nested class to define its iterator
   private class LinkedListIterator implements ListIterator
   {
      private Node position; //current position
      private Node previous; //it is used for remove() method

      // Constructs an iterator that points to the front
      // of the linked list.

      public LinkedListIterator()
      {
         position = null;
         previous = null;
      }

     // Tests if there is an element after the iterator position.
     public boolean hasNext()
      {
         if (position == null) //not traversed yet
          {
             if (first != null)
                return true;
             else
                return false;
          }
         else
           {
              if (position.next != null)
                 return true;
              else
                 return false;
           }
      }

      // Moves the iterator past the next element, and returns
      // the traversed element's data.
      public Object next()
      {
         if (!hasNext())
          {
           NoSuchElementException ex = new NoSuchElementException();
           throw ex;
          }
         else
          {
            previous = position; // Remember for remove

            if (position == null)
               position = first;
            else
               position = position.next;

            return position.data;
          }
      }

      // Adds an element after the iterator position
      // and moves the iterator past the inserted element.
      public void add(Object element)
      {
         if (position == null) //never traversed yet
         {
            addFirst(element);
            position = first;
         }
         else
         {
            //making a new node to add
            Node newNode = new Node();
            newNode.data = element;
            newNode.next = position.next;
            //change the link to insert the new node
            position.next = newNode;
            //move the position forward to the new node
            position = newNode;
         }
         //this means that we cannot call remove() right after add()
         previous = position;
      }

      // Removes the last traversed element. This method may
      // only be called after a call to the next() method.
      public void remove()
      {
         if (previous == position)  //not after next() is called
          {
            IllegalStateException ex = new IllegalStateException();
            throw ex;
          }
         else
          {
           if (position == first)
            {
              removeFirst();
            }
           else
            {
              previous.next = position.next; //removing
            }
           //stepping back
           //this also means that remove() cannot be called twice in a row.
           position = previous;
      }
      }

      // Sets the last traversed element to a different value.
      public void set(Object element)
      {
         if (position == null)
          {
            NoSuchElementException ex = new NoSuchElementException();
            throw ex;
          }
         else
          position.data = element;
      }
   } //end of LinkedListIterator class
} //end of LinkedList class