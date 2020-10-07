// Assignment #: Arizona State University CSE205
//         Name: Raghav Aggarwal
//    StudentID: 1215935292
//      Lecture: MW 4:35-5:50
//  Description: The DrawingPane class creates a canvas where we can use
//               mouse key to draw lines with different colors and widths.
//               We can also use the the two buttons to erase the last
//				     drawn line or clear them all.


//import any classes necessary here
//----
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Line;
import javafx.scene.paint.Color;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Orientation;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent; 	

import java.util.ArrayList;

import javax.swing.undo.UndoManager;

public class DrawingPane extends BorderPane
{
   private Button undoButton, eraseButton;
   private ComboBox<String> colorCombo, widthCombo;
   private ArrayList<Line> lineList;
   private Pane canvas;
   private double x,y,x2,y2;
   private Line l1;
   //declare any other necessary instance variables here
   //----
    int colors;
    int widths;
   //Constructor

   public DrawingPane()
   {
      //Step #1: initialize instance variable and set up layout
      undoButton = new Button("Undo");
      eraseButton = new Button("Erase");
      undoButton.setMinWidth(80.0);
      eraseButton.setMinWidth(80.0);
      l1 = new Line(0,0,0,0);

      colorSet(l1);
      widthSet(l1);

      //Create the color comboBox and width comboBox,
      //----
      
      colorCombo = new ComboBox<String>();
      colorCombo.getItems().addAll("Black","Blue","Red","Yellow","Green");  //the options for colors
      colorCombo.getSelectionModel().select("Black");   //the default color
      ColorHandler handle1 = new ColorHandler();
    
      colorCombo.setOnAction(handle1);
	  this.getChildren().addAll(colorCombo);

    
      widthCombo = new ComboBox<String>();
      widthCombo.getItems().addAll("1","3","5","7");    //the options for width
      widthCombo.getSelectionModel().select("1");       //the default width
      WidthHandler handle2 = new WidthHandler();
      widthCombo.setOnAction(handle2);
	  this.getChildren().addAll(widthCombo);
       
      //initialize lineList, it is a data structure we used
      //to track the lines we created
      //----
     lineList = new ArrayList();   

      //topPane should contain two combo boxes and two buttons
      HBox topPane = new HBox();
      topPane.setSpacing(40);
      topPane.setPadding(new Insets(10, 10, 10, 10));
      topPane.setStyle("-fx-border-color: black");
      //adding the color, width, undo botton and erase button
      topPane.getChildren().add(colorCombo);
      topPane.getChildren().add(widthCombo);
      topPane.getChildren().add(undoButton);
      topPane.getChildren().add(eraseButton);
      
      
       
       //canvas is a Pane where we will draw lines
      canvas = new Pane();
      canvas.setStyle("-fx-background-color: white;");
       
      

       
      //add the canvas at the center of the pane and top panel
      //should have two combo boxes and two buttons
      this.setCenter(canvas);
      this.setTop(topPane);

       
      //Step #3: Register the source nodes with its handler objects
      canvas.setOnMousePressed(new MouseHandler());
      canvas.setOnMouseDragged(new MouseHandler());
      canvas.setOnMouseReleased(new MouseHandler());
      
      //the objects for the class and attaching the node to the object
      MouseHandler mouse1 = new MouseHandler();
      canvas.setOnMousePressed(mouse1);
        
      ButtonHandler h4=new ButtonHandler();
        eraseButton.setOnAction(h4);
        undoButton.setOnAction(h4);

      ColorHandler h2 = new ColorHandler();
      colorCombo.setOnAction(h2);
      
      WidthHandler h3 = new WidthHandler();
      widthCombo.setOnAction(h3);
   }



    //Step #2(A) - MouseHandler
    private class MouseHandler implements EventHandler<MouseEvent>
    {
        public void handle(MouseEvent event)
        {
            //handle MouseEvent here
            //Note: you can use if(event.getEventType()== MouseEvent.MOUSE_PRESSED)
            //to check whether the mouse key is pressed, dragged or released
            //write your own codes here
            //----
            if (event.getEventType() == MouseEvent.MOUSE_PRESSED)
            {
                x = event.getX();
                y = event.getY();
                lineList.add(new Line());

                //setting the start cordinates of the last added line
                //setting both x and y cordinates 
                lineList.get(lineList.size()-1).setStartX(x);
                lineList.get(lineList.size()-1).setStartY(y);
                widthSet(lineList.get(lineList.size()-1));
                colorSet(lineList.get(lineList.size()-1));
                
            }
            
            
            else if (event.getEventType() == MouseEvent.MOUSE_DRAGGED)
            {
                x2 = event.getX();
                y2 = event.getY();

                //setting the end cordinates of the last added line
                //setting both x and y cordinates 
                lineList.get(lineList.size()-1).setEndX(x2);
                lineList.get(lineList.size()-1).setEndY(y2);
                widthSet(lineList.get(lineList.size()-1));
                colorSet(lineList.get(lineList.size()-1));
                // lineList.set(lineList.size()-1,lineList.get(lineList.size()-1));

            }
            
            
           else if (event.getEventType() == MouseEvent.MOUSE_RELEASED)
            {
                x2 = event.getX();
                y2 = event.getY();
                lineList.get(lineList.size()-1).setEndX(x2);
                lineList.get(lineList.size()-1).setEndY(y2);
                widthSet(lineList.get(lineList.size()-1));
                colorSet(lineList.get(lineList.size()-1));
                // lineList.set(lineList.size()-1,l1);
            }
            canvas.getChildren().setAll(lineList);
            
            
        }//end handle()
    }//end MouseHandler

    //Step #2(B)- A handler class used to handle events from Undo & Erase buttons
    private class ButtonHandler implements EventHandler<ActionEvent>
    {
        public void handle(ActionEvent event)
        {
            //write your codes here
            //----

            //removing the last line
            //by removing the last object of the array list
            if(event.getSource().equals(undoButton)){
                lineList.remove(lineList.size()-1);
            }

            //erase by removing everything in the list 
            if(event.getSource().equals(eraseButton)){
                lineList.removeAll(lineList);
            }
            canvas.getChildren().setAll(lineList);
            
        }
    }//end ButtonHandler



   //Step #2(C)- A handler class used to handle colors
   private class ColorHandler implements EventHandler<ActionEvent>
   {
       public void handle(ActionEvent event)
       {
           //write your own codes here
           //----
           colors = colorCombo.getSelectionModel().getSelectedIndex();
           colorSet(l1);

        }//end ColorHandler
    }
    //Step #2(D)- A handler class used to handle widths of lines
    private class WidthHandler implements EventHandler<ActionEvent>
    {
        public void handle(ActionEvent event)
        {
            //write your own codes here
            //----
            widths = widthCombo.getSelectionModel().getSelectedIndex();
            widthSet(l1);
        }
    }//end WidthHandler
    private void widthSet(Line l1)
    {
        //using if else to choose the width 
        if(widths==0){
            l1.setStrokeWidth(1);
        }
        else if(widths==1){
            l1.setStrokeWidth(3);
       }
        else if(widths==2){
            l1.setStrokeWidth(5);
        }
        else if(widths==3){
           l1.setStrokeWidth(7);
        }
        else{
           l1.setStrokeWidth(1);
        }
    }
    private void colorSet(Line l1)
    {
        //using if else to choose the color
        if(colors==0){
            l1.setStroke(Color.BLACK);
        }
        else if(colors==1){
            l1.setStroke(Color.BLUE);
        }
        else if(colors==2){
            l1.setStroke(Color.RED);
        }
        else if(colors==3){
            l1.setStroke(Color.YELLOW);
       }
       else if(colors==4){
            l1.setStroke(Color.GREEN);
        }
        else{
            l1.setStroke(Color.BLACK);
       }
    }

}//end class DrawingPane