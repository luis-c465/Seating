package luisc.seating;

import luisc.lib.Obj;

/**
 * Displays a sidebar for the currently selected room
 * Allows the user to set a booking start and end date
 * If the room is already book it should say so
 */
public class Sidebar extends Obj {

  public boolean showingStudents = false;

  // Field constants
  private static final int safe = 20;

  private static final int shape_fill_c = 0xfff87171;
  private static final int max_txt_h = 100;
  private static final int max_txt_w = 290;
  private static final int icon_size = 80;
  public static final int padding = 20;
  public static final int x = 700;
  public int xs = x + padding;
  public int ys = padding;
  public static final int bg_r = 25;
  private static final int bg_c = 0xff334155;

  @Override
  protected void _update() {
    // Update the fields
  }

  @Override
  protected void _setup() {}

  protected void showBackground() {
    push();

    p.fill(bg_c);
    p.rectMode(c.CORNERS);
    p.rect(x, App.w, 0, App.h);

    pop();
  }

  @Override
  protected void preUpdate() {
    super.preUpdate();
    showBackground();
  }

  public Sidebar(App app) {
    super(app);
  }
}
