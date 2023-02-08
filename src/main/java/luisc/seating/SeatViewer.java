package luisc.seating;

import luisc.lib.Obj;

/**
 * Displays a seat with a student to the screen
 */
public class SeatViewer extends Obj {

  public Student student;
  public int r;
  public int c;

  @Override
  protected void _update() {}

  public SeatViewer(App app, int r, int c, Student student) {
    super(app);
    this.r = r;
    this.c = c;
    this.student = student;
  }

  public SeatViewer(App app) {
    super(app);
  }
}
