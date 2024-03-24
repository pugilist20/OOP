import java.awt.*;

public class TEllipse extends TCircle{
    public TEllipse(int x, int y, int r1, int r2, Color color) {
        super(x, y,r1,r2, color);
        this.r1=r1;
        this.r2=r2;
        this.color=color;
        System.out.println("Объект TEllipse создан");
    }

    public void turn(){
        int a = this.r1;
        this.r1 = this.r2;
        this.r2 = a;
        this.repaint();
    }
}
