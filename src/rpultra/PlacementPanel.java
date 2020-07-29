package rpultra;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class PlacementPanel extends JPanel {
    private ArrayList<Zone> zones;
    private BufferedImage biBackgroundImage;
    private int width;
    private int height;

    public PlacementPanel() {
        super(new MigLayout());
        width = 800;
        height = 600;
        biBackgroundImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        zones = new ArrayList<Zone>();
    }

    public PlacementPanel(Image backgroundImage) {
        super(new MigLayout());
        this.biBackgroundImage = (BufferedImage) backgroundImage;
        width = biBackgroundImage.getWidth();
        height = biBackgroundImage.getHeight();
    }

    void addRectangularZone(int x0, int y0, int x1, int y1, Color colour) {
        Vertex vertex0 = new Vertex(x0, y0); // upper-left
        Vertex vertex1 = new Vertex(x1, y1); // lower-right
        Vertex[] vertices = {vertex0, vertex1};
        zones.add(new Zone(Zone.ZONE_TYPE_RECTANGLE, vertices, colour, 3));
    }

    void addCircularZone(int x0, int y0, int radius, Color colour) {
        Vertex vertex0 = new Vertex(x0, y0);
        Vertex vertex1 = new Vertex(x0 + radius, y0);
        Vertex[] vertices = {vertex0, vertex1};
        zones.add(new Zone(Zone.ZONE_TYPE_CIRCLE, vertices, colour, 3));
    }

    void addTriangularZone(int x0, int y0, int x1, int y1, int x2, int y2, Color colour) {
        Vertex vertex0 = new Vertex(x0, y0);
        Vertex vertex1 = new Vertex(x1, y1);
        Vertex vertex2 = new Vertex(x2, y2);
        Vertex[] vertices = {vertex0, vertex1, vertex2};
        zones.add(new Zone(Zone.ZONE_TYPE_TRIANGLE, vertices, colour, 3));
    }

    void addPolygonalZone(int[] xCoords, int[] yCoords, Color colour) {
        if (xCoords.length != yCoords.length) {
            throw new RuntimeException("Quantity of x-coordinates and y-coordinates must be equal!");
        }

        Vertex[] vertices = new Vertex[xCoords.length];
        for (int i = 0; i < xCoords.length; ++i) {
            vertices[i] = new Vertex(xCoords[i], yCoords[i]);
        }

        zones.add(new Zone(Zone.ZONE_TYPE_POLYGON, vertices, colour, 3));
    }

    void setBackgroundImage(Image image) {
        biBackgroundImage = (BufferedImage) image;
    }

    BufferedImage getBackgroundImageAsBufferedImage() {
        return biBackgroundImage;
    }

//    private void drawBackground(BufferedImage bi) {
//        for (int x = 0; x < width; ++x) {
//            for (int y = 0; y < height; ++y) {
//                bi.setRGB();
//            }
//        }
//    }

    private void drawZone(Graphics g, BufferedImage bi, Zone zone) {
        switch (zone.zoneType) {
            case Zone.ZONE_TYPE_RECTANGLE:
                Vertex[] vertices = zone.vertices;
                int x0 = vertices[0].x;
                int y0 = vertices[0].y;
                int x1 = vertices[1].x;
                int y1 = vertices[1].y;
                int height = Math.abs(y1 - y0);
                int width = Math.abs(x1 - x0);

                Graphics2D g2d = (Graphics2D) g.create();

                // Set border thickness
                g2d.setStroke(new BasicStroke(zone.borderThickness));
                g2d.setColor(zone.colour);
                g2d.drawRect(x0, y0, width, height);

                // Fill rectangle with semi-transparent colour
                g2d.setColor(
                        new Color (
                                zone.colour.getRed(),
                                zone.colour.getGreen(),
                                zone.colour.getBlue(),
                                50
                        )
                );
                g2d.fillRect(x0, y0, width, height);
                break;
            case Zone.ZONE_TYPE_CIRCLE:
                vertices = zone.vertices;
                x0 = vertices[0].x;
                y0 = vertices[0].y;
                int radius = Math.abs(vertices[1].x - x0);

                g2d = (Graphics2D) g.create();

                // Set border thickness
                g2d.setStroke(new BasicStroke(zone.borderThickness));
                g2d.setColor(zone.colour);
                g2d.drawOval(x0, y0, radius, radius);

                // Fill circle with semi-transparent colour
                g2d.setColor(
                        new Color (
                                zone.colour.getRed(),
                                zone.colour.getGreen(),
                                zone.colour.getBlue(),
                                50
                        )
                );
                g2d.fillOval(x0, y0, radius, radius);
                break;
            case Zone.ZONE_TYPE_TRIANGLE:
                vertices = zone.vertices;

                g2d = (Graphics2D) g.create();

                // Set border thickness
                g2d.setStroke(new BasicStroke(zone.borderThickness));
                g2d.setColor(zone.colour);

                //TODO

                break;
            case Zone.ZONE_TYPE_POLYGON:

        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(biBackgroundImage, 0, 0, null);

        for (Zone zone : zones) {
            if (zone.display) {
                drawZone(g, biBackgroundImage, zone);
            }
        }
    }

    private class PlacementPanelMouseAdapter extends MouseAdapter {
        @Override
        public void mousePressed(MouseEvent me) {

        }
    }
}
