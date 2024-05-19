public class GraphBalancer {

    private static final int fa = 1;
    private static final int fg = 1;

    public static void balance(Graph G){
        int firstSum = 0;
        int secondSum = 0;
        for(Node n : G.getNodes()) firstSum += n.getX();
        for(Node n : G.getNodes()) secondSum += n.getY();
        double diff = 100.0;
        while(diff > 5){
            diff = 0;
            for(Node n : G.getNodes()){
                firstSum -= n.getX();
                secondSum -= n.getY();
                int oldX = n.getX();
                int oldY = n.getY();
                n.setX(fa*firstSum/((G.getNodes().size() - 1)*fa + fg));
                n.setY(fa*secondSum/((G.getNodes().size() - 1)*fa + fg));
                diff += Math.sqrt((oldX - n.getX())*(oldX - n.getX()) + (oldY - n.getY())*(oldY - n.getY()));

//                System.out.println(n.getName());
//                System.out.println(n.getX());
//                System.out.println(n.getY());
//                System.out.println();
            }
        }
    }
}
