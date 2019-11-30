package model;


import iPath.*;
import math.ScreenPoints;
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

    public ArrayList<ScreenPoint> getSoursePoints() {
        return soursePoints;
    }

    public void setSoursePoints(ArrayList<ScreenPoint> soursePoints) {
        this.soursePoints = soursePoints;
    }

    private ScreenPoint sp;
    ArrayList<ScreenPoint> list;


    //IPath path = new Circle();
    //IPath path = new Infinity();
    //IPath path = new Sin();
    IPath path = new Points();
    brez brez = new brez();
    private double angle;
    ArrayList<ScreenPoint> soursePoints = new ArrayList<>();

    public World(Puck p, Field f) {
        this.p = p;
        this.f = f;
        this.externalForce = new ForceSource(f.getRectangle().getCenter());
        this.soursePoints = new ArrayList<>();

    }

    public void update(double dt) {
        //  p.setPosition(path.getStartPoint(f));
        // path.update(dt);

        path.update(dt);
        // p.setPosition(path.getStartPoint(f, sourcePoints));


    }

    public void draw(Graphics2D g, ScreenConverter sc) {


//        soursePoints.add(0, (new Vector2(7, 10)));
//        soursePoints.add(1, (new Vector2(3, 6)));
//        soursePoints.add(2, (new Vector2(4, 2)));
//        soursePoints.add(3, (new Vector2(3, 8)));
//        soursePoints.add(4, (new Vector2(2, 4)));

       // ArrayList<ScreenPoint> screenPoints = new ArrayList<>();

        // ScreenPoint tl = sc.r2s(f.getRectangle().getCenter());
        // path.drawPath(g, f, tl, soursePoints);
        brez.bezierGoGo(soursePoints, g);
        g.setColor(Color.RED);
        ScreenPoint v2 = path.getStartPoint(f, soursePoints);
        // ScreenPoint pc = sc.r2s(v2);
        // p.setPosition(path.getStartPoint(f));
        int rh = sc.r2sDistanceH(p.getR());
        int rv = sc.r2sDistanceV(p.getR());
        g.fillOval((v2.getI()), v2.getJ(), rh + rh, rv + rv);


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