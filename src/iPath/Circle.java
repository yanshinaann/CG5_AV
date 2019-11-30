package iPath;

import model.Field;
import utils2D.ScreenPoint;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;

public class Circle implements IPath {
    double angle;

    public Shape shape(double x, double y, double r) {
        return new Ellipse2D.Double(x - r, y - r, 2 * r, 2 * r);
    }

    @Override
    public void drawPath(Graphics2D g, Field f, ScreenPoint tl, ArrayList<ScreenPoint> points) {

        g.setStroke(new BasicStroke(3f));
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.setColor(Color.WHITE);
        double w = f.getRectangle().getWidth();
        double h = f.getRectangle().getHeight();
        g.draw(shape((tl.getI() + w * 5 / 4), tl.getJ() + h * 5 / 4, tl.getI() - 6 * (w + h)));
        // g.drawOval((tl.getI())-w, tl.getJ()-h , h+h, w+w);

    }

    @Override
    public void update(double dt) {
        angle += dt;
    }

    @Override
    public ScreenPoint getStartPoint(Field f, ArrayList<ScreenPoint> sourcePoints) {
        ScreenPoint v2 = new ScreenPoint(0, 0);
        v2.setI((int)(f.getRectangle().getCenter().getX() + f.getRectangle().getCenter().getX() / 2 * Math.cos(angle)));
        v2.setJ((int)(f.getRectangle().getCenter().getY() + f.getRectangle().getCenter().getX() / 2 * Math.sin(angle)));

        return v2;
    }

    public int getN() {
        return 1;
    }
}
