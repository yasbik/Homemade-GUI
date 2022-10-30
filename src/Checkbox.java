
public class Checkbox extends GUIelement {
  

  private static final double MARGIN = 0.005;
  
  public Checkbox(double xCentre, double yCentre, double size, String newText) { 
    super(xCentre, yCentre, size, size, newText, false); 
  }
  
  // Draw the Checkbox
  public void draw() {    
    // Outer Square
    StdDraw.setPenRadius(); 
    super.draw();

    // Draw the label
    StdDraw.textLeft(xCentre+halfWidth+MARGIN,yCentre,text);

    // Highlighting
    if(highlighted) {
      StdDraw.line(xCentre-halfWidth,yCentre+halfHeight,
                   xCentre+halfWidth,yCentre-halfHeight);
      StdDraw.line(xCentre-halfWidth,yCentre-halfHeight,
                   xCentre+halfWidth,yCentre+halfHeight);
    }
  }
  
  public boolean handleClick(double x, double y) {

    if(!super.handleClick(x,y)) 
      return false;
    else {
      highlighted = !highlighted; 
      draw(); 
      return true; 
    }
  }

}