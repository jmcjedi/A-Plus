package aplusmain;

import java.awt.Point;
import java.io.IOException;
import java.util.ArrayList;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.state.*;
import org.newdawn.slick.util.ResourceLoader;

public class Play extends BasicGameState
{
  public String mouse = ""; 
  public static int currentLetter = 0;
  public static int upperLower = 0;
  public static boolean guidesOn = false;
  public static int guideNum = 0;
  public static double guideSlope = 0.0;
  public static int prevX = 0;
  public static int prevY = 0;
  public static int width = 0;
  public static int height = 0;
  public static int nextLetterCheck = 0;
  public static boolean drawCheck = false;
  public static int checkCounter = 0;
  //public static int counter2 = 0;
  
  public static Image chalk, clear, check, draw, background, next, up, down, level1guides, 
                      currentImage, data, chalkTrail, guides, guideAnimation, colorPickerImage, colorPickerTab,
                      startingArrow; 
  
  public static Image[] guideImagesUpper = new Image[4];
  public static Image[] guideImagesLower = new Image[4];
  public static String imagePathsUpper, imagePathsLower, dataPathsUpper, dataPathsLower;
  public static String[] guidePathsLower, guidePathsUpper;
  public static int guideCountsUpper;
  public static int guideCountsLower;
  public static ArrayList<Point> guideLocationsUpper = new ArrayList<Point>();
  public static ArrayList<Point> guideLocationsLower = new ArrayList<Point>();
  
  public static int correctCounter = 0;
  public static int incorrectCounter = 0;
  public static String[] correctSounds = {"resources/sounds/correct.wav", "resources/sounds/keepUpTheGoodWork.wav", 
                                          "resources/sounds/movingRightAlong.wav", "resources/sounds/onToTheNext.wav", 
                                          "resources/sounds/wayToGo.wav"};
  
  public static String[] incorrectSounds = {"resources/sounds/tryAgain.wav", "resources/sounds/incorrect.wav"};
  public static String[] check_mark = {"resources/images/check_mark1.png","resources/images/check_mark2.png",
                                       "resources/images/check_mark3.png","resources/images/check_mark4.png",
                                       "resources/images/check_mark5.png","resources/images/check_mark6.png",
                                       "resources/images/check_mark7.png","resources/images/check_mark8.png",
                                       "resources/images/check_mark9.png","resources/images/check_mark10.png",
                                       "resources/images/check_mark11.png","resources/images/check_mark12.png",
                                       "resources/images/check_mark13.png","resources/images/check_mark14.png",
                                       "resources/images/check_mark15.png","resources/images/check_mark16.png",
                                       "resources/images/check_mark17.png","resources/images/check_mark18.png",
                                       "resources/images/check_mark19.png"};
  
  public static Sound correct;
  public static Sound incorrect;
  public static Sound startHere;
  public static Sound offTrack;
  //public static Sound tryAgain;
  public static int chalkX = 200;
  public static int chalkY = 200;
  public static int accelX = 0;
  public static int accelY = 0;
  public static int accelZ = 0;
  public static double irX = 0;
  public static double irY = 0;
  public static String buttonpressed = "";
  public static int standardLetter[][]; 
  public static int pixelsToMatch = 0;
  
  public static boolean colorPicker = false;
  public static boolean colorPicked = true;
  public static int colorChoice = 0;
  public static int colorPickerLocation = -269;
  public static String[] chalkOptions = {"resources/images/chalk_white.png", 
                                         "resources/images/chalk_red.png",
                                         "resources/images/chalk_blue.png", 
                                         "resources/images/chalk_green.png",
                                         "resources/images/chalk_yellow.png"};
  public static String[] chalkTrailOptions = {"resources/images/chalkTrail_white.png", 
                                              "resources/images/chalkTrail_red.png",
                                              "resources/images/chalkTrail_blue.png", 
                                              "resources/images/chalkTrail_green.png",
                                              "resources/images/chalkTrail_yellow.png"};
                                      
  public static Letter A = new A();
  public static Letter B = new B();
  public static Letter C = new C();
  public static Letter D = new D();
  public static Letter E = new E();
  public static Letter F = new F();
  public static Letter G = new G();
  public static Letter H = new H();
  public static Letter I = new I();
  public static ArrayList<Letter> letters = new ArrayList<Letter>();
  
  
  public static ArrayList<Point> userPath = new ArrayList<Point> (); 
  public static ArrayList<Point> expectedPath = new ArrayList<Point> (); 
  public static ArrayList<Point> expectedPathLink = new ArrayList<Point> (); 
  public static Point startingLocation = new Point(0,0);
  public static Point startingPointArrow = new Point(0,0);; 
  public static boolean letterStarted = false;
  public static boolean alreadyPlayed = false;  
  public static boolean showStartingPoint = false;
  public static boolean offTrackPlay = false;
  public static Point prevLocation = new Point(0, 0);
  //public static int currentScore = 0;
  //public static int totalScore = 0;
  public static int moveCounter = 0;
  public static int playCounter = 0;
  public static int justStarted = 0;
  //public static MoteFinderListener listener4;// = Connect.listener;
  //public static AccelerometerListener<Mote>  listener5;// = Connect.listener2;
  //public static IrCameraListener listener6;// = Connect.listener3;
  //public static CoreButtonListener listener7;
  //public static boolean[] leds2;// = Connect.leds;
  
  public Play(int state)
  {
	  
  }
   
  public void init(GameContainer container, StateBasedGame stategame) throws SlickException
  {
    //texture = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("res/image.png"));
    //currentImage = new Image("resources/images/ADataCap.png");
    //width = currentImage.getWidth();
    //height = currentImage.getHeight();
    letters.add(A); 
    letters.add(B);
    letters.add(C);
    letters.add(D);
    letters.add(E);
    letters.add(F);
    letters.add(G);
    letters.add(H);
    letters.add(I);
    
    System.out.println(letters.get(0).getImagePathsLower());
    System.out.println(A.getImagePathsLower());
    
    startingArrow = new Image("resources/images/start_here.png");

    chalkTrail = new Image("resources/images/chalkTrail_white.png");
    chalk = new Image("resources/images/chalk_white.png"); 
    colorPickerTab = new Image("resources/images/chalk_tab.png");
    colorPickerImage = new Image("resources/images/chalk_selection.png");

    clear = new Image("resources/images/clear.png");
    next = new Image("resources/images/next_letter.png");
    up = new Image("resources/images/upArrow.png");
    down = new Image("resources/images/downArrow.png");
    
    offTrack = new Sound("resources/sounds/offTrack.wav");
    startHere = new Sound("resources/sounds/startHere.wav");
    //tryAgain = new Sound("resources/sounds/tryAgain.wav");
    
    check = new Image("resources/images/check.png");
    guides = new Image("resources/images/guides.png");
    draw = new Image("resources/images/draw_here.png");
    level1guides = new Image("resources/images/level1guides.png");
    background = new Image("resources/images/background_small.png");
    
    constructLetter();
  }
  
  public void render(GameContainer container, StateBasedGame stategame, Graphics g) throws SlickException
  {
    Image checkMark = new Image(check_mark[checkCounter]);
    g.drawImage(background, 0, 0);
    g.drawImage(level1guides, 50, 50);
    g.drawImage(check, 50, 725);
    g.drawImage(clear, 830, 725);
    g.drawImage(next, 864, 100);
    g.drawImage(guides, 50, 75);
    g.drawImage(currentImage, 300, 50);
    g.drawImage(colorPickerTab, 70, 0);
    
    //g.drawImage(draw, 635, 10);
    g.setColor(Color.white);
    //g.drawString(mouse, 50, 50);
    //g.drawRect(580, 200, 135, 210);
    if(upperLower==0)
    {
      g.drawImage(down, 774, 523); 
    }
    else g.drawImage(up, 774, 523); 

    if(guidesOn==true)
    {
      if(upperLower==0)
      {
        for(int i=0; i< guideCountsUpper; i++)
        {
          g.drawImage(guideImagesUpper[i], guideLocationsUpper.get(i).x, guideLocationsUpper.get(i).y); 
        }
      }
      else
      {
        for(int i=0; i< guideCountsLower; i++)
        {
          g.drawImage(guideImagesLower[i], guideLocationsLower.get(i).x, guideLocationsLower.get(i).y); 
        }
      }
    }
    
    if(showStartingPoint==true)
    {
      g.drawImage(startingArrow, 300+startingPointArrow.x, 50+startingPointArrow.y);
    }
    
    //g.drawString("This is the 'Menu' screen", 50, 50);
    //g.drawString(buttonpressed, 50, 100);
    //g.drawString("Accelerometer X: " + accelX + " Y: " + accelY + " Z: " + accelZ, 50, 120);
    //g.drawString("IR Camera X: " + irX + " Y: " + irY, 50, 140);
    g.drawImage(chalk, chalkX, chalkY);
    
    int x, y;
    for (x = 0; x < 1024; x++)
    {
      for (y = 0; y < 768; y++)
      {
        if (Connect.chalkTrail[x][y] == 1)
        {
          g.drawImage(chalkTrail, x, y);
          //g.fillOval((float)x, (float)y, 60, 60);
          //g.fillRect((float)x, (float)y, 8, 8);
        }
      }
    } 
     
    if (colorPicker==true)
    {
      if(colorPickerLocation < 0)
      {
        g.drawImage(colorPickerImage, 275, colorPickerLocation);
        colorPickerLocation+=9;
      }
      else g.drawImage(colorPickerImage, 275, 0);
    }
    
    if (colorPicker==false) 
    {
      if(colorPickerLocation > -269)
      {
        g.drawImage(colorPickerImage, 275, colorPickerLocation);
        colorPickerLocation-=9;
      }
    }
    
    g.drawImage(chalk, chalkX, chalkY);
    
    if (drawCheck == true)
    { //System.out.println(" DRAWING CHECK !!!!!!!!!!!!!!" + checkCounter);
      g.drawImage(checkMark, 300, 200);
      if(checkCounter==18) 
      {
        try
        {
          Thread.sleep(500l);
        } catch (InterruptedException e)
        {
          e.printStackTrace();
        }
        drawCheck = false;
        checkCounter = 0;
      }               
      else checkCounter++;
    }
  }
  
  // method for updating the screen at regular intervals for 
  public void update(GameContainer container, StateBasedGame stategame, int delta) throws SlickException
  {
    correct = new Sound(correctSounds[correctCounter]);
    incorrect = new Sound(incorrectSounds[incorrectCounter]);
    
    justStarted++;
    if (justStarted > 20)
    {
      playCounter++;
      if (playCounter > 90)
      {
        offTrackPlay = true;
      }
      accelX = Connect.accelX;
      accelY = Connect.accelY;
      accelZ = Connect.accelZ;
      irX = Connect.irX;
      irY = Connect.irY;
      chalkX = (int)irX;
      chalkY = (int)irY;
    
      buttonpressed = Connect.buttonpressed;
      if (buttonpressed=="A")
      {
        /*try
        {
         Thread.sleep(50);
      } catch (InterruptedException e1)
      {
        // TODO Auto-generated catch block
        e1.printStackTrace();
      }*/ 
        Connect.chalkTrail[(int)irX][(int)irY] = 1;
        for (int x = 0; x < 60; x++)
        {
          for (int y = 0; y < 60; y++)
          {
            Connect.inputLetter[(int)(Connect.irX + x)][(int)Connect.irY + y] = 1;
          }
        }
        if(chalkY > 700 && chalkY < 745 && chalkX > 830 && chalkX < 974)
        {
          clearTrail();
        }
        else if(chalkY > 700 && chalkY < 745 && chalkX > 50 && chalkX < 185)
        {
          try
          {
            compareLetters();
          } catch (InterruptedException e)
          {e.printStackTrace();
          }
        }
        else if(chalkY > 100 && chalkY < 260 && chalkX > 864 && chalkX < 974)
        {      
            try
            {
              Thread.sleep(500);
            } catch (InterruptedException e)
            { e.printStackTrace();
            }
            pixelsToMatch = 0;
            if (currentLetter == 8) currentLetter = 0;
            else currentLetter++;
            constructLetter();
            justStarted = 0;
        }
        else if(chalkY > 523 && chalkY < 668 && chalkX > 774 && chalkX < 974)
        {      
            try
            {
              Thread.sleep(500);
            } catch (InterruptedException e)
            { e.printStackTrace();
            }
            pixelsToMatch = 0;
            if(upperLower==0) upperLower = 1;
            else upperLower = 0;
            constructLetter();
            justStarted = 0;
        }
        else if(chalkY > 75 && chalkY < 120 && chalkX > 50 && chalkX < 230)
        {
          if (guidesOn==true)
          {
            guidesOn = false;        
          }
          else
          {
            guidesOn = true;
            createGuides();
          }
          justStarted = 0;
        }
        else if(chalkY > 0 && chalkY < 66 && chalkX > 70 && chalkX < 270)
        {
          if (colorPicker==true)
          {
            //animateColorPickerReverse = true;
            colorPicker = false;
          }
          else
          {
          //animateColorPicker = true;
            colorPicker = true;
          }
          justStarted = 0;
        }
        else if(chalkY > 0 && chalkY < 257 && chalkX > 275 && chalkX < 851)
        {
          if(colorPicker==true)
          {
            if (chalkX < 396)
            {
              colorChoice = 2;
              changeColor();
              clearTrail();
              justStarted = 0;
            }
            else if (chalkX < 506)
            {
              colorChoice = 1;
              changeColor();
              clearTrail();
              justStarted = 0;
            }
            else if (chalkX < 603)
            {
              colorChoice = 3;
              changeColor();
              clearTrail();
              justStarted = 0;
            }
            else if (chalkX < 708)
            {
              colorChoice = 4;
              changeColor();
              clearTrail();
              justStarted = 0;
            }
            else if (chalkX < 851)
            {
              colorChoice = 0;
              changeColor();
              clearTrail();
              justStarted = 0;
            }
          }
        }
        if(chalkY > 50 && chalkY < 720 && chalkX > 300 && chalkX < 730)
        {
          try
          {
            try
            {
              comparePaths();
            } catch (InterruptedException e)
            {
              e.printStackTrace();
            }
          } catch (IOException e)
          {
            e.printStackTrace();
         }
        }
      }
    }
    
    
    //gets all input from user
    /*Input input = container.getInput();

    int x = Mouse.getX();
    int y = Mouse.getY();
    
    mouse = "Mouse X: " + x + ", Mouse Y: " + y;
    chalkX = Mouse.getX();
    chalkY = 768 - Mouse.getY();
    
    if((x>50 && x<150) && (y>568 && y<668))
    {
      if(input.isMouseButtonDown(0))
      {
        stategame.enterState(3);
      }
    }*/ 
    
  }
  
  public static void comparePaths() throws IOException, InterruptedException 
  {
    System.out.println("");
    int length = expectedPathLink.size();
    int x = chalkX - 275;// accounting for 25 pixels to center of chalk mark
    int y = chalkY - 25;
    
    int gridX = (int)((double)x/50.00);
    int gridY = (int)((double)y/50.00);
    
    Point currentLocation = new Point(gridX, gridY);
    if (currentLocation.x==prevLocation.x && currentLocation.y==prevLocation.y)
    {
      System.out.println("Previous and Current Locations Match");
      return;
      //don't do anything
      //System.out.println("GridX = " + gridX + ", GridY = " + gridY);
    }
   
    int startX = startingLocation.x;
    int startY = startingLocation.y;
    int nextX = 0;
    int nextY = 0;
    int nextNextX = 0;
    int nextNextY = 0;
    int nextNextNextX = 0;
    int nextNextNextY = 0;
    Point temp2 = new Point(0,0);
    
    //get final point for checking
    int finalX = 0;
    int finalY = 0;
    Point finalPoint = new Point(0,0);
    finalPoint = expectedPathLink.get(length-1);
    finalX = (int) finalPoint.getX();
    finalY = (int) finalPoint.getY();
    
    //if(expectedPathLink.get(moveCounter+1)!=null)
    if(moveCounter+1<length)
    {
      temp2 = expectedPathLink.get(moveCounter+1);
      nextX = temp2.x;
      nextY = temp2.y;
      System.out.println("nextX = " + nextX + ", nextY = " + nextY);
    }
    //if(expectedPathLink.get(moveCounter+2)!=null)
    if(moveCounter+2<length)
    {
      nextNextX = expectedPathLink.get(moveCounter+2).x;
      nextNextY = expectedPathLink.get(moveCounter+2).y;
      System.out.println("nextNextX = " + nextNextX + ", nextNextY = " + nextNextY);
    }
    if(moveCounter+3<length)
    {
      nextNextNextX = expectedPathLink.get(moveCounter+3).x;
      nextNextNextY = expectedPathLink.get(moveCounter+3).y;
      System.out.println("nextNextX = " + nextNextX + ", nextNextY = " + nextNextY);
    }
    
    Point temp = expectedPathLink.get(moveCounter);
  
    int currentX = temp.x;
    int currentY = temp.y;
      
    System.out.println("GridX = " + gridX + ", GridY = " + gridY);
    System.out.println("currentX = " + currentX + ", currentY = " + currentY);
    //System.out.println("Initial Current  = " + currentScore + ", Initial Total Score = " + totalScore);
    
    if (letterStarted == true)
    {
      if((moveCounter > (int)(length/1.5)) &&
          (finalX == gridX || finalX == gridX) &&
          (finalY == gridY || finalY == gridY))
      {
        System.out.println("Found the end!!");
        userPath.add(new Point(gridX, gridY));
        try
        {
          compareLetters();
        } catch (SlickException e)
        {
          e.printStackTrace();
        }
    
      }
      else if ((currentX == gridX+2 || currentX == gridX-2 || 
           currentX == gridX+1 || currentX == gridX-1 || 
           currentX == gridX || currentX == gridX) &&
          (currentY == gridY+2 || currentY == gridY-2 || 
           currentY == gridY+1 || currentY == gridY-1 || 
           currentY == gridY || currentY == gridY))
      {
        
        System.out.println("Letter started and within allowable bounds of current expected location.");
            // Do nothing - allow the user to continue to draw uninhibited
            //userPath.add(new Point(gridX, gridY));
            //expectedPathLink.removeFirst();
            //System.out.println("currentX = " + currentX + ", currentY = " + currentY);

      }
      else if((moveCounter+1<length) &&
              (nextX == gridX+2 || nextX == gridX-2 || 
               nextX == gridX+1 || nextX == gridX-1 || 
               nextX == gridX || nextX == gridX) &&
              (nextY == gridY+2 || nextY == gridY-2 || 
               nextY == gridY+1 || nextY == gridY-1 || 
               nextY == gridY || nextY == gridY))
      {
          System.out.println("Outside bounds of first space, but within second - moving on...");
          userPath.add(new Point(gridX, gridY));
          moveCounter++; 
      }
      else if((moveCounter+2<length) &&
              (nextNextX == gridX+2 || nextNextX == gridX-2 || 
               nextNextX == gridX+1 || nextNextX == gridX-1 || 
               nextNextX == gridX || nextNextX == gridX) &&
              (nextNextY == gridY+2 || nextNextY == gridY-2 || 
               nextNextY == gridY+1 || nextNextY == gridY-1 || 
               nextNextY == gridY || nextNextY == gridY))
      {
        System.out.println("Outside bounds of first space and second space, but within third - moving on...");
        userPath.add(new Point(gridX, gridY));
        moveCounter+=2; 
        
      }
      else if((moveCounter+3<length) &&
          (nextNextNextX == gridX+3 || nextNextNextX == gridX-3 ||
           nextNextNextX == gridX+2 || nextNextNextX == gridX-2 || 
           nextNextNextX == gridX+1 || nextNextNextX == gridX-1 || 
           nextNextNextX == gridX || nextNextNextX == gridX) &&
          (nextNextNextY == gridY+3 || nextNextNextY == gridY-3 ||
           nextNextNextY == gridY+2 || nextNextNextY == gridY-2 || 
           nextNextNextY == gridY+1 || nextNextNextY == gridY-1 || 
           nextNextNextY == gridY || nextNextNextY == gridY))
      {
        System.out.println("Outside bounds of first space, second space & third, but within fourth - moving on...");
        userPath.add(new Point(gridX, gridY));
        moveCounter+=3; 
    
      }
      else
      {

          System.out.println("Outside range of expected blocks, adding to and resetting.");
          
          /*int xDiff, yDiff = 0;
          if (gridX > currentX) xDiff = gridX-currentX;
          else xDiff = currentX - gridX;
          if (gridY > currentY) yDiff = gridY-currentY;
          else yDiff = currentY - gridY;
          if (xDiff > yDiff) currentScore += xDiff;
          else currentScore += yDiff;*/
          
          if (offTrackPlay == true)
          {
            offTrackPlay = false;
            playCounter = 0;
            //letterStarted = false;
            //alreadyPlayed = false;
            Connect.remote.vibrateFor(20);
            offTrack.play();
          }
          moveCounter = 0;
          System.out.println("Current User Path = " + userPath);
          guidesOn = true;
          userPath.clear();
          clearTrail();

        //totalScore += currentScore;
        //currentScore = 0;
      }
    }
    else 
    {
      if ((startX == gridX+2 || startX == gridX-2 || 
           startX == gridX+1 || startX == gridX-1 || 
           startX == gridX || startX == gridX) &&
          (startY == gridY+2 || startY == gridY-2 || 
           startY == gridY+1 || startY == gridY-1 || 
           startY == gridY || startY == gridY))
      {
        letterStarted = true;
        userPath.add(new Point(gridX, gridY));
        //expectedPathLink.removeFirst();
        showStartingPoint = false;
      }
      else
      {
        if(alreadyPlayed == false)
        { 
          startHere.play();
          clearTrail();
          alreadyPlayed = true;
        }
        showStartingPoint = true;
        guidesOn = true;
        clearTrail();
      }
    }
    prevLocation.x = currentLocation.x;
    prevLocation.y = currentLocation.y;
    System.out.println("Current User Path = " + userPath);
    return;
  }

  public static void compareLetters() throws InterruptedException, SlickException
  { 
    Thread.sleep(1000);                            
    int x, y;
    int totalPixels = 0;
    double percentage = 0.0;
    for (x =  0; x < width; x++)
    {
      for (y = 0; y < height; y++)
      {
        if (standardLetter[x][y] == 1)
        {
          if (standardLetter[x][y] == Connect.inputLetter[x+300][y+50])
          {
            totalPixels++;
            //int newX = x+300;
            //int newY = y+50;
            //System.out.println("Matching points at: " + newX + ", " + newY);
          }
        }
      }
    }

    percentage = (double)((double)totalPixels/(double)pixelsToMatch);
    System.out.println("Total Pixels = " + totalPixels);
    System.out.println("pixelsToMatch = " + pixelsToMatch);
    System.out.println("Percentage = " + percentage);
    if (percentage > .75)
    {
      correct.play();
      drawCheck = true;
      if (correctCounter == 4) correctCounter = 0;
      else correctCounter++;
      if (currentLetter == 8) currentLetter = 0;
      else currentLetter++;
      pixelsToMatch = 0;
      constructLetter();
    }
    else if (percentage < .75)
    {
      incorrect.play();
      clearTrail();
      letterStarted = false;
      userPath.clear();
      moveCounter = 0;
      if (incorrectCounter == 1) incorrectCounter = 0;
      else incorrectCounter++;
    }
    /*else if (totalScore > 15)
    {
      System.out.println("Total Score = " + totalScore);
      tryAgain.play();
      clearTrail();
      totalScore = 0;
      alreadyPlayed = false;
      letterStarted = false;
      userPath.clear();
      moveCounter = 0;
    }*/
  }
  
  public static void clearTrail()
  {
    int x, y;
    for (x = 0; x < 1024; x++)
    {
      for (y = 0; y < 768; y++)
      {
        Connect.chalkTrail[x][y] = 0;
      }
    } 
    for (x = 0; x < 1084; x++)
    {
      for (y = 0; y < 828; y++)
      {
        Connect.inputLetter[x][y] = 0;
      }
    }
    letterStarted = false;
    userPath.clear();
    moveCounter = 0;
  }
  
  public static void changeColor() throws SlickException
  {
    chalkTrail = new Image(chalkTrailOptions[colorChoice]);
    chalk = new Image(chalkOptions[colorChoice]); 
    colorPicker = false;
    clearTrail();
  }
  
  public static void constructLetter() throws SlickException
  {
    letterStarted = false;
    alreadyPlayed = false;
    offTrackPlay = false;
    clearTrail();
    userPath.clear();
    guidesOn = false;
    moveCounter = 0;
    
    if (upperLower==0)
    {
      expectedPath = letters.get(currentLetter).getUpperPath();
    }
    else expectedPath = letters.get(currentLetter).getLowerPath();
    
    expectedPathLink.clear();
    expectedPathLink.addAll(expectedPath);
    
    startingLocation = letters.get(currentLetter).getStartingLocation();
    startingPointArrow.setLocation(startingLocation.x*50 + 25, startingLocation.y*50 + 25);
       
    guidePathsUpper = letters.get(currentLetter).getGuidePathsUpper();
    guidePathsLower = letters.get(currentLetter).getGuidePathsLower();
    
    guideCountsUpper = letters.get(currentLetter).getGuideCountsUpper();
    guideCountsLower = letters.get(currentLetter).getGuideCountsLower();
    
    guideLocationsUpper = letters.get(currentLetter).getGuideLocationsUpper();
    guideLocationsLower = letters.get(currentLetter).getGuideLocationsLower();
  
    dataPathsUpper = letters.get(currentLetter).getDataPathsUpper();
    dataPathsLower = letters.get(currentLetter).getDataPathsLower();
    
    imagePathsUpper = letters.get(currentLetter).getImagePathsUpper();
    imagePathsLower = letters.get(currentLetter).getImagePathsLower();
    
    for (int i=0; i<guideCountsUpper; i++)
    {
      guideImagesUpper[i] = new Image(guidePathsUpper[i]);
    }
    for (int i=0; i<guideCountsLower; i++)
    {
      guideImagesLower[i] = new Image(guidePathsLower[i]);
    }
    
    Texture texture = null;
    if(pixelsToMatch==0)
    {
      if(upperLower==0)
      {
        try
        {
          texture = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream(imagePathsUpper));
          data = new Image(dataPathsUpper);
          currentImage = new Image(imagePathsUpper);
        } catch (IOException e)
        {e.printStackTrace();
        }
        width = texture.getImageWidth();
        height = texture.getImageHeight();
        standardLetter = new int[width][height];
      }
      else
      {
        try
        {
          texture = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream(imagePathsLower));
          data = new Image(dataPathsLower);
          currentImage = new Image(imagePathsLower);
        } catch (IOException e)
        {e.printStackTrace();
        }
        width = texture.getImageWidth();
        height = texture.getImageHeight();
        standardLetter = new int[width][height];
      }
          
      for (int x = 0; x < width; x++)
      {
        for (int y = 0; y < height; y++)
        { 
          if(data.getColor(x, y).getAlpha()==255 &&
             data.getColor(x, y).getGreen()==255 &&
             data.getColor(x, y).getBlue()==255 &&
             data.getColor(x, y).getRed()==255)
          {
            standardLetter[x][y] = 1;
            pixelsToMatch++;
          }
          else standardLetter[x][y] = 0;
        }
      }
      System.out.println("Total Pixels to Match = " + pixelsToMatch);  
    }
  }
  
  public static void createGuides()
  {
    if(upperLower==0) guideNum = guideCountsUpper;
    else guideNum = guideCountsLower;
  }
  
  public int getID()
  {
	  return 3;
  }
}