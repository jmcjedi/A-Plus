package aplusmain;

import java.awt.Point;
import java.util.ArrayList;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class A extends Letter
{
  private static ArrayList<Point> upperPath = new ArrayList<Point> ();
  private static ArrayList<Point> lowerPath = new ArrayList<Point> ();
  
  private static String dataPathsUpper = "resources/images/ADataCap.png";
  private static String dataPathsLower= "resources/images/aData.png";
  
  private static String imagePathsUpper= "resources/images/ACapClear.png";
  private static String imagePathsLower= "resources/images/aClear.png";
  
  private static String guidePathsUpper[]= {"resources/images/A_1.png", "resources/images/A_2.png", "resources/images/A_3.png"};
  private static String guidePathsLower[]= {"resources/images/a__1.png", "resources/images/a__2.png"};
  
  private static int guideCountsUpper = 3;
  private static int guideCountsLower = 2;
  
  private static ArrayList<Point> guideLocationsUpper = new ArrayList<Point>();
  private static ArrayList<Point> guideLocationsLower = new ArrayList<Point>();
  
  private static Point startingLocationUpper = new Point(3, 0);
  private static Point startingLocationLower = new Point(6, 6);
  
  public A()
  {
    guideLocationsUpper.add(new Point(275, 85));
    guideLocationsUpper.add(new Point(575,100));
    guideLocationsUpper.add(new Point(420, 480));
    
    guideLocationsLower.add(new Point(230,225));
    guideLocationsLower.add(new Point(670,350));
    
    getUpperPath().add(new Point(3,0));
    getUpperPath().add(new Point(3,1));
    getUpperPath().add(new Point(3,2));
    getUpperPath().add(new Point(3,3));
    getUpperPath().add(new Point(2,4));
    getUpperPath().add(new Point(2,5));
    getUpperPath().add(new Point(2,6));
    getUpperPath().add(new Point(2,7));
    getUpperPath().add(new Point(1,8));
    getUpperPath().add(new Point(1,9));
    getUpperPath().add(new Point(1,10));
    getUpperPath().add(new Point(0,11));
    //getUpperPath().add(new Point(0,12));
    

    getUpperPath().add(new Point(4,1));
    getUpperPath().add(new Point(4,2));
    getUpperPath().add(new Point(4,3));
    getUpperPath().add(new Point(5,4));
    getUpperPath().add(new Point(5,5));
    getUpperPath().add(new Point(5,6));
    getUpperPath().add(new Point(5,7));
    getUpperPath().add(new Point(6,8));
    getUpperPath().add(new Point(6,9));
    getUpperPath().add(new Point(7,10));
    getUpperPath().add(new Point(7,11));
    //getUpperPath().add(new Point(8,12));
    
    getUpperPath().add(new Point(2,7));
    getUpperPath().add(new Point(3,7));
    getUpperPath().add(new Point(4,7));
    getUpperPath().add(new Point(5,7));

    //add Lower path
    getLowerPath().add(new Point(5,7));
    getLowerPath().add(new Point(4,6));
    getLowerPath().add(new Point(3,6));
    getLowerPath().add(new Point(2,6));
    getLowerPath().add(new Point(1,7));
    getLowerPath().add(new Point(0,8));
    getLowerPath().add(new Point(0,9));
    getLowerPath().add(new Point(0,10));
    getLowerPath().add(new Point(1,11));
    getLowerPath().add(new Point(2,12));
    getLowerPath().add(new Point(3,12));
    getLowerPath().add(new Point(4,12));
    getLowerPath().add(new Point(5,11));
    
    getLowerPath().add(new Point(6,6));
    getLowerPath().add(new Point(6,7));
    getLowerPath().add(new Point(6,8));
    getLowerPath().add(new Point(6,9));
    getLowerPath().add(new Point(6,10));
    getLowerPath().add(new Point(6,11));
    getLowerPath().add(new Point(6,12));
  }

  public ArrayList<Point> getUpperPath()
  {
    return upperPath;
  }

  public void setUpperPath(ArrayList<Point> upperPath)
  {
    A.upperPath = upperPath;
  }
  
  public ArrayList<Point> getLowerPath()
  {
    return lowerPath;
  }

  public void setLowerPath(ArrayList<Point> lowerPath)
  {
    A.lowerPath = lowerPath;
  }

  public Point getStartingLocation()
  {
    if (Play.upperLower==1) return startingLocationLower;
    else return startingLocationUpper; 
  }
  
  public void setStartingLocation(Point startingLocation)
  {
    if (Play.upperLower==1) A.startingLocationLower = startingLocation;
    else A.startingLocationUpper = startingLocation;
  }
  
  public int getGuideCountsUpper()
  {
    return guideCountsUpper;
  }
  
  public void setGuideCountsUpper(int guideCountsUpper)
  {
    A.guideCountsUpper = guideCountsUpper;
  }
  
  public int getGuideCountsLower()
  {
    return guideCountsLower;
  }
  
  public void setGuideCountsLower(int guideCountsLower)
  {
    A.guideCountsLower = guideCountsLower;
  }
  
  public String[] getGuidePathsLower()
  {
    return guidePathsLower;
  }
  
  public void setGuidePathsLower(String[] guidePathsLower)
  {
    A.guidePathsLower = guidePathsLower;
  }
  
  public String[] getGuidePathsUpper()
  {
    return guidePathsUpper;
  }
  
  public void setGuidePathsUpper(String[] guidePathsUpper)
  {
    A.guidePathsUpper = guidePathsUpper;
  }
  
  public String getDataPathsLower()
  {
    return dataPathsLower;
  }
  
  public void setDataPathsLower(String dataPathsLower)
  {
    A.dataPathsLower = dataPathsLower;
  }
  
  public String getDataPathsUpper()
  {
    return dataPathsUpper;
  }
  
  public void setDataPathsUpper(String dataPathsUpper)
  {
    A.dataPathsUpper = dataPathsUpper;
  }
  
  
  public String getImagePathsLower()
  {
    return imagePathsLower;
  }
  
  public void setImagePathsLower(String imagePathsLower)
  {
    A.imagePathsLower = imagePathsLower;
  }
  
  public String getImagePathsUpper()
  {
    return imagePathsUpper;
  }
  
  public void setImagePathsUpper(String imagePathsUpper)
  {
    A.imagePathsUpper = imagePathsUpper;
  }
  
  public ArrayList<Point> getGuideLocationsLower()
  {
    return guideLocationsLower;
  }
  
  public void setGuideLocationsLower(ArrayList<Point> guideLocationsLower)
  {
    A.guideLocationsLower = guideLocationsLower;
  }
  
  public ArrayList<Point> getGuideLocationsUpper()
  {
    return guideLocationsUpper;
  }
  
  public void setGuideLocationsUpper(ArrayList<Point> guideLocationsUpper)
  {
    A.guideLocationsUpper = guideLocationsUpper;
  }
  
  /*public static void main(String[] args)
  {
    A letterA = new A();
    System.out.println(A.upperPath);
    Point a = upperPath.pop();
    System.out.println("X = " + a.x + ", Y = " + a.y);
    
  }*/

}
