package luisc.seating;

import luisc.lib.Clickable;

/**
 * Shows information about a student
 * Can be clicked on to adda student to that seat
 */
public class ClickableStudent extends Clickable {

  public boolean alreadySeated = false;
  public boolean selected = false;

  public int row;
  public int col;

  public static final int radius = 5;
  public static final int margin_top = 75;
  public static final int margin_left = 740;
  public static final int gap = 10;
  public static final int vert_gap = 10;
  public static final int padding = 2;

  public Student student;

  @Override
  protected void _update() {
    if (student.alreadySeated) {
      p.fill(a.gray);
    } else if (m.sidebar.selectedStudent == this.student) {
      p.fill(a.selected);
    } else {
      p.fill(255);
    }

    p.rectMode(c.CENTER);
    p.rect(x, y, w, h, radius);

    p.fill(255);
    p.textMode(c.CENTER);
    p.textSize(14);
    p.fill(0);
    p.text(
      student.toShortString(),
      x + padding,
      y + padding / 2,
      w - padding * 2,
      h - padding * 2
    );
  }

  @Override
  protected void onClick() {
    m.sidebar.selectedStudent = this.student;
  }

  @Override
  protected void _setup() {
    w = 120;
    h = 55;

    x = margin_left + (w + gap) * col;
    y = margin_top + (h + vert_gap) * row;

    cornerToCenter();
  }

  public ClickableStudent(App a, Student s, int row, int col) {
    super(a);
    this.student = s;
    this.row = row;
    this.col = col;

    setup();
  }
}
