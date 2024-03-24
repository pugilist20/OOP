

import java.awt.Color;
import java.awt.Graphics;
import java.awt.LayoutManager;
import javax.swing.JPanel;

public class Rectangle extends JPanel {
    private int x;
    private int y;
    private int w;
    private int h;
    private Color color;
    private boolean vision = true;

    public Rectangle(int c1, int c2, int c3, int c4, Color c) {
        setOpaque(false);
        x = c1;
        y = c2;
        w = c3;
        h = c4;
        color = c;
    }


    public void MoveTo(int c1, int c2) {
        if(this.x+c1<=1240 && this.y+c2<=590 && this.w+x+c1<=1250 && this.h+y+c2<=600&&this.x+c1>=10 && this.y+c2>=10 && this.w+x+c1>=10 && this.h+y+c2>=10) {
            x+=c1;
            y+=c2;
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
        if(x+w+c1<=1250&&y+h+c2<=600){
            w += c1;
            h += c2;
        }

    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (vision) {
            g.setColor(color);
            g.drawRect(x, y, w, h);
        }

    }
    public void setColor(Color color) {
        this.color = color;
    }
}
