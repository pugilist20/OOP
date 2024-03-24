
import java.awt.Color;
import java.awt.Graphics;
import java.awt.LayoutManager;
import javax.swing.JPanel;

public class Circle extends JPanel {
    private int x;
    private int y;
    private int D;
    private Color color;
    private boolean vision = true;
    public Circle(int c1, int c2, int c3, Color c) {
        setOpaque(false);
        x = c1;
        y = c2;
        D = c3;
        color = c;
    }

    public void MoveTo(int dx, int dy) {
        if(this.x+dx<=1250 && this.y+dy<=605 &&D+y+dy<=605 &&D+x+dx<=1250&&this.x+dx>=10 && this.y+dy>=10 &&y-D+dy>=10 &&x-D+dx>=10) {
            x += dx;
            y += dy;
            repaint();
        }
    }

    public void Show(boolean VISION) {
        vision = VISION;
        setVisible(vision);
        vision = true;
        repaint();
    }

    public void chRad(int c1) {
        if(x+c1<=1250&&y+c1<=610&&x-c1>=0&&y-c1>=0){
            D = c1;
            repaint();
        }

    }

    public void setColor(Color color) {
        this.color = color;
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (vision) {
            g.setColor(color);
            g.drawOval(x - D / 2, y - D / 2, D, D);
        }

    }
}
