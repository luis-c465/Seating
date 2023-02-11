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
  public static final int margin_left = 100;
  public static final int gap = 10;
  public static final int padding = 3;
  public static final int doublePadding = padding * 2;
  public static final int radius = 10;

  public static final int padding_gap = 20;
  public int name_y = -1;
  public int id_y = -1;
  public int dob_y = -1;
  public int str_x = -1;
  public int str_x_end = -1;
  public static final int str_h_max = 20;

  public Student student;
  public int row;
  public int col;

  public int default_row;
  public int default_col;

  public int clicksCombo = 1;
  public int time_since_click = 0;
  public int overlayTimer = 0;
  public static final int max_time_since_click = 20;

  public int max_txt_w = -1;

  @Override
  protected void _setup() {
    w = 105;
    h = 110;

    max_txt_w = w - doublePadding;

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

    name_y = y - h / 2 + gap;
    id_y = name_y + str_h_max * 2 + padding_gap;
    dob_y = id_y + padding_gap;
    str_x = x - w / 2 + padding;
    str_x_end = w - padding;
  }

  @Override
  protected void _update() {
    display();

    checkClicksCombo();
  }

  private void display() {
    p.rectMode(c.CENTER);
    p.rect(x, y, w, h, radius);

    p.rectMode(c.CORNER);
    p.fill(0);
    p.textSize(13);
    p.textAlign(c.LEFT, c.TOP);
    if (student != null) {
      // p.text(
      //   student.toDisplayString(),
      //   x + padding,
      //   y + padding,
      //   w - doublePadding,
      //   h - doublePadding
      // );

      showName();
      showId();
      showDOB();
    }
  }

  private void showName() {
    p.textSize(12);
    p.text(student.toNameString(), str_x, name_y, str_x_end, str_h_max * 3);
  }

  private void showId() {
    p.textSize(14);
    p.text(student.toIdString(), str_x, id_y, str_x_end, str_h_max);
  }

  private void showDOB() {
    p.textSize(14);
    p.text(student.getDOBString(), str_x, dob_y, str_x_end, str_h_max);
  }

  private void checkClicksCombo() {
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
