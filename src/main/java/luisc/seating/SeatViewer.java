package luisc.seating;

import luisc.lib.Clickable;

/**
 * Displays a seat with a student to the screen
 */
public class SeatViewer extends Clickable {

  public static final int c_overlay = 0xff475569;
  public static final int overlay_opacity = 100;
  public static final int showOverlayFor = 40;

  public static final int margin_top = 450;
  public static final int margin_left = 65;
  public static final int gap = 10;
  public static final int padding = 3;
  public static final int doublePadding = padding * 2;
  public static final int radius = 10;

  public Student student;
  public int row;
  public int col;

  public int default_row;
  public int default_col;

  public int clicksCombo = 1;
  public int time_since_click = 0;
  public int overlayTimer = 0;
  public static final int max_time_since_click = 20;

  @Override
  protected void _setup() {
    w = 110;
    h = 110;

    canMove = true;
    calc();

    cornerToCenter();
  }

  @Override
  protected void updateCorners() {
    calc();
    super.updateCorners();
  }

  private void calc() {
    x = margin_left + (w + gap) * col;
    y = margin_top + (h + gap) * row;
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

    if (clicksCombo >= 2) {
      if (overlayTimer < showOverlayFor) {
        showDeleteOverlay();
      } else {
        clicksCombo = 1;
        time_since_click = 0;
        overlayTimer = 0;
      }
    }

    if (time_since_click <= max_time_since_click) {
      time_since_click++;
    }
  }

  /**
   * Should only be shown if the click combo is greater or equal to 1
   */
  protected void showDeleteOverlay() {
    overlayTimer++;

    p.rectMode(c.CENTER);
    p.fill(c_overlay, overlay_opacity);
    p.rect(x, y, w, h, radius);
    // Then show the delete icon

    p.shapeMode(c.CENTER);
    p.shape(a.userMinus, x, y, 40, 40);
  }

  @Override
  protected void onClick() {
    if (student != null) {
      if (time_since_click < max_time_since_click) {
        if (clicksCombo >= 2 && overlayTimer < showOverlayFor) {
          student.alreadySeated = false;
          this.student = null;
          overlayTimer = 0;
          clicksCombo = 1;
          time_since_click = 0;

          return;
        }

        clicksCombo++;
      } else {
        clicksCombo = 1;
      }

      time_since_click = 0;

      return;
    }

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

    this.default_row = r;
    this.default_col = c;

    setup();
  }

  public SeatViewer(App app) {
    super(app);
  }
}
