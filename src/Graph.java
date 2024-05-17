import java.util.ArrayList;

public class Graph {

    private ArrayList <Node> nodes;

    public Graph(){
        this.nodes = new ArrayList <Node>();
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
        }
        else{
            throw new RuntimeException("Names are not correct!");
        }
    }
}
