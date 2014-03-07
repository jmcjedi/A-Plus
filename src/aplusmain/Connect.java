package aplusmain;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JFrame;
import javax.swing.JPanel;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

import wiiremotej.AbsoluteAnalogStickMouse;
import wiiremotej.AccelerometerMouse;
import wiiremotej.AnalogStickData;
import wiiremotej.AnalogStickMouse;
import wiiremotej.ButtonMap;
import wiiremotej.ButtonMouseMap;
import wiiremotej.ButtonMouseWheelMap;
import wiiremotej.IRAccelerometerMouse;
import wiiremotej.IRLight;
import wiiremotej.IRMouse;
import wiiremotej.MotionAccelerometerMouse;
import wiiremotej.PrebufferedSound;
import wiiremotej.RelativeAnalogStickMouse;
import wiiremotej.TiltAccelerometerMouse;
import wiiremotej.WiiRemote;
import wiiremotej.WiiRemoteExtension;
import wiiremotej.WiiRemoteJ;
import wiiremotej.event.WRAccelerationEvent;
import wiiremotej.event.WRButtonEvent;
import wiiremotej.event.WRClassicControllerExtensionEvent;
import wiiremotej.event.WRExtensionEvent;
import wiiremotej.event.WRGuitarExtensionEvent;
import wiiremotej.event.WRIREvent;
import wiiremotej.event.WRNunchukExtensionEvent;
import wiiremotej.event.WRStatusEvent;
import wiiremotej.event.WiiRemoteListener;

public class Connect extends BasicGameState 
{
  
  //new
  public static WiiRemoteListener listener = null;
  public static WiiRemote remote;
  public static PrebufferedSound prebuf;
  public static boolean accelerometerSource = true; //true = wii remote, false = nunchuk
  public static boolean lastSource = true;
  
  public static boolean mouseTestingOn;
  public static int status = 0;
  public static int accelerometerStatus = 0;
  public static int analogStickStatus = 0;
  public static JFrame mouseTestFrame;
  public static JPanel mouseTestPanel;
  
  public static JFrame graphFrame;
  public static JPanel graph;
  public static int[][] pixels;
  public static int t = 0;
  public static int x = 0;
  public static int y = 0;
  public static int z = 0;
  
  public static int lastX = 0;
  public static int lastY = 0;
  public static int lastZ = 0;
  
  //public static final MoteFinderListener listener = null;
  public static int connected = 0;
  int counter, counter2 = 0;
  int checkCounter = 0;
  static boolean go = false;
  public static String buttonpressed = "";
  public static int accelX = 0;
  public static int accelY = 0;
  public static int accelZ = 0;
  public static double irX = 0;
  public static double irY = 0;
  int pixelArrayX[]= new int[424];
  int pixelArrayY[] = new int[424];
  int pixelArrayZ[] = new int[424];
  Image chalk;
  public static int chalkX, chalkY;
  public static int chalkTrail[][] = new int[1024][1024];
  public static int inputLetter[][] = new int[1084][1084];
  public static String[] wheel_spokes = {"resources/images/spin1.png","resources/images/spin2.png",
                                         "resources/images/spin3.png","resources/images/spin4.png",
                                         "resources/images/spin5.png","resources/images/spin6.png",
                                         "resources/images/spin7.png","resources/images/spin8.png",
                                         "resources/images/spin9.png","resources/images/spin10.png",
                                         "resources/images/spin11.png","resources/images/spin12.png",
                                         "resources/images/spin13.png"};
  
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
  public static Image rotating_wheel; 
  public static Image checkMark;
  public static int wheel_spoke = 0;
  public static boolean connectedPlay = false;
  public static Sound getConnected;
  
  public Connect(int state) 
  {
    
  }
  
  /*public Connect(WiiRemote remote)
  {
    this.remote = remote;
  }*/
  
  public void init(GameContainer container, StateBasedGame stategame) throws SlickException
  {
    chalk = new Image("resources/images/chalk_white.png"); 
    getConnected = new Sound("resources/sounds/getConnected.wav");
  }
  
  public void render(GameContainer container, StateBasedGame stategame, Graphics g) throws SlickException
  {
    rotating_wheel = new Image(wheel_spokes[wheel_spoke]); 
    Image background = new Image("resources/images/background_small.png");
    Image connect1 = new Image("resources/images/connect1.png");
    Image connect2 = new Image("resources/images/connect2.png");
    Image connectarrow = new Image("resources/images/connectarrow.png");
    Image checkMark = new Image(check_mark[checkCounter]);
    
    g.drawImage(background, 0, 0); 
    //g.drawImage(connect1, 20, 134);
    //g.drawImage(connect2, 523, 134);
    //g.drawImage(connectarrow, 412, 284);
    //g.drawImage(rotating_wheel, 350, 200);
    
    if(connected==0)
    {
      if (connectedPlay==false)
      {
        getConnected.play();
        connectedPlay = true;
      }
      g.drawImage(connect1, 20, 134);
      g.drawImage(connect2, 523, 134);
      g.drawImage(connectarrow, 412, 284);
      g.drawImage(rotating_wheel, 380, 150);
    }
    if(connected==1)
    {
      counter2++;
      if(counter2 % 2 == 0)
      {
        if(checkCounter==18) checkCounter = 18;
        else checkCounter++;
        
        if(counter2 > 90)
        {
          go = true;
        }
      }
      g.drawImage(checkMark, 300, 200);
    }
    //g.setColor(Color.white);
    //g.drawString("This is the 'Connect' screen", 50, 50);
    //g.drawString(buttonpressed, 50, 100);
    //g.drawString("Accelerometer X: " + accelX + " Y: " + accelY + " Z: " + accelZ, 50, 120);
    //g.drawString("IR Camera X: " + irX + " Y: " + irY, 50, 140);
    //g.drawImage(chalk, chalkX, chalkY);
    
    int x, y;
    for (x = 0; x < 1024; x++)
    {
      for (y = 0; y < 1024; y++)
      {
        if (chalkTrail[x][y] == 1)
        {
          g.fillRect((float)x, (float)y, 8, 8);
        }
        
      }
    } 
    
    /*if (connected==1)
    {
      //Draw graph box in center of screen
      g.drawString("Input Value: 0", 160, 378);
      g.drawString("Input Value: 100", 150, 278);
      g.drawRect(300, 168, 424, 432);
      
      g.setColor(Color.white);
      g.drawLine(300, 384, 724, 384);
      
      //int accelXnew = (accelX - 95) * 4;
      //int accelYnew = (accelY - 95) * 4;
      //int accelZnew = (accelZ - 95) * 4;
      //populate and draw curve for X acceleration
      
      int tempX = 0;
      int temp2X = 0;
      int tempY = 0;
      int temp2Y = 0;
      int tempZ = 0;
      int temp2Z = 0;
      
      for (int i = 0; i < 424; i++)
      {
        if (i==0) 
        {
          tempX = 384-accelX;
          pixelArrayX[i] = tempX;
          tempY = 384-accelY;
          pixelArrayY[i] = tempY;
          tempZ = 384-accelZ;
          pixelArrayZ[i] = tempZ;
        }
        else
        {
          temp2X = pixelArrayX[i];
          pixelArrayX[i] = tempX;
          tempX = temp2X;
          
          temp2Y = pixelArrayY[i];
          pixelArrayY[i] = tempY;
          tempY = temp2Y;
          
          temp2Z = pixelArrayZ[i];
          pixelArrayZ[i] = tempZ;
          tempZ = temp2Z;
        }
      }
      for (int i = 0; i < 424; i++)
      {
        g.setColor(Color.red);
        g.fillRect(300+i, pixelArrayX[i], 2, 2);
        g.setColor(Color.green);
        g.fillRect(300+i, pixelArrayY[i], 2, 2);
        g.setColor(Color.blue);
        g.fillRect(300+i, pixelArrayZ[i], 2, 2);
      }
    }*/
  }
  
  // method for updating the screen at regular intervals for 
  public void update(GameContainer container, StateBasedGame stategame, int delta) throws SlickException
  {
    counter++;
    if(counter % 2 == 0)
    {
      if(wheel_spoke==12) wheel_spoke = 0;
      else wheel_spoke++;
    }
    
    if(remote!=null)
    {
      if (remote.isConnected())
      {
        irX = WiimoteAdapter.lightX;
        irY = WiimoteAdapter.lightY;
        //accelX = WiimoteAdapter.x;
        //accelY = WiimoteAdapter.y;
        //accelZ = WiimoteAdapter.z;
      }
    }
    //else System.out.println("NotConnected...");
    
    //Input input = container.getInput();
    //int x = Mouse.getX();
    //int y = Mouse.getY();
    //mouse = "Mouse X: " + x + ", Mouse Y: " + y;

 
      if(connected==0 && counter > 90)
      {  
        try
        {
          connectwiimote();
        } catch (IllegalStateException e)
        {
          // TODO Auto-generated catch block
          e.printStackTrace();
        } catch (InterruptedException e)
        {
          // TODO Auto-generated catch block
          e.printStackTrace();
        } catch (IOException e)
        {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }
      }
      
      //  *** NEED TO DESIGN SOME TRANSITIONAL GRAHPICS BETWEEN STATES ***
      // connecting to the wiimote
      /*if(connected==1)
      {
        stategame.enterState(2);
      }*/
      
      if(go==true)
      {
        stategame.enterState(2);
      }

  }
  
  public static void connectwiimote() throws IllegalStateException, InterruptedException, IOException
  {
    //basic console logging options...
    WiiRemoteJ.setConsoleLoggingAll();
    //WiiRemoteJ.setConsoleLoggingOff();
    System.setProperty("bluecove.jsr82.psm_minimum_off", "true");
    
    remote = WiiRemoteJ.findRemote();
    remote.addWiiRemoteListener(new WiimoteAdapter(remote));
    remote.setAccelerometerEnabled(true);
    remote.setSpeakerEnabled(true);
    remote.setIRSensorEnabled(true, WRIREvent.BASIC);
    remote.setLEDIlluminated(0, true);
    remote.vibrateFor(20);
    connected = 1;

    
    remote.getButtonMaps().add(new ButtonMap(WRButtonEvent.HOME, ButtonMap.NUNCHUK, WRNunchukExtensionEvent.C, new int[]{java.awt.event.KeyEvent.VK_CONTROL}, 
        java.awt.event.InputEvent.BUTTON1_MASK, 0, -1));
                
    //Prebuffer a preformatted audio file
    System.out.println("Buffering audio file...");
    long time = System.currentTimeMillis();
    AudioInputStream audio = null;
    try
    {
      audio = AudioSystem.getAudioInputStream(new java.io.File("resources/sounds/audio8.wav"));
    } catch (UnsupportedAudioFileException e)
    {
      e.printStackTrace();
    }
    prebuf = WiiRemote.bufferSound(audio);
    time = System.currentTimeMillis()-time;
    time /= 1000;
    System.out.println("Prebuf done: " + time + " seconds.");

    /*listener2 = new AccelerometerListener<Mote>()
    {
      public void accelerometerChanged(AccelerometerEvent<Mote> evt)
      {
        //System.out.println(evt.getX() + " : " + evt.getY() + " : " + evt.getZ());
        accelX = evt.getX();
        accelY = evt.getY();
        accelZ = evt.getZ();
      }
    };
    
    listener3 = new IrCameraListener() 
    {  
      public void irImageChanged(IrCameraEvent evt) 
      {
        //System.out.println(evt.getIrPoint(0).getX() + " : " + evt.getIrPoint(0).getY());
        irX = evt.getIrPoint(0).getX();
        irY = evt.getIrPoint(0).getY();
        chalkX = (int)(1024.0 - evt.getIrPoint(0).getX());
        chalkY = (int)evt.getIrPoint(0).getY();
      }
    
    };
    
    listener = new MoteFinderListener() 
    {  
      public void moteFound(final Mote mote) 
      {
        System.out.println("Found mote: " + mote.getBluetoothAddress());
        mote.rumble(2000l);
        mote.setPlayerLeds(leds);
            
        mote.addAccelerometerListener(listener2); 
        mote.addIrCameraListener(listener3);
        mote.enableIrCamera();
        
        mote.setReportMode(ReportModeRequest.DATA_REPORT_0x37);
        
        
        mote.addCoreButtonListener(new CoreButtonListener()
        {
          public void buttonPressed(CoreButtonEvent evt) 
          {
            if (evt.isButtonAPressed()) 
            {
              buttonpressed = "Button A pressed!";
              chalkTrail[(int)(1024 - irX)][(int)irY] = 1;
              for (int x = 0; x < 60; x++)
              {
                for (int y = 0; y < 60; y++)
                {
                  inputLetter[(int)(1024 - irX + x)][(int)irY + y] = 1;
                }
              }
            }
            if (evt.isButtonBPressed()) 
            {
              buttonpressed = "Button B pressed!";
              for (int x = 0; x < 1024; x++)
              {
                for (int y = 0; y < 768; y++)
                {
                 chalkTrail[x][y] = 0;
                }
              } 
              go = true;
            }
            if (evt.isNoButtonPressed()) 
            {
              buttonpressed = "No button pressed!";
            }
            if (evt.isNoButtonPressed()) 
            {
              buttonpressed = "No button pressed!";
            }
            if (evt.isButtonHomePressed()) 
            {
              buttonpressed = "Home button pressed!";
            }
            if (evt.isButtonMinusPressed()) 
            {
              buttonpressed = "Minus button pressed!";
            }
            if (evt.isButtonPlusPressed()) 
            {
              buttonpressed = "Plus button pressed!";
            }
            if (evt.isButtonOnePressed()) 
            {
              buttonpressed = "1 button pressed!";
            }
            if (evt.isButtonTwoPressed()) 
            {
              buttonpressed = "2 button pressed!";
            }
            if (evt.isDPadDownPressed()) 
            {
              buttonpressed = "Down pressed!";
            }
            if (evt.isDPadLeftPressed()) 
            {
              buttonpressed = "Left pressed!";
              if(leds[0]==true)
              {
                leds[0] = false;
                leds[3] = true;
                mote.setPlayerLeds(leds);      
              }
              else if(leds[1]==true)
              {
                leds[1] = false;
                leds[0] = true;
                mote.setPlayerLeds(leds);      
              }
              else if(leds[2]==true)
              {
                leds[2] = false;
                leds[1] = true;
                mote.setPlayerLeds(leds);      
              }
              else if(leds[3]==true)
              {
                leds[3] = false;
                leds[2] = true;
                mote.setPlayerLeds(leds);      
              }   
            }
            if (evt.isDPadRightPressed()) 
            {
              buttonpressed = "Right pressed!";
              if(leds[0]==true)
              {
                leds[0] = false;
                leds[1] = true;
                mote.setPlayerLeds(leds);      
              }
              else if(leds[1]==true)
              {
                leds[1] = false;
                leds[2] = true;
                mote.setPlayerLeds(leds);      
              }
              else if(leds[2]==true)
              {
                leds[2] = false;
                leds[3] = true;
                mote.setPlayerLeds(leds);      
              }
              else if(leds[3]==true)
              {
                leds[3] = false;
                leds[0] = true;
                mote.setPlayerLeds(leds);      
              }   
            }
            if (evt.isDPadUpPressed()) 
            {
              buttonpressed = "Up pressed!";
            }
            if (evt.isNoButtonPressed()) 
            {
              buttonpressed = "No button pressed!";
            }
          }
        });
      }
    };
      
    MoteFinder finder = MoteFinder.getMoteFinder();
    finder.addMoteFinderListener(listener);
      
    System.out.println("Starting discovery..");
    finder.startDiscovery();
      
    System.out.println("Putting thread to sleep..");
    try
    {
      Thread.sleep(30000l);
    } catch (InterruptedException e)
    {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    
    System.out.println("Stopping discovery..");
    finder.stopDiscovery();
      
    for (Mote m : motes) {
        m.disconnect();
      }

    SimpleMoteFinder simpleMoteFinder = new SimpleMoteFinder();
    Mote mote = simpleMoteFinder.findMote();
   
    mote.rumble(1000l);*/
    
    
  }
  
  /*public void disconnected()
  {
      System.out.println("Remote disconnected... Please Wii again.");
      System.exit(0);
  }
  
  public void statusReported(WRStatusEvent evt)
  {
      System.out.println("Battery level: " + (double)evt.getBatteryLevel()/2+ "%");
      System.out.println("Continuous: " + evt.isContinuousEnabled());
      System.out.println("Remote continuous: " + remote.isContinuousEnabled());
  }
  
  public void IRInputReceived(WRIREvent evt)
  {
      for (IRLight light : evt.getIRLights())
      {
          if (light != null)
          {
            irX = light.getX();
            irY = light.getY();
              System.out.println("X: "+light.getX());
              System.out.println("Y: "+light.getY());
          }
      }
      
  }
  
  public void accelerationInputReceived(WRAccelerationEvent evt)
  {
      if (accelerometerSource)
      {
          lastX = accelX;
          lastY = accelY;
          lastZ = accelZ;
          
          accelX = (int)(evt.getXAcceleration()/5*300)+300;
          accelY = (int)(evt.getYAcceleration()/5*300)+300;
          accelZ = (int)(evt.getZAcceleration()/5*300)+300;
          
          t++;
          
          graph.repaint();
      }
      
      System.out.println("---Acceleration Data---");
      System.out.println("X: " + evt.getXAcceleration());
      System.out.println("Y: " + evt.getYAcceleration());
      System.out.println("Z: " + evt.getZAcceleration());
      
  }
  
  public void extensionInputReceived(WRExtensionEvent evt)
  {
      if (evt instanceof WRNunchukExtensionEvent)
      {
          WRNunchukExtensionEvent NEvt = (WRNunchukExtensionEvent)evt;
          
          if (!accelerometerSource)
          {
              WRAccelerationEvent AEvt = NEvt.getAcceleration();
              lastX = accelX;
              lastY = accelY;
              lastZ = accelZ;
              
              accelX = (int)(AEvt.getXAcceleration()/5*300)+300;
              accelY = (int)(AEvt.getYAcceleration()/5*300)+300;
              accelZ = (int)(AEvt.getZAcceleration()/5*300)+300;
              
              t++;
              
              graph.repaint();
          }
          
          if (NEvt.wasPressed(WRNunchukExtensionEvent.C))System.out.println("Jump...");
          if (NEvt.wasPressed(WRNunchukExtensionEvent.Z))System.out.println("And crouch.");
      }
      else if (evt instanceof WRClassicControllerExtensionEvent)
      {
          WRClassicControllerExtensionEvent CCEvt = (WRClassicControllerExtensionEvent)evt;
          if (CCEvt.wasPressed(WRClassicControllerExtensionEvent.A))
          {
            System.out.println("A!");
            chalkTrail[(int)(1024 - irX)][(int)irY] = 1;
            for (int x = 0; x < 60; x++)
            {
              for (int y = 0; y < 60; y++)
              {
                inputLetter[(int)(1024 - irX + x)][(int)irY + y] = 1;
              }
            }
          }
          if (CCEvt.wasPressed(WRClassicControllerExtensionEvent.B))System.out.println("B!");
          if (CCEvt.wasPressed(WRClassicControllerExtensionEvent.Y))System.out.println("Y!");
          if (CCEvt.wasPressed(WRClassicControllerExtensionEvent.X))System.out.println("X!");
          if (CCEvt.wasPressed(WRClassicControllerExtensionEvent.LEFT_Z))System.out.println("ZL!");
          if (CCEvt.wasPressed(WRClassicControllerExtensionEvent.RIGHT_Z))System.out.println("ZR!");
          if (CCEvt.wasPressed(WRClassicControllerExtensionEvent.LEFT_TRIGGER))System.out.println("TL!");
          if (CCEvt.wasPressed(WRClassicControllerExtensionEvent.RIGHT_TRIGGER))System.out.println("TR!");
          if (CCEvt.wasPressed(WRClassicControllerExtensionEvent.DPAD_LEFT))System.out.println("DL!");
          if (CCEvt.wasPressed(WRClassicControllerExtensionEvent.DPAD_RIGHT))System.out.println("DR!");
          if (CCEvt.wasPressed(WRClassicControllerExtensionEvent.DPAD_UP))System.out.println("DU!");
          if (CCEvt.wasPressed(WRClassicControllerExtensionEvent.DPAD_DOWN))System.out.println("DD!");
          if (CCEvt.wasPressed(WRClassicControllerExtensionEvent.PLUS))System.out.println("Plus!");
          if (CCEvt.wasPressed(WRClassicControllerExtensionEvent.MINUS))System.out.println("Minus!");
          if (CCEvt.isPressed(WRClassicControllerExtensionEvent.HOME))
          {
              System.out.println("L shoulder: " + CCEvt.getLeftTrigger());
              System.out.println("R shoulder: " + CCEvt.getRightTrigger());
          }
      }
      else if (evt instanceof WRGuitarExtensionEvent)
      {
          WRGuitarExtensionEvent GEvt = (WRGuitarExtensionEvent)evt;
          if (GEvt.wasPressed(WRGuitarExtensionEvent.MINUS))System.out.println("Minus!");
          if (GEvt.wasPressed(WRGuitarExtensionEvent.PLUS))System.out.println("Plus!");
          if (GEvt.wasPressed(WRGuitarExtensionEvent.STRUM_UP))System.out.println("Strum up!");
          if (GEvt.wasPressed(WRGuitarExtensionEvent.YELLOW))System.out.println("Yellow!");
          if (GEvt.wasPressed(WRGuitarExtensionEvent.GREEN))System.out.println("Green!");
          if (GEvt.wasPressed(WRGuitarExtensionEvent.BLUE))System.out.println("Blue!");
          if (GEvt.wasPressed(WRGuitarExtensionEvent.RED))System.out.println("Red!");
          if (GEvt.wasPressed(WRGuitarExtensionEvent.ORANGE))System.out.println("Orange!");
          if (GEvt.wasPressed(WRGuitarExtensionEvent.STRUM_DOWN))System.out.println("Strum down!");
          if (GEvt.wasPressed(WRGuitarExtensionEvent.GREEN+WRGuitarExtensionEvent.RED))
          {
              System.out.println("Whammy bar: " + GEvt.getWhammyBar());
              AnalogStickData AS = GEvt.getAnalogStickData();
              System.out.println("Analog- X: " + AS.getX() + " Y: " + AS.getY());
          }
      }
  }
  
  public void extensionConnected(WiiRemoteExtension extension)
  {
      System.out.println("Extension connected!");
      try
      {
          remote.setExtensionEnabled(true);
      }catch(Exception e){e.printStackTrace();}
  }
  
  public void extensionPartiallyInserted()
  {
      System.out.println("Extension partially inserted. Push it in more next time, jerk!");
  }
  
  public void extensionUnknown()
  {
      System.out.println("Extension unknown. Did you try to plug in a toaster or something?");
  }
  
  public void extensionDisconnected(WiiRemoteExtension extension)
  {
      System.out.println("Extension disconnected. Why'd you unplug it, retard?");
  }
  
  private void mouseCycle()
  {
      try
      {
          if (status == 0)
          {
              if (accelerometerStatus == 0)remote.setMouse(MotionAccelerometerMouse.getDefault());
              else if (accelerometerStatus == 1)remote.setMouse(TiltAccelerometerMouse.getDefault());
              else if (accelerometerStatus == 2)remote.setMouse(new MotionAccelerometerMouse(80, 60, AccelerometerMouse.NUNCHUK_EXTENSION, 0.06, 0.08));
              else if (accelerometerStatus == 3)remote.setMouse(new TiltAccelerometerMouse(10, 10, AccelerometerMouse.NUNCHUK_EXTENSION, 0.1, 0.1));
          }
          else if (status == 1)remote.setMouse(IRMouse.getDefault());
          else if (status == 2)remote.setMouse(IRAccelerometerMouse.getDefault());
          else if (status == 3)
          {
              if (analogStickStatus == 0)remote.setMouse(AbsoluteAnalogStickMouse.getDefault());
              else if (analogStickStatus == 1)remote.setMouse(RelativeAnalogStickMouse.getDefault());
              else if (analogStickStatus == 2)remote.setMouse(new AbsoluteAnalogStickMouse(1, 1, AnalogStickMouse.CLASSIC_CONTROLLER_LEFT));
              else if (analogStickStatus == 3)remote.setMouse(new RelativeAnalogStickMouse(10, 10, 0.05, 0.05, AnalogStickMouse.CLASSIC_CONTROLLER_LEFT));
              else if (analogStickStatus == 4)remote.setMouse(new AbsoluteAnalogStickMouse(1, 1, AnalogStickMouse.CLASSIC_CONTROLLER_RIGHT));
              else if (analogStickStatus == 5)remote.setMouse(new RelativeAnalogStickMouse(10, 10, 0.05, 0.05, AnalogStickMouse.CLASSIC_CONTROLLER_RIGHT));
          }
          mouseTestPanel.repaint();
      }
      catch(Exception e){e.printStackTrace();}
          
  }
  
  public void buttonInputReceived(WRButtonEvent evt)
  {
      
      if (evt.wasPressed(WRButtonEvent.TWO))System.out.println("2");
      if (evt.wasPressed(WRButtonEvent.ONE))System.out.println("1");
      if (evt.wasPressed(WRButtonEvent.B))System.out.println("B");
      if (evt.wasPressed(WRButtonEvent.A))
      {
        System.out.println("A");
        try
        {
          remote.vibrateFor(20);
        } catch (IOException e)
        {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }
      }
      if (evt.wasPressed(WRButtonEvent.MINUS))System.out.println("Minus");
      if (evt.wasPressed(WRButtonEvent.HOME))System.out.println("Home");
      if (evt.wasPressed(WRButtonEvent.LEFT))System.out.println("Left");
      if (evt.wasPressed(WRButtonEvent.RIGHT))System.out.println("Right");
      if (evt.wasPressed(WRButtonEvent.DOWN))System.out.println("Down");
      if (evt.wasPressed(WRButtonEvent.UP))System.out.println("Up");
      if (evt.wasPressed(WRButtonEvent.PLUS))System.out.println("Plus");
      
      
      try
      {
          /*if (evt.isPressed(WRButtonEvent.MINUS) && evt.wasPressed(WRButtonEvent.PLUS))
              System.out.println("Avg Tardiness: " + remote.totalTardiness/remote.reportsProcessed);*/
          
          /*if (evt.isPressed(WRButtonEvent.HOME))
          {
              boolean lightChanged = false;
              if (evt.wasPressed(WRButtonEvent.PLUS) && !mouseTestingOn)
              {
                  mouseTestingOn = true;
                  remote.getButtonMaps().add(new ButtonMouseMap(WRButtonEvent.B, java.awt.event.InputEvent.BUTTON1_MASK));
                  remote.getButtonMaps().add(new ButtonMouseMap(WRButtonEvent.A, java.awt.event.InputEvent.BUTTON3_MASK));
                  remote.getButtonMaps().add(new ButtonMouseWheelMap(WRButtonEvent.UP, -5, 100));
                  remote.getButtonMaps().add(new ButtonMouseWheelMap(WRButtonEvent.DOWN, 5, 100));
                  mouseTestFrame.setVisible(true);
                  mouseCycle();
              }
              else if (evt.wasPressed(WRButtonEvent.MINUS) && mouseTestingOn)
              {
                  mouseTestingOn = false;
                  remote.getButtonMaps().remove(new ButtonMouseMap(WRButtonEvent.B, java.awt.event.InputEvent.BUTTON1_MASK));
                  remote.getButtonMaps().remove(new ButtonMouseMap(WRButtonEvent.A, java.awt.event.InputEvent.BUTTON3_MASK));
                  remote.getButtonMaps().remove(new ButtonMouseWheelMap(WRButtonEvent.UP, -5, 100));
                  remote.getButtonMaps().remove(new ButtonMouseWheelMap(WRButtonEvent.DOWN, 5, 100));
                  mouseTestFrame.setVisible(false);
                  remote.setMouse(null);
              }
              else if (evt.wasPressed(WRButtonEvent.ONE))
              {
                  accelerometerSource = !accelerometerSource;
                  if (accelerometerSource)graphFrame.setTitle("Accelerometer graph: Wii Remote");
                  else graphFrame.setTitle("Accelerometer graph: Nunchuk");
              }
              else if (evt.wasPressed(WRButtonEvent.TWO)) //code for Wii Remote memory dump/comparison
              {
                  Thread thread = new Thread(new Runnable()
                  {
                      public void run()
                      {
                          try
                          {
                              File dataF = new File("data.dat");
                              byte dataO[] = null;
                              if (dataF.exists())
                              {
                                  dataO = new byte[0x0040];
                                  DataInputStream dataS = new DataInputStream(new FileInputStream(dataF));
                                  dataS.readFully(dataO);
                                  dataS.close();
                              }
                              
                              File data2F = new File("data2.dat");
                              byte data2O[] = null;
                              if (data2F.exists())
                              {
                                  data2O = new byte[0xFFFF];
                                  DataInputStream data2S = new DataInputStream(new FileInputStream(data2F));
                                  data2S.readFully(data2O);
                                  data2S.close();
                              }
                              
                              System.out.println("Searching address...");
                              //byte[] address = new byte[]{0x00, 0x17, (byte)0xAB};
                              //byte[] address = new byte[]{0x0F, 0x04, 0x00, 0x01, 0x01, 0x04};
                              
                       
                              byte[] data = remote.readData(new byte[]{0x00, 0x00, 0x00, 0x00}, 0x0040);
                              System.out.println("Read complete (data)");
                              if (!dataF.exists())
                              {
                                  DataOutputStream dataOS = new DataOutputStream(new FileOutputStream(dataF));
                                  dataOS.write(data, 0, data.length);
                                  dataOS.close();
                              }
                              else
                              {
                                  System.out.println("Comparing arrs (data)");
                                  for (int c = 0; c < data.length; c++)
                                  {
                                      //System.out.println("0x" + Integer.toHexString(data[c]) + " : 0x" + Integer.toHexString(dataO[c]));
                                      if (data[c] != dataO[c])System.out.println("Flash: 0x" + Integer.toHexString(c));
                                  }
                                  System.out.println("Comparing complete");
                              }
                             
                              
                              
                             
                              byte[] data2 = remote.readData(new byte[]{0x04, (byte)0xA2, 0x00, 0x00}, 65535);
                              System.out.println("Read complete (data2)");
                              if (!data2F.exists())
                              {
                                  DataOutputStream data2OS = new DataOutputStream(new FileOutputStream(data2F));
                                  data2OS.write(data2, 0, data2.length);
                                  data2OS.close();
                              }
                              else
                              {
                                  System.out.println("Comparing arrs (data2)");
                                  for (int c = 0; c < data2.length; c++)
                                  {
                                      System.out.println("0x" + Integer.toHexString(data2[c]) + " : 0x" + Integer.toHexString(data2O[c]));
                                      if (data2[c] != data2O[c])System.out.println("Register: 0x" + Integer.toHexString(c + 0x04A20000));
                                  }
                                  System.out.println("Comparing complete");
                              }
                             
                              
                              System.out.println("Search complete.");
                          }
                          catch (Exception e){e.printStackTrace();}
                      }
                  });
                  thread.start();
              }
              else if (mouseTestingOn)
              {
                  boolean change = false;
                  if (evt.wasPressed(WRButtonEvent.HOME+WRButtonEvent.RIGHT))
                  {
                      status = (status+1)%4;
                      change = true;
                  }
                  else if (evt.wasPressed(WRButtonEvent.HOME+WRButtonEvent.LEFT))
                  {
                      status = (status+3)%4;
                      change = true;
                  }
                  
                  if (status == 0)
                  {
                      if (evt.wasPressed(WRButtonEvent.DOWN))
                      {
                          accelerometerStatus = (accelerometerStatus+1)%4;
                          change = true;
                      }
                      else if (evt.wasPressed(WRButtonEvent.UP))
                      {
                          accelerometerStatus = (accelerometerStatus+3)%4;
                          change = true;
                      }
                  }
                  else if (status == 3)
                  {
                      if (evt.wasPressed(WRButtonEvent.DOWN))
                      {
                          analogStickStatus = (analogStickStatus+1)%6;
                          change = true;
                      }
                      else if (evt.wasPressed(WRButtonEvent.UP))
                      {
                          analogStickStatus = (analogStickStatus+5)%6;
                          change = true;
                      }
                  }
                  
                  if (change)mouseCycle();
              }
          }
          else if (evt.wasPressed(WRButtonEvent.TWO))
          {
              remote.requestStatus();
              if (remote.isPlayingSound())remote.stopSound();
          }
          else if (evt.wasPressed(WRButtonEvent.ONE))
          {
              if (prebuf != null)remote.playPrebufferedSound(prebuf, WiiRemote.SF_PCM8S);
          }
          else if (evt.wasPressed(WRButtonEvent.PLUS))
          {
              if (remote.isSpeakerEnabled())
              {
                  double volume = (remote.getSpeakerVolume()*20+1)/20;
                  if (volume <= 1)remote.setSpeakerVolume(volume);
                  System.out.println("Volume: " + remote.getSpeakerVolume());
              }
          }
          else if (evt.wasPressed(WRButtonEvent.MINUS))
          {
              if (remote.isSpeakerEnabled())
              {
                  double volume = (remote.getSpeakerVolume()*20-1)/20;
                  if (volume >= 0)remote.setSpeakerVolume(volume);
                  System.out.println("Volume: " + remote.getSpeakerVolume());
              }
          }
      }
      catch(Exception e){e.printStackTrace();}
  }*/
  
  public int getID()
  {
    return 1;
  }
}