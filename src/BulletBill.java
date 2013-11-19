import geometry.*;
import impsoundworld.*;

//Assignment 13 Final Project
//Emil Abraham
//eabraham
//Ryan McKinnon
//mckinnon
//18 April 2012

/**
 * A Class to represent Bullet Bill.
 * @author Emil Abraham & Ryan McKinnon
 *
 */
public class BulletBill{
    int x;
    int y;
    BulletBill(int x, int y){
        this.x = x;
        this.y = y;
    }
    
    /**
     * @return WorldImage
     * Make an image of Bullet bill (image 44 by 40)
     */
    WorldImage bulletBillImage(){
        return new FromFileImage(new Posn(this.x, this.y), "bulletbill.png");
    }
    
    /**
     * Resets Bullet Bill when he gets too far off the left of the screen.
     * @param i1 An integer representing the x-coordinate when the Bullet Bills should reset
     */
    public void newBillHuh(int i1){
        if (this.x < i1){
            this.x = 500;
            this.y = 50 + (int)(Math.random()*450);
        }
    }
    
    /**
     * Move the Bullet Bill to the left 5 pixels.
     */
    public void moveBillLeft(){
        this.x = this.x - 5;
    }
}