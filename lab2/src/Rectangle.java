

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class Rectangle extends JPanel {
    private Point point=new Point();
    private int w;
    private int h;
    private Color color;
    private boolean vision = true;

    public Rectangle(int x, int y, int w, int h, Color c) {
        setOpaque(false);
        point.setX(x);
        point.setY(y);
        this.w = w;
        this.h = h;
        color = c;
        repaint();
        System.out.println("Объект Rectangle создан");
    }


    public void MoveTo(int c1, int c2) {
        if(this.point.getX()+c1<=1240 && this.point.getY()+c2<=590 && this.w+point.getX()+c1<=1250 && this.h+point.getY()+c2<=600&&this.point.getX()+c1>=10 && this.point.getY()+c2>=10 && this.w+point.getX()+c1>=10 && this.h+point.getY()+c2>=10) {
            point.setX(point.getX()+c1);
            point.setY(point.getY()+c2);
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
        if(point.getX()+w+c1<=1250&&point.getY()+h+c2<=600){
            w += c1;
            h += c2;
        }

    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (vision) {
            g.setColor(color);
            g.drawRect(point.getX(), point.getY(), w, h);
        }

    }
    public void setColor(Color color) {
        this.color = color;
    }
}
