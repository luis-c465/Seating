package luisc.lib;

import luisc.seating.App;
import processing.core.PShape;

public abstract class Btn extends Clickable {

  protected final int btn_safe = 10;

  protected String txt = "Click me!";
  protected int txt_size = 15;
  protected int c = 0xfffac83c;
  protected int txt_c = 0xffffffff;
  protected int radius = 25;

  protected boolean hasIcon = true;
  protected PShape icon;
  protected int icon_space = 70;
  protected int icon_size = 50;

  // ! Calculated in setup
  protected int icon_x;
  protected int icon_y;
  protected int txt_x;
  protected int txt_y;

  protected int icon_y_mod = 0;

  protected int txt_space = 10;

  public Btn(App app) {
    super(app);
  }

  protected void postSetup() {
    super.postSetup();
    setupIcon();
    setupText();
  }

  /**
   * Should be overridden by inheriting classes if needed
   * Icon should be setup here
   */
  protected abstract void _setup();

  protected void _update() {
    p.rectMode(p.CENTER);
    p.shapeMode(p.CENTER);

    p.fill(c);

    p.noStroke();
    p.rect(x, y, w, h, radius, radius, radius, radius);

    // Draw text
    p.textAlign(p.LEFT, p.CENTER);
    p.fill(txt_c);
    p.textSize(txt_size);
    p.text(txt, txt_x, y - 3);

    if (hasIcon) {
      p.shapeMode(p.CORNER);
      p.shape(icon, icon_x, icon_y, icon_size, icon_size);
    }
  }

  protected void setupIcon() {
    icon_x = x - w / 2;
    icon_y = y - h / 3;
  }

  protected void setupText() {
    txt_x = x - w / 6;
    txt_y = y + h / 2;
  }
}
