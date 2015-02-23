import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Sam Noyes and Lucas Webb on 2/10/15.
 */

public class Canvas extends JPanel{
    double screenHeight = 700;
    double screenWidth = 1250;
    Menu m;
    JPanel container;
    Driver d;
    Graph graph;

    public Canvas(Driver d){
        super();
        this.d = d;
        ImageIcon icon = new ImageIcon ( "physics.jpg");
        d.setTitle("Physics Simulator v. 1.0.0");
        d.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        d.setIconImage(icon.getImage());

        d.setVisible(true);
        d.setSize((int) screenWidth, (int) screenHeight);
        d.add(this);

        container = new JPanel();
        container.setLayout(new BoxLayout(container, BoxLayout.X_AXIS));

        m = new Menu(this);
        m.setVisible(true);
        this.add(m);


        graph = new Graph(screenWidth/2, screenHeight/2);

        container.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createEmptyBorder(5, 5, 5, 5),
                container.getBorder()));

        revalidate();
        repaint();
    }

    public void startSim(int k){
        m.setVisible(false);
        d.add(container);
        container.setVisible(true);
        graph.setVisible(true);

        switch (k){
            case 0: container.add(new RampSimulator(Math.toRadians(45),700,20,15,screenWidth,screenHeight,graph,9.8));
                    break;
            case 1:
                    //container.add(new SpringSimulator())
            default: break;
        }
        container.add(graph);
        this.repaint();
    }

    public double getScreenWidth(){
        return screenWidth;
    }

    public double getScreenHeight(){
        return screenHeight;
    }
}
