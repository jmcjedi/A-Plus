package aplusmain;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class APlus extends StateBasedGame 
{
  public static final String gamename = "A-Plus";
  public static final int intro = 0;
  public static final int connect = 1;
  public static final int menu = 2;
  public static final int play = 3;
  
  public APlus(String gamename)
  {
	  super(gamename);
	
	  this.addState(new Connect(connect));
    this.addState(new Intro(intro));
	  this.addState(new Menu(menu));
	  this.addState(new Play(play));
  }
  
  public void initStatesList(GameContainer container) throws SlickException
  {
    
    //initialize menu screen  
    this.getState(intro).init(container, this);
    
    //initialize main play screen
    this.getState(connect).init(container, this);
	  
    //initialize menu screen  
	  this.getState(menu).init(container, this);
	
	  //initialize main play screen
	  this.getState(play).init(container, this);
	
	  //screen to start the game on
	  this.enterState(intro);
  }
  
  public static void main(String[] args)
  {
	  //creates main window to hold the game
	  
	  
	  AppGameContainer appcontainer;
	  try{
		  //puts the specific game within the window
		 appcontainer = new AppGameContainer(new APlus(gamename)); 
		 //set display mode to full screen (set to false for no full screen)
		 appcontainer.setDisplayMode(1024, 768, true);
		 appcontainer.setShowFPS(false);
		 appcontainer.setTargetFrameRate(30);
		 appcontainer.start();
		 
	  }catch(SlickException e){
		e.printStackTrace();
	  }
	  
  }

}
