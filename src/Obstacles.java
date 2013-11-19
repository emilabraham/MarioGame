import impsoundworld.*;
import java.util.*;

//Assignment 13 Final Project
//Emil Abraham
//eabraham
//Ryan McKinnon
//mckinnon
//18 April 2012

/**
 * A class to represent the Obstacles Mario walks on.
 * @author Emil Abraham & Ryan McKinnon
 *
 */
public class Obstacles{
    ArrayList<RectangleImage> obstacleArray;
    Random ranGen = new Random();
    Obstacles(ArrayList<RectangleImage> obstacleArray){
        this.obstacleArray = obstacleArray;
    }
    
    /**
     * Generates the image of the obstacles Mario has to overcome.
     * @return WorldImage An image containing all of the images of the Obstacles.
     */
    WorldImage obstaclesImage(){
        WorldImage image = this.obstacleArray.get(0);
        for(WorldImage i : this.obstacleArray){
            image = new OverlayImages(i, image);
        }
        return image;
    }
    /**
     * Moves all of the obstacles depending on the keypress.
     * @param ke A String that represents the key pressed.
     */
    void moveObstacles(String ke){
        if (ke.equals("d") || ke.equals("right")){
            for (RectangleImage rect : this.obstacleArray){
                rect.pinhole.x = rect.pinhole.x-10;
            }
        }
        
        if (ke.equals("a") || ke.equals("left")){
            for (RectangleImage rect : this.obstacleArray){
                rect.pinhole.x = rect.pinhole.x+10;
            }
        }
    }
    
    /**
     * Regenerates offscreen objects back on the screen at a random position.
     * It also removes objects that are too far offscreen to prevent the world from becoming too large.
     */
    void generateObstacles(){
        RectangleImage temp = this.obstacleArray.get(0);
        int lastXPosn = this.obstacleArray.get(this.obstacleArray.size()-1).pinhole.x;
        if(obstacleArray.get(0).pinhole.x<=-300){
            temp.pinhole.x = lastXPosn+ranGen.nextInt(10)*10+70;
            this.obstacleArray.remove(0);
            this.obstacleArray.add(temp);
        }
        else if(obstacleArray.get(obstacleArray.size()-1).pinhole.x>=1000){
            obstacleArray.remove(obstacleArray.size()-1);
        }
    }
    
    /**
     * Finds the index of the obstacle with the highest y value.
     * @return int The index of the object with the highest y value.
     */
    int peakObstacle(){
        int max = 400;
        int peakIndex = 0;
        for(RectangleImage rect : this.obstacleArray){
            if(max > rect.pinhole.y){
                max = rect.pinhole.y;
                peakIndex = this.obstacleArray.indexOf(rect);
            }
        }
        return peakIndex;
    }
}