package iPath;

import model.Field;
import utils2D.ScreenPoint;

import java.awt.*;
import java.util.ArrayList;

public class Infinity implements IPath {
    private double angel;
    ScreenPoint v2 = new ScreenPoint(0, 0);
    double p =0;

    @Override
    public void update(double dt) {
        angel += dt;
    }

    @Override
    public void drawPath(Graphics2D g, Field f, ScreenPoint tl, ArrayList<ScreenPoint> points) {

    }

    @Override
    public ScreenPoint getStartPoint(Field f, ArrayList<ScreenPoint> sourcePoints) {
        //  Vector2 v2 = new Vector2(0, 0);

        double c = 3.5;
       // double p =0;

       p= Math.sqrt(Math.tan(Math.PI / 4 -angel));
       if (Double.isNaN(p)) {
           p = Math.sqrt(Math.tan(Math.PI / 4 + angel+Math.PI/2));
           v2.setI((int)(f.getRectangle().getCenter().getX() + c * Math.sqrt(2) * (p + Math.pow(p, 3)) / (1 + Math.pow(p, 4))));
       } else {
           p= Math.sqrt(Math.tan(Math.PI / 4 +angel));
           v2.setJ((int)(f.getRectangle().getCenter().getX() - c * Math.sqrt(2) * (p + Math.pow(p, 3)) / (1 + Math.pow(p, 4))));
       }

        if (v2.getI() < f.getRectangle().getCenter().getX())
            v2.setJ((int)(f.getRectangle().getCenter().getX() - c * Math.sqrt(2) * (p + Math.pow(p, 3)) / (1 + Math.pow(p, 4))));
        else
            v2.setI((int)(f.getRectangle().getCenter().getX() + c * Math.sqrt(2) * (p + Math.pow(p, 3)) / (1 + Math.pow(p, 4))));
        v2.setJ((int)(3+c * Math.sqrt(2) * (p - Math.pow(p, 3)) / (1 + Math.pow(p, 4))));




        // v2.setX(f.getRectangle().getCenter().getX() + f.getRectangle().getCenter().getX() / 2 * Math.cos(angle));
        //  v2.setY(f.getRectangle().getCenter().getY() + f.getRectangle().getCenter().getX() / 2 * Math.sin(angle));
        return v2;
    }
}
//сделать движение по точкам задаем точки и коэф сглаженности
//сделать нормальную бесконечность
//учитывать скорость