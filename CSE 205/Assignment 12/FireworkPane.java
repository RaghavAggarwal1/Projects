// Assignment #: Arizona State University CSE205 #12
//         Name: Raghav Aggarwal
//    StudentID: 1215935292
//      Lecture: MW 4:35pm - 5:50pm
//  Description: The FireworkPane class creates sets the values for the 3 buttons and 2 sliders 
//               control for the movement of Firework, and also gives attributes of the Pane
//               displaying Firework.
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.Background;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.util.Duration;

public class FireworkPane extends Pane 
 {
    //declaring the variables of the class
     private double centerX;
     private double centerY;
     private double radius;
     private double radiusLimit;
     private double angleSize;
     private Timeline timeline1;
     private double step;
     private int beamNum;
     private Color color;
     //craeting the variable of Keyframs and goving it the required parameters
     private KeyFrame keyFran = new KeyFrame(Duration.millis(500), new FireworkHandler());

     //*** constructor ******/
     public FireworkPane(Color color, int width)
     {
        this.color = color;
        this.centerX = width/2;
        this.centerY = width/2;
        this.radiusLimit = (width-10)/(4.0);
        this.radius =  25.0;
        setBeamNumber(8);
        this.angleSize = (360.0)/(beamNum*2);
        this.step = 2;

        //setting the black background color for the pane which has the designs
        this.setStyle("-fx-background-color: black;");
        
        //Setting up the design of the firework
        for (int currentAngle=0; currentAngle <= 360; currentAngle += 2*angleSize)
        {
            Arc arc1 = new Arc(centerX, centerY, radius, radius, currentAngle, angleSize);
            arc1.setFill(color);
            arc1.setStroke(color);
            arc1.setType(ArcType.ROUND);
            getChildren().add(arc1);
        }

        //creating object of Timeline again
        this.timeline1=new Timeline(keyFran);
        this.timeline1.setCycleCount(Timeline.INDEFINITE);
        this.timeline1.setRate(20);  //default rate = 20
        this.timeline1.play();
     }

     //Meathod to resume the timeline
     public void resume()
     {
        this.timeline1.play();
     }

     //Meathod to pause the timeline
     public void suspend()
     {
        this.timeline1.pause();
     }

      //Meathod to change the color of the design/ firework
     public void changeColor(Color anotherColor)
     {
        this.color = anotherColor;
     }
      //Meathod to change the no of beams in the design/ firework
     public void setBeamNumber(int beam)
     {
        this.beamNum = beam;
        this.angleSize = (360.0)/(beamNum*2.0);
     }
      //Meathod to change the rate at which the design/ firework will grow
     public void setRate(int rate1)
     {
        this.timeline1.setRate(rate1);
     }

     //Handler class for firework
     //will handel the changes made to the arc
     private class FireworkHandler implements EventHandler<ActionEvent>
     {
         public void handle(ActionEvent event)
         {
            getChildren().clear(); //clearing the screen 
            angleSize = (360.0)/(beamNum*2);
            radius = step + radius;
            for (int currentAngle=0; currentAngle <= 360; currentAngle += 2*angleSize)
            {
                Arc arc1 = new Arc(centerX, centerY, radius, radius, currentAngle, angleSize);
                arc1.setFill(color);
                arc1.setStroke(color);
                arc1.setType(ArcType.ROUND);
                getChildren().add(arc1);
            }

            //resetting the radius if the limit is hit or exceeded
            if(radius>=radiusLimit)
            {
                radius = 0.0;
            }
         }
     } //end of FireworkHandler
 }