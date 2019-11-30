package model;

import math.ScreenPoints;

/**
 *
 * Класс, описывающий шайбу.
 * @author Alexey
 */
public class Puck {
    private double m, r;
    private ScreenPoints position;
    private ScreenPoints velocity;
    private ScreenPoints acceleration;

    /**
     * Создаём шайбу с нулевой скоростью и ускорением
     * @param m Масса шайбы [кг]
     * @param r Радиус шайбы [м]
     * @param position Положение шайбы относительно начала координат [м]
     */
    public Puck(double m, double r, ScreenPoints position) {
        this.m = m;
        this.r = r;
        this.position = position;
        this.velocity = new ScreenPoints(0, 0);
        this.acceleration = new ScreenPoints(0, 0);
    }

    public ScreenPoints getAcceleration() {
        return acceleration;
    }

    public void setAcceleration(ScreenPoints acceleration) {
        this.acceleration = acceleration;
    }

    public double getM() {
        return m;
    }

    public void setM(double m) {
        this.m = m;
    }

    public ScreenPoints getPosition() {
        return position;
    }

    public void setPosition(ScreenPoints position) {
        this.position = position;
    }

    public double getR() {
        return r;
    }

    public void setR(double r) {
        this.r = r;
    }

    public ScreenPoints getVelocity() {
        return velocity;
    }

    public void setVelocity(ScreenPoints velocity) {
        this.velocity = velocity;
    }


}