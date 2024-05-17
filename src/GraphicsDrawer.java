import javax.swing.*;
import java.awt.*;

public class GraphicsDrawer extends JFrame {

    private Graph Gr;

    public GraphicsDrawer(Graph G){
        Gr = G;
        setTitle("Drawing a Circle");
        setSize(700, 700);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.WHITE);
        g2d.fillRect(0, 0, getWidth(), getHeight());
        Gr.draw(g2d, 10);
    }
}
