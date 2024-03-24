

import java.awt.*;
import javax.swing.JPanel;

public class Line extends JPanel {
    private int x1;
    private int y1;
    private int x2;
    private int y2;
    private Color color;
    private boolean vision = true;

    public Line(int c1, int c2, int c3, int c4, Color c) {
        setOpaque(false);
        x1 = c1;
        y1 = c2;
        x2 = c3;
        y2 = c4;
        color = c;
        repaint();
    }


    public void MoveTo(int c1, int c2) {
        if(this.x2+c1<=1240 && this.y2+c2<=580 && this.x1+c1<=1250 && this.y1+c2<=590&&this.x2+c1>=0 && this.y2+c2>=0 && this.x1+c1>=0 && this.y1+c2>=0) {
            x1 += c1;
            x2 += c1;
            y1 += c2;
            y2 += c2;
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
        double c1 = (double) (x2 - x1) * Math.cos(Math.toRadians(45.0)) - (double) (y2 - y1) * Math.sin(Math.toRadians(45.0)) + (double) x1;
        double c2 = (double) (x2 - x1) * Math.sin(Math.toRadians(45.0)) + (double) (y2 - y1) * Math.cos(Math.toRadians(45.0)) + (double) y1;
        if (c1<=1250&&c2<=600&&c1>=0&&c2>=0){
            x2 = (int) c1;
            y2 = (int) c2;
            repaint();
        }

    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (vision) {
            g.setColor(color);
            g.drawLine(x1, y1, x2, y2);

        }
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
