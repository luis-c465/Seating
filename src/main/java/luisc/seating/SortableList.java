package luisc.seating;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class SortableList extends LinkedList<LinkedList<SeatViewer>> {

  public static final Comparator<SeatViewer> nameSorter = new Comparator<SeatViewer>() {
    public int compare(SeatViewer a, SeatViewer b) {
      int first = a.student.firstName.compareTo(b.student.firstName);

      if (first != 0) {
        return first;
      }

      return a.student.lastName.compareTo(b.student.lastName);
    }
  };

  public static final Comparator<SeatViewer> idSorter = new Comparator<SeatViewer>() {
    public int compare(SeatViewer a, SeatViewer b) {
      return Integer.compare(a.student.id_i, b.student.id_i);
    }
  };

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
}
