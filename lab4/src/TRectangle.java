

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class TRectangle extends TQuadrilaterals {

    public TRectangle(int x, int y, int w, int h, Color c) {
        super(x, y, x+w, y, x+w, y+h, x, y+h, c);
        System.out.println("Объект TRectangle создан");
    }
    @Override
    public void chSize(int c1, int c2) {
        if (super.getPointX1()+c1<=1240&&super.getPointX2()+c1<=1240&&super.getPointY2()+c2<=600&&super.getPointY3()+c2<=600&&super.getPointX1()+c1>=10&&super.getPointX2()+c1>=10&&super.getPointY3()+c2>=10&&super.getPointY3()+c2>=10) {
            super.setPointX1(super.getPointX1()+c1);
            super.setPointX2(super.getPointX2()+c1);
            super.setPointY2(super.getPointY2()+c2);
            super.setPointY3(super.getPointY2());
        }
    }
}
