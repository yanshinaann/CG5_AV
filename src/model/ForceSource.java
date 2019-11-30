package model;

import math.ScreenPoints;

/**
 *
 * Класс, описывающий источник внешнего воздействия.
 * @author Alexey
 */
public class ForceSource {
    private ScreenPoints location;
    private double value;

    public ForceSource(ScreenPoints location) {
        this.location = location;
        value = 0;
    }

    public ScreenPoints getLocation() {
        return location;
    }

    public void setLocation(ScreenPoints location) {
        this.location = location;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    /**
     * Вычисляет вектор силы в заданной точке
     * @param p Точка, для которой производят вычисления
     * @return Вектор силы
     */
    public ScreenPoints getForceAt(ScreenPoints p) {
        if (Math.abs(value) < 1e-12)
            return new ScreenPoints(0, 0);
        return location.add(p.mul(-1)).normolized().mul(value);
    }
}