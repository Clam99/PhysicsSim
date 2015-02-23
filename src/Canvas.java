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
    Menu m;
    JPanel container;
    Driver dd;
    Graph graph;

    public Canvas(Driver d){
        super();
        dd = d;
        d.setTitle("Physics Simulator v. 1.0.0");
        d.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        d.setVisible(true);
        d.setSize((int) screenWidth, (int) screenHeight);
        d.add(this);

        container = new JPanel();
        container.setLayout(new BoxLayout(container, BoxLayout.X_AXIS));

        m = new Menu(this);
        m.setVisible(true);
        this.add(m);


        graph = new Graph(screenWidth/2, screenHeight/2);
        //rs = new RampSimulator(Math.toRadians(50),700,20, 15, screenWidth, screenHeight, rsgraph, 9.8);

        container.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createEmptyBorder(5, 5, 5, 5),
                container.getBorder()));

        revalidate();
        repaint();
    }

    public void startSim(int k, Simulator sim){
        m.setVisible(false);
        dd.add(container);
        container.setVisible(true);

        switch (k){
            case 0: container.add(sim);
                    container.add(graph);
                    graph.setVisible(true);
                    break;
            default: break;
        }
        this.repaint();
    }

    public double getScreenWidth(){
        return screenWidth;
    }

    public double getScreenHeight(){
        return screenHeight;
    }
}
