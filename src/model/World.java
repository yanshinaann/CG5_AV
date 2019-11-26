package model;


import iPath.IPath;
import iPath.Infinity;
import iPath.Points;
import iPath.Sin;
import math.Vector2;
import utils2D.ScreenConverter;
import utils2D.ScreenPoint;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;

/**
 * Класс, описывающий весь мир, в целом.
 *
 * @author Alexey
 */
public class World {
    private Puck p;
    private Field f;
    private ForceSource externalForce;
    private ScreenPoint sp;
    ArrayList<ScreenPoint> list; 
    //IPath path = new Circle();
 // IPath path = new Infinity();
    //IPath path = new Sin();
   IPath path = new Points();
    private double angle;

    public World(Puck p, Field f) {
        this.p = p;
        this.f = f;
        this.externalForce = new ForceSource(f.getRectangle().getCenter());
    }

    public void update(double dt) {
        //  p.setPosition(path.getStartPoint(f));
        // path.update(dt);

        path.update(dt);
        p.setPosition(path.getStartPoint(f));

    }

    public void draw(Graphics2D g, ScreenConverter sc) {
        g.setColor(Color.RED);
        ScreenPoint pc = sc.r2s(path.getStartPoint(f));
        // p.setPosition(path.getStartPoint(f));
        int rh = sc.r2sDistanceH(p.getR());
        int rv = sc.r2sDistanceV(p.getR());
        g.fillOval((pc.getI()), pc.getJ(), rh + rh, rv + rv);

        ScreenPoint tl = sc.r2s(f.getRectangle().getCenter());

//        ArrayList<ScreenPoint> soursePoints = new ArrayList<>();
//        soursePoints.add(0, new ScreenPoint(1, 100));
//        soursePoints.add(1, new ScreenPoint(200, 50));
//        soursePoints.add(2, new ScreenPoint(140, 60));

       // path.drawPath(g, f, tl, soursePoints);



//        g.setColor(Color.LIGHT_GRAY);
//        int w = sc.r2sDistanceH(f.getRectangle().getWidth());
//        int h = sc.r2sDistanceV(f.getRectangle().getHeight());
//        path.drawPath(g, sc, w, h, tl);


//g.drawOval((pc.getI() - rh), pc.getJ() - rv, rh + rh, rv + rv);
//
//        int angle = 0;
//        int r = Math.min(h / 4, w / 4);
//        g.fill(shape((h / 4 + r * Math.cos(angle)), (w / 4 + r * Math.sin(angle)), r / 6));


        // path.drawPath(g, sc, rv, rh, pc);
        // path.doable(g, sc, rv, rh, pc);
    }

    private Shape shape(double x, double y, double r) {
        return new Ellipse2D.Double(x - r, y - r, 2 * r, 2 * r);
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