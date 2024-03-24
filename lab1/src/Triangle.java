

import java.awt.Color;
import java.awt.Graphics;
import java.awt.LayoutManager;
import javax.swing.JPanel;

public class Triangle extends JPanel {
    private int x1;
    private int x2;
    private int x3;
    private int y1;
    private int y2;
    private int y3;
    private Color color;
    private boolean vision = true;

    public Triangle(int c1, int c2, int c3, int c4, int c5, int c6, Color c) {
        setOpaque(false);
        x1 = c1;
        x2 = c2;
        x3 = c3;
        y1 = c4;
        y2 = c5;
        y3 = c6;
        color = c;
    }

    public void MoveTo(int c1, int c2) {
        if (this.x1 + c1 <= 1260 && this.x2 + c1 <= 1260 && this.x3 + c1 <= 1260 && this.y2 + c2 <= 600 && this.y1 + c2 <= 600 && this.y3 + c2 <= 600&&this.x1 + c1 >= 0 && this.x2 + c1 >= 0 && this.x3 + c1 >= 0 && this.y2 + c2 >= 0 && this.y1 + c2 >= 0 && this.y3 + c2 >= 0) {
            x1 += c1;
            x2 += c1;
            x3 += c1;
            y2 += c2;
            y1 += c2;
            y3 += c2;
            repaint();
        }

    }

    public void Show(boolean VISION) {
        vision = VISION;
        setVisible(vision);
        vision = true;
        repaint();
    }

    public void chSize(int c1, int c2) {
        if (x1 + c1 <= 1250 && x3 + c1 <= 1250 && y1 - c2 >= 0) {
            x1 += c1;
            x3 += c1;
            y1 -= c2;
        }

    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (vision) {
            g.setColor(color);
            g.drawPolygon(new int[]{x1, x2, x3}, new int[]{y1, y2, y3}, 3);
        }
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
