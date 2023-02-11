package luisc.seating;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Seats extends LinkedList<LinkedList<SeatViewer>> {

  public static final int COLS = 6;

  public static final int ROWS = 5;

  public boolean sorted = false;

  public static final Comparator<SeatViewer> nullSorter = new Comparator<SeatViewer>() {
    public int compare(SeatViewer a, SeatViewer b) {
      if (a == null && b == null) {
        return 1;
      } else if (a == null) {
        return 1;
      } else if (b == null) {
        return -1;
      }

      if (a.student == null && b.student == null) {
        return 1;
      } else if (a.student == null) {
        return 1;
      } else if (b.student == null) {
        return -1;
      }

      return 0;
    }
  };

  public static final Comparator<SeatViewer> defaultSorter = new Comparator<SeatViewer>() {
    public int compare(SeatViewer a, SeatViewer b) {
      int temp = Integer.compare(a.default_col, b.default_col);
      if (temp != 0) {
        return temp;
      }
      return Integer.compare(a.default_row, b.default_row);
    }
  };

  public static final Comparator<SeatViewer> nameSorter = new Comparator<SeatViewer>() {
    public int compare(SeatViewer a, SeatViewer b) {
      int tmp = nullSorter.compare(a, b);
      if (tmp != 0) {
        return tmp;
      }

      int last = a.student.lastName.compareTo(b.student.lastName);

      if (last != 0) {
        return last;
      }

      return a.student.firstName.compareTo(b.student.firstName);
    }
  };

  public static final Comparator<SeatViewer> idSorter = new Comparator<SeatViewer>() {
    public int compare(SeatViewer a, SeatViewer b) {
      int tmp = nullSorter.compare(a, b);
      if (tmp != 0) {
        return tmp;
      }

      return Integer.compare(a.student.id_i, b.student.id_i);
    }
  };

  public void rowsSortByDefault() {
    for (List<SeatViewer> l : this) {
      Collections.sort(l, defaultSorter);
    }

    sorted = true;
  }

  public void rowsSortByName() {
    for (List<SeatViewer> l : this) {
      Collections.sort(l, nameSorter);
    }
    // for (int r = 0; r < ROWS; r++) {
    //   LinkedList<SeatViewer> ref = this.get(r);
    //   Collections.sort(ref, nameSorter);
    //   this.set(r, ref);
    // }

    sorted = true;
  }

  public void rowsSortById() {
    for (List<SeatViewer> l : this) {
      Collections.sort(l, idSorter);
    }
    sorted = true;
  }

  public void colsSortByName() {
    for (int c = 0; c < COLS; c++) {
      sortbyColumn(c, nameSorter);
    }
    sorted = true;
  }

  public void colsSortById() {
    for (int c = 0; c < COLS; c++) {
      sortbyColumn(c, idSorter);
    }
    sorted = true;
  }

  public void colsSortByDefault() {
    for (int c = 0; c < COLS; c++) {
      sortbyColumn(c, defaultSorter);
    }
    sorted = true;
  }

  public void sortByNormal() {
    // for (LinkedList<SeatViewer> seats : this) {
    //   for (SeatViewer seat : seats) {
    //     seat.row = seat.default_row;
    //     seat.col = seat.default_col;
    //   }
    // }
    rowsSortByDefault();
    colsSortByDefault();

    sorted = false;
  }

  public void sortbyColumn(int col, Comparator<SeatViewer> c) {
    List<SeatViewer> column = new ArrayList<>();
    for (List<SeatViewer> row : this) {
      column.add(row.get(col));
    }
    Collections.sort(column, c);

    int index = 0;
    for (List<SeatViewer> row : this) {
      row.set(col, column.get(index++));
    }
  }

  public Seats(App p) {
    super();
    // Add 3 rows to the program
    for (int r = 0; r < ROWS; r++) {
      LinkedList<SeatViewer> seats = new LinkedList<SeatViewer>();
      for (int c = 0; c < COLS; c++) {
        seats.add(new SeatViewer(p, r, c));
      }

      this.add(seats);
    }
  }

  @Override
  public String toString() {
    Iterator<LinkedList<SeatViewer>> it = iterator();
    if (!it.hasNext()) return "[]";

    StringBuilder sb = new StringBuilder();
    sb.append('[');
    for (;;) {
      LinkedList<SeatViewer> e = it.next();
      sb.append(e);
      if (!it.hasNext()) return sb.append(']').toString();
      sb.append(',').append('\n');
    }
  }
}
