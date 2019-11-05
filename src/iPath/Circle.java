package iPath;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.util.Map;

public class Circle implements IPath {

    public Shape shape(double x, double y, double r) {
        return new Ellipse2D.Double(x - r, y - r, 2 * r, 2 * r);
    }
}
