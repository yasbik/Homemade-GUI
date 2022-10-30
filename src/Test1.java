
public class Test1 {
  
  
  public static void main(String[] args) {
    
    //X coordinates of objects
    final double LEFT    = 0.2; 
    final double CENTRE  = 0.46; 
    final double RIGHT   = 0.6; 

    //Y coordinates of objects
    final double ROW1 = 0.8;  
    final double ROW2 = 0.65; 
    final double ROW3 = 0.5;  
    final double ROW4 = 0.37;
    final double ROW5 = 0.30; 
    final double ROW6 = 0.23; 
    final double ROW7 = 0.15; 
    
    final double BUTTON_HEIGHT = 0.04;
    final double BUTTON_WIDTH = 0.08;
    final double OPTION_SIZE = 0.02; 
    final double TEXTBOX_WIDTH = 0.38;
    final double TEXTBOX_HEIGHT = 0.05;
    
    GUIgroup allElements = new GUIgroup();
    GUIgroup leftSide = new GUIgroup();
    GUIgroup rightSide = new GUIgroup();

    allElements.addElement(leftSide);
    allElements.addElement(rightSide);
    
    // Buttons
    rightSide.addElement(new Button(RIGHT,ROW3,BUTTON_WIDTH,BUTTON_HEIGHT,"Right"));
    leftSide.addElement(new Button(LEFT,ROW3,BUTTON_WIDTH,BUTTON_HEIGHT,"Left"));

    // Checkbox 1
    rightSide.addElement(new Checkbox(RIGHT,ROW7,OPTION_SIZE,"R option"));

    // Radio Buttons
    rightSide.addElement(new RadioButton(RIGHT,ROW4,OPTION_SIZE,"R choice 1",true,rightSide));
    rightSide.addElement(new RadioButton(RIGHT,ROW5,OPTION_SIZE,"R choice 2",false,rightSide));
    rightSide.addElement(new RadioButton(RIGHT,ROW6,OPTION_SIZE,"R choice 3",false,rightSide));

    // Checkbox 2
    leftSide.addElement(new Checkbox(LEFT,ROW7,OPTION_SIZE,"L option"));

    // Radio Buttons 2
    leftSide.addElement(new RadioButton(LEFT,ROW4,OPTION_SIZE,"L choice 1",true,leftSide));
    leftSide.addElement(new RadioButton(LEFT,ROW5,OPTION_SIZE,"L choice 2",false,leftSide));
    leftSide.addElement(new RadioButton(LEFT,ROW6,OPTION_SIZE,"L choice 3",false,leftSide));

    // New Input TextBox
    allElements.addElement(new TextBox(CENTRE,ROW1,TEXTBOX_WIDTH,TEXTBOX_HEIGHT,"Input box",true));
    
    // Add new Output TextBox
    TextBox outbox;
    allElements.addElement(outbox = new TextBox(CENTRE,ROW2,TEXTBOX_WIDTH,TEXTBOX_HEIGHT,"Output box",false));
    
    // draw everything
    allElements.draw();


    int count = 0;
    while(true) {

      if(StdDraw.hasNextKeyTyped()){    
        char c = StdDraw.nextKeyTyped();
        allElements.handleCharTyped(c);
      } 
      else if(StdDraw.mousePressed()){  
        allElements.handleClick(StdDraw.mouseX(),StdDraw.mouseY());
        Utilities.waitMouseUp();

        // Display CLick counter
        outbox.displayText("Click "+(++count));
      }
      else
        Utilities.delay(); 
    }
  }

}
