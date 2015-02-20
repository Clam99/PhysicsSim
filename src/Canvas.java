import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Sam Noyes and Lucas Webb on 2/10/15.
 */

public class Canvas extends JPanel{
    double screenHeight = 700;
    double screenWidth = 1250;
    RampSimulator rs;
    public Graph graph;
    Menu m;

    public Canvas(Driver d){
        super();
        d.setTitle("Physics Simulator v. 1.0.0");
        d.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        d.setVisible(true);
        d.setSize((int) screenWidth, (int) screenHeight);

        JPanel container = new JPanel();
        container.setLayout(new BoxLayout(container, BoxLayout.X_AXIS));


        //d.add(container);
        m = new Menu();
        d.add(m);

        graph = new Graph(screenWidth/2, screenHeight/2);
        rs = new RampSimulator(Math.toRadians(40),500,20, 15, screenWidth, screenHeight, graph, 9.8);
        container.add(rs);
        container.add(graph);
        container.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createEmptyBorder(5, 5, 5, 5),
                container.getBorder()));
    }

    public void showChooseScreen(){//Show the screen to choose the specific simulator
        showMessage("Spring", 300, 100, 0, 0);
        showMessage("Pendulum", 300, 100, 0, 200);
    }

    public void showMessage(String str, int width, int height, int x, int y){//show onscreen message
        JLabel label = new JLabel(str);
        label.setSize(new Dimension(width, height));
        label.setLocation(x,y);
        this.add(label);
    }
}
