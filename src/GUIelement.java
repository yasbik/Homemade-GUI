/**
 * A superclass for all User Interface Elements
 */
public abstract class GUIelement {
  
  //Six instance variables that all GUI elements need.
  // The GUI Element is anchored to a center point (x,y). 
  // Measurements of half the width and height are used to offset the sides of the element from the center. 
  protected double xCentre;
  protected double yCentre;
  // Half of the width and height. Offset the top and sides by this amount from the center point. 
  protected double halfWidth;
  protected double halfHeight;
  // Is the GUI currently highlighted? 
  protected boolean highlighted;
  // The string of text to print to the GUI
  protected String text;

  private boolean DEBUG_LOGS = true;

  //A normal constructor
  // Center X & Y corrdinates (in screenspace)
  // Positional offsets of sides (half the width and height)
  // The text string and whether or not the GUI element is highlighted. 
  public GUIelement(double new_xCentre, double new_yCentre, 
                    double new_halfWidth, double new_halfHeight,
                    String new_text, boolean new_highlighted) { 
    xCentre = new_xCentre;
    yCentre = new_yCentre;
    halfWidth = new_halfWidth;
    halfHeight = new_halfHeight;
    text = new_text;
    highlighted = new_highlighted;
  }

  //A no-parameters constructor that leaves everything at default values.
  public GUIelement(){ }
  
  //The basic draw() method will erase the rectanglular area, and then
  //outline it with a thin black box.
  public void draw(){ 
    // Draw the Background Color
    StdDraw.setPenColor(StdDraw.WHITE); // Sets the standard draw pen color to white
    StdDraw.filledRectangle(xCentre,yCentre,halfWidth,halfHeight); // draw a filledRectangle in white
    // Draw the outline box
    StdDraw.setPenColor(StdDraw.BLACK); // set the pen color to black
    StdDraw.setPenRadius(); //Set the pen radius to a Default thin line.
    StdDraw.rectangle(xCentre,yCentre,halfWidth,halfHeight); // Draw the outline
  }
  
  //All subclasses will need to know when a click is in the rectangle
  //for this particulat GUI element.
  public boolean handleClick(double x, double y) {
    boolean clickWithinVertical = false;
    boolean clickWithinHorizontal = false; 

    // The click is within the horizontal boundaries of the GUI element
    if((x >= xCentre-halfWidth) && (x <= xCentre+halfWidth) ){
      clickWithinHorizontal = true;
    }

    // The click is within the vertical boundaries of the GUI element
    if((y >= yCentre-halfHeight) && (y <= yCentre+halfHeight) ){
      clickWithinVertical = true;
    }

    // If debug mode is enabled, print a message when the click handler is triggered. 
    if( DEBUG_LOGS){ 
      System.out.println("handleClick in GUIElement at " + x + ":" + y + " vBounds: " + clickWithinVertical + " hBounds: " + clickWithinHorizontal);
    }

    return (clickWithinVertical && clickWithinHorizontal);
  }
  
  //Only textboxes will override this one.
  // This is listening for a typed character from a text input box
  public boolean handleCharTyped(char c){
    return false;
  }
  
  //Accessors
  // Is the button currently highlighted? 
  public boolean isHighlighted(){
    return highlighted;
  }
  
  // Return the text to print to the GUI
  public String getText(){
    return text;
  }
  
}//GUIelement
