import javax.swing.*;
import java.awt.*;

public class Ring extends JPanel {
    Point point;
    private int r;
    private Color color;
    private boolean vision = true;
    private Circle first, second;

    public Ring(int x, int y, int r, Color color) {
        setLayout(null);
        setOpaque(false);
        point = new Point(x, y);
        first = new Circle(point, r, color);
        second = new Circle(point, (int) (r * 0.33), color);
        this.r = r;
        this.color = color;
        System.out.println("Объект Ring создан");
    }

    public Ring() {
        System.out.println("Объект Ring создан");
    }

    public void chRad(int rPlus) {
        int fR = first.getR();
        int newR = first.getR() + rPlus;
        if (newR >= 15 && second.getR() + rPlus >= 10 &&
                (first.getPointX() + newR <= 1250) && (first.getPointY() + newR <= 605) &&
                (first.getPointX() - newR >= 10) && (first.getPointY() - newR >= 10)) {
            first.chRad(rPlus);
            if (fR != first.getR()) {
                second.chRad(rPlus / 3);
            }
        }
    }

    public void MoveTo(int dx, int dy) {
        if (first.getPointX() + dx + r <= 1250 && first.getPointY() + dy + r <= 605 && first.getPointY() + dx - r >= 10 && first.getPointY() - r + dy >= 10) {
            first.MoveTo(dx, dy);
        }
    }

    public void Show(boolean VISION) {
        vision = VISION;
        setVisible(vision);
        vision = true;
        repaint();
    }

    public void setColor(Color color) {
        first.setColor(color);
        second.setColor(color);

    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (vision) {
            g.setColor(color);
            first.paintComponent(g);
            second.paintComponent(g);
        }
    }
}
