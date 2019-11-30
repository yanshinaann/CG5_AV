package iPath;

import math.ScreenPoints;
import model.Field;
import utils2D.ScreenPoint;

import java.awt.*;
import java.util.ArrayList;

public class Points implements IPath {
    ArrayList<ScreenPoints> finalPoints = new ArrayList<>();
    ArrayList<ScreenPoint> sourcePoints = new ArrayList<>();
    //  ArrayList<ScreenPoint> fp;

    int dt;

    int i = 1;

    @Override
    public void update(double dt) {
        this.dt += dt;

    }

    public void drawPath(Graphics2D g, Field f, ScreenPoint tl, ArrayList<ScreenPoint> sourcePoints) {

    }

    public ArrayList<ScreenPoint> getFinalPoints(ArrayList<ScreenPoint> sourcePoints) {
        ArrayList<ScreenPoint> finalPoints = new ArrayList<>();
        for (double t = 0; t <= 1; t += 0.01)
            finalPoints.add(calculateBezierFunction(t, sourcePoints));
        return finalPoints;
    }


    @Override
    public ScreenPoint getStartPoint(Field f, ArrayList<ScreenPoint> sourcePoints) {
        ArrayList<ScreenPoint> fp = new ArrayList<>(getFinalPoints(sourcePoints));
        if (i < fp.size() - 1) i++;
        ScreenPoint v2 = new ScreenPoint(0, 0);
        // v2.setX(f.getRectangle().getCenter().getX() + f.getRectangle().getCenter().getX() / 2 * Math.cos(angle));
        // v2.setY(f.getRectangle().getCenter().getY() + f.getRectangle().getCenter().getX() / 2 * Math.sin(angle));

        // v2 = new Vector2(0, 0);

        int x1 = (int) (fp.get(i - 1).getI());
        int y1 = (int) (fp.get(i - 1).getJ());
        int x2 = (int) (fp.get(i).getI());
        int y2 = (int) (fp.get(i).getJ());
//            painter.drawLine(x1, y1, x2, y2);

        v2.setI(x1 + Math.abs(x2 - x1) * dt);
        v2.setJ(y1 + Math.abs(y2 - y1) * dt);


        return v2;
    }


    private ScreenPoint calculateBezierFunction(double t, ArrayList<ScreenPoint> srcPoints) {
        // ф-ия расчитывает очередную точку на кривой исходя из входного набора управляющих точек
        double x = 0;
        double y = 0;

        int n = srcPoints.size() - 1;
        for (int i = 0; i <= n; i++) {
            x += fact(n) / (fact(i) * fact(n - i)) * srcPoints.get(i).getI() * Math.pow(t, i) * Math.pow(1 - t, n - i);
            y += fact(n) / (fact(i) * fact(n - i)) * srcPoints.get(i).getJ() * Math.pow(t, i) * Math.pow(1 - t, n - i);
        }
        return new ScreenPoint((int) x, (int) y);
    }

    private double fact(double arg) {
        if (arg < 0) throw new RuntimeException("negative argument.");
        if (arg == 0) return 1;

        double rezult = 1;
        for (int i = 1; i <= arg; i++)
            rezult *= i;
        return rezult;
    }

    private void drawCurve(ArrayList<ScreenPoint> points) {

    }
}
