import java.awt.*;

public class Edge {

    private final Node start;
    private final Node finnish;

    public Edge(Node a, Node b){
        this.start = a;
        this.finnish = b;
    }

    public void draw(Graphics2D g2d){

        g2d.setColor(Color.BLACK);
        g2d.drawLine(this.start.getX(), this.start.getX(), this.finnish.getX(), this.finnish.getY());

    }
}
