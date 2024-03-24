import java.awt.*;

public class TTrapeze extends TQuadrilaterals {
    public TTrapeze(int x, int y, int w, int h, int c, Color color) {
        super(x, y);
        this.x1 = x;
        this.y1 = this.y2 = y;
        this.x2 = x + w;
        System.out.println(c);
        if (x2 - c < x1) {
            int n = 5 + (int) (Math.random() * ((x2 - x1) / 2 - 5));
            this.x3 = x2 - n;
            this.x4 = x1 + n;
        } else {
            this.x3 = x2 - c;
            this.x4 = x + c;
        }
        if (x3 == x4) {
            x3 -= 1;
            x4 += 1;
        }
        if (y - h < 1) {
            this.y3 = this.y4 = 1;
        } else {
            this.y3 = this.y4 = y - h;
        }
        this.color = color;
        System.out.println("Объект TTrapeze создан");
    }

    public TTrapeze(int x, int y) {
        super(x, y);
        System.out.println("Объект TTrapeze создан");

    }
    @Override
    public void chSize(int dx, int dy) {
        if (x2 + dx * 2 >= 10 && x3 + dx >= 10 && y3 + dy >= 10 && x4 + dx >= 10 && y4 + dy >= 10 && x2 + dx * 2 <= 1240 && x3 + dx <= 1240 && y3 + dy <= 600 && x4 + dx <= 1240 && y4 + dy <= 600&&x2+dx*2>x1) {
            x2 += dx * 2;
            x3 += dx;
            x4 += dx;
            y3 += dy;
            y4 += dy;
        }
    }
}
