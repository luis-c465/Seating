package luisc.seating;

import luisc.lib.Clickable;

/**
 * Displays a seat with a student to the screen
 */
public class SeatViewer extends Clickable {

  public static final int margin_top = 500;
  public static final int margin_left = 25;
  public static final int gap = 20;

  public Student student;
  public int row;
  public int col;

  @Override
  protected void _setup() {
    w = 100;
    h = 100;

    x = margin_left + (w + gap) * col;
    y = margin_top + (h + gap) * row;

    cornerToCenter();
  }

  @Override
  protected void _update() {
    p.rectMode(c.CENTER);
    p.rect(x, y, w, h);

    p.fill(255);
    if (student != null) {
      p.text(student.toString(), x, y);
    }
  }

  @Override
  public String toString() {
    return "" + row + "" + col + " " + student;
  }

  public SeatViewer(App app, int r, int c, Student student) {
    super(app);
    this.row = r;
    this.col = c;
    this.student = student;

    _setup();
  }

  public SeatViewer(App app, int r, int c) {
    super(app);
    this.row = r;
    this.col = c;

    _setup();
  }

  public SeatViewer(App app) {
    super(app);
  }
}
