package rpultra;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class UIMaster extends JFrame {
    private PlacementPanel placementPanel;

    public UIMaster() {
        this.setTitle("RPUltra");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);

        initComponents();
        addComponents();
        finaliseComponents();
    }

    private void initComponents() {
        panelMaster = new JPanel(new MigLayout());
        placementPanel = new PlacementPanel();
        buttonAddZone = new JButton("Add Zone");
        textFieldx = new JTextField("0");
        textFieldy = new JTextField("0");

        placementPanel.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
        placementPanel.addMouseListener(new PlacementPanelMouseAdapter());

        buttonAddZone.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                placementPanel.addRectangularZone(100, 100, 300, 300, Color.RED);
                placementPanel.addCircularZone( 400, 100, 50, Color.BLUE);
                refreshGraphics();
            }
        });


    }

    private void addComponents() {
        this.add(panelMaster);
        panelMaster.add(textFieldx, "width 100");
        panelMaster.add(textFieldy, "width 100");
        panelMaster.add(buttonAddZone, "wrap");
        panelMaster.add(placementPanel, "span 3, width 800, height 600");

    }

    private void finaliseComponents() {
        this.setVisible(true);
        this.pack();
    }

    static void refreshGraphics() {
        panelMaster.repaint();
        panelMaster.validate();
    }

    static void setCoordinates(int x, int y) {
        textFieldx.setText(Integer.toString(x));
        textFieldy.setText(Integer.toString(y));
        refreshGraphics();
    }

    private static JPanel panelMaster;
    private static JButton buttonAddZone;
    private static JTextField textFieldx;
    private static JTextField textFieldy;
}
