public class Test {
    public static void main(String[] args){
        Graph G = new Graph();
        Node a = new Node("a");
        Node b = new Node("b");
        Node c = new Node("c");
        Node d = new Node("d");

        G.addNode(a);
        G.addNode(b);
        G.addNode(c);
        G.addNode(d);

        a.setX(50);
        a.setY(50);
        b.setX(0);
        b.setY(0);
        c.setX(20);
        c.setY(40);
        d.setX(60);
        d.setY(-60);

//        G.addEdge("a", "b");
//        G.addEdge(a, c);

        draw(G);
    }

    private static void draw(Graph G){
        new GraphicsDrawer(G);
    }
}
