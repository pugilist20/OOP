import javax.swing.*;
import java.awt.*;

public abstract class TFigure extends JPanel {
    private Point tPoint = new Point();
    private boolean vision=true;

    abstract void MoveTo(int x, int y);

    public void Show(boolean VISION) {
        vision = VISION;
        setVisible(vision);
        vision = true;
        repaint();
    }
    abstract void setColor(Color color);

    public TFigure(int x, int y) {
        this.tPoint.setX(x);
        this.tPoint.setY(y);
        this.setLayout(null);
        this.setOpaque(false);
        System.out.println("Координаты TFigure инициализированы");
    }

    public void setX(int x) {
        tPoint.setX(x);
    }

    public void setY(int y) {
        tPoint.setY(y);
    }

    public int getPointX() {
        return tPoint.getX();
    }

    public int getPointY() {
        return tPoint.getY();
    }
}
