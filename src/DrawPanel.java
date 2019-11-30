/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import iPath.IPath;
import math.Rectangle;
import math.ScreenPoints;
import model.Field;
import model.Puck;
import model.World;
import timers.AbstractWorldTimer;
import timers.UpdateWorldTimer;
import utils2D.ScreenConverter;
import utils2D.ScreenPoint;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;
import javax.swing.*;


/**
 * @author Alexey
 */
public class DrawPanel extends JPanel implements ActionListener,
        MouseListener, MouseMotionListener, MouseWheelListener, KeyListener {
    private ScreenConverter sc;
    private World w;
    private AbstractWorldTimer uwt;
    private Timer drawTimer;
    private IPath path;
    private final int dx = 4, dy = 4;
    private ScreenPoint sp;
    private ScreenPoint selected;
    //  private Plane plane;
    private JLabel label = new JLabel();
    private final Font numbersFont = new Font("Segoe UI", Font.PLAIN, 16);
    private ArrayList<ScreenPoint> points = new ArrayList<>();
    ArrayList<ScreenPoint> allpoints = new ArrayList<>();
    int i = 0;
    private MouseEvent e;
    boolean canPaint;
    int period=10;

    public DrawPanel() {
        //super();
        Field f = new Field(
                new Rectangle(0, 10, 10, 10),
                0.1, 9.8, points);
        w = new World(new Puck(1, 0.3, f.getRectangle().getCenter()), f);
        sc = new ScreenConverter(f.getRectangle(), 450, 450);
        sp = new ScreenPoint(2, 5);
        //   points.add(0, sc.r2s(new ScreenPoints(7, 10)));
//        points.add(1, sc.r2s((new ScreenPoints(3, 6))));
//        points.add(2, sc.r2s((new ScreenPoints(4, 2))));
//        points.add(3, sc.r2s((new ScreenPoints(3, 8))));
//        points.add(4, sc.r2s((new ScreenPoints(2, 4))));
//        points.add(4, sc.r2s((new ScreenPoints(5, 9))));

        this.addMouseListener(this);
        this.addKeyListener(this);


        this.addMouseMotionListener(this);
        // this.addMouseWheelListener(this);

        (uwt = new UpdateWorldTimer(w, period)).start();
        drawTimer = new Timer(40, this);
        drawTimer.start();
//        if (canPaint) {
//            (uwt = new UpdateWorldTimer(w, period)).start();
//            drawTimer.restart();
//        }


    }

    @Override
    public void paint(Graphics g) {
//        for (int i = 0; i < points.size(); i++) {
//            ScreenPoint point = points.get(i);
//            g.setColor(Color.BLUE);
//            g.fillRect((int) point.getI() - dx, (int) point.getJ() - dy, 2 * dx, 2 * dy);
//            g.setFont(numbersFont);
//            g.drawString(String.valueOf(i), (int) (point.getI() + dx), (int) (point.getJ() + dy));
//        }


        BufferedImage bi = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);

        w.draw((Graphics2D) bi.getGraphics(), sc);

        g.drawImage(bi, 0, 0, null);

//        AtomicReference<Integer[]> ref = new AtomicReference<>();
//        // String perimeter = plane.getPerimeter(ref);
//        Integer[] list = ref.get();
//        if (list != null) {
//            int size = list.length;
//            for (int i = 0; i < size; i++) {
//                ScreenPoint p1 = points.get(list[i]);
//                ScreenPoint p2 = points.get(list[(i + 1) % size]);
//                g.setColor(Color.RED);
//                g.drawLine((int) (p1.getI()), (int) (p1.getJ()), (int) (p2.getI()), (int) (p2.getJ()));
//            }
//        }
//
//        g.setFont(numbersFont);
//        g.setColor(Color.BLUE);
        // int width = g.getFontMetrics().stringWidth();
        // g.drawString(perimeter, getIconWidth() - width - 10, getIconHeight() - 10);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
//        int direction = 0;
//        if (e.getButton() == MouseEvent.BUTTON1)
//            direction = 1;
//        else if (e.getButton() == MouseEvent.BUTTON3)
//            direction = -1;
//        w.getExternalForce().setValue(10*direction);

        ArrayList<ScreenPoint> points1 = new ArrayList<>();
        points1.add(new ScreenPoint(e.getX(), e.getY()));
        if (i == 0) points.clear();
        points.add(0, new ScreenPoint(e.getX(), e.getY()));
        canPaint = false; // selected = plane.getClosest(e.getX(), e.getY(), dx, dy);
        if ((e.getButton() == MouseEvent.BUTTON1) && (points.size() > 0)) {
            //
            selected = new ScreenPoint(e.getX(), e.getY());
            points.add(i, selected);
            i++;
            w.setSoursePoints(points1);
        } else if (e.getButton() == MouseEvent.BUTTON3) {
            canPaint = true;
            w.setSoursePoints(points);
            i = 0;

        }
        //  this.repaint();

        // selected = points.get(i);
//            if (selected == null && e.getButton() == MouseEvent.BUTTON1) {
//                selected = new ScreenPoint(e.getX(), e.getY());
//            }
//        } else if (selected != null && e.getButton() == MouseEvent.BUTTON3) {
//            points.remove(selected);
//            selected = null;
//        }

        //i++;

        //     label.paintImmediately(0, 0, 10, 10);
        // }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // w.getExternalForce().setValue(0);
        selected = null;
    }

    @Override
    public void mouseEntered(MouseEvent e) {

        // this.e = e;
    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        // w.getExternalForce().setLocation(sc.s2r(new ScreenPoint(e.getX(), e.getY())));
//               if (selected == null)
//            return;
//        selected.setI(e.getX());
//        selected.setJ(e.getY());

        //selected.z = plane.nextZ();
        //     label.paintImmediately(0, 0,10, 10);
//        if (sp == null)
//            return;
//        sp.setI( e.getX());
//        sp.setJ( e.getY());
        // repaint();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        //  w.getExternalForce().setLocation(sc.s2r(new ScreenPoint(e.getX(), e.getY())));
    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
//        double oldMu = w.getF().getMu();
//        oldMu = Math.round(oldMu*100 + e.getWheelRotation())*0.01;
//
//        if (oldMu < -1)
//            oldMu = -1;
//        else if (oldMu > 1)
//            oldMu = 1;
//        else if (Math.abs(oldMu) < 0.005)
//            oldMu = 0;
//        w.getF().setMu(oldMu);
//    }

    }

    @Override
    public void keyTyped(KeyEvent e) {
//        if (e.getKeyChar() == 's') {
//            points.clear();
//            w.setSoursePoints(points);
//
//
//        }

    }

    @Override
    public void keyPressed(KeyEvent e) {

        // this.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
