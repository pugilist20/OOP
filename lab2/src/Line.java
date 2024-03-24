

import java.awt.*;
import javax.swing.JPanel;

public class Line extends JPanel {
    private Point point1 = new Point();
    private Point point2 = new Point();
    private Color color;
    private boolean vision = true;

    public Line(int x1, int y1, int x2, int y2, Color c) {
        setOpaque(false);
        point1.setX(x1);
        point1.setY(y1);
        point2.setX(x2);
        point2.setY(y2);
        color = c;
        repaint();
        System.out.println("Объект Line создан");
    }

    public void MoveTo(int c1, int c2) {
        if (point2.getX() + c1 <= 1240 && this.point2.getY() + c2 <= 580 && this.point1.getX() + c1 <= 1250 && this.point1.getY() + c2 <= 590 && this.point2.getX() + c1 >= 0 && this.point2.getY() + c2 >= 0 && this.point1.getX() + c1 >= 0 && this.point1.getY() + c2 >= 0) {
            point1.setX(point1.getX() + c1);
            point1.setY(point1.getY() + c2);
            point2.setX(point2.getX() + c1);
            point2.setY(point2.getX() + c2);
            repaint();
        }
    }

    public void Show(boolean VISION) {
        vision = VISION;
        setVisible(vision);
        vision = true;
        repaint();
    }

    public void Turn() {
        double c1 = (double) (point2.getX() - point1.getX()) * Math.cos(Math.toRadians(45.0)) - (double) (point2.getY() - point1.getY()) * Math.sin(Math.toRadians(45.0)) + (double) point1.getX();
        double c2 = (double) (point2.getX() - point1.getX()) * Math.sin(Math.toRadians(45.0)) + (double) (point2.getY() - point1.getY()) * Math.cos(Math.toRadians(45.0)) + (double) point1.getY();
        if (c1 <= 1250 && c2 <= 600 && c1 >= 0 && c2 >= 0) {
            point2.setX((int) c1);
            point2.setY((int) c2);
            repaint();
        }

    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (vision) {
            g.setColor(color);
            g.drawLine(point1.getX(), point1.getY(), point2.getX(), point2.getY());

        }
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
