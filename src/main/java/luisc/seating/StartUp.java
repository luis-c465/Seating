package luisc.seating;

import controlP5.ControlP5;
import controlP5.Textfield;
import luisc.lib.Btn;
import luisc.lib.Transitionable;
import processing.core.PApplet;

/**
 * Class which displays the startup screen
 * Shows 2 inputs for both players names
 */
public class StartUp extends Transitionable {

  private Textfield p1Name;
  private Textfield p2Name;
  private StartGameBtn startGameBtn;
  private static final String instructions =
    "Enter the names for Player 1 and Player 2";
  private static final int txt_y = 200;
  private String errors = "";

  // * DRAWING CONSTANTS
  private static final int num_w = 200;
  private static final int num_h = 50;
  private int num_x = App.cw - num_w / 2;
  private static final int num_gap = 100;
  private static final int num_bg_c = 0xff374151;
  private static final int num_txt_c = 0xffffffff;
  private static final int name_label_c = 0xff64748b;

  private static final int errors_c = 0xfff87171;
  private static final int vs_y = App.ch + 15;

  // Constants different for each input
  private int num_rows_y = App.ch - num_h - num_gap;
  private int num_cols_y = App.ch - num_h + num_gap;
  private int errors_y = App.ch + 150;

  @Override
  protected void _setup() {
    // done = true;

    p1Name =
      m.cp5
        .addTextfield("player1Name")
        .setPosition(num_x, num_rows_y)
        .setSize(num_w, num_h)
        .setFont(a.nunito_small)
        .setFocus(true)
        .setColor(num_txt_c)
        .setColorForeground(num_txt_c)
        .setColorBackground(num_bg_c)
        .setCaptionLabel("Player 1 Name")
        .setLabelVisible(true)
        .setColorCaptionLabel(name_label_c)
        .hide();

    p1Name
      .getCaptionLabel()
      .align(ControlP5.LEFT, ControlP5.BOTTOM_OUTSIDE)
      .setPaddingX(0)
      .setSize(15)
      .setFont(a.nunito_small);

    p2Name =
      m.cp5
        .addTextfield("player2Name")
        .setPosition(num_x, num_cols_y)
        .setSize(num_w, num_h)
        .setFont(a.nunito_small)
        .setColor(num_txt_c)
        .setColorForeground(num_txt_c)
        .setColorBackground(num_bg_c)
        .setCaptionLabel("Player 2 Name")
        .setLabelVisible(true)
        .setColorCaptionLabel(name_label_c)
        .hide();

    p2Name
      .getCaptionLabel()
      .align(ControlP5.LEFT, ControlP5.BOTTOM_OUTSIDE)
      .setPaddingX(0)
      .setSize(15)
      .setFont(a.nunito_small);

    startGameBtn = new StartGameBtn(m);
    startGameBtn.setup();
  }

  @Override
  protected void _update() {
    if (done) {
      p1Name.hide();
      p2Name.hide();
      paused = true;
      return;
    }

    p.imageMode(c.CORNER);
    p.image(a.rating, 0, 0, 800, Math.round(800 * 0.595));

    p.fill(a.error);
    p.text("this game is clearly finished", App.cw, App.ch);

    p.fill(255);

    // Else show the text boxes
    p1Name.show();
    p2Name.show();
    startGameBtn.update();

    // Show vs text
    p.textFont(a.nunito);
    p.textAlign(c.CENTER);
    p.fill(255);
    p.text("VS", m.cw, vs_y);

    // Show instructions
    p.textSize(30);
    p.text(instructions, App.cw, txt_y);

    // Show errors text
    p.textFont(a.nunito);
    p.textSize(20);
    p.textAlign(PApplet.CENTER);
    p.fill(errors_c);
    p.text(errors, App.cw, errors_y);

    checkBtns();
  }

  // Check is the button was clicked
  private void checkBtns() {
    if (startGameBtn.clicked) {
      m.p1Name = p1Name.getText();
      m.p2Name = p2Name.getText();

      errors = "";

      p1Name.remove();
      p2Name.remove();

      // Begin transitioning!
      trans = true;
    }
  }

  @Override
  protected void onTransOutBegin() {
    onDone();
  }

  private class StartGameBtn extends Btn {

    @Override
    public void _setup() {
      x = App.cw;
      y = 800;
      w = 200;

      txt = "Start Game";
      c = 0xff0ea5e9;
      txt_size = 20;
      txt_c = 255;
      txt_space = 30;

      icon = p.loadShape("play.svg");
      icon_space = 60;
      icon_y_mod = 5;
    }

    public StartGameBtn(App app) {
      super(app);
    }
  }

  public StartUp(App app) {
    super(app);
  }
}
