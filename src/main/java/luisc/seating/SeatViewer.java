package luisc.seating;

import luisc.lib.Clickable;

/**
 * Displays a seat with a student to the screen
 */
public class SeatViewer extends Clickable {

  public static final int margin_top = 500;
  public static final int margin_left = 10;
  public static final int gap = 10;
  public static final int padding = 3;
  public static final int doublePadding = padding * 2;
  public static final int radius = 10;

  public Student student;
  public int row;
  public int col;

  @Override
  protected void _setup() {
    w = 110;
    h = 110;

    x = margin_left + (w + gap) * col;
    y = margin_top + (h + gap) * row;

    cornerToCenter();
  }

  @Override
  protected void _update() {
    p.rectMode(c.CENTER);
    p.rect(x, y, w, h, radius);

    p.fill(255);
    if (student != null) {
      p.fill(0);
      p.textSize(13);
      p.text(
        student.toDisplayString(),
        x + padding,
        y + padding,
        w - doublePadding,
        h - doublePadding
      );
    }
  }

  @Override
  protected void onClick() {
    // If there is no selected student or the sidebars student is already seated do not process the click
    if (
      m.sidebar.selectedStudent == null ||
      m.sidebar.selectedStudent.alreadySeated
    ) {
      return;
    }

    // Add the student to this seat
    this.student = m.sidebar.selectedStudent;

    // Make the student already seated
    this.student.alreadySeated = true;

    // Reset the sidebars selected student
    m.sidebar.selectedStudent = null;
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

    setup();
  }

  public SeatViewer(App app, int r, int c) {
    super(app);
    this.row = r;
    this.col = c;

    setup();
  }

  public SeatViewer(App app) {
    super(app);
  }
}
