import java.util.ArrayList;
import tunes.*;
import impsoundworld.*;
import geometry.*;
import colors.*;

//Assignment 13 Final Project
//Emil Abraham
//eabraham
//Ryan McKinnon
//mckinnon
//18 April 2012

/**
 * A class to represent a Mario Level.
 * @author Emil Abraham & Ryan McKinnon
 *
 */
public class MarioLevel extends World{
    Mario mario;
    Peach peach;
    Obstacles obstacles;
    BulletBill bill1;
    BulletBill bill2;
    public MarioLevel(Mario mario, 
                      Peach peach,
                      Obstacles obstacles, 
                      BulletBill bill1, 
                      BulletBill bill2){
        this.mario = mario;
        this.peach = peach;
        this.obstacles = obstacles; 
        this.bill1 = bill1;
        this.bill2 = bill2;
    }
    
    //Values we need for some operations
    int backGroundX = 200;
    int peachX;
    int peachY;
    int tickCount2;
    int tickCounter = 0;
    int chainChompX = -250;
    int currentChord = 0;
        
    /**
     * Draws the World
     * @return WorldImage Return an image of the world.
     */
    public WorldImage makeImage(){
        this.peachX = this.obstacles.obstacleArray.get(this.obstacles.peakObstacle()).pinhole.x;
        this.peachY = this.obstacles.obstacleArray.get(this.obstacles.peakObstacle()).pinhole.y-
                      this.obstacles.obstacleArray.get(this.obstacles.peakObstacle()).height/2 -
                      this.peach.spriteHeight;
        if (tickCount2 >= 500){
        this.peach.x = this.peachX;
        this.peach.y = this.peachY;
            return new OverlayImages(new FromFileImage(new Posn(backGroundX, 100), "mariobackground.png"),
                   new OverlayImages(this.mario.marioImage(),
                   new OverlayImages(this.obstacles.obstaclesImage(),
                   new OverlayImages(new FromFileImage(new Posn(chainChompX, 100), "chainchomp.png"),
                   new OverlayImages(this.bill1.bulletBillImage(),
                   new OverlayImages(this.bill2.bulletBillImage(),
                           this.peach.peachImage()))))));
            }
        else{
            return new OverlayImages(new FromFileImage(new Posn(backGroundX, 100), "mariobackground.png"), 
                   new OverlayImages(this.mario.marioImage(),
                   new OverlayImages(this.obstacles.obstaclesImage(),
                   new OverlayImages(new FromFileImage(new Posn(chainChompX, 100), "chainchomp.png"),
                   new OverlayImages(this.bill1.bulletBillImage(),
                   new OverlayImages(this.bill2.bulletBillImage(),
                           this.peach.peachImage()))))));
        }
    }

    /**
     * Respond to keys hit by the user.
     * @param ke A String form of the key pressed.
     */
    public void onKeyEvent(String ke){
       if ((ke.equals("left") || ke.equals("a")) && 
               !this.mario.horizontalCollideLeft(this.obstacles.obstacleArray)){
           this.obstacles.moveObstacles(ke);
           backGroundX = backGroundX + 1;
           chainChompX = chainChompX + 5;
           this.bill1.x = this.bill1.x + 5;
           this.bill2.x = this.bill2.x + 5;
           }
       
       if ((ke.equals("right") || ke.equals("d")) &&
               !this.mario.horizontalCollideRight(this.obstacles.obstacleArray)){
           this.obstacles.moveObstacles(ke);
           backGroundX = backGroundX - 1;
           chainChompX = chainChompX - 5;
           this.bill1.x = this.bill1.x - 5;
           this.bill2.x = this.bill2.x - 5;
           this.tickCount2++;
           }
       
       if ((ke.equals("up") || ke.equals("w")) && this.mario.canjump){
           this.mario.jumpMario(ke);
           this.keyTunes.addNote(PIANO, noteG);
           }
       
       if ((ke.equals("up") || ke.equals("w")) && this.mario.canjump){
           this.mario.jumpMario(ke);
           this.keyTunes.addNote(PIANO, noteG);
           }
       }

    ArrayList<Chord> chordArray = new ArrayList<Chord>();
    /**
     * Adds notes, creates chords, and initializes the Mario Theme Song.
     */
    public void initSong(){

    //All of the notes
    Note empty = new Note("F4s0");
    Note c6 = new Note("C6n1");
    Note b5 = new Note("B5m1");
    Note a5 = new Note("A5n1");
    Note g5 = new Note("G5n1");
    Note gflat5 = new Note("G5f1");
    Note f5 = new Note("F5n1");
    Note e5 = new Note("E5n1");
    Note eflat5 = new Note("E5f1");
    Note d5 = new Note("D5n1");
    Note c5 = new Note("C5n1");
    Note b4 = new Note("B4n1");
    Note bflat5 = new Note("B5f1");
    Note bflat4 = new Note("B4f1");
    Note a4 = new Note("A4n1");
    Note gsharp4 = new Note("G4s1");
    Note g4 = new Note("G4n1");
    Note fsharp4 = new Note("F4s1");
    Note f4 = new Note("F4n1");
    Note e4 = new Note("E4n1");
    Note d4 = new Note("D4n1");
    Note dflat4 = new Note("D4f1");
    Note c4 = new Note("C4n1");
    Note b3 = new Note("B3n1");
    Note bflat3 = new Note("B3f1");
    Note a3 = new Note("A3n1");
    Note aflat3 = new Note("A3f1");
    Note g3 = new Note("G3n1");
    Note gflat3 = new Note("G3f1");
    Note f3 = new Note("F3n1");
    Note e3 = new Note("E3n1");
    Note eflat3 = new Note("E3f1");
    Note d3 = new Note("D3n1");
    Note c3 = new Note("C3n1");
    Note aflat2 = new Note("A2f1");
    Note g2 = new Note("G2n1");
    
    //All of the chords in the song
    Chord ch  = new Chord(empty);
    Chord ch1 = new Chord(d3, fsharp4, e5);
    Chord ch2 = new Chord(d3, fsharp4, c5);
    Chord ch3 = new Chord(g4, b4, g5);
    Chord ch4 = new Chord(g3, g4);
    Chord ch5 = new Chord(g3, e4, c5);
    Chord ch6 = new Chord(e3, c4, g4);
    Chord ch7 = new Chord(c3, g3, e4);
    Chord ch8 = new Chord(f3, c4, a5);
    Chord ch9 = new Chord(g3, d4, b5);
    Chord ch10 = new Chord(gflat3, dflat4, bflat5);
    Chord ch11 = new Chord(c4, g4, e5);
    Chord ch12 = new Chord(e4, b4, g5);
    Chord ch13 = new Chord(f4, c5, a5);
    Chord ch14 = new Chord(d4, a4, f5);
    Chord ch15 = new Chord(e4, b4, g5);
    Chord ch16 = new Chord(c4, a4, e5);
    Chord ch17 = new Chord(a3, e4, c5);
    Chord ch18 = new Chord(b3, f4, d5);
    Chord ch19 = new Chord(c3);
    Chord ch20 = new Chord(e5, g5);
    Chord ch21 = new Chord(g3, eflat5, gflat5);
    Chord ch22 = new Chord(d5, f5);
    Chord ch23 = new Chord(b4, eflat5);
    Chord ch24 = new Chord(c4);
    Chord ch25 = new Chord(c5, e5);
    Chord ch26 = new Chord(f3);
    Chord ch27 = new Chord(e4, gsharp4);
    Chord ch28 = new Chord(f4, a4);
    Chord ch29 = new Chord(c4, g4, c5);
    Chord ch30 = new Chord(c4, a4);
    Chord ch31 = new Chord(f3, e4, c5);
    Chord ch32 = new Chord(f4, d5);
    Chord ch33 = new Chord(g3, eflat5, gflat5);
    Chord ch34 = new Chord(g3);
    Chord ch35 = new Chord(c4, c5, e5);
    Chord sus = new Chord(f5, g5, c6);
    Chord ch36 = new Chord(aflat3, gsharp4, eflat5);
    Chord ch37 = new Chord(bflat3, f4, d5);
    Chord ch38 = new Chord(c4, e4, c5);
    Chord ch39 = new Chord(aflat2, gsharp4, c5);
    Chord ch40 = new Chord(gsharp4, c5);
    Chord ch41 = new Chord(eflat3, gsharp4, c5);
    Chord ch42 = new Chord(aflat3, bflat4, d5);
    Chord ch43 = new Chord(g3, g4, e5);
    Chord ch44 = new Chord(e4, c5);
    Chord ch45 = new Chord(c3, e4, a4);
    Chord ch46 = new Chord(c4, g4);
    Chord ch47 = new Chord(g2);
    Chord ch48 = new Chord(g4, e5);

    //Super Mario Bros. Main Theme: copyright 1985 by Nintendo.
    //Arrangement from www.MarioPiano.com
    chordArray.add(ch1);
    chordArray.add(ch1);
    chordArray.add(ch);
    chordArray.add(ch1);
    
    chordArray.add(ch);
    chordArray.add(ch2);
    chordArray.add(ch1);
    chordArray.add(ch);
    
    chordArray.add(ch3);
    chordArray.add(ch);
    chordArray.add(ch);
    chordArray.add(ch);
    
    chordArray.add(ch4);
    chordArray.add(ch);
    chordArray.add(ch);
    chordArray.add(ch);
    
    chordArray.add(ch5);
    chordArray.add(ch);
    chordArray.add(ch);
    chordArray.add(ch6);
    
    chordArray.add(ch);
    chordArray.add(ch);
    chordArray.add(ch7);
    chordArray.add(ch);
    
    chordArray.add(ch);
    chordArray.add(ch8);
    chordArray.add(ch);
    chordArray.add(ch9);
    
    chordArray.add(ch);
    chordArray.add(ch10);
    chordArray.add(ch8);
    chordArray.add(ch);
    
    //triplet measure (approximation)
    chordArray.add(ch6);
    chordArray.add(ch);
    chordArray.add(ch11);
    chordArray.add(ch12);
    
    chordArray.add(ch13);
    chordArray.add(ch);
    chordArray.add(ch14);
    chordArray.add(ch15);
    
    chordArray.add(ch);
    chordArray.add(ch16);
    chordArray.add(ch);
    chordArray.add(ch17);
    
    chordArray.add(ch18);
    chordArray.add(ch9);
    chordArray.add(ch);
    chordArray.add(ch);
    
    chordArray.add(ch19);
    chordArray.add(ch);
    chordArray.add(ch20);
    chordArray.add(ch21);
    
    chordArray.add(ch22);
    chordArray.add(ch23);
    chordArray.add(ch24);
    chordArray.add(ch25);
    
    chordArray.add(ch26);
    chordArray.add(ch27);
    chordArray.add(ch28);
    chordArray.add(ch29);
    
    chordArray.add(ch24);
    chordArray.add(ch30);
    chordArray.add(ch31);
    chordArray.add(ch32);
    
    chordArray.add(ch19);
    chordArray.add(ch);
    chordArray.add(ch20);
    chordArray.add(ch33);
    
    chordArray.add(ch22);
    chordArray.add(ch23);
    chordArray.add(ch34);
    chordArray.add(ch35);
    
    chordArray.add(ch);
    chordArray.add(sus);
    chordArray.add(ch);
    chordArray.add(sus);
    
    chordArray.add(sus);
    chordArray.add(ch);
    chordArray.add(ch34);
    chordArray.add(ch);
    
    chordArray.add(ch19);
    chordArray.add(ch);
    chordArray.add(ch20);
    chordArray.add(ch21);
    
    chordArray.add(ch22);
    chordArray.add(ch23);
    chordArray.add(ch24);
    chordArray.add(ch25);
    
    chordArray.add(ch26);
    chordArray.add(ch27);
    chordArray.add(ch28);
    chordArray.add(ch29);
    
    chordArray.add(ch24);
    chordArray.add(ch30);
    chordArray.add(ch31);
    chordArray.add(ch32);
    
    chordArray.add(ch19);
    chordArray.add(ch);
    chordArray.add(ch36);
    chordArray.add(ch);
    
    chordArray.add(ch);
    chordArray.add(ch37);
    chordArray.add(ch);
    chordArray.add(ch);
    
    chordArray.add(ch38);
    chordArray.add(ch);
    chordArray.add(ch);
    chordArray.add(ch34);
    
    chordArray.add(ch34);
    chordArray.add(ch);
    chordArray.add(ch19);
    chordArray.add(ch);
    
    chordArray.add(ch39);
    chordArray.add(ch40);
    chordArray.add(ch);
    chordArray.add(ch41);
    
    chordArray.add(ch);
    chordArray.add(ch40);
    chordArray.add(ch42);
    chordArray.add(ch);
    
    chordArray.add(ch43);
    chordArray.add(ch44);
    chordArray.add(ch);
    chordArray.add(ch45);
    
    chordArray.add(ch46);
    chordArray.add(ch);
    chordArray.add(ch47);
    chordArray.add(ch);
    
    chordArray.add(ch39);
    chordArray.add(ch40);
    chordArray.add(ch);
    chordArray.add(ch41);
    
    chordArray.add(ch);
    chordArray.add(ch40);
    chordArray.add(ch42);
    chordArray.add(ch48);
    
    chordArray.add(ch34);
    chordArray.add(ch);
    chordArray.add(ch);
    chordArray.add(ch19);
    
    chordArray.add(ch);
    chordArray.add(ch);
    chordArray.add(ch47);
    chordArray.add(ch);
    
    chordArray.add(ch39);
    chordArray.add(ch40);
    chordArray.add(ch);
    chordArray.add(ch41);
    
    chordArray.add(ch);
    chordArray.add(ch40);
    chordArray.add(ch42);
    chordArray.add(ch);
    
    chordArray.add(ch43);
    chordArray.add(ch44);
    chordArray.add(ch);
    chordArray.add(ch45);
    
    chordArray.add(ch46);
    chordArray.add(ch);
    chordArray.add(ch47);
    chordArray.add(ch);
    }    

    /**
     * Plays Mario Theme Song. A Chord every 3 ticks.
     */
    public void song(){
        initSong();
        if (tickCounter%3 == 0){
        this.tickTunes.addChord(PIANO, this.chordArray.get(currentChord));
        currentChord = (currentChord+1)%160;}
    tickCounter = tickCounter + 1;}
    
    /**
     * Updates the world at each tick.
     */
    public void onTick(){
        //Play the Mario Theme
        song();

        //If Mario isn't on the ground, apply gravity 
        this.mario.gravityHuh(this.obstacles.obstacleArray);
        
        //Physics for Mario's jumping
        mario.jumpCounterCheck();
        
        //Determine when we must set the Bullet Bills to be reused
        this.bill1.newBillHuh(-100);
        this.bill2.newBillHuh(-150);
        
        //Move the Bullet Bills
        bill1.moveBillLeft();
        bill2.moveBillLeft();
        
        //Move the chain chomp
        chainChompX = chainChompX+2;

        //Generate the obstacles for the level
        obstacles.generateObstacles();
        
        //Determine if we should end the game
        this.endOfWorldHuh();

        //Up the counter to animate the peach sprite.
        this.peach.currentTick++;
    }
    
    /**
     * Checks if the conditions are met for the world to end and stop ticking.
     */
    public void endOfWorldHuh(){
        if ((this.mario.y > 200) ||
            (this.mario.hitBillHuh(bill1)) ||
            (this.mario.hitBillHuh(bill2)) ||
            (this.mario.x < chainChompX + 176) ||
            (this.mario.hitPeachHuh(peach))){
        this.tickTunes.addNote(PIANO, "C1n4");
        this.tickTunes.addNote(PIANO, "C2n4");
        this.endOfWorld("");}
    }

    /**
     * Displays the losing screen.
     * @param s A String.
     * @return WorldImage Displays the final image after the world stops.
     */
    public WorldImage lastImage(String s){
    	if(!this.mario.hitPeachHuh(peach)){
    		return new OverlayImages(new FromFileImage(new Posn(backGroundX, 100), "mariobackground.png"), 
            		new TextImage(new Posn(200, 100), "GAME OVER", new Red()));
    	}
    	else{
    		return lastImage2();
    	}
    }
    
    /**
     * A second lastImage that displays the game winning screen.
     * @return WorldImage returns the game winning screen.
     */
    public WorldImage lastImage2(){
    	return new OverlayImages(new FromFileImage(new Posn(backGroundX, 100), "mariobackground.png"), 
        		new TextImage(new Posn(200, 100), "YOU WIN! THANKS FOR PLAYING!", new Green()));
    }
    
}