package luisc.seating;

import luisc.lib.Obj;
import processing.core.PImage;

public class HelpModal extends Obj {

  public static final int rect_h = 70;
  public static final int rect_c = 0xff94a3b8;
  public static final int rect_w = 400;
  public static final int rect_r = 25;
  public static final int msg_size = 20;
  public static final String msg = "Press ENTER or click anywhere to exit";
  public static final int msg_c = 0xff7c3aed;
  public PImage img;
  public boolean show = false;
  public boolean beginShowing = false;

  @Override
  protected void _setup() {
    img = a.tutorial;
  }

  @Override
  protected void _update() {
    if (!show && !beginShowing) {
      return;
    }

    checkEsc();
    display();

    if (beginShowing) {
      beginShowing = false;
      show = true;
    }
  }

  private void display() {
    // Show the help img
    p.imageMode(c.CORNERS);
    p.image(img, 0, 0, App.w, App.h);

    // Then overlay clicking anywhere to exit or press esc
    p.fill(rect_c);
    p.rectMode(c.CORNER);
    p.rect(App.w - rect_w, App.h - rect_h, rect_w, rect_h, 5, 0, 0, 0);

    p.fill(msg_c);
    p.textSize(20);
    p.textAlign(c.LEFT, c.TOP);
    // p.text(msg, App.w - rect_w, App.h - rect_h, App.w - 5, App.h - 5);
    p.text(msg, App.w - rect_w + 5, App.h - rect_h + 5, rect_w - 5, rect_h);
  }

  private void checkEsc() {
    if (beginShowing) {
      return;
    }

    if (p.keyPressed && (p.key == p.RETURN || p.key == p.ENTER)) {
      show = false;
    }
  }

  public void mouseClicked() {
    if (!beginShowing && !m.header.helpBtn.hovered) {
      show = false;
    }
  }

  public HelpModal(App a) {
    super(a);
  }
}
