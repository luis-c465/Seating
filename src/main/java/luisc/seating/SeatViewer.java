package luisc.seating;

import luisc.lib.Clickable;

/**
 * Displays a seat with a student to the screen
 */
public class SeatViewer extends Clickable {

  public static final int margin_top = 100;
  public static final int margin_left = 50;
  public static final int gap = 20;

  public Student student;
  public int row;
  public int col;

  @Override
  protected void _setup() {
    w = 75;
    h = 75;

    x = 50 + (w + gap) * col;
    y = margin_top + (h + gap) * row;
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
  }

  public SeatViewer(App app, int r, int c) {
    super(app);
    this.row = r;
    this.col = c;
  }

  public SeatViewer(App app) {
    super(app);
  }
}
