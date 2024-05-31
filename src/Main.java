import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;

public class Main extends JFrame {

    private static final int SIZE_X = 1000;
    private static final int SIZE_Y = 700;
    private static Graph G;

    private JButton btnSaveMatrix;
    private JButton btnOpenMatrix;
    private JButton btnCreateMatrix;

    private JFileChooser fileChooser;

    public Main(){
        super("Graph drawer");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(SIZE_X, SIZE_Y);
        G = new Graph();

        Container container = getContentPane();
        JPanel buttons = new JPanel(new GridLayout(8, 1, 0, 10));

        btnOpenMatrix = new JButton("Выбрать матрицу смежности");
        btnSaveMatrix = new JButton("Сохранить матрицу смежности");
        btnCreateMatrix = new JButton("Ввести матрицу смежности");

        fileChooser = new JFileChooser();

        btnOpenMatrix.addActionListener(e -> {
            fileChooser.setDialogTitle("Выбор директории");
            fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
            int result = fileChooser.showOpenDialog(Main.this);
            if (result == JFileChooser.APPROVE_OPTION) {
                try (FileReader reader = new FileReader(fileChooser.getSelectedFile())) {
                    G = new Graph();
                    int c;
                    ArrayList <String> s = new ArrayList<>();
                    String temp = "";
                    while ((c = reader.read()) != -1) {
                        if(c != 13 && c != 10){
                            temp += (char) c;
                        }
                        else if (c == 13) {
                            temp += ' ';
                            s.add(temp);
                            temp = "";
                        }
                    }
                    s.add(temp);
                    createGraph(s);
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        });

        buttons.add(btnOpenMatrix);
        buttons.add(btnSaveMatrix);
        buttons.add(btnCreateMatrix);

        container.add(buttons, BorderLayout.EAST);

        setVisible(true);
    }
    public static void main(String[] args) {
        new Main();
    }

    private static void createGraph(ArrayList <String> matrix){
        ArrayList <Node> nodes = new ArrayList<Node>();
        String st =  matrix.getLast().replaceAll("\\W", "");
        if(st.length() != matrix.size()) {
            int i = -1;
            while (i < matrix.getFirst().length() - 1) {
                i += 1;
                char c = matrix.getFirst().charAt(i);
                String name = "";
                while (c != ' ') {
                    name += c;
                    i += 1;
                    c = matrix.getFirst().charAt(i);
                }
                nodes.add(new Node(name));
            }
        }
        else {
            for(int i = 1; i <= matrix.size(); i++)
                nodes.add(new Node(Integer.toString(i)));
        }
        for(int i = matrix.size() - nodes.size(); i < matrix.size(); i++){
            String s =  matrix.get(i).replaceAll("\\W", "");
            for(int j = 0; j < s.length(); j++){
                if(s.charAt(j) == '1'){
                    nodes.get(i - (matrix.size() - nodes.size())).addNeighbour(nodes.get(j));
                }
            }
        }
        for(Node n : nodes){
            n.setX((int) (Math.random()*SIZE_X));
            n.setY((int) (Math.random()*SIZE_Y));
        }
        G.setNodes(nodes);
        draw(G);
    }

    private static void draw(Graph G){
        new GraphicsDrawer(G);
    }
}
