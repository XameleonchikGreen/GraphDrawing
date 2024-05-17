import java.awt.*;
import java.util.ArrayList;

public class Graph {

    private ArrayList <Node> nodes;
    private ArrayList <Edge> edges;

    public Graph(){
        this.nodes = new ArrayList <Node>();
        this.edges = new ArrayList <Edge>();
    }

    public void setNodes(ArrayList<Node> nodes) {
        this.nodes = nodes;
    }

    public ArrayList<Node> getNodes() {
        return nodes;
    }

    public void addNode(Node newNode) throws RuntimeException{
        boolean flag = true;
        for(Node node: this.nodes){
            if(node.getName().equals(newNode.getName())){
                flag = false;
                break;
            }
        }
        if(flag) {
            this.nodes.add(newNode);
        }
        else {
            throw new RuntimeException("Node with this name is already exist");
        }
    }

    public void addEdge(Node node1, Node node2){
        node1.addNeighbour(node2);
        node2.addNeighbour(node1);
        this.edges.add(new Edge(node1, node2));
    }

    public void addEdge(String name1, String name2) throws RuntimeException{
        Node node1 = null;
        Node node2 = null;
        for(Node node : this.nodes){
            if(node.getName().equals(name1)) node1 = node;
            if(node.getName().equals(name2)) node2 = node;
        }
        if(node1 != null && node2 != null){
            node1.addNeighbour(node2);
            node2.addNeighbour(node1);
            this.edges.add(new Edge(node1, node2));
        }
        else{
            throw new RuntimeException("Names are not correct!");
        }
    }

    public void draw(Graphics2D g2d, int rad){
        for(Edge e : this.edges) e.draw(g2d);
        for(Node n : this.nodes) n.draw(g2d, rad);
    }
}
