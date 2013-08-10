package aplusmain;

import java.awt.Point;
import java.util.ArrayList;

public class C extends Letter
{
  private static ArrayList<Point> upperPath = new ArrayList<Point> ();
  private static ArrayList<Point> lowerPath = new ArrayList<Point> ();
  
  private static String dataPathsUpper = "resources/images/CDataCap.png";
  private static String dataPathsLower= "resources/images/cData.png";
  
  private static String imagePathsUpper= "resources/images/CCapClear.png";
  private static String imagePathsLower= "resources/images/cClear.png";
  
  //Need C guides
  private static String guidePathsUpper[]= {"resources/images/C_1.png"};
  private static String guidePathsLower[]= {"resources/images/c__1.png"};
  
  private static int guideCountsUpper = 1;
  private static int guideCountsLower = 1;
  
  private static ArrayList<Point> guideLocationsUpper = new ArrayList<Point>();
  private static ArrayList<Point> guideLocationsLower = new ArrayList<Point>();
  
  private static Point startingLocationUpper = new Point(7, 2);
  private static Point startingLocationLower = new Point(6, 6);
  
  public C()
  {
    guideLocationsUpper.add(new Point(410, 170));
    
    guideLocationsLower.add(new Point(370, 405));
    
    //getUpperPath().add(new Point(8,3));
    getUpperPath().add(new Point(8,2));
    getUpperPath().add(new Point(7,1));
    getUpperPath().add(new Point(6,0));
    getUpperPath().add(new Point(5,0));
    getUpperPath().add(new Point(4,0));
    getUpperPath().add(new Point(3,0));
    getUpperPath().add(new Point(2,1));
    getUpperPath().add(new Point(1,2));
    getUpperPath().add(new Point(1,3));
    getUpperPath().add(new Point(0,4));
    getUpperPath().add(new Point(0,5));
    getUpperPath().add(new Point(0,6));
    getUpperPath().add(new Point(0,7));
    getUpperPath().add(new Point(0,8));
    getUpperPath().add(new Point(0,9));
    getUpperPath().add(new Point(1,10));
    getUpperPath().add(new Point(2,11));
    getUpperPath().add(new Point(3,12));
    getUpperPath().add(new Point(4,12));
    getUpperPath().add(new Point(5,12));
    getUpperPath().add(new Point(6,12));
    getUpperPath().add(new Point(7,11));
    getUpperPath().add(new Point(8,10));
    getUpperPath().add(new Point(8,9));
    
    //getLowerPath().add(new Point(6,7));
    getLowerPath().add(new Point(5,6));
    getLowerPath().add(new Point(4,6));
    getLowerPath().add(new Point(3,6));
    getLowerPath().add(new Point(2,6));
    getLowerPath().add(new Point(1,7));
    getLowerPath().add(new Point(0,8));
    getLowerPath().add(new Point(0,9));
    getLowerPath().add(new Point(0,10));
    getLowerPath().add(new Point(1,11));
    getLowerPath().add(new Point(3,12));
    getLowerPath().add(new Point(4,12));
    getLowerPath().add(new Point(5,12));
    getLowerPath().add(new Point(6,11));
  }

  public ArrayList<Point> getUpperPath()
  {
    return upperPath;
  }
  
  public void setUpperPath(ArrayList<Point> upperPath)
  {
    C.upperPath = upperPath;
  }
  
  public ArrayList<Point> getLowerPath()
  {
    return lowerPath;
  }

  public void setLowerPath(ArrayList<Point> LowerPath)
  {
    C.lowerPath = LowerPath;
  }

  public Point getStartingLocation()
  {
    if (Play.upperLower==1) return startingLocationLower;
    else return startingLocationUpper; 
  }

  public void setStartingLocation(Point startingLocation)
  {
    if (Play.upperLower==1) C.startingLocationLower = startingLocation;
    else C.startingLocationUpper = startingLocation;
  }
  
  public int getGuideCountsUpper()
  {
    return guideCountsUpper;
  }
  
  public void setGuideCountsUpper(int guideCountsUpper)
  {
    C.guideCountsUpper = guideCountsUpper;
  }
  
  public int getGuideCountsLower()
  {
    return guideCountsLower;
  }
  
  public void setGuideCountsLower(int guideCountsLower)
  {
    C.guideCountsLower = guideCountsLower;
  }
  
  public String[] getGuidePathsLower()
  {
    return guidePathsLower;
  }
  
  public void setGuidePathsLower(String[] guidePathsLower)
  {
    C.guidePathsLower = guidePathsLower;
  }
  
  public String[] getGuidePathsUpper()
  {
    return guidePathsUpper;
  }
  
  public void setGuidePathsUpper(String[] guidePathsUpper)
  {
    C.guidePathsUpper = guidePathsUpper;
  }
  
  public String getDataPathsLower()
  {
    return dataPathsLower;
  }
  
  public void setDataPathsLower(String dataPathsLower)
  {
    C.dataPathsLower = dataPathsLower;
  }
  
  public String getDataPathsUpper()
  {
    return dataPathsUpper;
  }
  
  public void setDataPathsUpper(String dataPathsUpper)
  {
    C.dataPathsUpper = dataPathsUpper;
  }
  
  
  public String getImagePathsLower()
  {
    return imagePathsLower;
  }
  
  public void setImagePathsLower(String imagePathsLower)
  {
    C.imagePathsLower = imagePathsLower;
  }
  
  public String getImagePathsUpper()
  {
    return imagePathsUpper;
  }
  
  public void setImagePathsUpper(String imagePathsUpper)
  {
    C.imagePathsUpper = imagePathsUpper;
  }
  
  public ArrayList<Point> getGuideLocationsLower()
  {
    return guideLocationsLower;
  }
  
  public void setGuideLocationsLower(ArrayList<Point> guideLocationsLower)
  {
    C.guideLocationsLower = guideLocationsLower;
  }
  
  public ArrayList<Point> getGuideLocationsUpper()
  {
    return guideLocationsUpper;
  }
  
  public void setGuideLocationsUpper(ArrayList<Point> guideLocationsUpper)
  {
    C.guideLocationsUpper = guideLocationsUpper;
  }
  
  /*public static void main(String[] args)
  {
    A letterA = new A();
    System.out.println(A.upperPath);
    Point a = upperPath.pop();
    System.out.println("X = " + a.x + ", Y = " + a.y);
    
  }*/

}
