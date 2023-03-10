package luisc.seating;

import controlP5.ControlP5;
import java.util.LinkedList;
import luisc.lib.BaseApp;
import luisc.lib.TransitionIn;
import luisc.lib.TransitionOut;

/**
 * Main class for the application
 */
public final class App extends BaseApp {

  // * VARIABLES
  public String p1Name = "";
  public String p2Name = "";

  public int p1Wins = 0;
  public int p2Wins = 0;

  public boolean doingIntro = true;
  public boolean doingStartUp = true;
  public boolean transitioning = false;
  public int numCols = -1;
  public int numRows = -1;
  public boolean paused = false;

  public long numDead = 0;
  public long numTicks = 0;

  // Should be calculated at runtime

  // * Util classes
  public Assets a = new Assets();

  // * luisc.seating.library classes
  public ControlP5 cp5;

  // Game classes
  public Header header = new Header(this);
  public StartUp startUp = new StartUp(this);
  public Intro intro = new Intro(this);
  public Sidebar sidebar = new Sidebar(this);
  public HelpModal helpModal = new HelpModal(this);

  public Seats seats = new Seats(this);
  public SeatsViewer seatsViewer = new SeatsViewer(this);
  public LinkedList<Student> students = new LinkedList<Student>();

  // Transition classes
  public TransitionIn transIn = new TransitionIn(this);
  public TransitionOut transOut = new TransitionOut(this);

  @Override
  public void setup() {
    frameRate(30);
    smooth();
    procSet();

    // Setup variables and assets
    a.setup(this);
    cp5 = new ControlP5(this);

    // Initialize box2d physics and create the world
    StudentLoader.load(this, students);
    // println(students);

    // println(seats);

    // SETUP CLASSES
    header.setup();
    intro.setup();
    startUp.setup();

    sidebar.setup();

    seatsViewer.setup();

    helpModal.setup();
    // Setup game classes
  }

  @Override
  public void draw() {
    background(bg);
    fill(255);

    intro.update();
    if (doingIntro) {
      return;
    }

    seatsViewer.update();
    sidebar.update();
    header.update();
    helpModal.update();
  }

  @Override
  public void mouseClicked() {
    helpModal.mouseClicked();
  }
}
