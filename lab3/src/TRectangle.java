

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class TRectangle extends TQuadrilaterals {

    public TRectangle(int x, int y, int w, int h, Color c) {
        super(x, y);
        this.x1 = x;
        this.y1 = y;
        this.x2 = this.x3 = x + w;
        this.y2 = y;
        this.y3 = this.y4 = y + h;
        this.x4 = x;
        this.color = c;
        System.out.println("Объект TRectangle создан");
    }
    public TRectangle(int x,int y){
        super(x,y);
        System.out.println("Объект TRectangle создан");

    }
    @Override
    public void chSize(int c1, int c2) {
        if (x2+c1<=1240&&x3+c1<=1240&&y3+c2<=600&&y4+c2<=600&&x2+c1>=10&&x3+c1>=10&&y3+c2>=10&&y4+c2>=10) {
            x2+=c1;
            x3+=c1;
            y3+=c2;
            y4=y3;
        }
    }
}
