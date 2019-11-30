package iPath;

import utils2D.ScreenPoint;

import java.awt.*;
import java.util.ArrayList;

public class brez {


    public void bezierGoGo(ArrayList<ScreenPoint> sourcePoints, Graphics painter) {
        // ф-ия расчитывает финальный набор точек, по которым будет строится кривуля, а затем рисует ее
        ArrayList<ScreenPoint> finalPoints = new ArrayList<>();

        for (double t = 0; t <= 1; t += 0.01)
            finalPoints.add(calculateBezierFunction(t, sourcePoints));
        drawCurve(finalPoints, painter);
    }

    private ScreenPoint calculateBezierFunction(double t, ArrayList<ScreenPoint> srcPoints) {   // ф-ия расчитывает очередную точку на кривой исходя из входного набора управляющих точек
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

    private void drawCurve(ArrayList<ScreenPoint> points, Graphics painter) {
        for (int i = 1; i < points.size(); i++) {
            int x1 = (int) (points.get(i - 1).getI());
            int y1 = (int) (points.get(i - 1).getJ());
            int x2 = (int) (points.get(i).getI());
            int y2 = (int) (points.get(i).getJ());

            painter.drawLine(x1, y1, x2, y2);
        }
    }
}
