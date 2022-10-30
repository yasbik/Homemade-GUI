public class TextBox extends GUIelement {

    private static final double MARGIN = 0.005;

    private boolean isInput;

    public TextBox( double xCentreIn, double yCenterIn,
                    double halfWidthIn, double halfHeightIn,
                    String newText, boolean isInput) {

        super(xCentreIn, yCenterIn, halfWidthIn, halfHeightIn, newText, isInput);

        this.isInput = isInput;
    }

    public void draw() {
        // draw outline
        // StdDraw.setPenColor(StdDraw.BLACK);
        // StdDraw.setPenRadius();
        // StdDraw.rectangle(xCentre, yCentre, halfWidth, halfHeight);

        super.draw();

        StdDraw.textLeft((xCentre - halfWidth + MARGIN), yCentre, text);
    }

    // handle the mouse click
    public boolean handleClick(double x, double y) {
        // outside the radiobutton
        if (!super.handleClick(x, y)) {
            return false;
        }
        // inside the buttton
        else {
            if (isInput) {
                text = "";
                draw();
            }
            return true;
        }
    }

    // handle the mouse click
    public boolean handleCharTyped(char enteredChar) {
        if (isInput) {
            text += enteredChar;
            draw();
            return true;
        }
        else {
            return false;
        }
    }

    public void displayText(String outputString) {
        text = outputString;
        draw();
    }
}
