import geometry.*;
import impsoundworld.*;

//Assignment 13 Final Project
//Emil Abraham
//eabraham
//Ryan McKinnon
//mckinnon
//18 April 2012

/**
 * A class to represent Princess Peach
 * @author Emil Abraham & Ryan McKinnon
 *
 */
public class Peach{
    int x;
    int y;
    int currentTick;
    int spriteHeight = 15;
    boolean switchSprite;
    Peach(){
        this.x = -100;
        this.y = -100;
        this.switchSprite = true;
    }
    
    /**
     * Generates the proper image of Princess Peach.
     * @return WorldImage An image of Princess Peach from file.
     */
    WorldImage peachImage(){
        return new FromFileImage(new Posn(this.x, this.y), this.whichSprite());
    }
    
    /**
     * Determines which sprite to use based on a boolean. This will animate the sprite.
     * @return String A String representing the file fame for the peachImage() method.
     */
    public String whichSprite(){
        this.switchTheSprite();
        if (this.switchSprite){
            return "peachsprite1.png";
        }
        else{
            return "peachsprite2.png";
        }
    }
    
    /**
     * Switches the boolean every 10 ticks, resulting in an even animation.
     */
    public void switchTheSprite(){
        if(currentTick%10 == 0){
            switchSprite = !switchSprite;
        }
    }
}