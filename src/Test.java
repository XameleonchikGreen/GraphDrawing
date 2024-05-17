public class Test {
    public static void main(String[] args){
        Graph G = new Graph();
        Node a = new Node("a");
        Node b = new Node("b");
        Node c = new Node("c");

        G.addNode(a);
        G.addNode(b);
        G.addNode(c);

        a.setX(50);
        a.setY(50);
        b.setX(100);
        b.setY(100);
        c.setX(200);
        c.setY(400);

        G.addEdge("a", "b");
        G.addEdge(a, c);

        draw(G);
    }

    private static void draw(Graph G){
        new GraphicsDrawer(G);
    }
}
