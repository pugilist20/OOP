
import java.awt.Color;
import java.awt.Graphics;

public class TCircle extends TFigure {
    protected int r1;
    protected int r2;

    protected Color color;
    private boolean vision = true;

    public TCircle(int x, int y, int r1, Color color) {
        super(x, y);
        this.r1 = this.r2 = r1;
        this.color = color;
        System.out.println("Объект TCircle создан");
    }

    public TCircle(int x, int y) {
        super(x, y);
        System.out.println("Объект TCircle создан");

    }

    @Override
    public void MoveTo(int x, int y) {
        if (r1 + super.getPointY() + y <= 605 && r1 + super.getPointX() + x <= 1250 && super.getPointY() - r1 + y >= 10 && super.getPointX() - r1 + x >= 10) {
            super.setX(super.getPointX() + x);
            super.setY(super.getPointY() + y);
            repaint();
        }
    }

    public void chRad(int rPlus) {
        if (super.getPointX() + rPlus + r1 <= 1250 && super.getPointY() + rPlus + r1 <= 610 && super.getPointX() - rPlus - r1 >= 10 && super.getPointY() - rPlus - r1 >= 10) {
            r1 = r2 = r1 + rPlus;
            if (r1 == 0) {
                r1 = r2 = 1;
            }
            repaint();
        }
    }

    public int getR() {
        return r1;
    }

    @Override
    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (vision) {
            g.setColor(color);
            g.drawOval(super.getPointX() - r1 / 2, super.getPointY() - r1 / 2, r1, r2);
        }
    }
}
