public class RadioButton extends GUIelement {
    
    private GUIgroup tracker;
    private static final double MARGIN = 0.005;
    
    // constructor
    public RadioButton( double xCenterIn, double yCenterIn, 
                        double radius, String title, 
                        boolean setHighlight, GUIgroup group) {

        super(xCenterIn, yCenterIn, radius, radius, title, setHighlight);
        tracker = group;
    }

    // method to draw a hollow circle
    public void draw() {
        // draw solid white circle
        StdDraw.setPenColor(StdDraw.WHITE);
        StdDraw.filledCircle(xCentre, yCentre, halfWidth);
        
        // draw outline
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.setPenRadius();
        StdDraw.circle(xCentre, yCentre, halfWidth);

        StdDraw.textLeft((xCentre + halfWidth + MARGIN), yCentre, text);

        if (highlighted) {
            StdDraw.setPenColor(StdDraw.BLACK);
            StdDraw.filledCircle(xCentre, yCentre, (halfWidth - MARGIN));
        }
    }

    // reset the buttons
    public void reset() {
        highlighted = false;
        draw();
    }

    // handle the mouse click
    public boolean handleClick(double x, double y) {
        // outside the radiobutton
        if (!super.handleClick(x, y)) {
            return false;
        }
        // inside the buttton
        else {
            // change highlight to true and reset the buttons
            tracker.resetRadioButtons();
            highlighted = true;
            draw();
            return true;
        }
    }

}
