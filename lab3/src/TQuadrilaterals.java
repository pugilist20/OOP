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
    protected Color color;
    private boolean vision = true;

    public TQuadrilaterals(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4, Color color) {
        super(x1, y1);
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
        System.out.println(x1+" "+y1+" "+x2+" "+y2+" "+x3+" "+y3+" "+x4+" "+y4+" ");

    }

    public TQuadrilaterals(int x, int y) {
        super(x, y);
        System.out.println("Объект TQuadrilaterals создан");

    }

    @Override
    void MoveTo(int x, int y) {
        if (x1 + x >= 10 && y1 + y >= 10 && x2 + x >= 10 && y2 + y >= 10 && x3 + x >= 10 && y3 + y >= 10 && x4 + x >= 10 && y4 + y >= 10 && x1 + x <= 1240 && y1 + y <= 600 && x2 + x <= 1240 && y2 + y <= 600 && x3 + x <= 1240 && y3 + y <= 600 && x4 + x <= 1240 && y4 + y <= 600) {
            x1 += x;
            y1 += y;
            x2 += x;
            x3 += x;
            x4 += x;
            y2 += y;
            y3 += y;
            y4 += y;
            repaint();
        }
    }

    public void chSize(int c1, int c2) {
        if (x2+c1<=1240&&x3+c1<=1240&&y3+c2<=600&&y4+c2<=600&&x2+c1>=10&&x3+c1>=10&&y3+c2>=10&&y4+c2>=10&&x3+c1>x4&&y4+c2>y2&&x4+c1<=1240&&x4+c1>=10&&y2+c2<=1240&&y2+c2>=10) {
            x2+=c1;
            y2+=c2;
            x3+=c1;
            y3+=c2;
            x4+=c1;
            y4+=c2;
        }
    }

    @Override
    public void setColor(Color color) {
        this.color = color;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (this.vision) {
            g.setColor(this.color);
            int[] xPoints = {this.x1, this.x2, this.x3, this.x4};
            int[] yPoints = {this.y1, this.y2, this.y3, this.y4};
            g.drawPolygon(xPoints, yPoints, 4);
        }
    }
}
