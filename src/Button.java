public class Button extends GUIelement {
    
    public Button ( double xCenterIn, double yCenterIn,
                    double halfWidthIn, double halfHeightIn, String title) {

                        super(xCenterIn, yCenterIn, halfWidthIn, halfHeightIn, title, false);
    }
    
    public void draw() {
        if (highlighted) {
            // draw light grey rectangle
            StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
            StdDraw.filledRectangle(xCentre, yCentre, halfWidth, halfHeight);
        }
        else {
            // draw white rectancle
            StdDraw.setPenColor(StdDraw.WHITE);
            StdDraw.filledRectangle(xCentre, yCentre, halfWidth, halfHeight);
        }

        // draw outline
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.setPenRadius();
        StdDraw.rectangle(xCentre, yCentre, halfWidth, halfHeight);
        StdDraw.text(xCentre, yCentre, text);
    }

    public boolean handleClick(double x, double y) {
        if (!super.handleClick(x, y)) {
            return false;
        }
        // inside the buttton
        else {
            // change highlight to true and reset the buttons
            highlighted = true;
            draw();
            highlighted = false;
            Utilities.waitMouseUp();
            draw();
            return true;
        }
    }
}
