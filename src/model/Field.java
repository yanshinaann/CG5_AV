package model;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import math.Rectangle;
import utils2D.ScreenPoint;

import java.util.ArrayList;

/**
 *
 * Класс, описывающий прямоугольное поле.
 * @author Alexey
 */
public class Field {
    private Rectangle rectangle;
    private double mu, g;
    ArrayList<ScreenPoint> soursePoints = new ArrayList<>();

    public ArrayList<ScreenPoint> getSoursePoints() {
        return soursePoints;
    }

    public void setSoursePoints(ArrayList<ScreenPoint> soursePoints) {
        this.soursePoints = soursePoints;
    }

    /**
     * Создаёт игровое поле
     * @param rectangle Прямоугольник поля
     * @param mu Коэффициент трения
     * @param g Ускорение свободного падения
     */
    public Field(Rectangle rectangle, double mu, double g, ArrayList soursePoints) {
        this.rectangle = rectangle;
        this.mu = mu;
        this.g = g;
        this.soursePoints = soursePoints;
    }

    public double getG() {
        return g;
    }

    public void setG(double g) {
        this.g = g;
    }

    public double getMu() {
        return mu;
    }

    public void setMu(double mu) {
        this.mu = mu;
    }

    public Rectangle getRectangle() {
        return rectangle;
    }

    public void setRectangle(Rectangle rectangle) {
        this.rectangle = rectangle;
    }


}