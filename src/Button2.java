public class Button2 extends GUIelement {

    private static final double BORDER_WIDTH = 0.006;

    private Handler handle;

    
    public Button2 ( double xCenterIn, double yCenterIn,
                    double halfWidthIn, double halfHeightIn, String title, Handler h) {

        super(xCenterIn, yCenterIn, halfWidthIn, halfHeightIn, title, false);

        handle = h;
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
        StdDraw.setPenRadius(BORDER_WIDTH);
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
            Utilities.waitMouseUp();
            highlighted = false;
            draw();

            if (handle != null) {
                handle.doIt();
            }
            return true;
        }
    }
}
