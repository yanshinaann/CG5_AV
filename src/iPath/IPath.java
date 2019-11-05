package iPath;

import java.awt.*;
import java.util.Map;
import utils2D.ScreenConverter;
import utils2D.ScreenPoint;

public interface IPath {
   Shape shape(double x, double y, double r) ;
   void doable(Graphics2D g, ScreenConverter sc, int rv, int rh, ScreenPoint pc);
   int getN();
   void update(double dt);
}
