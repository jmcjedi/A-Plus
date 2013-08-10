package aplusmain;

import java.awt.Point;
import java.util.ArrayList;

public class E extends Letter
{
  private static ArrayList<Point> upperPath = new ArrayList<Point> ();
  private static ArrayList<Point> lowerPath = new ArrayList<Point> ();
  
  private static String dataPathsUpper = "resources/images/EDataCap.png";
  private static String dataPathsLower= "resources/images/eData.png";
  
  private static String imagePathsUpper= "resources/images/ECapClear.png";
  private static String imagePathsLower= "resources/images/eClear.png";
  
  //Need C guides
  private static String guidePathsUpper[]= {"resources/images/E_1.png", "resources/images/E_2.png", "resources/images/E_3.png", "resources/images/E_4.png"};
  private static String guidePathsLower[]= {"resources/images/e__1.png", "resources/images/e__2.png"};
  
  private static int guideCountsUpper = 4;
  private static int guideCountsLower = 2;
  
  private static ArrayList<Point> guideLocationsUpper = new ArrayList<Point>();
  private static ArrayList<Point> guideLocationsLower = new ArrayList<Point>();
  
  private static Point startingLocationUpper = new Point(0, 0);
  private static Point startingLocationLower = new Point(1, 8);
  
  public E()
  {
    guideLocationsUpper.add(new Point(210, 70));
    guideLocationsUpper.add(new Point(365, 130));
    guideLocationsUpper.add(new Point(365, 385));
    guideLocationsUpper.add(new Point(365, 520));
    
    guideLocationsLower.add(new Point(425, 525));
    guideLocationsLower.add(new Point(205, 215));
    
    //E part 1
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
    
    //E part 2
    getUpperPath().add(new Point(0,0));
    getUpperPath().add(new Point(1,0));
    getUpperPath().add(new Point(2,0));
    getUpperPath().add(new Point(3,0));
    getUpperPath().add(new Point(4,0));
    getUpperPath().add(new Point(5,0));
    getUpperPath().add(new Point(6,0));
    getUpperPath().add(new Point(7,0));
    
    //E part 3
    getUpperPath().add(new Point(0,6));
    getUpperPath().add(new Point(1,6));
    getUpperPath().add(new Point(2,6));
    getUpperPath().add(new Point(3,6));
    getUpperPath().add(new Point(4,6));
    getUpperPath().add(new Point(5,6));

    //E part 4
    getUpperPath().add(new Point(0,12));
    getUpperPath().add(new Point(1,12));
    getUpperPath().add(new Point(2,12));
    getUpperPath().add(new Point(3,12));
    getUpperPath().add(new Point(4,12));
    getUpperPath().add(new Point(5,12));
    getUpperPath().add(new Point(6,12));
    getUpperPath().add(new Point(7,12));
    
    //e part 1
    getLowerPath().add(new Point(1,9));
    getLowerPath().add(new Point(2,9));
    getLowerPath().add(new Point(3,9));
    getLowerPath().add(new Point(4,9));
    getLowerPath().add(new Point(5,9));
    getLowerPath().add(new Point(6,9));
    
    //e part 2
    getLowerPath().add(new Point(7,9));
    getLowerPath().add(new Point(7,8));
    getLowerPath().add(new Point(6,7));
    getLowerPath().add(new Point(5,6));
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
    getLowerPath().add(new Point(5,12));
    getLowerPath().add(new Point(6,11));
    
    
  }

  public ArrayList<Point> getUpperPath()
  {
    return upperPath;
  }
  
  public void setUpperPath(ArrayList<Point> upperPath)
  {
    E.upperPath = upperPath;
  }
  
  public ArrayList<Point> getLowerPath()
  {
    return lowerPath;
  }

  public void setLowerPath(ArrayList<Point> LowerPath)
  {
    E.lowerPath = LowerPath;
  }

  public Point getStartingLocation()
  {
    if (Play.upperLower==1) return startingLocationLower;
    else return startingLocationUpper; 
  }

  public void setStartingLocation(Point startingLocation)
  {
    if (Play.upperLower==1) E.startingLocationLower = startingLocation;
    else E.startingLocationUpper = startingLocation;
  }
  
  public int getGuideCountsUpper()
  {
    return guideCountsUpper;
  }
  
  public void setGuideCountsUpper(int guideCountsUpper)
  {
    E.guideCountsUpper = guideCountsUpper;
  }
  
  public int getGuideCountsLower()
  {
    return guideCountsLower;
  }
  
  public void setGuideCountsLower(int guideCountsLower)
  {
    E.guideCountsLower = guideCountsLower;
  }
  
  public String[] getGuidePathsLower()
  {
    return guidePathsLower;
  }
  
  public void setGuidePathsLower(String[] guidePathsLower)
  {
    E.guidePathsLower = guidePathsLower;
  }
  
  public String[] getGuidePathsUpper()
  {
    return guidePathsUpper;
  }
  
  public void setGuidePathsUpper(String[] guidePathsUpper)
  {
    E.guidePathsUpper = guidePathsUpper;
  }
  
  public String getDataPathsLower()
  {
    return dataPathsLower;
  }
  
  public void setDataPathsLower(String dataPathsLower)
  {
    E.dataPathsLower = dataPathsLower;
  }
  
  public String getDataPathsUpper()
  {
    return dataPathsUpper;
  }
  
  public void setDataPathsUpper(String dataPathsUpper)
  {
    E.dataPathsUpper = dataPathsUpper;
  }
  
  
  public String getImagePathsLower()
  {
    return imagePathsLower;
  }
  
  public void setImagePathsLower(String imagePathsLower)
  {
    E.imagePathsLower = imagePathsLower;
  }
  
  public String getImagePathsUpper()
  {
    return imagePathsUpper;
  }
  
  public void setImagePathsUpper(String imagePathsUpper)
  {
    E.imagePathsUpper = imagePathsUpper;
  }
  
  public ArrayList<Point> getGuideLocationsLower()
  {
    return guideLocationsLower;
  }
  
  public void setGuideLocationsLower(ArrayList<Point> guideLocationsLower)
  {
    E.guideLocationsLower = guideLocationsLower;
  }
  
  public ArrayList<Point> getGuideLocationsUpper()
  {
    return guideLocationsUpper;
  }
  
  public void setGuideLocationsUpper(ArrayList<Point> guideLocationsUpper)
  {
    E.guideLocationsUpper = guideLocationsUpper;
  }
  
  /*public static void main(String[] args)
  {
    A letterA = new A();
    System.out.println(A.upperPath);
    Point a = upperPath.pop();
    System.out.println("X = " + a.x + ", Y = " + a.y);
    
  }*/

}