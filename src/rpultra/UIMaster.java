package rpultra;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import javax.swing.border.BevelBorder;

public class UIMaster extends JFrame {
    private PlacementPanel placementPanel;
    private ZoneManager zoneManager;

    public UIMaster() {
        this.setTitle("RPUltra");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);

        initComponents();
        addComponents();
        finaliseComponents();
    }

    private void initComponents() {
        panelLayoutTab = new JPanel(new MigLayout());
        panelRosterTab = new JPanel(new MigLayout());
        tabbedPaneMaster = new JTabbedPane(JTabbedPane.LEFT);
        placementPanel = new PlacementPanel();
        zoneManager = new ZoneManager();

        placementPanel.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
        placementPanel.addMouseListener(new PlacementPanelMouseAdapter());

    }

    private void addComponents() {
        this.add(tabbedPaneMaster);

        tabbedPaneMaster.addTab("Raid Layout", panelLayoutTab);
        tabbedPaneMaster.addTab("Roster", panelRosterTab);
    }

    private void initLayoutTab() {
        panelLayoutTab.add(zoneManager, "width 500");
        panelLayoutTab.add(placementPanel, "width 800, height 600");
    }

    private void initRosterTab() {

    }

    private void finaliseComponents() {
        this.setVisible(true);
        this.pack();
    }

    static void refreshGraphics() {
        panelLayoutTab.repaint();
        panelLayoutTab.validate();
    }

    static void setCoordinates(int x, int y) {
        refreshGraphics();
    }

    private static JPanel panelLayoutTab;
    private static JPanel panelRosterTab;
    private static JTabbedPane tabbedPaneMaster;
}
