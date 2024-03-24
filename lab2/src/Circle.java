
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class Circle extends JPanel {
    private Point point=new Point();
    private int r;
    private Color color;
    private boolean vision = true;
    public Circle(int x, int y, int r, Color c) {
        setLayout(null);
        setOpaque(false);
        point.setX(x);
        point.setY(y);
        this.r = r;
        color = c;
        System.out.println("Объект Circle создан");
    }

    public Circle(Point point, int r, Color c) {
        setLayout(null);
        setOpaque(false);
        this.point = point;
        this.r = r;
        color = c;
        System.out.println("Объект Circle создан");
    }

    public void MoveTo(int dx, int dy) {
        if(r +point.getY()+dy<=605 && r +point.getX()+dx<=1250&&point.getY()- r +dy>=10 &&point.getX()- r +dx>=10) {
            point.setX(point.getX()+dx);
            point.setY(point.getY()+dy);
            repaint();
        }
    }

    public void Show(boolean VISION) {
        vision = VISION;
        setVisible(vision);
        vision = true;
        repaint();
    }

    public void chRad(int rPlus) {
        if(point.getX()+rPlus+r<=1250&&point.getY()+rPlus+r<=610&&point.getX()-rPlus-r>=10&&point.getY()-rPlus-r>=10){
            r = r+ rPlus;
            if(r==0){
                r=1;
            }
            repaint();
        }
    }

    public int getR() {
        return r;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (vision) {
            g.setColor(color);
            g.drawOval(point.getX() - r / 2, point.getY() - r / 2, r, r);
        }
    }
    public int getPointX(){
        return point.getX();
    }
    public int getPointY(){
        return point.getY();
    }
}
