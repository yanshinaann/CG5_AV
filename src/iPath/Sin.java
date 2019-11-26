package iPath;

import math.Vector2;
import model.Field;
import utils2D.ScreenPoint;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;

public class Sin implements IPath {
    private double angel;

    @Override
    public void update(double dt) {
        angel += dt;
    }

    //    private int Convert_X(double x, Field f)
//    {
//       // return (int)((f.getRectangle().getWidth()/2)+(x/(5*Pi/2))*(f.getRectangle().getWidth()/2));
//    }
//
//    private int Convert_Y(double x)
//    {
//       // return (int)((Hig/2)-(x/(1.5))*(Hig/2));
//    }
    @Override
    public void drawPath(Graphics2D g, Field f, ScreenPoint tl, ArrayList<ScreenPoint> points) {
//        double PrevX=f.getRectangle().getWidth()*(-2*Math.PI);
//        PrevY=Convert_Y(Math.sin(-2*Pi));
//
//
//        //рисуем саму синусоиду...
//        for (double delta=(-2*Math.PI); delta<=(2*Math.PI); delta+=(4*Math.PI/200))
//        {
//            double CurX=Convert_X(delta);
//            CurY=Convert_Y(Math.sin(delta));
//
//            g.drawLine(PrevX, PrevY, CurX, CurY);
//
//            PrevX=CurX;
//            PrevY=CurY;
//        }
    }

    @Override
    public Vector2 getStartPoint(Field f) {
        Vector2 v2 = new Vector2(0, 0);
        v2.setX(angel + (f.getRectangle().getLeft() + f.getRectangle().getWidth() * Math.sin(angel)));
        v2.setY((f.getRectangle().getWidth() / 2 - f.getRectangle().getHeight() / 4 * Math.sin(angel * 10)));
        if (isPoint(v2, f)) {
            angel = 0;
            // v2.setX(f.getRectangle().getRight()-f.getRectangle().getWidth()/2 * Math.sin(angel));
            // cnt = 0;
        }
        return v2;
    }

    public boolean isPoint(Vector2 v2, Field f) {
        if ((v2.getX() > f.getRectangle().getRight()) || (v2.getX() < f.getRectangle().getLeft())) {
            return true;
        }
        return false;
    }
}
