package rpultra;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PlacementPanelMouseAdapter extends MouseAdapter {
    boolean mousePressed = false;

    @Override
    public void mousePressed(MouseEvent me) {
        mousePressed = true;

        int x = me.getX();
        int y = me.getY();

        UIMaster.setCoordinates(x, y);
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        mousePressed = false;
    }
}
