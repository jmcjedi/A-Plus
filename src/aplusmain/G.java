package aplusmain;

import java.awt.Point;
import java.util.ArrayList;

public class G extends Letter
{
  private static ArrayList<Point> upperPath = new ArrayList<Point> ();
  private static ArrayList<Point> lowerPath = new ArrayList<Point> ();
  
  private static String dataPathsUpper = "resources/images/GDataCap.png";
  private static String dataPathsLower= "resources/images/gData.png";
  
  private static String imagePathsUpper= "resources/images/GCapClear.png";
  private static String imagePathsLower= "resources/images/gClear.png";
  
  //Need C guides
  private static String guidePathsUpper[]= {"resources/images/G_1.png", "resources/images/G_2.png"};
  private static String guidePathsLower[]= {"resources/images/g__1.png", "resources/images/g__2.png"};
  
  private static int guideCountsUpper = 2;
  private static int guideCountsLower = 2;
  
  private static ArrayList<Point> guideLocationsUpper = new ArrayList<Point>();
  private static ArrayList<Point> guideLocationsLower = new ArrayList<Point>();
  
  private static Point startingLocationUpper = new Point(8, 2);
  private static Point startingLocationLower = new Point(6, 2);
  
  public G()
  {
    guideLocationsUpper.add(new Point(390, 120));
    guideLocationsUpper.add(new Point(515, 250));
    
    guideLocationsLower.add(new Point(230, 0));
    guideLocationsLower.add(new Point(685, 65));
    
    //G part 1
    getUpperPath().add(new Point(8,3));
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
    getUpperPath().add(new Point(8,8));
    getUpperPath().add(new Point(8,7));
    
    //G part 2
    getUpperPath().add(new Point(5,7));
    getUpperPath().add(new Point(6,7));
    getUpperPath().add(new Point(7,7));
    getUpperPath().add(new Point(8,7));
    
    //g part 1
    getLowerPath().add(new Point(6,3));
    getLowerPath().add(new Point(6,2));
    getLowerPath().add(new Point(5,1));
    getLowerPath().add(new Point(4,1));
    getLowerPath().add(new Point(3,1));
    getLowerPath().add(new Point(2,1));
    getLowerPath().add(new Point(1,2));
    getLowerPath().add(new Point(1,3));
    getLowerPath().add(new Point(0,4));
    getLowerPath().add(new Point(0,5));
    getLowerPath().add(new Point(1,6));
    getLowerPath().add(new Point(2,7));
    getLowerPath().add(new Point(3,7));
    getLowerPath().add(new Point(4,7));
    getLowerPath().add(new Point(5,7));
    getLowerPath().add(new Point(6,6));
    
    //g part 2
    getLowerPath().add(new Point(7,1));
    getLowerPath().add(new Point(7,2));
    getLowerPath().add(new Point(7,3));
    getLowerPath().add(new Point(7,4));
    getLowerPath().add(new Point(7,5));
    getLowerPath().add(new Point(7,6));
    getLowerPath().add(new Point(7,7));
    getLowerPath().add(new Point(7,8));
    getLowerPath().add(new Point(6,9));
    getLowerPath().add(new Point(5,10));
    getLowerPath().add(new Point(4,11));
    getLowerPath().add(new Point(3,11));
    getLowerPath().add(new Point(2,10));
    getLowerPath().add(new Point(1,10));
    
  }

  public ArrayList<Point> getUpperPath()
  {
    return upperPath;
  }
  
  public void setUpperPath(ArrayList<Point> upperPath)
  {
    G.upperPath = upperPath;
  }
  
  public ArrayList<Point> getLowerPath()
  {
    return lowerPath;
  }

  public void setLowerPath(ArrayList<Point> LowerPath)
  {
    G.lowerPath = LowerPath;
  }

  public Point getStartingLocation()
  {
    if (Play.upperLower==1) return startingLocationLower;
    else return startingLocationUpper; 
  }

  public void setStartingLocation(Point startingLocation)
  {
    if (Play.upperLower==1) G.startingLocationLower = startingLocation;
    else G.startingLocationUpper = startingLocation;
  }
  
  public int getGuideCountsUpper()
  {
    return guideCountsUpper;
  }
  
  public void setGuideCountsUpper(int guideCountsUpper)
  {
    G.guideCountsUpper = guideCountsUpper;
  }
  
  public int getGuideCountsLower()
  {
    return guideCountsLower;
  }
  
  public void setGuideCountsLower(int guideCountsLower)
  {
    G.guideCountsLower = guideCountsLower;
  }
  
  public String[] getGuidePathsLower()
  {
    return guidePathsLower;
  }
  
  public void setGuidePathsLower(String[] guidePathsLower)
  {
    G.guidePathsLower = guidePathsLower;
  }
  
  public String[] getGuidePathsUpper()
  {
    return guidePathsUpper;
  }
  
  public void setGuidePathsUpper(String[] guidePathsUpper)
  {
    G.guidePathsUpper = guidePathsUpper;
  }
  
  public String getDataPathsLower()
  {
    return dataPathsLower;
  }
  
  public void setDataPathsLower(String dataPathsLower)
  {
    G.dataPathsLower = dataPathsLower;
  }
  
  public String getDataPathsUpper()
  {
    return dataPathsUpper;
  }
  
  public void setDataPathsUpper(String dataPathsUpper)
  {
    G.dataPathsUpper = dataPathsUpper;
  }
  
  
  public String getImagePathsLower()
  {
    return imagePathsLower;
  }
  
  public void setImagePathsLower(String imagePathsLower)
  {
    G.imagePathsLower = imagePathsLower;
  }
  
  public String getImagePathsUpper()
  {
    return imagePathsUpper;
  }
  
  public void setImagePathsUpper(String imagePathsUpper)
  {
    G.imagePathsUpper = imagePathsUpper;
  }
  
  public ArrayList<Point> getGuideLocationsLower()
  {
    return guideLocationsLower;
  }
  
  public void setGuideLocationsLower(ArrayList<Point> guideLocationsLower)
  {
    G.guideLocationsLower = guideLocationsLower;
  }
  
  public ArrayList<Point> getGuideLocationsUpper()
  {
    return guideLocationsUpper;
  }
  
  public void setGuideLocationsUpper(ArrayList<Point> guideLocationsUpper)
  {
    G.guideLocationsUpper = guideLocationsUpper;
  }
  
  /*public static void main(String[] args)
  {
    A letterA = new A();
    System.out.println(A.upperPath);
    Point a = upperPath.pop();
    System.out.println("X = " + a.x + ", Y = " + a.y);
    
  }*/

}