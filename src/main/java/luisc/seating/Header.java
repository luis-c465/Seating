package luisc.seating;

import luisc.lib.Btn;
import luisc.lib.Obj;

/**
 * Shows a information about the program
 * and 6 buttons for sorting the list of students
 * Also shows a hel button on how to use the program
 */
public class Header extends Obj {

  public static final int safe = 10;
  public static final int margin_top = 10;
  public static final int h = 100;
  public static final String title = "Seating Chart";
  public static final String r_string = "Rows";
  public static final String c_string = "Cols";
  public static final int center = 700 / 2;
  public static final int bts_begin_y = 125;
  public static final int bts_begin_y_2 = bts_begin_y * 2 + 20;
  public static final int x1 = 200;
  public static final int x2 = 400;
  public static final int x3 = 600;

  public HelpBtn helpBtn;

  public RowsAlphabetical rowsAlphabetical;
  public RowsId rowsId;

  public ColsAlphabetical colsAlphabetical;
  public ColsId colsId;

  public DefaultSeat defaultSeat;

  @Override
  protected void _setup() {
    helpBtn = new HelpBtn(m);

    rowsAlphabetical = new RowsAlphabetical(m);
    rowsId = new RowsId(m);

    colsAlphabetical = new ColsAlphabetical(m);
    colsId = new ColsId(m);

    defaultSeat = new DefaultSeat(m);
  }

  @Override
  protected void _update() {
    showHeader();

    showRowsAndColsLabel();

    updateBtns();
  }

  private void showRowsAndColsLabel() {
    p.shapeMode(c.CORNER);
    p.textAlign(c.CORNER);
    p.textSize(30);
    p.text(r_string, safe, bts_begin_y);
    p.text(c_string, safe, bts_begin_y * 2 + safe);

    p.shape(a.rows, safe, bts_begin_y + 20, 40, 40);
    p.shape(a.columns, safe, bts_begin_y * 2 + 20 + safe, 40, 40);
  }

  private void showHeader() {
    p.textAlign(c.CENTER);
    p.text(title, center, 55);
  }

  private void updateBtns() {
    helpBtn.update();

    rowsAlphabetical.update();
    rowsId.update();

    colsAlphabetical.update();
    colsId.update();

    defaultSeat.update();
  }

  public class RowsAlphabetical extends Btn {

    @Override
    protected void _setup() {
      x = x1;
      y = bts_begin_y;

      txt = "Sort by name";
      icon = p.loadShape("sort-ascending-letters.svg");
    }

    @Override
    protected void onClick() {
      m.seats.rowsSortByName();
    }

    public RowsAlphabetical(App a) {
      super(a);
      setup();
    }
  }

  public class RowsId extends Btn {

    @Override
    protected void _setup() {
      x = x2;
      y = bts_begin_y;

      txt = "Sort by Id";
      icon = p.loadShape("sort-ascending-numbers.svg");
    }

    @Override
    protected void onClick() {
      m.seats.rowsSortById();
    }

    public RowsId(App a) {
      super(a);
      setup();
    }
  }

  public class RowsDefault extends Btn {

    @Override
    protected void _setup() {
      x = x3;
      y = bts_begin_y;

      txt = "Sort by seat";
      icon = p.loadShape("sort-ascending-2.svg");
    }

    @Override
    protected void onClick() {
      m.seats.rowsSortByDefault();
    }

    public RowsDefault(App a) {
      super(a);
      setup();
    }
  }

  public class ColsAlphabetical extends Btn {

    @Override
    protected void _setup() {
      x = x1;
      y = bts_begin_y_2;

      txt = "Sort by name";
      icon = p.loadShape("sort-ascending-letters.svg");
    }

    @Override
    protected void onClick() {
      m.seats.colsSortByName();
    }

    public ColsAlphabetical(App a) {
      super(a);
      setup();
    }
  }

  public class ColsId extends Btn {

    @Override
    protected void _setup() {
      x = x2;
      y = bts_begin_y_2;

      txt = "Sort by Id";
      icon = p.loadShape("sort-ascending-numbers.svg");
    }

    @Override
    protected void onClick() {
      m.seats.colsSortById();
    }

    public ColsId(App a) {
      super(a);
      setup();
    }
  }

  public class ColsDefault extends Btn {

    @Override
    protected void _setup() {
      x = x3;
      y = bts_begin_y_2;

      txt = "Sort by seat";
      icon = p.loadShape("sort-ascending-2.svg");
    }

    @Override
    protected void onClick() {
      m.seats.colsSortByDefault();
    }

    public ColsDefault(App a) {
      super(a);
      setup();
    }
  }

  public class DefaultSeat extends Btn {

    @Override
    protected void _setup() {
      x = x3;
      y = (bts_begin_y_2 + bts_begin_y) / 2;

      txt = "Sort by seat";
      icon = p.loadShape("sort-ascending-2.svg");
    }

    @Override
    protected void onClick() {
      m.seats.sortByNormal();
    }

    public DefaultSeat(App a) {
      super(a);
      setup();
    }
  }

  public Header(App app) {
    super(app);
  }
}
