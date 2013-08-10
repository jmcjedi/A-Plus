package aplusmain;

import java.awt.Point;
import java.util.ArrayList;

public class I extends Letter
{
  private static ArrayList<Point> upperPath = new ArrayList<Point> ();
  private static ArrayList<Point> lowerPath = new ArrayList<Point> ();
  
  private static String dataPathsUpper = "resources/images/IDataCap.png";
  private static String dataPathsLower= "resources/images/iData.png";
  
  private static String imagePathsUpper= "resources/images/ICapClear.png";
  private static String imagePathsLower= "resources/images/iClear.png";
  
  //Need C guides
  private static String guidePathsUpper[]= {"resources/images/I_1.png", "resources/images/I_2.png", "resources/images/I_3.png"};
  private static String guidePathsLower[]= {"resources/images/i__1.png"};
  
  private static int guideCountsUpper = 3;
  private static int guideCountsLower = 1;
  
  private static ArrayList<Point> guideLocationsUpper = new ArrayList<Point>();
  private static ArrayList<Point> guideLocationsLower = new ArrayList<Point>();
  
  private static Point startingLocationUpper = new Point(3, 0);
  private static Point startingLocationLower = new Point(3, 5);
  
  
  public I()
  {
    guideLocationsUpper.add(new Point(335, 70));
    guideLocationsUpper.add(new Point(530, 100));
    guideLocationsUpper.add(new Point(530, 515));
    
    guideLocationsLower.add(new Point(545, 145));
    
    //I part 1
    getUpperPath().add(new Point(3,1));
    getUpperPath().add(new Point(3,2));
    getUpperPath().add(new Point(3,3));
    getUpperPath().add(new Point(3,4));
    getUpperPath().add(new Point(3,5));
    getUpperPath().add(new Point(3,6));
    getUpperPath().add(new Point(3,7));
    getUpperPath().add(new Point(3,8));
    getUpperPath().add(new Point(3,9));
    getUpperPath().add(new Point(3,10));
    getUpperPath().add(new Point(3,11));
    
    //I part 2
    getUpperPath().add(new Point(1,0));
    getUpperPath().add(new Point(2,0));
    getUpperPath().add(new Point(3,0));
    getUpperPath().add(new Point(4,0));
    getUpperPath().add(new Point(5,0));
    
    
    //I part 3
    getUpperPath().add(new Point(1,12));
    getUpperPath().add(new Point(2,12));
    getUpperPath().add(new Point(3,12));
    getUpperPath().add(new Point(4,12));
    getUpperPath().add(new Point(5,12));

    //i part 1
    getLowerPath().add(new Point(3,6));
    getLowerPath().add(new Point(3,7));
    getLowerPath().add(new Point(3,8));
    getLowerPath().add(new Point(3,9));
    getLowerPath().add(new Point(3,10));
    getLowerPath().add(new Point(3,11));
    getLowerPath().add(new Point(3,12));
    
    //i part 2
    getLowerPath().add(new Point(3,3));
  }

  public ArrayList<Point> getUpperPath()
  {
    return upperPath;
  }
  
  public void setUpperPath(ArrayList<Point> upperPath)
  {
    I.upperPath = upperPath;
  }
  
  public ArrayList<Point> getLowerPath()
  {
    return lowerPath;
  }

  public void setLowerPath(ArrayList<Point> LowerPath)
  {
    I.lowerPath = LowerPath;
  }

  public Point getStartingLocation()
  {
    if (Play.upperLower==1) return startingLocationLower;
    else return startingLocationUpper; 
  }

  public void setStartingLocation(Point startingLocation)
  {
    if (Play.upperLower==1) I.startingLocationLower = startingLocation;
    else I.startingLocationUpper = startingLocation;
  }
  
  public int getGuideCountsUpper()
  {
    return guideCountsUpper;
  }
  
  public void setGuideCountsUpper(int guideCountsUpper)
  {
    I.guideCountsUpper = guideCountsUpper;
  }
  
  public int getGuideCountsLower()
  {
    return guideCountsLower;
  }
  
  public void setGuideCountsLower(int guideCountsLower)
  {
    I.guideCountsLower = guideCountsLower;
  }
  
  public String[] getGuidePathsLower()
  {
    return guidePathsLower;
  }
  
  public void setGuidePathsLower(String[] guidePathsLower)
  {
    I.guidePathsLower = guidePathsLower;
  }
  
  public String[] getGuidePathsUpper()
  {
    return guidePathsUpper;
  }
  
  public void setGuidePathsUpper(String[] guidePathsUpper)
  {
    I.guidePathsUpper = guidePathsUpper;
  }
  
  public String getDataPathsLower()
  {
    return dataPathsLower;
  }
  
  public void setDataPathsLower(String dataPathsLower)
  {
    I.dataPathsLower = dataPathsLower;
  }
  
  public String getDataPathsUpper()
  {
    return dataPathsUpper;
  }
  
  public void setDataPathsUpper(String dataPathsUpper)
  {
    I.dataPathsUpper = dataPathsUpper;
  }
  
  
  public String getImagePathsLower()
  {
    return imagePathsLower;
  }
  
  public void setImagePathsLower(String imagePathsLower)
  {
    I.imagePathsLower = imagePathsLower;
  }
  
  public String getImagePathsUpper()
  {
    return imagePathsUpper;
  }
  
  public void setImagePathsUpper(String imagePathsUpper)
  {
    I.imagePathsUpper = imagePathsUpper;
  }
  
  public ArrayList<Point> getGuideLocationsLower()
  {
    return guideLocationsLower;
  }
  
  public void setGuideLocationsLower(ArrayList<Point> guideLocationsLower)
  {
    I.guideLocationsLower = guideLocationsLower;
  }
  
  public ArrayList<Point> getGuideLocationsUpper()
  {
    return guideLocationsUpper;
  }
  
  public void setGuideLocationsUpper(ArrayList<Point> guideLocationsUpper)
  {
    I.guideLocationsUpper = guideLocationsUpper;
  }
  
  /*public static void main(String[] args)
  {
    A letterA = new A();
    System.out.println(A.upperPath);
    Point a = upperPath.pop();
    System.out.println("X = " + a.x + ", Y = " + a.y);
    
  }*/

}