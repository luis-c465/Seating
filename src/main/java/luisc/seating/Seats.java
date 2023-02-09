package luisc.seating;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Seats extends LinkedList<LinkedList<SeatViewer>> {

  private static final int COLS = 10;

  private static final int ROWS = 3;

  public static final Comparator<SeatViewer> defaultSorter = new Comparator<SeatViewer>() {
    public int compare(SeatViewer a, SeatViewer b) {
      if (a == null) {
        return -1;
      } else if (b == null) {
        return 1;
      }

      if (a.student == null) {
        return -1;
      } else if (b.student == null) {
        return 1;
      }

      return Integer.compare(a.col, b.col);
    }
  };

  public static final Comparator<SeatViewer> nameSorter = new Comparator<SeatViewer>() {
    public int compare(SeatViewer a, SeatViewer b) {
      if (a == null) {
        return -1;
      } else if (b == null) {
        return 1;
      }

      int first = a.student.firstName.compareTo(b.student.firstName);

      if (first != 0) {
        return first;
      }

      return a.student.lastName.compareTo(b.student.lastName);
    }
  };

  public static final Comparator<SeatViewer> idSorter = new Comparator<SeatViewer>() {
    public int compare(SeatViewer a, SeatViewer b) {
      if (a == null) {
        return -1;
      } else if (b == null) {
        return 1;
      }

      return Integer.compare(a.student.id_i, b.student.id_i);
    }
  };

  public void rowsSortByDefault() {
    for (List<SeatViewer> l : this) {
      Collections.sort(l, defaultSorter);
    }
  }

  public void rowsSortByName() {
    for (List<SeatViewer> l : this) {
      Collections.sort(l, nameSorter);
    }
  }

  public void rowsSortById() {
    for (List<SeatViewer> l : this) {
      Collections.sort(l, idSorter);
    }
  }

  public void colsSortByName() {
    int cols = this.get(0).size();
    for (int c = 0; c < cols; c++) {
      sortbyColumn(c, nameSorter);
    }
  }

  public void colsSortById() {
    int cols = this.get(0).size();
    for (int c = 0; c < cols; c++) {
      sortbyColumn(c, idSorter);
    }
  }

  public void sortbyColumn(int col, Comparator<SeatViewer> c) {
    // Using built-in sort function Arrays.sort
    Collections.sort(
      this,
      new Comparator<List<SeatViewer>>() {
        @Override
        // Compare values according to columns
        public int compare(
          final List<SeatViewer> l1,
          final List<SeatViewer> l2
        ) {
          return c.compare(l1.get(col), l2.get(col));
        }
      }
    ); // End of function call sort().
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
