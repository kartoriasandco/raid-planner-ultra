package rpultra;

import java.awt.*;

public class Zone {
    static final int ZONE_TYPE_RECTANGLE = 0;
    static final int ZONE_TYPE_CIRCLE = 1;
    static final int ZONE_TYPE_TRIANGLE = 2;
    static final int ZONE_TYPE_POLYGON = 3;

    final Vertex[] vertices;
    final int zoneType;
    final Color colour;
    final int borderThickness;
    boolean display;

    public Zone(int zoneType, Vertex[] vertices, Color colour, int borderThickness) {
        this.zoneType = zoneType;
        this.vertices = vertices;
        this.colour = colour;
        this.borderThickness = (borderThickness < 0 ) ? 1 : borderThickness;
        display = true;

        switch (zoneType) {
            case ZONE_TYPE_RECTANGLE:
                if (vertices.length != 2) {
                    throw new RuntimeException("Rectangular zones must have exactly 4 vertices!");
                }
                break;
            case ZONE_TYPE_CIRCLE:
                if (vertices.length != 2) {
                    throw new RuntimeException("Circular zones must have exactly 2 vertices!");
                }
                break;
            case ZONE_TYPE_TRIANGLE:
                if (vertices.length != 3) {
                    throw new RuntimeException("Triangular zones must have exactly 3 vertices!");
                }
                break;
            case ZONE_TYPE_POLYGON:
                if (vertices.length < 4) {
                    throw new RuntimeException("Polygonal zones must have at least 4 vertices!");
                }
        }
    }
}
