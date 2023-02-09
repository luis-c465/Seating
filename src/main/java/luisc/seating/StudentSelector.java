package luisc.seating;

import luisc.lib.Obj;

/**
 * Handles the displaying updating of a list of students in the sidebar
 */
public class StudentSelector extends Obj {

  private static final int COLS = 2;

  private static final int ROWS = 15;

  public ClickableStudent[][] clickableStudents = new ClickableStudent[ROWS][COLS];

  @Override
  protected void _update() {
    for (ClickableStudent[] csl : clickableStudents) {
      for (ClickableStudent cs : csl) {
        cs.update();
      }
    }
  }

  public StudentSelector(App a) {
    super(a);
    for (int r = 0; r < ROWS; r++) {
      for (int c = 0; c < COLS; c++) {
        int studentIndex = (r * COLS) + c;
        clickableStudents[r][c] =
          new ClickableStudent(a, m.students.get(studentIndex), r, c);
      }
    }
  }
}
