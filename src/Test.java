public class Test {
    public static void main(String[] args){

        Graph G = new Graph();
        Node a = new Node("a");
        Node b = new Node("b");
        G.addNode(a);
        G.addNode(b);

        System.out.println(G.getNodes());

        G.addEdge("a", "b");
    }
}
