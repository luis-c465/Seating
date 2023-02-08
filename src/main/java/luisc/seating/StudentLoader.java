package luisc.seating;

import java.util.List;
import processing.core.PApplet;

public class StudentLoader {

  // Btw the student ids and dob are randomized
  public static final String[] students = {
    "Leonardo Bain",
    "Luis Canada",
    "David Cuesta",
    "Paul Fabian",
    "Luis Flores",
    "Sebastian Franco",
    "Alexander Garcia",
    "Webster Geffrard",
    "Nicholas Henry",
    "Noah Hidalgo",
    "Robert Hoel",
    "Vernon Jones",
    "Silvia Lamas",
    "Anthony Lanuza",
    "Isabel Larenas",
    "Valerie Lee",
    "Adrian Morton",
    "Jorge Muguira",
    "Parrilla Matthew",
    "Oliver Perez",
    "Andrew Picon",
    "Lucas Ramos",
    "Christian Ravelo",
    "Noah Richards",
    "Kaleb Rodriguez",
    "Oakley Sever",
    "Yash Singh",
    "Alexander Tuero",
    "Aldrwin Urbina",
    "Jacob Wilgenbusch",
  };

  public static final void load(PApplet p, List<Student> list) {
    for (String str : students) {
      list.add(new Student(p, str));
    }
  }
}
