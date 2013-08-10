package aplusmain;

import java.awt.Point;
import java.util.ArrayList;

public class B extends Letter
{
  private static ArrayList<Point> upperPath = new ArrayList<Point> ();
  private static ArrayList<Point> lowerPath = new ArrayList<Point> ();
  
  private static String dataPathsUpper = "resources/images/BDataCap.png";
  private static String dataPathsLower= "resources/images/bData.png";
  private static String imagePathsUpper= "resources/images/BCapClear.png";
  private static String imagePathsLower= "resources/images/bClear.png";
  
  //Need B guides...
  private static String guidePathsUpper[]= {"resources/images/B_1.png", "resources/images/B_2.png", "resources/images/B_3.png"};
  private static String guidePathsLower[]= {"resources/images/b__1.png", "resources/images/b__2.png"};
  private static int guideCountsUpper = 3;
  private static int guideCountsLower = 2;
  
  private static ArrayList<Point> guideLocationsUpper = new ArrayList<Point>();
  private static ArrayList<Point> guideLocationsLower = new ArrayList<Point>();
  
  private static Point startingLocationUpper = new Point(0, 0);
  private static Point startingLocationLower = new Point(0, 3);
  
  public B()
  {
    guideLocationsUpper.add(new Point(215, 85));
    guideLocationsUpper.add(new Point(350, 122));
    guideLocationsUpper.add(new Point(390, 400));
    
    guideLocationsLower.add(new Point(195, 85));
    guideLocationsLower.add(new Point(495, 180));
    
    //B part 1
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
    
    getUpperPath().add(new Point(1,1));
    getUpperPath().add(new Point(2,1));
    getUpperPath().add(new Point(3,1));
    getUpperPath().add(new Point(4,1));
    getUpperPath().add(new Point(5,1));
    getUpperPath().add(new Point(6,1));
    getUpperPath().add(new Point(6,2));
    getUpperPath().add(new Point(6,3));
    getUpperPath().add(new Point(6,4));
    getUpperPath().add(new Point(5,5));
    getUpperPath().add(new Point(4,5));
    getUpperPath().add(new Point(3,5));
    getUpperPath().add(new Point(2,5));
    getUpperPath().add(new Point(1,5));
    
    getUpperPath().add(new Point(1,6));
    getUpperPath().add(new Point(2,6));
    getUpperPath().add(new Point(3,6));
    getUpperPath().add(new Point(4,6));
    getUpperPath().add(new Point(5,6));
    getUpperPath().add(new Point(6,6));
    getUpperPath().add(new Point(7,7));
    getUpperPath().add(new Point(7,8));
    getUpperPath().add(new Point(7,9));
    getUpperPath().add(new Point(7,10));
    getUpperPath().add(new Point(7,11));
    getUpperPath().add(new Point(6,12));
    getUpperPath().add(new Point(5,12));
    getUpperPath().add(new Point(4,12));
    getUpperPath().add(new Point(3,12));
    getUpperPath().add(new Point(2,12));
    getUpperPath().add(new Point(1,12));

    //add Lower path
    //getLowerPath().add(new Point(0,2));
    getLowerPath().add(new Point(0,3));
    getLowerPath().add(new Point(0,4));
    getLowerPath().add(new Point(0,5));
    getLowerPath().add(new Point(0,6));
    getLowerPath().add(new Point(0,7));
    getLowerPath().add(new Point(0,8));
    getLowerPath().add(new Point(0,9));
    getLowerPath().add(new Point(0,10));
    getLowerPath().add(new Point(0,11));
    //getLowerPath().add(new Point(0,12));
    
    getLowerPath().add(new Point(1,7));
    getLowerPath().add(new Point(2,6));
    getLowerPath().add(new Point(3,6));
    getLowerPath().add(new Point(4,6));
    getLowerPath().add(new Point(5,6));
    getLowerPath().add(new Point(6,7));
    getLowerPath().add(new Point(6,8));
    getLowerPath().add(new Point(6,9));
    getLowerPath().add(new Point(6,10));
    getLowerPath().add(new Point(6,11));
    getLowerPath().add(new Point(5,12));
    getLowerPath().add(new Point(4,12));
    getLowerPath().add(new Point(3,12));
    getLowerPath().add(new Point(2,12));
    getLowerPath().add(new Point(1,11));
  }

  public ArrayList<Point> getUpperPath()
  {
    return upperPath;
  }

  public void setUpperPath(ArrayList<Point> upperPath)
  {
    B.upperPath = upperPath;
  }

  public ArrayList<Point> getLowerPath()
  {
    return lowerPath;
  }

  public void setLowerPath(ArrayList<Point> lowerPath)
  {
    B.lowerPath = lowerPath;
  }
  
  public Point getStartingLocation()
  {
    if (Play.upperLower==1) return startingLocationLower;
    else return startingLocationUpper; 
  }
  
  public void setStartingLocation(Point startingLocation)
  {
    if (Play.upperLower==1) B.startingLocationLower = startingLocation;
    else B.startingLocationUpper = startingLocation;
  }
  
  public int getGuideCountsUpper()
  {
    return guideCountsUpper;
  }
  
  public void setGuideCountsUpper(int guideCountsUpper)
  {
    B.guideCountsUpper = guideCountsUpper;
  }
  
  public int getGuideCountsLower()
  {
    return guideCountsLower;
  }
  
  public void setGuideCountsLower(int guideCountsLower)
  {
    B.guideCountsLower = guideCountsLower;
  }
  
  public String[] getGuidePathsLower()
  {
    return guidePathsLower;
  }
  
  public void setGuidePathsLower(String[] guidePathsLower)
  {
    B.guidePathsLower = guidePathsLower;
  }
  
  public String[] getGuidePathsUpper()
  {
    return guidePathsUpper;
  }
  
  public void setGuidePathsUpper(String[] guidePathsUpper)
  {
    B.guidePathsUpper = guidePathsUpper;
  }
  
  public String getDataPathsLower()
  {
    return dataPathsLower;
  }
  
  public void setDataPathsLower(String dataPathsLower)
  {
    B.dataPathsLower = dataPathsLower;
  }
  
  public String getDataPathsUpper()
  {
    return dataPathsUpper;
  }
  
  public void setDataPathsUpper(String dataPathsUpper)
  {
    B.dataPathsUpper = dataPathsUpper;
  }
  
  
  public String getImagePathsLower()
  {
    return imagePathsLower;
  }
  
  public void setImagePathsLower(String imagePathsLower)
  {
    B.imagePathsLower = imagePathsLower;
  }
  
  public String getImagePathsUpper()
  {
    return imagePathsUpper;
  }
  
  public void setImagePathsUpper(String imagePathsUpper)
  {
    B.imagePathsUpper = imagePathsUpper;
  }
  
  public ArrayList<Point> getGuideLocationsLower()
  {
    return guideLocationsLower;
  }
  
  public void setGuideLocationsLower(ArrayList<Point> guideLocationsLower)
  {
    B.guideLocationsLower = guideLocationsLower;
  }
  
  public ArrayList<Point> getGuideLocationsUpper()
  {
    return guideLocationsUpper;
  }
  
  public void setGuideLocationsUpper(ArrayList<Point> guideLocationsUpper)
  {
    B.guideLocationsUpper = guideLocationsUpper;
  }
  
  /*public static void main(String[] args)
  {
    A letterA = new A();
    System.out.println(A.upperPath);
    Point a = upperPath.pop();
    System.out.println("X = " + a.x + ", Y = " + a.y);
    
  }*/

}
