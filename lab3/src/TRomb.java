import java.awt.*;

public class TRomb extends TQuadrilaterals{
    public TRomb(int x, int y, int w, int h, Color color) {
        super(x,y);
        x1=x;
        y1=y;
        this.x2 = this.x4 = x1 + w / 2;
        if(y1-h/2<1){
            this.y2=1;
            this.y4=y1+(y1-y2);
        }
        else{
            this.y2 = y1 - h / 2;
            this.y4 = y1 + h / 2;
        }
        this.x3 = x1 + w;
        this.y3 = y1;
        this.color = color;
        System.out.println("Объект TRomb создан");
    }
    public TRomb(int x, int y){
        super(x,y);
        System.out.println("Объект TRomb создан");

    }
    @Override
    public void chSize(int dx, int dy) {
        if(x2+dx>=10&&y2+dx>=10&&x3+dx*2>=10&&x4+dx>=10&&y4-dy>=10&&x2+dx<=1240&&y2+dx<=600&&x3+dx*2<=1240&&x4+dx<=1240&&y4-dy<=600){
            x2+=dx;
            y2+=dy;
            x3+=dx*2;
            x4+=dx;
            y4-=dy;
        }

        this.repaint();
    }
}
