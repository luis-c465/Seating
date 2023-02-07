package luisc.seating;

import luisc.lib.Obj;

/**
 * Shows the score of both players and the current player turn
 * The currents players turn will be highlighted
 *
 * Also shows the names of both players and the pieces they are using
 */
public class Header extends Obj {

  public static final int safe = 10;
  public static final int gap = 50;
  public static final int h = 100;
  public static final int h_c = 50;

  public static final int score_x_l = App.cw - gap;
  public static final int score_x_r = App.cw + gap;

  public static final int name_y = 30;

  public static final int piece_x_l = gap;
  public static final int piece_x_r = App.w - gap;

  @Override
  protected void _setup() {}

  @Override
  protected void _update() {}

  public Header(App app) {
    super(app);
  }
}
