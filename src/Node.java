import java.awt.*;
import java.util.ArrayList;

public class Node {

    private String name;
    private ArrayList <Node> neighbours;
    private int x;
    private int y;

    public Node(String name){
        this.name = name;
        this.neighbours = new ArrayList<Node>();
    }

    public Node(String name, ArrayList <Node> neighbours){
        this.name = name;
        this.neighbours = neighbours;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNeighbours(ArrayList<Node> neighbours) {
        this.neighbours = neighbours;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getName() {
        return this.name;
    }

    public ArrayList<Node> getNeighbours() {
        return this.neighbours;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public void addNeighbour(Node neighbour) throws RuntimeException{
        if (!neighbour.getName().equals(this.name)) {
            boolean flag = true;
            for (Node node : this.neighbours){
                if(node.getName().equals(neighbour.name)) {
                    flag = false;
                    break;
                }
            }
            if(flag){
                this.neighbours.add(neighbour);
            }
            else {
                throw new RuntimeException("This node is already neighbour");
            }
        }
        else {
            throw new RuntimeException("This node can't be neighbour of itself");
        }
    }

    public void draw(Graphics2D g2d, int rad, int sizeX, int sizeY){

        g2d.setColor(Color.CYAN);
        g2d.fillOval(sizeX + this.x - rad, sizeY - this.y + rad, 2*rad, 2*rad);

        g2d.setColor(Color.BLUE);
        g2d.drawOval(sizeX + this.x - rad, sizeY - this.y + rad, 2*rad, 2*rad);

    }
}
