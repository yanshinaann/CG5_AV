/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package math;

/**
 *
 * Описывает координаты реальной точки.
 * @author Alexey
 */
public class ScreenPoints {
    private double x, y;

    /**
     * Создаёт новый вектор/точку
     * @param x x-составляющая (горизонтальная ось)
     * @param y y-составляющая (вертикальная ось)
     */
    public ScreenPoints(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    /**
     * Вычисляет новый вектор, который является результатом сложения двух векторов
     * @param other другой вектор, с которым складывается текущий
     * @return новый вектор
     */
    public ScreenPoints add(ScreenPoints other) {
        return new ScreenPoints(x + other.x, y + other.y);
    }

    /**
     * Вычисляет новый вектор, котрый является результатом умножаения текущего вектора на число
     * @param n число, на которое умножается вектор
     * @return новый вектор
     */
    public ScreenPoints mul(double n) {
        return new ScreenPoints((x * n), y * n);
    }

    /**
     * Метод возвращает единичный (нормализованный) вектор
     * Если вектор нулевой, то возвращает новый нулевой вектор
     * @return Получившийся вектор
     */
    public ScreenPoints normolized() {
        double len = length();
        if (len < 1e-12) /*Да, здесь не по модулю, т.к. корень не будет отрицательным.*/
            return new ScreenPoints(0, 0);
        return new ScreenPoints(x / len, y / len);
    }

    /**
     * Метод возвращает модуль вектора
     * @return Вычесленное значение
     */
    public double length() {
        return Math.sqrt(x*x + y*y);
    }
}