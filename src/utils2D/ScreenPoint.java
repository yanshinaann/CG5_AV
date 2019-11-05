package utils2D;

public class ScreenPoint {
    /**
     * i - номер пикселя по горизонтальной оси
     * j - номер пикселя по вертикальной оси
     */
    private int i, j;

    /**
     * Создаёт экранную точку.
     * @param i Номер пикселя по горизонтальной оси (X)
     * @param j Номер пикселя по вертикальной оси (Y)
     */
    public ScreenPoint(int i, int j) {
        this.i = i;
        this.j = j;
    }

    public int getI() {
        return i;
    }

    public int getJ() {
        return j;
    }

}