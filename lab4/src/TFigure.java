import javax.swing.*;
import java.awt.*;

public abstract class TFigure extends JPanel {
    private Point tPoint = new Point();
    private Point tPoint1 = new Point();
    private Point tPoint2 = new Point();
    private Point tPoint3 = new Point();
    protected Color color;
    protected int type;
    private boolean vision = true;

    public void MoveTo(int x, int y) {
        if(type ==1){
            if (tPoint.getX() + x >= 10 && tPoint.getY() + y >= 10 && tPoint1.getX() + x >= 10 && tPoint1.getY() + y >= 10 && tPoint2.getX() + x >= 10 && tPoint2.getY() + y >= 10 && tPoint3.getX() + x >= 10 && tPoint3.getY() + y >= 10 && tPoint.getX() + x <= 1240 && tPoint.getY() + y <= 600 && tPoint1.getX() + x <= 1240 && tPoint1.getY() + y <= 600 && tPoint2.getX() + x <= 1240 && tPoint2.getY() + y <= 600 && tPoint3.getX() + x <= 1240 && tPoint3.getY() + y <= 600) {
                tPoint.setX(tPoint.getX() + x);
                tPoint.setY(tPoint.getY() + y);
                tPoint1.setX(tPoint1.getX() + x);
                tPoint2.setX(tPoint2.getX() + x);
                tPoint3.setX(tPoint3.getX() + x);
                tPoint1.setY(tPoint1.getY() + y);
                tPoint2.setY(tPoint2.getY() + y);
                tPoint3.setY(tPoint3.getY() + y);
                this.Show(vision);
                this.repaint();
            }
        }
        else{
            if (tPoint1.getX()/2 + tPoint.getY() + y <= 605 && tPoint1.getX()/2 + tPoint.getX() + x <= 1250 && tPoint.getY()- tPoint1.getX()/2 + y >= 10 && tPoint.getX() - tPoint1.getX()/2 + x >= 10) {
                tPoint.setX(tPoint.getX() + x);
                tPoint.setY(tPoint.getY() + y);
                repaint();
            }
        }

    }

    public void Show(boolean VISION) {
        vision = VISION;
        setVisible(vision);
        vision = true;
        repaint();
    }

    abstract void setColor(Color color);

    public TFigure(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4, Color color) {
        this.tPoint.setX(x1);
        this.tPoint.setY(y1);
        this.tPoint1.setX(x2);
        this.tPoint1.setY(y2);
        this.tPoint2.setX(x3);
        this.tPoint2.setY(y3);
        this.tPoint3.setX(x4);
        this.tPoint3.setY(y4);
        this.color=color;
        type =1;
        this.setLayout(null);
        this.setOpaque(false);
        System.out.println("Координаты TFigure инициализированы");
    }
    public TFigure(int x1, int y1, int x2, int y2,Color color) {
        this.tPoint.setX(x1);
        this.tPoint.setY(y1);
        this.tPoint1.setX(x2);
        this.tPoint1.setY(y2);
        this.color=color;
        type =2;
        this.setLayout(null);
        this.setOpaque(false);
    }

    public void setX(int x) {
        tPoint.setX(x);
    }

    public void setY(int y) {
        tPoint.setY(y);
    }
    public void setPointX1(int x) {
        tPoint1.setX(x);
    }

    public void setPointY1(int y) {
        tPoint1.setY(y);
    }
    public void setPointX2(int x) {
        tPoint2.setX(x);
    }

    public void setPointY2(int y) {
        tPoint2.setY(y);
    }
    public void setPointX3(int x) {
        tPoint3.setX(x);
    }

    public void setPointY3(int y) {
        tPoint3.setY(y);
    }

    public int getPointX() {
        return tPoint.getX();
    }

    public int getPointY() {
        return tPoint.getY();
    }

    public int getPointX1() {
        return tPoint1.getX();
    }

    public int getPointY1() {
        return tPoint1.getY();
    }

    public int getPointX2() {
        return tPoint2.getX();
    }

    public int getPointY2() {
        return tPoint2.getY();
    }

    public int getPointX3() {
        return tPoint3.getX();
    }

    public int getPointY3() {
        return tPoint3.getY();
    }
}
