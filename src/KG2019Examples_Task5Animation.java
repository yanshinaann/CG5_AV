import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class KG2019Examples_Task5Animation {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        DrawPanel panel = new DrawPanel();
        frame.add(panel);
        frame.setVisible(true);
    }
}