package iPath;

import com.sun.xml.internal.bind.v2.runtime.reflect.Lister;
import model.Puck;
import utils2D.ScreenPoint;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.util.Map;
import utils2D.ScreenConverter;

public class Circle implements IPath {
    double angle;
    public Shape shape(double x, double y, double r) {
        return new Ellipse2D.Double(x - r, y - r, 2 * r, 2 * r);
    }

    public void doable(Graphics2D g, ScreenConverter sc, int rv, int rh,ScreenPoint pc){

        double x = 5* rv;
        double y =  5* rh;
        double r =  Math.min(x, y);
        g.draw(shape(pc.getI()-x, pc.getJ()-y, r));
        g.setColor(Color.red);
        x += r * Math.cos(angle);
        y += r * Math.sin(angle);
        r = Math.max(0.1*r, 5);
        // r = rv+rh;
        g.fill(shape((pc.getI()-x), pc.getJ()-y, r));
    }
    public void update(double dt){
        angle+=dt;

    }
    public int getN() {
        return  1;
    }
}
