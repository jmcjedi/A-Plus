package aplusmain;

import java.awt.Point;
import java.util.ArrayList;

public class F extends Letter
{
  private static ArrayList<Point> upperPath = new ArrayList<Point> ();
  private static ArrayList<Point> lowerPath = new ArrayList<Point> ();
  
  private static String dataPathsUpper = "resources/images/FDataCap.png";
  private static String dataPathsLower= "resources/images/fData.png";
  
  private static String imagePathsUpper= "resources/images/FCapClear.png";
  private static String imagePathsLower= "resources/images/fClear.png";
  
  //Need C guides
  private static String guidePathsUpper[]= {"resources/images/F_1.png", "resources/images/F_2.png", "resources/images/F_3.png"};
  private static String guidePathsLower[]= {"resources/images/f__1.png", "resources/images/f__2.png"};
  
  private static int guideCountsUpper = 3;
  private static int guideCountsLower = 2;
  
  private static ArrayList<Point> guideLocationsUpper = new ArrayList<Point>();
  private static ArrayList<Point> guideLocationsLower = new ArrayList<Point>();
  
  private static Point startingLocationUpper = new Point(0, 0);
  private static Point startingLocationLower = new Point(6, 2);
  
  public F()
  {
    guideLocationsUpper.add(new Point(210, 70));
    guideLocationsUpper.add(new Point(365, 130));
    guideLocationsUpper.add(new Point(365, 410));
    
    guideLocationsLower.add(new Point(380, 70));
    guideLocationsLower.add(new Point(245, 395));
    
    //F part 1
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
    getUpperPath().add(new Point(0,12));
    
    //F part 2
    getUpperPath().add(new Point(0,0));
    getUpperPath().add(new Point(1,0));
    getUpperPath().add(new Point(2,0));
    getUpperPath().add(new Point(3,0));
    getUpperPath().add(new Point(4,0));
    getUpperPath().add(new Point(5,0));
    getUpperPath().add(new Point(6,0));
    getUpperPath().add(new Point(7,0));
    
    //F part 3
    getUpperPath().add(new Point(0,6));
    getUpperPath().add(new Point(1,6));
    getUpperPath().add(new Point(2,6));
    getUpperPath().add(new Point(3,6));
    getUpperPath().add(new Point(4,6));
    getUpperPath().add(new Point(5,6));
    getUpperPath().add(new Point(6,6));
    
    //f part 1
    getLowerPath().add(new Point(6,3));
    getLowerPath().add(new Point(5,2));
    getLowerPath().add(new Point(4,2));
    getLowerPath().add(new Point(3,3));
    getLowerPath().add(new Point(3,4));
    getLowerPath().add(new Point(3,5));
    getLowerPath().add(new Point(3,6));
    getLowerPath().add(new Point(3,7));
    getLowerPath().add(new Point(3,8));
    getLowerPath().add(new Point(3,9));
    getLowerPath().add(new Point(3,10));
    getLowerPath().add(new Point(3,11));
    getLowerPath().add(new Point(3,12));
    
    //f part 2
    getLowerPath().add(new Point(1,6));
    getLowerPath().add(new Point(2,6));
    getLowerPath().add(new Point(3,6));
    getLowerPath().add(new Point(4,6));
    getLowerPath().add(new Point(5,6));
    
  }

  public ArrayList<Point> getUpperPath()
  {
    return upperPath;
  }
  
  public void setUpperPath(ArrayList<Point> upperPath)
  {
    F.upperPath = upperPath;
  }
  
  public ArrayList<Point> getLowerPath()
  {
    return lowerPath;
  }

  public void setLowerPath(ArrayList<Point> LowerPath)
  {
    F.lowerPath = LowerPath;
  }

  public Point getStartingLocation()
  {
    if (Play.upperLower==1) return startingLocationLower;
    else return startingLocationUpper; 
  }

  public void setStartingLocation(Point startingLocation)
  {
    if (Play.upperLower==1) F.startingLocationLower = startingLocation;
    else F.startingLocationUpper = startingLocation;
  }
  
  public int getGuideCountsUpper()
  {
    return guideCountsUpper;
  }
  
  public void setGuideCountsUpper(int guideCountsUpper)
  {
    F.guideCountsUpper = guideCountsUpper;
  }
  
  public int getGuideCountsLower()
  {
    return guideCountsLower;
  }
  
  public void setGuideCountsLower(int guideCountsLower)
  {
    F.guideCountsLower = guideCountsLower;
  }
  
  public String[] getGuidePathsLower()
  {
    return guidePathsLower;
  }
  
  public void setGuidePathsLower(String[] guidePathsLower)
  {
    F.guidePathsLower = guidePathsLower;
  }
  
  public String[] getGuidePathsUpper()
  {
    return guidePathsUpper;
  }
  
  public void setGuidePathsUpper(String[] guidePathsUpper)
  {
    F.guidePathsUpper = guidePathsUpper;
  }
  
  public String getDataPathsLower()
  {
    return dataPathsLower;
  }
  
  public void setDataPathsLower(String dataPathsLower)
  {
    F.dataPathsLower = dataPathsLower;
  }
  
  public String getDataPathsUpper()
  {
    return dataPathsUpper;
  }
  
  public void setDataPathsUpper(String dataPathsUpper)
  {
    F.dataPathsUpper = dataPathsUpper;
  }
  
  
  public String getImagePathsLower()
  {
    return imagePathsLower;
  }
  
  public void setImagePathsLower(String imagePathsLower)
  {
    F.imagePathsLower = imagePathsLower;
  }
  
  public String getImagePathsUpper()
  {
    return imagePathsUpper;
  }
  
  public void setImagePathsUpper(String imagePathsUpper)
  {
    F.imagePathsUpper = imagePathsUpper;
  }
  
  public ArrayList<Point> getGuideLocationsLower()
  {
    return guideLocationsLower;
  }
  
  public void setGuideLocationsLower(ArrayList<Point> guideLocationsLower)
  {
    F.guideLocationsLower = guideLocationsLower;
  }
  
  public ArrayList<Point> getGuideLocationsUpper()
  {
    return guideLocationsUpper;
  }
  
  public void setGuideLocationsUpper(ArrayList<Point> guideLocationsUpper)
  {
    F.guideLocationsUpper = guideLocationsUpper;
  }
  
  /*public static void main(String[] args)
  {
    A letterA = new A();
    System.out.println(A.upperPath);
    Point a = upperPath.pop();
    System.out.println("X = " + a.x + ", Y = " + a.y);
    
  }*/

}