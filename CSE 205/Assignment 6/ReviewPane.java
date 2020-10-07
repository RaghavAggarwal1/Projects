// Assignment #: Arizona State University CSE205
//         Name: raghav
//    StudentID: 1215935292
//      Lecture: Your lecture time mw 4:35-5:50
//  Description: ReviewPane displays a list of available movies
//  from which a user can select to reviw.


import javafx.collections.FXCollections;
import javafx.scene.layout.VBox;
import javafx.event.ActionEvent;    //**Need to import to handle event
import javafx.event.EventHandler;   //**Need to import to handle event

import javafx.scene.control.ListView;
import java.util.ArrayList;
import javafx.scene.layout.HBox;
import javafx.collections.ObservableList;

//import all other necessary javafx classes here
//----   
import javafx.scene.layout.*;
import javafx.scene.control.*;



public class ReviewPane extends VBox
{
   private ArrayList<Movie> movieList = new ArrayList<Movie>();

   //A ListView to display movies created
   private ListView<Movie> movieListView = new ListView<Movie>();

   //declare all other necessary GUI variables here
   //----
    private RadioButton btn1 ; 
    private RadioButton btn2 ;
    private RadioButton btn3 ;
    private RadioButton btn4 ;
    private RadioButton btn5 ;
    private Button sub_btn ;
    private Movie movie;
    private ObservableList<Object> list2;
   //constructor
   public ReviewPane(ArrayList<Movie> list)
   {
       //initialize instance variables
       this.movieList = list;
       
       
       btn1 = new RadioButton("1 Poor");
       btn2 = new RadioButton("2 Fair");
       btn3 = new RadioButton("3 Average");
       btn4 = new RadioButton("4 Good");
       btn5 = new RadioButton("5 Excellent");
       Label r1_label = new Label("Choose a movie to give a review, and select a rating:");
       sub_btn = new Button("Submit");
       
       list2 = FXCollections.observableArrayList(list);
       movieListView = new ListView(list2);

       //set up the layout
       //----
       ToggleGroup toggle = new ToggleGroup();
       btn1.setToggleGroup(toggle);
       btn2.setToggleGroup(toggle);
       btn3.setToggleGroup(toggle);
       btn4.setToggleGroup(toggle);
       btn5.setToggleGroup(toggle);
       
       movieListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
       
       HBox pn2 = new HBox();
       pn2.getChildren().addAll(btn1,btn2,btn3,btn4,btn5);
       

       //ReviewPane is a VBox - add the components here
       //----
       VBox pn3 = new VBox();
       pn3.getChildren().addAll(r1_label,movieListView,pane2,sub_btn);
       this.getChildren().add(pn3);
       
       
       //Step #3: Register the button with its handler class
       //----
       RatingHandler r1_handler = new RatingHandler();
       sub_btn.setOnAction(r1_handler);
      
       movie = new Movie();
   } //end of constructor

 //This method refresh the ListView whenever there's new movie added in CreatePane
 //you will need to update the underline ObservableList object in order for ListView
 //object to show the updated movie list
 public void updateMovieList(Movie newMovie)
 {
     //-------
     list2.add(newMovie);
     
 }

 //Step 2: Create a RatingHandler class
 private class RatingHandler implements EventHandler<ActionEvent>
    {
        //Override the abstact method handle()
        public void handle(ActionEvent event)
        {
            //When "Submit Review" button is pressed and a movie is selected from
            //the list view's average rating is updated by adding a additional
            //rating specified by a selected radio button
            
            Movie rate = movieListView.getSelectionModel().getSelectedItem();
            if (btn1.isSelected()==true)
            {
                rate.addRating(1) ;
            }
            else if(btn2.isSelected()==true)
            {
                rate.addRating(2);
            }
            else if(btn3.isSelected()==true)
            {
                rate.addRating(3);
            }
            else if(btn4.isSelected()==true)
            {
                rate.addRating(4);
            }
            else if (btn5.isSelected()==true)
            {
                rate.addRating(5);
            }
            movieListView.refresh();
        }
    } //end of RatingHandler
}//end of ReviewPane class
