public class GraphBalancer {

    private static final double fa = 0.1;
    private static final double fb = 100000;
    private static final double fg = 0.01;
    private static final int a = 2;
    private static final int r = -1;
    private static final int g = 2;

    public static void balance(Graph G){
        double diff = 100.0;
        int eps = 1;
        if(G.getNodes().size() > 7) eps = 5;
        while(diff > eps){
            diff = 0;
            for(Node n : G.getNodes()){
                int oldX = n.getX();
                int oldY = n.getY();
                double firstSum = 0;
                double secondSum = 0;

                for(Node m : n.getNeighbours()) firstSum += Math.pow(distance(oldX, oldY, m),
                        a/2.0 - 1)*(oldX - m.getX());
                for(Node m : G.getNodes()) {
                    if (!m.getName().equals(n.getName())) secondSum += Math.pow(distance(oldX, oldY, m),
                            r / 2.0 - 1) * (oldX - m.getX());
                }
                double pow = Math.pow(oldX * oldX + oldY * oldY, g / 2.0 - 1);
                n.setX((int)(oldX - 0.5*(a*fa*firstSum + r*fb*secondSum + g*fg*pow*oldX)));

                firstSum = 0;
                secondSum = 0;

                for(Node m : n.getNeighbours()) firstSum += Math.pow(distance(oldX, oldY, m),
                        a/2.0 - 1)*(oldY - m.getY());
                for(Node m : G.getNodes()) {
                    if (!m.getName().equals(n.getName())) secondSum += Math.pow(distance(oldX, oldY, m),
                        r/2.0 - 1)*(oldY - m.getY());
                }
                n.setY((int)(oldY - 0.5*(a*fa*firstSum + r*fb*secondSum + g*fg*pow*oldY)));
                diff += Math.sqrt((oldX - n.getX())*(oldX - n.getX()) + (oldY - n.getY())*(oldY - n.getY()));
            }
        }
    }

    private static double distance(int x, int y, Node p){
        return (x - p.getX())*(x - p.getX()) + (y - p.getY())*(y - p.getY());
    }
}
