package luisc.lib;

import processing.core.PApplet;

/**
 * Base class for all apps
 */
public class BaseApp extends PApplet {

  // * CONSTANTS
  public static final int h = 1000;
  public static final int w = 1000;

  public static final int ch = 500;
  public static final int cw = 500;

  // * COLORS
  public static final int bg = 0xff1e293b;

  @Override
  public void settings() {
    size(1000, 1000);
  }

  public static final String[] appletArgs = {
    "--display=1",
    "luisc.seating.App",
  };

  public static void main(String[] args) {
    runSketch(appletArgs, null);
  }

  /**
   * Sets the default settings for drawing with processing
   */
  public void procSet() {
    background(0);
    shapeMode(CENTER);
    textAlign(CENTER);
    imageMode(CENTER);
    noStroke();

    // Default fill color is white
    fill(255);
  }
}
