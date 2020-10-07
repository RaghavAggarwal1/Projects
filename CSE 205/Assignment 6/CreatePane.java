// Assignment #: Arizona State University CSE205
//         Name: raghav
//    StudentID: 1215935292
//      Lecture: Your lecture time mw 4:35-5:50
//  Description: CreatePane generates a pane where a user can enter
//  a movie information and create a list of available movies.

import java.util.ArrayList;
import javafx.scene.layout.HBox;
//import all other necessary javafx classes here
//----
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.geometry.*;
import javafx.event.*;
import javafx.scene.paint.Color;


public class CreatePane extends HBox
{
    private ArrayList<Movie> movieList;
    
    //The relationship between CreatePane and ReviewPane is Aggregation
    private ReviewPane reviewPane;
    private Label emptyLabel;
    private Label titleLabel;//movie title
    private Label lengthLabel;//length
    private Label yearLabel;//year
    private TextField n_text;//textbox for title
    private TextField l_text;//textbox for length
    private TextField y_text;//textbox for year
    private Button c_button ;//create button
    private TextArea t_area;//text area

    //constructor
    public CreatePane(ArrayList<Movie> list, ReviewPane rePane)
     {
        this.movieList = list;
        this.reviewPane = rePane;

        //Step #1: initialize each instance variable and set up the layout
        //----
        emptyLabel = new Label("");
        titleLabel = new Label("Title");
        lengthLabel = new Label("Length");
        yearLabel = new Label("Year");
        c_button = new Button("Create a Movie");
        n_text = new TextField();
        l_text = new TextField();
        y_text = new TextField();
       
        //create a GridPane hold those labels & text fields
        //consider using .setPadding() or setHgap(), setVgap()
        //to control the spacing and gap, etc.
        //----
        GridPane pn1 = new GridPane();
        pn1.setAlignment(Pos.CENTER);
        pn1.setPadding(new Insets(10,10,10,10));
        pn1.setHgap(10);
        pn1.setVgap(10);
        
        pn1.add(emptyLabel,1,2);
        pn1.add(titleLabel,2,3);
        pn1.add(n_text,3,3);
        pn1.add(lengthLabel,2,4);
        pn1.add(l_text,3,4);
        pn1.add(yearLabel,2,5);
        pn1.add(y_text,3,5);
        
        //You might need to create a sub pane to hold the button
        //----
        VBox pn2 = new VBox();
        pn2.getChildren().addAll(pn1,c_button);
        pn2.setAlignment(Pos.CENTER);
        //Set up the layout for the left half of the CreatePane.
        //----
        HBox pn3 = new HBox();
        
        
        //the right half of the CreatePane is simply a TextArea object
        //Note: a ScrollPane will be added to it automatically when there are no
        //enough space
        t_area = new TextArea("No Movie");
        
        
        
        //Add the left half and right half to the CreatePane
        //Note: CreatePane extends from HBox
        //----
        pn3.getChildren().addAll(pn2,t_area);
        this.getChildren().add(pn3);
        
        //Step #3: register source object with event handler
        //----
        ButtonHandler handle = new ButtonHandler();
        c_button.setOnAction(handle);
        
    } //end of constructor

    //Step 2: Create a ButtonHandler class
    //ButtonHandler listens to see if the button "Create a Movie" is pushed or not,
    //When the event occurs, it get a movie's Title, Year, and Length    
    //information from the relevant text fields, then create a new movie and add it inside
    //the movieList. Meanwhile it will display the movie's information inside the text area.
    //It also does error checking in case any of the textfields are empty or non-numeric string is typed
    private class ButtonHandler implements EventHandler<ActionEvent>
     {
        //Override the abstact method handle()
        public void handle(ActionEvent event)
         {
            //declare any necessary local variables here
            //---
            String n1,l1,y1;
            n1 = n_text.getText();
            l1 = l_text.getText();
            y1 = y_text.getText();
            //when a text field is empty and the button is pushed
            if (n1.equals("")||l1.equals("")||y1.equals(""))
            {
                    //handle the case here
                    emptyLabel.setText("Please Enter in All fields");
                    emptyLabel.setTextFill(Color.RED);
            }
            else    //for all other cases
            {
                    //----
                 
                    try
                    {
                        int length1 = Integer.parseInt(l1);
                        int year1 = Integer.parseInt(y1);
                    }
                    catch(NumberFormatException e1)
                    {
                        emptyLabel.setText("Incorrect data format");
                        emptyLabel.setTextFill(Color.RED);
                    }
                    int length1 = Integer.parseInt(l1);
                    int year1 = Integer.parseInt(y1);
                    
                    Movie newMovie = new Movie();
                    newMovie.setMovieTitle(n1);
                    newMovie.setLength(length1);
                    newMovie.setYear(year1);
                    movieList.add(newMovie);
                    reviewPane.updateMovieList(newMovie);
                    emptyLabel.setText("Movie Added");
                    emptyLabel.setTextFill(Color.RED);
                    n_text.setText("");
                    l_text.setText("");
                    y_text.setText("");
                    
                    for(int i = 0 ; i <= movieList.size(); i++)
                    {
                        t_area.appendText(movieList.get(i).toString());
                    }
                    //at the end, don't forget to update the new arrayList
                    //information on the ListView of the ReviewPane
                    //----
                    
                    //Also somewhere you will need to use try & catch block to catch
                    //the NumberFormatException
            }
         } //end of handle() method
   } //end of ButtonHandler class
}
