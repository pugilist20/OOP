import java.awt.*;

public class TTrapeze extends TQuadrilaterals {
    public TTrapeze(int x, int y, int w, int h, int c, Color color) {
        super(x, y, x + w, y, x + w - c, y - h, x + c, y - h, color);
        this.x1 = x;
        this.y1 = this.y2 = y;
        this.x2 = x + w;
        this.x3 = x + w - c;
        this.y3 = y - h;
        this.x4 = x + c;
        this.y4 = y - h;

        this.color = color;
        System.out.println("Объект TTrapeze создан");
    }
    @Override
    public void chSize(int dx, int dy) {
        if (super.getPointX1()+dx*2<=1240&&super.getPointX2()+dx<=1240&&super.getPointY2()+dy<=600&&super.getPointY3()+dy<=600&&super.getPointX1()+dx*2>=10&&super.getPointX2()+dx>=10&&super.getPointY3()+dy>=10&&super.getPointX1()+dx*2>super.getX()) {
            super.setPointX1(super.getPointX1()+dx*2);
            super.setPointX2(super.getPointX2()+dx);
            super.setPointX3(super.getPointX3()+dx);
            super.setPointY2(super.getPointY2()+dy);
            super.setPointY3(super.getPointY3()+dy);
        }
    }
}
