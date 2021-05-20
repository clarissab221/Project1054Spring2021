import java.io.*;
import java.lang.*;
import javafx.application.*;
import javafx.scene.input.*;
import javafx.scene.layout.*;
import javafx.animation.*;
import javafx.scene.control.*;
import javafx.scene.image.*;
import java.net.*;
import javafx.geometry.*;
import javafx.scene.canvas.*;
import javafx.scene.paint.*;
import javafx.event.*;
import javafx.stage.*;
import javafx.scene.*;
import java.util.*;
import java.text.*;


public class MazeGame extends Application
{
   FlowPane root = new FlowPane();
   MazeCanvas mc = new MazeCanvas();
   GraphicsContext gc = mc.getGraphicsContext2D();
   

   //create stage
   public void start(Stage stage)
   {

      root.setPrefSize(525,525);
      
      root.getChildren().add(mc);
     
      root.setOnKeyPressed(new KeyListenerDown());
      
      mc.draw(gc);
     
      //create scene
      Scene scene = new Scene(root, 525, 525);
      stage.setScene(scene); 
      stage.setTitle("Fun Maze Game");
      stage.show();
      
      root.requestFocus();
   }
   
   public static void main(String[] args)
   {
      launch(args);
   }
   
   
   //keylistener to move through the maze
   public class KeyListenerDown implements EventHandler<KeyEvent>  
   {
      public void handle(KeyEvent event) 
      {
      
         KeyCode pressed = event.getCode();
         mc.buttonKeys(pressed);
      
      }
   }
   
   
}