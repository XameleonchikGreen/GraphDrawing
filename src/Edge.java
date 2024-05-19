import java.awt.*;

public class Edge {

    private final Node start;
    private final Node finnish;

    public Edge(Node a, Node b){
        this.start = a;
        this.finnish = b;
    }

    public void draw(Graphics2D g2d, int sizeX, int sizeY){

        g2d.setColor(Color.BLACK);
        g2d.drawLine(sizeX + this.start.getX(), sizeY - this.start.getY(),
                sizeX + this.finnish.getX(), sizeY - this.finnish.getY());

    }
}
