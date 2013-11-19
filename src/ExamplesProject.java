import geometry.*;
import impsoundworld.*;

import java.util.*;
import tester.*;
import colors.*;

//Assignment 13 Final Project
//Emil Abraham
//eabraham
//Ryan McKinnon
//mckinnon
//18 April 2012

/**
 * A class to containing examples and runs the world.
 * @author Emil Abraham & Ryan McKinnon
 *
 */
public class ExamplesProject{
    Mario mario1 = new Mario(0);
    Peach peach = new Peach();
    RectangleImage testobs1 = new RectangleImage(new Posn(200, 200), 300, 100, new Green());
    RectangleImage testobs2 = new RectangleImage(new Posn(300, 150), 100, 100, new Green());
    RectangleImage testobs3 = new RectangleImage(new Posn(400, 125), 100, 100, new Green());
    BulletBill bill1 = new BulletBill(500, 100);
    BulletBill bill2 = new BulletBill(500, 100);
    Obstacles obstacles = new Obstacles(new ArrayList<RectangleImage>());
    MarioLevel testLevel = new MarioLevel(mario1, peach, obstacles, bill1, bill2);
    
    /**
     * Initializes the testExamples.
     */
    public void testExamples(){
    mario1 = new Mario(0);
    peach = new Peach();
    testobs1 = new RectangleImage(new Posn(200, 200), 300, 100, new Green());
    testobs2 = new RectangleImage(new Posn(300, 150), 100, 100, new Green());
    testobs3 = new RectangleImage(new Posn(400, 125), 100, 100, new Green());
    bill1 = new BulletBill(500, 100);
    bill2 = new BulletBill(500, 100);
    obstacles.obstacleArray.clear();
    obstacles.obstacleArray.add(testobs1);
    obstacles.obstacleArray.add(testobs2);
    obstacles.obstacleArray.add(testobs3);
    testLevel = new MarioLevel(mario1, peach, obstacles, bill1, bill2);
    }
    
    //--------------------------TESTS FOR MARIO CLASS--------------------------
    /**
     * Tests the marioImage method
     * @param t A Tester
     */
    public void testmarioImage(Tester t){
        testExamples();
        t.checkExpect(mario1.marioImage(), new FromFileImage(new Posn(mario1.x, mario1.y), "mariosprite.png"));
        mario1.jumpCounter = 10;
        t.checkExpect(mario1.marioImage(), new FromFileImage(new Posn(mario1.x, mario1.y), "mariosprite2.png"));
    }
    
    /**
     * Tests the whichSprite method
     * @param t A Tester
     */
    public void testwhichSprite(Tester t){
        testExamples();
        t.checkExpect(mario1.whichSprite(), "mariosprite.png");
        mario1.jumpCounter = 2;
        t.checkExpect(mario1.whichSprite(), "mariosprite2.png");
    }
    
    /**
     * Tests the jumpMario method
     * @param t A Tester
     */
    public void testjumpMario(Tester t){
        testExamples();
        mario1.jumpCounter = -1;
        mario1.jumpMario("up");
        t.checkExpect(mario1.jumpCounter, 15);
        mario1.jumpCounter = -1;
        mario1.jumpMario("w");
        t.checkExpect(mario1.jumpCounter, 15);
        mario1.jumpCounter = -1;
        mario1.jumpMario("right");
        t.checkExpect(mario1.jumpCounter, -1);
    }
    
    /**
     * Tests the onObstacleHuh method
     * @param t A Tester
     */
    public void testonObstacleHuh(Tester t){
       testExamples();
       t.checkExpect(mario1.onObstacleHuh(obstacles.obstacleArray), false);
       mario1.y = 135;
       t.checkExpect(mario1.onObstacleHuh(obstacles.obstacleArray), true);
       mario1.y = 125;
       t.checkExpect(mario1.onObstacleHuh(obstacles.obstacleArray), false);
    }
    
    /**
     * Tests the horizontalCollideLeft method
     * @param t A Tester
     */
    public void testhorizontalCollideLeft(Tester t){
        testExamples();
        this.mario1.y = 135;
        t.checkExpect(mario1.horizontalCollideLeft(obstacles.obstacleArray), false);
        obstacles.obstacleArray.add(new RectangleImage(new Posn(150, 100), 20, 300, new Green()));
        obstacles.moveObstacles("left");
        obstacles.moveObstacles("left");
        obstacles.moveObstacles("left");
        t.checkExpect(mario1.horizontalCollideLeft(obstacles.obstacleArray), true);
        obstacles.moveObstacles("left");
        t.checkExpect(mario1.horizontalCollideLeft(obstacles.obstacleArray), false);
    }
    
    /**
     * Tests the horizontalCollideRight method
     * @param t A Tester
     */
    public void testhorizontalCollideRight(Tester t){
        testExamples();
        t.checkExpect(mario1.horizontalCollideRight(obstacles.obstacleArray), false);
        this.mario1.y = 135;
        obstacles.moveObstacles("right");
        obstacles.moveObstacles("right");
        obstacles.moveObstacles("right");
        obstacles.moveObstacles("right");
        t.checkExpect(mario1.horizontalCollideRight(obstacles.obstacleArray), true);
        testExamples();
        obstacles.moveObstacles("right");
        obstacles.moveObstacles("right");
        obstacles.moveObstacles("right");
        t.checkExpect(mario1.horizontalCollideRight(obstacles.obstacleArray), false);
        testExamples();
    }
    
    /**
     * Tests the hitBillHuh method
     * @param t A Tester
     */
    public void testhitBillHuh(Tester t){
        testExamples();
        t.checkExpect(mario1.hitBillHuh(bill1), false);
        t.checkExpect(mario1.hitBillHuh(bill2), false);
        this.bill1.x = 200;
        this.bill1.y = 200;
        this.mario1.y = 200;
        t.checkExpect(mario1.hitBillHuh(bill1), true);
    }
    
    /**
     * Tests the hitPeachHuh method
     * @param t A Tester
     */
    public void testHitPeachHuh(Tester t){
        testExamples();
        t.checkExpect(mario1.hitPeachHuh(peach), false);
        this.peach.x = 50;
        this.peach.y = 50;
        this.mario1.x = 50;
        this.mario1.y = 50;
        t.checkExpect(mario1.hitPeachHuh(peach), true);
    }
    
    /**
     * Tests the jumpCounterCheck method
     * @param t A Tester
     */
    public void testJumpCounterCheck(Tester t){
        testExamples();
        t.checkExpect(mario1.jumpCounter, -1);
        mario1.jumpCounterCheck();
        t.checkExpect(mario1.jumpCounter, -1);
        mario1.jumpCounter = 15;
        mario1.jumpCounterCheck();
        t.checkExpect(mario1.jumpCounter, 14);
    }
    
    /**
     * Tests the gravityHuh method
     * @param t A Tester
     */
    public void testGravityHuh(Tester t){
        testExamples();
        mario1.gravityHuh(obstacles.obstacleArray);
        t.checkExpect(mario1.canjump, false);
        t.checkExpect(mario1.y, 5);
        mario1.gravityHuh(obstacles.obstacleArray);
        t.checkExpect(mario1.canjump, false);
        t.checkExpect(mario1.y, 10);
        testExamples();
        mario1.y = 135;
        mario1.gravityHuh(obstacles.obstacleArray);
        t.checkExpect(mario1.canjump, true);
        t.checkExpect(mario1.y, mario1.y);
    }
    
    //--------------------------TESTS FOR BULLETBILL CLASS--------------------------
    /**
     * Tests the bulletBillImage method
     * @param t A Tester
     */
    public void testbulletBillImage(Tester t){
        testExamples();
        t.checkExpect(bill1.bulletBillImage(), new FromFileImage(new Posn(bill1.x, bill1.y), "bulletbill.png"));
        t.checkExpect(bill2.bulletBillImage(), new FromFileImage(new Posn(bill2.x, bill2.y), "bulletbill.png"));
    }
    
    /**
     * Tests the moveBillLeft method
     * @param t A Tester
     */
    public void testmoveBillLeft(Tester t){
        t.checkExpect(bill1.x, 500);
        bill1.moveBillLeft();
        t.checkExpect(bill1.x, 495);
        bill1.moveBillLeft();
        t.checkExpect(bill1.x, 490);
    }
    
    //--------------------------TESTS FOR OBSTACLES CLASS--------------------------  
    /**
     * Tests the moveObstacles method
     * @param t A Tester
     */
    public void testmoveObstacles(Tester t){
        testExamples();
        obstacles.moveObstacles("I am not a key");
        t.checkExpect(obstacles, obstacles);
        obstacles.moveObstacles("right");
        t.checkExpect(obstacles.obstacleArray.get(0).pinhole.x, 190);  
        t.checkExpect(obstacles.obstacleArray.get(1).pinhole.x, 290);
        t.checkExpect(obstacles.obstacleArray.get(2).pinhole.x, 390);
        testExamples();
        obstacles.moveObstacles("left");
        t.checkExpect(obstacles.obstacleArray.get(0).pinhole.x, 210);  
        t.checkExpect(obstacles.obstacleArray.get(1).pinhole.x, 310);
        t.checkExpect(obstacles.obstacleArray.get(2).pinhole.x, 410);
        obstacles.moveObstacles("right");
        t.checkExpect(obstacles.obstacleArray.get(0).pinhole.x, 200);  
        t.checkExpect(obstacles.obstacleArray.get(1).pinhole.x, 300);
        t.checkExpect(obstacles.obstacleArray.get(2).pinhole.x, 400);
    }
    
    /**
     * Tests the peakObstacle method
     * @param t A Tester
     */
    public void testpeakObstacle(Tester t){
        testExamples();
        t.checkExpect(obstacles.peakObstacle(), 2);
        obstacles.obstacleArray.remove(2);
        t.checkExpect(obstacles.peakObstacle(), 1);
        obstacles.obstacleArray.remove(1);
        t.checkExpect(obstacles.peakObstacle(), 0);
    }
    
    //--------------------------TESTS FOR PEACH CLASS--------------------------
    /**
     * Tests the peachImage method
     * @param t A Tester
     */
    public void testPeachImage(Tester t){
    	testExamples();
    	t.checkExpect(peach.peachImage(), new FromFileImage(new Posn(peach.x, peach.y), "peachsprite2.png"));
    }
    
    /**
     * Tests the whichSprite method
     * @param t A Tester
     */
    public void testWhichSprite(Tester t){
    	testExamples();
    	t.checkExpect(peach.whichSprite(), "peachsprite2.png");
    	peach.switchSprite = false;
    	t.checkExpect(peach.whichSprite(), "peachsprite1.png");
    }
    
    /**
     * Tests the switchTheSprite method
     * @param t A Tester
     */
    public void testSwitchTheSprite(Tester t){
    	testExamples();
    	t.checkExpect(peach.switchSprite, true);
    	peach.switchTheSprite();
    	t.checkExpect(peach.switchSprite, false);
    }
    

    //--------------------------BIG BANG--------------------------
    public static void main(String[] argv){
        ExamplesProject me = new ExamplesProject();
        Tester.runReport(me, false, false); 

    //Mario
    Mario mario = new Mario(0);
    
    //Peach
    Peach peach = new Peach();
    
    //Initial rectangles: the game will always start with the same 
    //  objects on the ground; the rest will be randomly generated
    //All rectangles must have a height and width that is divisible by 10, 
    //  since mario moves in increments of five
    RectangleImage obs1 = new RectangleImage(new Posn(200, 200), 300, 100, new Green());
    RectangleImage obs2 = new RectangleImage(new Posn(300, 150), 100, 100, new Green());
    RectangleImage obs3 = new RectangleImage(new Posn(400, 125), 100, 100, new Green());
    RectangleImage obs4 = new RectangleImage(new Posn(200, 200), 100, 50, new Green());
    RectangleImage obs5 = new RectangleImage(new Posn(500, 150), 100, 50, new Green());
    RectangleImage obs6 = new RectangleImage(new Posn(600, 200), 120, 50, new Green());
    RectangleImage obs7 = new RectangleImage(new Posn(700, 150), 300, 100, new Green());
    RectangleImage obs8 = new RectangleImage(new Posn(850, 300), 200, 100, new Green());
    RectangleImage obs9 = new RectangleImage(new Posn(900, 200), 100, 50, new Green());
    BulletBill bill1 = new BulletBill(500, 100);
    BulletBill bill2 = new BulletBill(500, 100);
    Obstacles obstacles1 = new Obstacles(new ArrayList<RectangleImage>());
    obstacles1.obstacleArray.add(obs1);
    obstacles1.obstacleArray.add(obs2);
    obstacles1.obstacleArray.add(obs3);
    obstacles1.obstacleArray.add(obs4);
    obstacles1.obstacleArray.add(obs5);
    obstacles1.obstacleArray.add(obs6);
    obstacles1.obstacleArray.add(obs7);
    obstacles1.obstacleArray.add(obs8);
    obstacles1.obstacleArray.add(obs9);
    
    //Add all of these definitions to the world
    MarioLevel level = new MarioLevel(mario, peach, obstacles1, bill1, bill2);
    //Let there be light
    level.bigBang(400, 200, .05);
    }
}