package luisc.seating;

import java.util.LinkedList;
import luisc.lib.Obj;

public class SeatsViewer extends Obj {

  public static String[] cols = { "A", "B", "C", "D", "E", "F" };

  @Override
  protected void _setup() {
    for (LinkedList<SeatViewer> list : m.seats) {
      for (SeatViewer studentViewer : list) {
        studentViewer.setup();
      }
    }
  }

  @Override
  protected void _update() {
    updateSeats();

    showRowsAndCols();
  }

  private void showRowsAndCols() {
    if (m.seats.sorted) {
      p.fill(a.gray, 150);
    }

    // Show Rows
    p.textSize(60);
    p.textAlign(c.CENTER);
    for (int row = 0; row < Seats.ROWS; row++) {
      int y = SeatViewer.margin_top + row * (110 + 10) + 20;

      p.text(Integer.toString(row), 20, y);
    }
    // Show cols

    for (int col = 0; col < Seats.COLS; col++) {
      int x = SeatViewer.margin_left + col * (105 + 10);

      p.text(cols[col], x, 380);
    }
  }

  private void updateSeats() {
    for (int r = 0; r < Seats.ROWS; r++) {
      LinkedList<SeatViewer> s = m.seats.get(r);
      for (int c = 0; c < Seats.COLS; c++) {
        SeatViewer seat = s.get(c);
        seat.row = r;
        seat.col = c;

        seat.update();
      }
    }
  }

  public SeatsViewer(App a) {
    super(a);
  }
}
