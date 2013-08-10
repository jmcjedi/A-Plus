package aplusmain;

import java.awt.Point;
import java.util.ArrayList;
import java.util.LinkedList;

import org.newdawn.slick.Image;

public abstract class Letter
{
  protected static Image lower, upper, lowerData, upperData, guidesUpper, guidesLower;
  protected static String dataPathsUpper;
  protected static String dataPathsLower;
  protected static String imagePathsUpper;
  protected static String imagePathsLower;
  protected static String[] guidePathsUpper;
  protected static String[] guidePathsLower;
  protected static int guideCountsUpper;
  protected static int guideCountsLower;
  protected static ArrayList<Point> guideLocationsUpper = new ArrayList<Point>();
  protected static ArrayList<Point> guideLocationsLower = new ArrayList<Point>();
  protected static LinkedList<Point> expectedPathUpper;
  protected static LinkedList<Point> expectedPathLower;
  protected static Point startingLocation;
  
  abstract ArrayList<Point> getUpperPath();
  abstract void setUpperPath(ArrayList<Point> upperPath);
  
  abstract Point getStartingLocation();
  abstract void setStartingLocation(Point startingLocation);
  
  abstract int getGuideCountsUpper();
  abstract void setGuideCountsUpper(int guideCountsUpper);
  
  abstract int getGuideCountsLower();
  abstract void setGuideCountsLower(int guideCountsLower);
  
  abstract String[] getGuidePathsUpper();
  abstract void setGuidePathsUpper(String[] guidePathsUpper);
  abstract String[] getGuidePathsLower();
  abstract void setGuidePathsLower(String[] guidePathsLower);
  
  abstract String getDataPathsUpper();
  abstract void setDataPathsUpper(String dataPathsUpper);
  abstract String getDataPathsLower();
  abstract void setDataPathsLower(String dataPathsLower);
  
  abstract String getImagePathsUpper();
  abstract void setImagePathsUpper(String imagePathsUpper);
  abstract String getImagePathsLower();
  abstract void setImagePathsLower(String imagePathsLower);
  
  abstract ArrayList<Point> getGuideLocationsUpper();
  abstract void setGuideLocationsUpper(ArrayList<Point> guideLocationsUpper);
  abstract ArrayList<Point> getGuideLocationsLower();
  abstract void setGuideLocationsLower(ArrayList<Point> guideLocationsLower);
  public ArrayList<Point> getLowerPath()
  {
    // TODO Auto-generated method stub
    return null;
  }

  
}
