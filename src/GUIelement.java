public abstract class GUIelement {

  protected double xCentre;
  protected double yCentre;
  protected double halfWidth;
  protected double halfHeight;
  protected boolean highlighted;
  protected String text;

  private boolean DEBUG_LOGS = true;

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

  public GUIelement(){ }

  public void draw(){ 

    StdDraw.setPenColor(StdDraw.WHITE); 
    StdDraw.filledRectangle(xCentre,yCentre,halfWidth,halfHeight); 
    
    // Draw outline 
    StdDraw.setPenColor(StdDraw.BLACK); 
    StdDraw.setPenRadius(); 
    StdDraw.rectangle(xCentre,yCentre,halfWidth,halfHeight); 
  }
  

  public boolean handleClick(double x, double y) {
    boolean clickWithinVertical = false;
    boolean clickWithinHorizontal = false; 

    // check horizontal
    if((x >= xCentre-halfWidth) && (x <= xCentre+halfWidth) ){
      clickWithinHorizontal = true;
    }

    // check vertical
    if((y >= yCentre-halfHeight) && (y <= yCentre+halfHeight) ){
      clickWithinVertical = true;
    }

    // debugging 
    if( DEBUG_LOGS){ 
      System.out.println("handleClick in GUIElement at " + x + ":" + y + " vBounds: " + clickWithinVertical + " hBounds: " + clickWithinHorizontal);
    }

    return (clickWithinVertical && clickWithinHorizontal);
  }
  
  // This is listening for a typed character from a text input box
  public boolean handleCharTyped(char c){
    return false;
  }
  
  public boolean isHighlighted(){
    return highlighted;
  }
  
  public String getText(){
    return text;
  }
  
}
