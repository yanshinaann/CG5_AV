package model;


import iPath.Circle;
import iPath.IPath;
import math.Vector2;
import utils2D.ScreenConverter;
import utils2D.ScreenPoint;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.util.Timer;

/**
 * Класс, описывающий весь мир, в целом.
 *
 * @author Alexey
 */
public class World {
    private Puck p;
    private Field f;
    private ForceSource externalForce;
    IPath path = new Circle();

    public World(Puck p, Field f) {
        this.p = p;
        this.f = f;
        this.externalForce = new ForceSource(f.getRectangle().getCenter());
    }

    public void update(double dt) {
      path.update(dt);
    }

    public void draw(Graphics2D g, ScreenConverter sc) {
        g.setStroke(new BasicStroke(3f));
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        ScreenPoint pc = sc.r2s(p.getPosition());
        int rh = sc.r2sDistanceH(p.getR());
        int rv = sc.r2sDistanceV(p.getR());
        path.doable(g, sc, rv, rh, pc);
    }

    public Field getF() {
        return f;
    }

    public void setF(Field f) {
        this.f = f;
    }

    public Puck getP() {
        return p;
    }

    public void setP(Puck p) {
        this.p = p;
    }

    public ForceSource getExternalForce() {
        return externalForce;
    }
}