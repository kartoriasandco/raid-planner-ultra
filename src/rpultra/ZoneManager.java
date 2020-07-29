package rpultra;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ZoneManager extends JPanel {
    private static ArrayList<Zone> zones;

    public ZoneManager() {
        super(new MigLayout());
        initComponents();
        addComponents();
        UIMaster.refreshGraphics();
        zones = new ArrayList<>();
    }

    private void initComponents() {
        panelZoneDetails = new JPanel(new MigLayout());
        buttonAddZone = new JButton("Add Zone");
        buttonDeleteZone = new JButton("Delete Zone");
        buttonAddVertex = new JButton("Add Vertex");
        buttonDeleteVertex = new JButton("Delete Vertex");
        tableZones = new JTable(new ZoneManagerTableModel());
        scrollPaneZones = new JScrollPane(tableZones);
        DefaultMutableTreeNode verticesRoot = new DefaultMutableTreeNode("Vertices:");
        treeVertices = new JTree(verticesRoot);
        scrollPaneVertices = new JScrollPane(treeVertices);
    }

    private void addComponents() {
        //this.add(panelZoneDetails, "wrap");
        this.add(new JScrollPane(tableZones), "grow");

        //panelZoneDetails.add(textFieldZoneName);
    }

    void addZone(Zone zone) {
        zones.add(zone);
        ZoneManagerTableModel tableModel = (ZoneManagerTableModel) tableZones.getModel();
        String zoneName = "Zone" + (zones.size() - 1);
    }

    private class ZoneAddedActionListener implements ActionListener {
        JButton button;

        public ZoneAddedActionListener(JButton button) {
            this.button = button;
        }

        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }

    private static JPanel panelZoneDetails;
    private static JScrollPane scrollPaneZones;
    private static JScrollPane scrollPaneVertices;
    private static JTable tableZones;
    private static JTree treeVertices;
    private static JButton buttonAddVertex;
    private static JButton buttonAddZone;
    private static JButton buttonDeleteZone;
    private static JButton buttonDeleteVertex;
}
