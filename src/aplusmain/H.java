package aplusmain;

import java.awt.Point;
import java.util.ArrayList;

public class H extends Letter
{
  private static ArrayList<Point> upperPath = new ArrayList<Point> ();
  private static ArrayList<Point> lowerPath = new ArrayList<Point> ();
  
  private static String dataPathsUpper = "resources/images/HDataCap.png";
  private static String dataPathsLower= "resources/images/hData.png";
  
  private static String imagePathsUpper= "resources/images/HCapClear.png";
  private static String imagePathsLower= "resources/images/hClear.png";
  
  //Need C guides
  private static String guidePathsUpper[]= {"resources/images/H_1.png", "resources/images/H_2.png", "resources/images/H_3.png"};
  private static String guidePathsLower[]= {"resources/images/h__1.png", "resources/images/h__2.png"};
  
  private static int guideCountsUpper = 3;
  private static int guideCountsLower = 2;
  
  private static ArrayList<Point> guideLocationsUpper = new ArrayList<Point>();
  private static ArrayList<Point> guideLocationsLower = new ArrayList<Point>();
  
  private static Point startingLocationUpper = new Point(0, 0);
  private static Point startingLocationLower = new Point(0, 2);
  
  
  public H()
  {
    guideLocationsUpper.add(new Point(185, 70));
    guideLocationsUpper.add(new Point(730, 60));
    guideLocationsUpper.add(new Point(430, 400));
    
    guideLocationsLower.add(new Point(195, 105));
    guideLocationsLower.add(new Point(375, 250));
    
    //H part 1
    getUpperPath().add(new Point(0,0));
    getUpperPath().add(new Point(0,1));
    getUpperPath().add(new Point(0,2));
    getUpperPath().add(new Point(0,3));
    getUpperPath().add(new Point(0,4));
    getUpperPath().add(new Point(0,5));
    getUpperPath().add(new Point(0,6));
    getUpperPath().add(new Point(0,7));
    getUpperPath().add(new Point(0,8));
    getUpperPath().add(new Point(0,9));
    getUpperPath().add(new Point(0,10));
    getUpperPath().add(new Point(0,11));
    //getUpperPath().add(new Point(0,12));
    
    //H part 2
    getUpperPath().add(new Point(7,0));
    getUpperPath().add(new Point(7,1));
    getUpperPath().add(new Point(7,2));
    getUpperPath().add(new Point(7,3));
    getUpperPath().add(new Point(7,4));
    getUpperPath().add(new Point(7,5));
    getUpperPath().add(new Point(7,6));
    getUpperPath().add(new Point(7,7));
    getUpperPath().add(new Point(7,8));
    getUpperPath().add(new Point(7,9));
    getUpperPath().add(new Point(7,10));
    getUpperPath().add(new Point(7,11));
    getUpperPath().add(new Point(7,12));
    
    //H part 3
    getUpperPath().add(new Point(0,6));
    getUpperPath().add(new Point(1,6));
    getUpperPath().add(new Point(2,6));
    getUpperPath().add(new Point(3,6));
    getUpperPath().add(new Point(4,6));
    getUpperPath().add(new Point(5,6));
    getUpperPath().add(new Point(6,6));
    getUpperPath().add(new Point(7,6));
    
    //h part 1
    getLowerPath().add(new Point(0,2));
    getLowerPath().add(new Point(0,3));
    getLowerPath().add(new Point(0,4));
    getLowerPath().add(new Point(0,5));
    getLowerPath().add(new Point(0,6));
    getLowerPath().add(new Point(0,7));
    getLowerPath().add(new Point(0,8));
    getLowerPath().add(new Point(0,9));
    getLowerPath().add(new Point(0,10));
    getLowerPath().add(new Point(0,11));
    getLowerPath().add(new Point(0,12));
    
    //h part 2
    getLowerPath().add(new Point(1,8));
    getLowerPath().add(new Point(1,7));
    getLowerPath().add(new Point(2,6));
    getLowerPath().add(new Point(3,6));
    getLowerPath().add(new Point(4,6));
    getLowerPath().add(new Point(5,7));
    getLowerPath().add(new Point(5,8));
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
    H.upperPath = upperPath;
  }
  
  public ArrayList<Point> getLowerPath()
  {
    return lowerPath;
  }

  public void setLowerPath(ArrayList<Point> LowerPath)
  {
    H.lowerPath = LowerPath;
  }

  public Point getStartingLocation()
  {
    if (Play.upperLower==1) return startingLocationLower;
    else return startingLocationUpper; 
  }

  public void setStartingLocation(Point startingLocation)
  {
    if (Play.upperLower==1) H.startingLocationLower = startingLocation;
    else H.startingLocationUpper = startingLocation;
  }
  
  public int getGuideCountsUpper()
  {
    return guideCountsUpper;
  }
  
  public void setGuideCountsUpper(int guideCountsUpper)
  {
    H.guideCountsUpper = guideCountsUpper;
  }
  
  public int getGuideCountsLower()
  {
    return guideCountsLower;
  }
  
  public void setGuideCountsLower(int guideCountsLower)
  {
    H.guideCountsLower = guideCountsLower;
  }
  
  public String[] getGuidePathsLower()
  {
    return guidePathsLower;
  }
  
  public void setGuidePathsLower(String[] guidePathsLower)
  {
    H.guidePathsLower = guidePathsLower;
  }
  
  public String[] getGuidePathsUpper()
  {
    return guidePathsUpper;
  }
  
  public void setGuidePathsUpper(String[] guidePathsUpper)
  {
    H.guidePathsUpper = guidePathsUpper;
  }
  
  public String getDataPathsLower()
  {
    return dataPathsLower;
  }
  
  public void setDataPathsLower(String dataPathsLower)
  {
    H.dataPathsLower = dataPathsLower;
  }
  
  public String getDataPathsUpper()
  {
    return dataPathsUpper;
  }
  
  public void setDataPathsUpper(String dataPathsUpper)
  {
    H.dataPathsUpper = dataPathsUpper;
  }
  
  
  public String getImagePathsLower()
  {
    return imagePathsLower;
  }
  
  public void setImagePathsLower(String imagePathsLower)
  {
    H.imagePathsLower = imagePathsLower;
  }
  
  public String getImagePathsUpper()
  {
    return imagePathsUpper;
  }
  
  public void setImagePathsUpper(String imagePathsUpper)
  {
    H.imagePathsUpper = imagePathsUpper;
  }
  
  public ArrayList<Point> getGuideLocationsLower()
  {
    return guideLocationsLower;
  }
  
  public void setGuideLocationsLower(ArrayList<Point> guideLocationsLower)
  {
    H.guideLocationsLower = guideLocationsLower;
  }
  
  public ArrayList<Point> getGuideLocationsUpper()
  {
    return guideLocationsUpper;
  }
  
  public void setGuideLocationsUpper(ArrayList<Point> guideLocationsUpper)
  {
    H.guideLocationsUpper = guideLocationsUpper;
  }
  
  /*public static void main(String[] args)
  {
    A letterA = new A();
    System.out.println(A.upperPath);
    Point a = upperPath.pop();
    System.out.println("X = " + a.x + ", Y = " + a.y);
    
  }*/

}