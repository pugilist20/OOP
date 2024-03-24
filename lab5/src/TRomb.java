import java.awt.*;

public class TRomb extends TQuadrilaterals{
    public TRomb(int x, int y, int w, int h, Color color) {
        super(x, y, x + w / 2, y - h / 2, x + w, y, x + w / 2, y + h / 2, color);
        x1 = x;
        y1 = y;
        this.x2 = this.x4 = x1 + w / 2;
        this.x3 = x1 + w;
        this.y3 = y1;
        this.color = color;
        System.out.println("Объект TRomb создан");
    }
    @Override
    public void chSize(int dx, int dy) {
        if (super.getPointX1()+dx<=1240&&super.getPointX2()+dx*2<=1240&&super.getPointY2()+dy<=600&&super.getPointY3()-dy<=600&&super.getPointX1()+dx>=10&&super.getPointX2()+dx*2>=10&&super.getPointY3()-dy>=10&&super.getPointY3()+dy>=10) {
            super.setPointX1(super.getPointX1()+dx);
            super.setPointY1(super.getPointY1()+dy);
            super.setPointX2(super.getPointX2()+dx*2);
            super.setPointX3(super.getPointX3()+dx);
            super.setPointY3(super.getPointY3()-dy);
        }
        this.repaint();
    }
}
