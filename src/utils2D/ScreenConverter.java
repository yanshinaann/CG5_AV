package utils2D;

import math.Rectangle;
import math.ScreenPoints;

public class ScreenConverter {
    private double xr, yr, wr, hr;
    private int ws, hs;

    /**
     * Создаёт новый конвертер с заданными параметрами
     * @param xr x-составляющая координаты левого верхнего угла реального прямоугольника
     * @param yr y-составляющая координаты левого верхнего угла реального прямоугольника
     * @param wr ширина реального прямоугольника
     * @param hr высота рального прямоугольника
     * @param ws ширина экранного прямоугольника
     * @param hs высота реального прямоугольника
     */
    public ScreenConverter(double xr, double yr, double wr, double hr, int ws, int hs) {
        this.xr = xr;
        this.yr = yr;
        this.wr = wr;
        this.hr = hr;
        this.ws = ws;
        this.hs = hs;
    }

    public ScreenConverter(Rectangle real, int width, int height) {
        this(real.getLeft(), real.getHeight(), real.getWidth(), real.getHeight(), width, height);
    }

    /**
     * Метод преобразует реальные координаты в экранные
     * @param p Точка в реальных координатах
     * @return Точка в экранных координатах.
     */
    public ScreenPoint r2s(ScreenPoints p) {
        int i = (int)((p.getX() - xr)*ws/wr);
        int j = (int)((yr - p.getY())*hs/hr);
        return new ScreenPoint(i, j);
    }

    /**
     * Метод пробразует экранные координаты в реальные
     * @param p Точка в экранных координатах
     * @return Точка в реальных координатах
     */
    public ScreenPoints s2r(ScreenPoint p) {
        double x = xr + p.getI()*wr/ws;
        double y = yr - p.getJ()*hr/hs;
        return new ScreenPoints(x, y);
    }

    /**
     * Преобразует расстояние из реальной системы координат в экранные воль горизонтальной оси.
     * @param d Расстояние в реальных единицах
     * @return Количество пикселей
     */
    public int r2sDistanceH(double d) {
        /*Можно написать проще*/
        return r2s(new ScreenPoints(d, 0)).getI() - r2s(new ScreenPoints(0, 0)).getI();
    }

    /**
     * Преобразует расстояние из реальной системы координат в экранные воль вертикальной оси.
     * @param d Расстояние в реальных единицах
     * @return Количество пикселей
     */
    public int r2sDistanceV(double d) {
        /*Можно написать проще*/
        return r2s(new ScreenPoints(0, 0)).getJ() - r2s(new ScreenPoints(0, d)).getJ();
    }

    public double getHr() {
        return hr;
    }

    public void setHr(double hr) {
        this.hr = hr;
    }

    public int getHs() {
        return hs;
    }

    public void setHs(int hs) {
        this.hs = hs;
    }

    public double getWr() {
        return wr;
    }

    public void setWr(double wr) {
        this.wr = wr;
    }

    public int getWs() {
        return ws;
    }

    public void setWs(int ws) {
        this.ws = ws;
    }

    public double getXr() {
        return xr;
    }

    public void setXr(double xr) {
        this.xr = xr;
    }

    public double getYr() {
        return yr;
    }

    public void setYr(double yr) {
        this.yr = yr;
    }




}
