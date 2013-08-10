package aplusmain;

public class Location
{
  private static int x;
  private static int y;
  
  public Location(int a, int b)
  {
    this.setX(a);
    this.setY(b);
  }

  public int getX()
  {
    return x;
  }

  public void setX(int x)
  {
    Location.x = x;
  }

  public int getY()
  {
    return y;
  }

  public void setY(int y)
  {
    Location.y = y;
  }

}
