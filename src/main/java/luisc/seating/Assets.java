package luisc.seating;

import processing.core.PApplet;
import processing.core.PFont;
import processing.core.PImage;
import processing.core.PShape;

/**
 * Class which loads images and audio to be used in the main class {@link App}
 *
 * Call the {@link #setup(App) setup method} to load all the images and the sounds
 */
public class Assets {

  // Color constants
  public static final int success = 0xff4ade80;
  public static final int error = 0xfff87171;
  public static final int gray = 0xff6b7280;
  public static final int selected = 0xff22d3ee;
  public static final int yellow = 0xfffbbf24;

  public PApplet p;
  public Class<? extends Assets> _class;

  public void setup(App app) {
    this.p = app;
    this._class = this.getClass();

    loadShapes();
    loadButtons();
    loadMisc();
    loadFonts();
  }

  public PShape skull;
  public PShape userMinus;
  public PShape rows;
  public PShape columns;

  public PImage rating;

  private void loadShapes() {
    skull = p.loadShape("skull.svg");
    userMinus = p.loadShape("user-minus.svg");

    rows = p.loadShape("rows.svg");
    columns = p.loadShape("columns.svg");
  }

  public PImage enter;
  public PImage space;

  private void loadButtons() {
    enter = p.loadImage("btn/enter.png");
    space = p.loadImage("btn/space.png");
    space.resize(200, 100);
  }

  public PFont nunito;
  // !Smaller versions of fonts are loaded because controlP5 does not give a method to set the font size of the input text
  public PFont nunito_small;

  private void loadFonts() {
    nunito = p.createFont("fonts/Nunito.ttf", 64);
    nunito_small = p.createFont("fonts/Nunito.ttf", 20);
    p.textFont(nunito);
  }

  public PImage intro;
  public PImage tutorial;

  private void loadMisc() {
    intro = p.loadImage("Intro.png");
    tutorial = p.loadImage("instructions.png");
  }

  /**
   * Safely and dynamically get an asset with the given name
   *
   * @return null if an error occurred getting the asset
   */
  public PImage getAsset(String name) {
    try {
      return (PImage) get(name);
    } catch (Exception e) {
      return null;
    }
  }

  public Object get(String k)
    throws IllegalAccessException, NoSuchFieldException {
    return (_class.getDeclaredField(k).get(this));
  }
}
