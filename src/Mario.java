import geometry.*;
import impsoundworld.*;
import java.util.*;

//Assignment 13 Final Project
//Emil Abraham
//eabraham
//Ryan McKinnon
//mckinnon
//18 April 2012

/**
 * A class to represent Mario
 * @author Emil Abraham & Ryan McKinnon
 *
 */
public class Mario{
    int x;
    int y;
    boolean canjump;
    int jumpCounter;
    Mario(int y){
        this.x = 200;
        this.y = y;
        this.canjump = true;
        this.jumpCounter = -1;
    }

    /**
     * @return WorldImage
     * Make an image of Mario (Image dimensions are 20 by 30)
     */
    WorldImage marioImage(){
        return new FromFileImage(new Posn(this.x, this.y), this.whichSprite());
    }
    
    /**
     * @return String
     * Determine which sprite we should currently use
     */
    public String whichSprite(){
        if (this.jumpCounter <= 0)
           return "mariosprite.png";
        else return "mariosprite2.png";
    }
    
    /**
     * @param ke
     * Check to see if Mario can jump, and if so perform the action
     */
    public void jumpMario(String ke){
        if (ke.equals("w") || ke.equals("up") && this.canjump)
            this.jumpCounter = 15;
    }
    
    /**
     * @param array
     * @return boolean
     * Determine if Mario is on any of the given obstacles
     */
    public boolean onObstacleHuh(ArrayList<RectangleImage> array){
        boolean acc = false;
        for (RectangleImage rect : array){
            acc = acc || ((this.y+15 == (rect.pinhole.y-rect.height/2)) &&
                          (this.x+10 > rect.pinhole.x-rect.width/2) 
                          && (this.x-10 < rect.pinhole.x+rect.width/2));
        }
        return acc;
    }
    
    /**
     * @param array
     * @return boolean
     * Determine if Mario will hit any of the obstacles to his left
     */
    public boolean horizontalCollideLeft(ArrayList<RectangleImage> array){
        boolean acc = false;
        for (RectangleImage rect : array){
            int marioLeft = this.x - 10;
            int marioTop = this.y - 15;
            int marioBottom = this.y + 15;
            acc = acc || ((marioLeft == rect.pinhole.x + rect.width/2) && 
                          (marioBottom > rect.pinhole.y - rect.height/2) && 
                          (marioTop < rect.pinhole.y + rect.height/2));    
        }
        return acc;
    }
    
    /**
     * @param array
     * @return boolean
     * Determine if Mario will hit any of the obstacles to his right
     */
    public boolean horizontalCollideRight(ArrayList<RectangleImage> array){
        boolean acc = false;
        for (RectangleImage rect : array){
            int marioRight = this.x + 10;
            int marioTop = this.y - 15;
            int marioBottom = this.y + 15;
            acc = acc || ((marioRight == rect.pinhole.x - rect.width/2) && 
                          (marioBottom > rect.pinhole.y - rect.height/2) && 
                          (marioTop < rect.pinhole.y + rect.height/2));
        }
        return acc;
    }
    
    /**
     * @param bill
     * @return boolean
     * Determine if Mario hits the given Bullet Bill
     */
    public boolean hitBillHuh(BulletBill bill){
        int marioRight = this.x + 10;
        int marioLeft = this.x - 10;
        int marioTop = this.y - 15;
        int marioBottom = this.y + 15;
        return (marioBottom > bill.y - 15) && 
               (marioTop < bill.y + 15) &&
               (marioRight > bill.x - 15) &&
               (marioLeft < bill.x + 15);
    }
    
    /**
     * @param peach
     * @return boolean
     * Determine if Mario hits Peach
     */
    public boolean hitPeachHuh(Peach peach){
        int marioRight = this.x + 10;
        int marioLeft = this.x - 10;
        int marioTop = this.y - 15;
        int marioBottom = this.y + 15;
        return (marioBottom > peach.y - 10) && 
               (marioTop < peach.y + 10) &&
               (marioRight > peach.x - 10) &&
               (marioLeft < peach.x + 10);
    }
    
    /**
     * Change the jump counter downwards if necessary
     */
    public void jumpCounterCheck(){
    if (this.jumpCounter > 0){
        this.y = this.y - this.jumpCounter;
        this.jumpCounter--;}
    }
    
    /**
     * @param obstacles The ArrayList of RectangleImages that represent the obstacles.
     * If mario isn't on any of the obstacles, apply gravity
     */
    public void gravityHuh(ArrayList<RectangleImage> obstacles){
        if (!this.onObstacleHuh(obstacles)){
            this.canjump = false;
            this.y = this.y + 5;}
        else this.canjump = true;
    }
}










