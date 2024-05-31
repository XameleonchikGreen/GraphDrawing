import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {

    private static final int SIZE_X = 1000;
    private static final int SIZE_Y = 700;

    private JButton btnSaveMatrix;
    private JButton btnOpenMatrix;
    private JButton btnCreateMatrix;

    private JFileChooser fileChooser;

    public Main(){
        super("Graph drawer");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(SIZE_X, SIZE_Y);

        Container container = getContentPane();
        JPanel buttons = new JPanel(new GridLayout(0, 1, 0, 10));

        btnOpenMatrix = new JButton("Выбрать матрицу смежности");
        btnSaveMatrix = new JButton("Сохранить матрицу смежности");
        btnCreateMatrix = new JButton("Ввести матрицу смежности");

        buttons.add(btnOpenMatrix);
        buttons.add(btnSaveMatrix);
        buttons.add(btnCreateMatrix);

        container.add(buttons, BorderLayout.EAST);

        setVisible(true);
    }
    public static void main(String[] args) {
        new Main();
    }
}
