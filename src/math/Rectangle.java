/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package math;

/**
 *
 * Описывает реальный прямоугольник
 * @author Alexey
 */
public class Rectangle {
    private double left, top, width, height;

    /**
     * Создаёт новый прямоугольник по двум диагональным точкам
     * @param topLeft Верхняя левая точка
     * @param bottomRight Нижняя правая точка
     */
    public Rectangle(ScreenPoints topLeft, ScreenPoints bottomRight) {
        this(
                Math.min(topLeft.getX(), bottomRight.getX()),
                Math.max(topLeft.getY(), bottomRight.getY()),
                Math.abs(topLeft.getX() - bottomRight.getX()),
                Math.abs(topLeft.getY() - bottomRight.getY())
        );
    }

    /**
     * Создаёт прямоуголньник
     * @param left X-координата верхнего левого угла
     * @param top Y-координата верхнего левого угла
     * @param width Ширина прямоугольника
     * @param height Высота прямоугольника
     */
    public Rectangle(double left, double top, double width, double height) {
        this.left = left;
        this.top = top;
        this.width = width;
        this.height = height;
    }

    public double getBottom() {
        return top - height;
    }

    public double getLeft() {
        return left;
    }

    public double getRight() {
        return left + width;
    }

    public double getTop() {
        return top;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public boolean isInside(ScreenPoints p) {
        return getLeft() < p.getX() && p.getX() < getRight() && getBottom() < p.getY() && p.getY() < getTop();
    }

    public ScreenPoints getCenter() {
        return new ScreenPoints((getLeft() + getRight()) * 0.5, (getTop() + getBottom()) * 0.5);
    }

    public ScreenPoints getSize() {
        return new ScreenPoints(getWidth(), getHeight());
    }

    public ScreenPoints getTopLeft() {
        return new ScreenPoints(left, top);
    }

    public ScreenPoints getBottomRight() {
        return new ScreenPoints(left + width, top - height);
    }
}