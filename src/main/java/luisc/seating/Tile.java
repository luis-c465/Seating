package luisc.seating;

public class Tile {

  private int myColor, myX, myY;

  public Tile(int x, int y) {
    myColor = App.bg;
    // myColor = 255;
    myX = x;
    myY = y;
  }

  public int getColor() {
    return myColor;
  }

  public void setColor(int mColor) {
    myColor = mColor;
  }

  public int getX() {
    return myX;
  }

  public int getY() {
    return myY;
  }
}
