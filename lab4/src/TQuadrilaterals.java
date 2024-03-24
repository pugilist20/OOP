import java.awt.*;

public class TQuadrilaterals extends TFigure {
    protected int x1;
    protected int y1;
    protected int x2;
    protected int x3;
    protected int x4;
    protected int y2;
    protected int y3;
    protected int y4;

    public TQuadrilaterals(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4, Color color) {
        super(x1, y1,x2,y2,x3,y3,x4,y4, color);
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.x3 = x3;
        this.y3 = y3;
        this.x4 = x4;
        this.y4 = y4;
        this.color = color;
        System.out.println("Объект TQuadrilaterals создан");
        System.out.println(x1 + " " + y1 + " " + x2 + " " + y2 + " " + x3 + " " + y3 + " " + x4 + " " + y4 + " ");

    }

    public void chSize(int c1, int c2) {
        if (super.getPointX1() + c1 <= 1240 && super.getPointX2()+ c1 <= 1240 && super.getPointY2() + c2 <= 600 && super.getPointY3() + c2 <= 600 && super.getPointX1() + c1 >= 10 && super.getPointX2() + c1 >= 10 && super.getPointY2() + c2 >= 10 && super.getPointY3() + c2 >= 10 && super.getPointX2() + c1 > super.getPointX3() && super.getPointY3() + c2 > super.getPointY1() && super.getPointX3() + c1 <= 1240 && super.getPointX3() + c1 >= 10 && super.getPointY1() + c2 <= 1240 && super.getPointY1() + c2 >= 10) {
            super.setPointX1(super.getPointX1()+c1);
            super.setPointY1(super.getPointY1()+c2);
            super.setPointX2(super.getPointX2()+c1);
            super.setPointY2(super.getPointY2()+c2);
            super.setPointX3(super.getPointX3()+c1);
            super.setPointY3(super.getPointY3()+c2);
        }
    }

    @Override
    public void setColor(Color color) {
        this.color = color;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(this.color);
        int[] xPoints = {super.getPointX(), super.getPointX1(), super.getPointX2(), super.getPointX3()};
        int[] yPoints = {super.getPointY(), super.getPointY1(), super.getPointY2(), super.getPointY3()};
        g.drawPolygon(xPoints, yPoints, 4);
    }
}
