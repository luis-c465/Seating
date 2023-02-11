package luisc.seating;

import luisc.lib.Btn;

public class HelpBtn extends Btn {

  @Override
  protected void _setup() {
    x = 650;
    y = 50;

    txt = "Help";
    icon = p.loadShape("help.svg");
    c = 0xff94a3b8;
  }

  @Override
  protected void onClick() {
    // p.println("Show the help modal here!");
    m.helpModal.beginShowing = true;
  }

  public HelpBtn(App a) {
    super(a);
    setup();
  }
}
