package iPath;

import java.awt.*;
import java.util.ArrayList;
import java.util.Map;

import math.Vector2;
import model.Field;
import utils2D.ScreenConverter;
import utils2D.ScreenPoint;

public interface IPath {
    void update(double dt);

    void drawPath(Graphics2D g, Field f, ScreenPoint tl, ArrayList<ScreenPoint> points);

    Vector2 getStartPoint(Field f); //возвращает точку начала
}
