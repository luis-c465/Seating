package luisc.seating;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import processing.core.PApplet;
import processing.core.PImage;

public class Student {

  public static final DateTimeFormatter dateParser = getDateInputFormatter();

  public String firstName;
  public String lastName;
  public String id;
  public int id_i;
  public LocalDate dob;
  public PImage img;

  @Override
  public String toString() {
    return (
      firstName + " " + lastName + " #" + id + " dob: " + dateParser.format(dob)
    );
  }

  public Student(PApplet p, String name, String id, String dob, String imgUrl) {
    String[] nameSplit = name.split(" ");

    this.firstName = nameSplit[0];
    this.lastName = nameSplit[1];
    this.id = id;
    this.id_i = Integer.parseInt(id);
    this.dob = LocalDate.from(dateParser.parse(dob));

    this.img = p.loadImage("students/" + imgUrl);
  }

  public Student(PApplet p, String... strings) {
    this(p, strings[0], strings[1], strings[2], strings[3]);
  }

  public static DateTimeFormatter getDateInputFormatter() {
    return new DateTimeFormatterBuilder()
      .parseCaseInsensitive()
      .parseLenient()
      .optionalStart()
      .appendValue(ChronoField.MONTH_OF_YEAR, 2)
      .appendLiteral("/")
      .appendValue(ChronoField.DAY_OF_MONTH, 2)
      .optionalEnd()
      .appendLiteral('/')
      .appendValue(ChronoField.YEAR_OF_ERA, 4) // 2 digit year not handled
      .toFormatter();
  }
}
