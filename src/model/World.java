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
 *
 * Класс, описывающий весь мир, в целом.
 * @author Alexey
 */
public class World {
    private Puck p;
    private Field f;
    private ForceSource externalForce;
    private double angle;

    public World(Puck p, Field f) {
        this.p = p;
        this.f = f;
        this.externalForce = new ForceSource(f.getRectangle().getCenter());
    }

    /**
     * Метод обновления состояния мира за указанное время
     * @param dt Промежуток времени, за который требуется обновить мир.
     */
    public void update(double dt) {

        angle += dt;

//        Vector2 np = p.getPosition()
//                .add(p.getVelocity().mul(dt))
//                .add(p.getAcceleration().mul(dt*dt*0.5));
//        Vector2 nv = p.getVelocity()
//                .add(p.getAcceleration().mul(dt));
//
//        double vx = nv.getX(), vy = nv.getY();
//        boolean reset = false;
//        if (np.getX() - p.getR() < f.getRectangle().getLeft() || np.getX() + p.getR() > f.getRectangle().getRight()) {
//            vx = -vx;
//            reset = true;
//        }
//        if (np.getY() - p.getR() < f.getRectangle().getBottom() || np.getY() + p.getR() > f.getRectangle().getTop()) {
//            vy = -vy;
//            reset = true;
//        }
//        nv = new Vector2(vx, vy);
//        if (nv.length() < 1e-10)
//            nv = new Vector2(0, 0);
//        if (reset)
//            np = p.getPosition();
//
//        Vector2 Fvn = externalForce.getForceAt(np);
//        Vector2 Ftr = p.getVelocity().normolized().mul(-f.getMu()*p.getM()*f.getG());
//        Vector2 F = Ftr.add(Fvn);
//
//        p.setAcceleration(F.mul(1/p.getM()));
//        p.setVelocity(nv);
//        p.setPosition(np);
    }

    /**
     * Метод рисует ткущее состояние мира.
     * На самом деле всю логику рисования стоит вынести из этого класса
     * куда-нибудь в WroldDrawer, унаследованный от IDrawer
     * @param g Графикс, на котором надо нарисовать текущее состояние.
     * @param sc Актуальный конвертер координат.
     */
    public void draw(Graphics2D g, ScreenConverter sc, IPath path) {
        path = new Circle();
        ScreenPoint tl = sc.r2s(f.getRectangle().getTopLeft());
        int w = sc.r2sDistanceH(f.getRectangle().getWidth());
        int h = sc.r2sDistanceV(f.getRectangle().getHeight());
        g.setColor(Color.lightGray);
        g.fillRect(tl.getI(), tl.getJ(), w, h);
        g.setColor(Color.blue);
        Graphics2D g2d = (Graphics2D) g;
        //g2d.setStroke(new BasicStroke(3f));
       //g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        ScreenPoint pc = sc.r2s(p.getPosition());
        int rh = sc.r2sDistanceH(p.getR());
        int rv = sc.r2sDistanceV(p.getR());
        double x = 5* rv;
        double y =  5* rh;
        double r =  Math.min(x, y);
        g2d.draw(path.shape(pc.getI()-x, pc.getJ()-y, r));
        g2d.setColor(Color.red);
        x += r * Math.cos(angle);
        y += r * Math.sin(angle);
       r = Math.max(0.1*r, 5);
       // r = rv+rh;
        g2d.fill(path.shape((pc.getI()-x), pc.getJ()-y, r));
//        ScreenPoint tl = sc.r2s(f.getRectangle().getTopLeft());
//        int w = sc.r2sDistanceH(f.getRectangle().getWidth());
//        int h = sc.r2sDistanceV(f.getRectangle().getHeight());
//        g.setColor(Color.WHITE);
//        g.fillRect(tl.getI(), tl.getJ(), w, h);
//        g.setColor(Color.RED);
//        g.drawRect(tl.getI(), tl.getJ(), w, h);
//        ScreenPoint pc = sc.r2s(p.getPosition());
//        int rh = sc.r2sDistanceH(p.getR());
//        int rv = sc.r2sDistanceV(p.getR());
//        g.setColor(Color.BLACK);
//        g.fillOval(pc.getI() - rh, pc.getJ() - rv, rh + rh, rv + rv);
//
//        g.drawString(String.format("Mu=%.2f", f.getMu()), 10, 30);
//        g.drawString(String.format("F=%.0f", externalForce.getValue()), 10, 50);
    }
//    private Shape circle(double x, double y, double r) {
//        return new Ellipse2D.Double(x - r, y - r, 2 * r, 2 * r);
//    }
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