
import java.lang.*;
import javafx.application.*;
import javafx.event.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.input.*;
import javafx.scene.layout.*;
import javafx.animation.*;
import javafx.scene.control.*;
import javafx.scene.image.*;
import java.net.*;
import javafx.geometry.*;
import java.util.*;
import java.text.*;
import java.io.*;
import javafx.scene.canvas.*;
import javafx.scene.paint.*;


public class MazeCanvas extends Canvas
{
   //create array
   int [][] myArray = new int [21][21];
   GraphicsContext gc = getGraphicsContext2D();

   //parameters
   int x = 0;
   int y = 0;
   KeyCode code;
   
   public MazeCanvas()
   {
         //create "try catch" to read from txt file  
         try
         {
               Scanner scan = new Scanner(new File("Maze.txt"));
               
               setWidth(525);
               setHeight(525);
      
               //for loop to draw black and white squares
               for(int i=0;i<21;i++)
               {
                  for(int j=0;j<21;j++)
                  {
                     int numinfile = scan.nextInt();
                     myArray[j][i] = numinfile; 
                  }
     
               }
         }
         catch(FileNotFoundException fnfe)
         {
               System.out.println("File does not exist!");
         }

         draw(gc);
 
   }
   
   //create draw method 
   public void draw(GraphicsContext gc)
   {
      for (int i = 0;i<myArray.length; i++)
      {
         for(int j = 0;j<myArray.length; j++)
         {
            if (myArray[i][j] == 0)
            {
               gc.setFill(Color.WHITE);
               gc.fillRect(i*25, j*25, 25 ,25);
              
            }
            if (myArray[i][j] == 1)
            {
               gc.setFill(Color.BLACK);
               gc.fillRect(i*25, j*25, 25 ,25);
            }        
         }
      }
      for (int i = 0; i<21; i++)
      {
         
         if (myArray[i][0] == 0)
         {
            x = i*25;
         }         
      }
      
      gc.setFill(Color.CYAN);
      gc.fillRect(x, 0, 25, 25);


   }
   public void buttonKeys(KeyCode code)
   {
      this.code = code;
      gc.clearRect(x,y,25,25);
      
      if(code == KeyCode.UP)
      {
         if(y > 0)
         {
            //subtract 25 from y 
            if(myArray[x/25][(y/25)-1] == 0)
            {
               y = y - 25;
            }
          
         }
      }
      if(code == KeyCode.DOWN)
      {
         if(y < 500)
         {
            //adds 25 to y 
            if(myArray[x/25][(y/25)+1] == 0)
            {
               y = y + 25;
            }
          
         }
      }
      if(code == KeyCode.RIGHT)
      {
         if(x < 500)
         {
            //adds 25 to x
            if(myArray[(x/25)+1][y/25] == 0)
            {
               x = x + 25;
            }
          
         }
      }
      if(code == KeyCode.LEFT)
      {
         if(x > 0)
         {
            //subtract 25 from x 
            if(myArray[(x/25)-1][y/25] == 0)
            {
               x = x - 25;
            }
          
         }
      }
      gc.setFill(Color.CYAN);
      gc.fillRect(x, y, 25, 25);
      
      if (y/25 == 20)
      {
            if (myArray[x/25][y/25] == 0) 
            {
               System.out.println("You Win!!");
            }
      }  

      
   }

   
}

