import java.util.ArrayList;

public class GUIgroup extends GUIelement {
    
    ArrayList<GUIelement> guiElementList;

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
            super.draw();

        }
    }


}

