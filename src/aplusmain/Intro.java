package aplusmain;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class Intro extends BasicGameState
{ 
  int counter = 0;
  
  public Intro(int state)
  {
    
  }
  
  // creation of the screen and housekeeping items
  public void init(GameContainer container, StateBasedGame stategame) throws SlickException
  {
    
  }
  
  // creation of graphics elements
  public void render(GameContainer container, StateBasedGame stategame, Graphics g) throws SlickException
  {
    Image background = new Image("resources/images/background_small.png");
    Image logo = new Image("resources/images/logo.png");
    g.drawImage(background, 0, 0);
    g.drawImage(logo, 298, 250);
    //g.drawString(mouse, 50, 50);
    //g.drawString("This is the 'Intro' state", 50, 100);
  }
  
  // method for updating the screen at regular intervals when things change
  public void update(GameContainer container, StateBasedGame stategame, int delta) throws SlickException
  {
    //delays game for intro sequence
    if(counter > 60)
    {
      stategame.enterState(1);
    }
    counter++;
    
    //samples for using keyboard input from user
    //Input input = container.getInput();
    //if(input.isKeyDown(Input.KEY_UP)) { chalkY-=1; }
    //if(input.isKeyDown(Input.KEY_DOWN)) { chalkY+=1; }
    //if(input.isKeyDown(Input.KEY_RIGHT)) { chalkX+=1; }
    //if(input.isKeyDown(Input.KEY_LEFT)) { chalkX-=1; }
  }
  
  public int getID()
  {
    return 0;
  }
}