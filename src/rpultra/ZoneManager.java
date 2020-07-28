package rpultra;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class ZoneManager extends JPanel {
    private final String[] ZONE_COLUMN_NAMES = {
            "Name",
            "Icon",
            "Colour",
            "Vertices"
    };
    private ArrayList<Zone> zones;

    public ZoneManager() {
        super(new MigLayout());
        initComponents();
        addComponents();
        UIMaster.refreshGraphics();
        zones = new ArrayList<>();
    }

    private void initComponents() {
        panelZoneDetails = new JPanel(new MigLayout());
        buttonNewZone = new JButton("New");
        buttonDeleteZone = new JButton("Delete");
        tableZones = new JTable(null, ZONE_COLUMN_NAMES);
    }

    private void addComponents() {
        this.add(panelZoneDetails, "wrap");
        this.add(tableZones);

        panelZoneDetails.add(textFieldZoneName);
    }

    private static JPanel panelZoneDetails;
    private static JTable tableZones;
    private static JTextField textFieldZoneName;
    private static JTextField textFieldZoneX;
    private static JTextField textFieldZoneY;
    private static JButton buttonNewZone;
    private static JButton buttonDeleteZone;
}
