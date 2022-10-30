import java.util.ArrayList;

public class GUIgroup extends GUIelement {
    
    private ArrayList<GUIelement> guiElementList;

    public GUIgroup() {
        guiElementList = new ArrayList<GUIelement>();
    }

    // method to add element to the end of the list
    public void addElement(GUIelement element) {

        guiElementList.add(element);
    }

    @Override
    public void draw() {
        
        for (int i = 0; i < guiElementList.size(); i++) {
            guiElementList.get(i).draw();
        }
    }

    public boolean handleClick(double x, double y) {
        boolean result = false;

        for (int i = 0; i < guiElementList.size(); i++) {
            result = guiElementList.get(i).handleClick(x, y);

            if (result) {
                break;
            }
        }
        return result;
    }

    public boolean handleCharTyped(char c) {
        boolean result = false;

        for (int i = 0; i < guiElementList.size(); i++) {
            result = guiElementList.get(i).handleClick(x, y);

            if (result) {
                break;
            }
        }
        return result;
    }

    public void resetRadioButtons() {

        for (int i = 0; i < guiElementList.size(); i++) {
            if (guiElementList.get(i) instanceof RadioButton) {
                guiElementList.get(i).reset();
            }
        }
    }

}

