/**
 * A standard checkbox class
 * It Overrides GUIElement and listens for a click event
 * It can be in two states, either highlighted or not highlighted. 
 */
public class Checkbox extends GUIelement {
  
  // Text indent margin. 
  // The small distance from the right edge of the box to the label.
  private static final double MARGIN = 0.005;
  
  //Constructor
  // Give it the Center coordinates (Screenspace) , the size (its square), and the text for the label
  public Checkbox(double xCentre, double yCentre, double size, String newText) { 
    super(xCentre, yCentre, size, size, newText, false); // Create a square box . It's not highlighted to start with.
  }//constructor
  
  // Draw the Checkbox
  public void draw(){    
    // Outer Square
    StdDraw.setPenRadius(); //Make sure it's a standard narrow pen
    super.draw(); //Let the superclass draw the outer square

    // Draw the label
    StdDraw.textLeft(xCentre+halfWidth+MARGIN,yCentre,text); //Add the label

    // Highlighting
    if(highlighted) {
      //Draw two lines to make an X in the box.
      StdDraw.line(xCentre-halfWidth,yCentre+halfHeight,
                   xCentre+halfWidth,yCentre-halfHeight);
      StdDraw.line(xCentre-halfWidth,yCentre-halfHeight,
                   xCentre+halfWidth,yCentre+halfHeight);
    }//if
  }//draw
  
  // Listen for the checkbox to get clicked and deal with it. 
  public boolean handleClick(double x, double y) {
    // Check if the click is in the boundaries of the superclass method 
    if(!super.handleClick(x,y)) //The superclass method is always used first.
      return false; //Nothing to do with me. Not in my rectangle.
    else {
      highlighted = !highlighted; //Toggle the box's status
      draw(); //And redraw it.
      return true; //I handled it. Nobody else should.
    }//else
  }//handleClick

}//checkbox
