package luisc.seating;

import java.util.List;
import processing.core.PApplet;

public class StudentLoader {

  public static final String[][] students = {
    { "Luis Canada", "0392934", "08/05/20", "luis" },
    { "Bobby Hoel", "0294936", "04/09/01", "bobby" },
  };

  public static final void load(PApplet p, List<Student> list) {
    for (String[] str : students) {
      list.add(new Student(p, str));
    }
  }
}
