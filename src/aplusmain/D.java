package aplusmain;

import java.awt.Point;
import java.util.ArrayList;

public class D extends Letter
{
  private static ArrayList<Point> upperPath = new ArrayList<Point> ();
  private static ArrayList<Point> lowerPath = new ArrayList<Point> ();
  
  private static String dataPathsUpper = "resources/images/DDataCap.png";
  private static String dataPathsLower= "resources/images/dData.png";
  
  private static String imagePathsUpper= "resources/images/DCapClear.png";
  private static String imagePathsLower= "resources/images/dClear.png";
  
  //Need C guides
  private static String guidePathsUpper[]= {"resources/images/D_1.png", "resources/images/D_2.png"};
  private static String guidePathsLower[]= {"resources/images/d__1.png", "resources/images/d__2.png"};
  
  private static int guideCountsUpper = 2;
  private static int guideCountsLower = 2;
  
  private static ArrayList<Point> guideLocationsUpper = new ArrayList<Point>();
  private static ArrayList<Point> guideLocationsLower = new ArrayList<Point>();
  
  private static Point startingLocationUpper = new Point(0, 0);
  private static Point startingLocationLower = new Point(6, 2);
  
  public D()
  {
    guideLocationsUpper.add(new Point(210, 70));
    guideLocationsUpper.add(new Point(365, 145));
    
    guideLocationsLower.add(new Point(670, 130));
    guideLocationsLower.add(new Point(350, 415));
    
    //D part 1
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
    
    //D part 2
    getUpperPath().add(new Point(0,0));
    getUpperPath().add(new Point(1,0));
    getUpperPath().add(new Point(2,0));
    getUpperPath().add(new Point(3,0));
    getUpperPath().add(new Point(4,0));
    getUpperPath().add(new Point(5,1));
    getUpperPath().add(new Point(6,2));
    getUpperPath().add(new Point(7,3));
    getUpperPath().add(new Point(7,4));
    getUpperPath().add(new Point(8,5));
    getUpperPath().add(new Point(8,6));
    getUpperPath().add(new Point(8,7));
    getUpperPath().add(new Point(8,8));
    getUpperPath().add(new Point(8,8));
    getUpperPath().add(new Point(7,9));
    getUpperPath().add(new Point(7,10));
    getUpperPath().add(new Point(6,11));
    getUpperPath().add(new Point(5,12));
    getUpperPath().add(new Point(4,12));
    getUpperPath().add(new Point(3,12));
    getUpperPath().add(new Point(2,12));
    getUpperPath().add(new Point(1,12));
    getUpperPath().add(new Point(0,12));
    
    //d part 1
    getLowerPath().add(new Point(6,2));
    getLowerPath().add(new Point(6,3));
    getLowerPath().add(new Point(6,4));
    getLowerPath().add(new Point(6,5));
    getLowerPath().add(new Point(6,6));
    getLowerPath().add(new Point(6,7));
    getLowerPath().add(new Point(6,8));
    getLowerPath().add(new Point(6,9));
    getLowerPath().add(new Point(6,10));
    getLowerPath().add(new Point(6,11));
    getLowerPath().add(new Point(6,12));
    
    //d part 2
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
  }

  public ArrayList<Point> getUpperPath()
  {
    return upperPath;
  }
  
  public void setUpperPath(ArrayList<Point> upperPath)
  {
    D.upperPath = upperPath;
  }
  
  public ArrayList<Point> getLowerPath()
  {
    return lowerPath;
  }

  public void setLowerPath(ArrayList<Point> LowerPath)
  {
    D.lowerPath = LowerPath;
  }

  public Point getStartingLocation()
  {
    if (Play.upperLower==1) return startingLocationLower;
    else return startingLocationUpper; 
  }

  public void setStartingLocation(Point startingLocation)
  {
    if (Play.upperLower==1) D.startingLocationLower = startingLocation;
    else D.startingLocationUpper = startingLocation;
  }
  
  public int getGuideCountsUpper()
  {
    return guideCountsUpper;
  }
  
  public void setGuideCountsUpper(int guideCountsUpper)
  {
    D.guideCountsUpper = guideCountsUpper;
  }
  
  public int getGuideCountsLower()
  {
    return guideCountsLower;
  }
  
  public void setGuideCountsLower(int guideCountsLower)
  {
    D.guideCountsLower = guideCountsLower;
  }
  
  public String[] getGuidePathsLower()
  {
    return guidePathsLower;
  }
  
  public void setGuidePathsLower(String[] guidePathsLower)
  {
    D.guidePathsLower = guidePathsLower;
  }
  
  public String[] getGuidePathsUpper()
  {
    return guidePathsUpper;
  }
  
  public void setGuidePathsUpper(String[] guidePathsUpper)
  {
    D.guidePathsUpper = guidePathsUpper;
  }
  
  public String getDataPathsLower()
  {
    return dataPathsLower;
  }
  
  public void setDataPathsLower(String dataPathsLower)
  {
    D.dataPathsLower = dataPathsLower;
  }
  
  public String getDataPathsUpper()
  {
    return dataPathsUpper;
  }
  
  public void setDataPathsUpper(String dataPathsUpper)
  {
    D.dataPathsUpper = dataPathsUpper;
  }
  
  
  public String getImagePathsLower()
  {
    return imagePathsLower;
  }
  
  public void setImagePathsLower(String imagePathsLower)
  {
    D.imagePathsLower = imagePathsLower;
  }
  
  public String getImagePathsUpper()
  {
    return imagePathsUpper;
  }
  
  public void setImagePathsUpper(String imagePathsUpper)
  {
    D.imagePathsUpper = imagePathsUpper;
  }
  
  public ArrayList<Point> getGuideLocationsLower()
  {
    return guideLocationsLower;
  }
  
  public void setGuideLocationsLower(ArrayList<Point> guideLocationsLower)
  {
    D.guideLocationsLower = guideLocationsLower;
  }
  
  public ArrayList<Point> getGuideLocationsUpper()
  {
    return guideLocationsUpper;
  }
  
  public void setGuideLocationsUpper(ArrayList<Point> guideLocationsUpper)
  {
    D.guideLocationsUpper = guideLocationsUpper;
  }
  
  /*public static void main(String[] args)
  {
    A letterA = new A();
    System.out.println(A.upperPath);
    Point a = upperPath.pop();
    System.out.println("X = " + a.x + ", Y = " + a.y);
    
  }*/

}