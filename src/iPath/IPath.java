package iPath;

import java.awt.*;
import java.util.ArrayList;

import model.Field;
import utils2D.ScreenPoint;

public interface IPath {
    void update(double dt);

    void drawPath(Graphics2D g, Field f, ScreenPoint tl, ArrayList<ScreenPoint> points);

    ScreenPoint getStartPoint(Field f, ArrayList<ScreenPoint> sourcePoints); //возвращает точку начала
}
