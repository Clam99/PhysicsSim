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

        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));



        container = new JPanel();
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));

        m = new Menu(this);
        m.setVisible(true);
        this.add(m);
        d.add(this);

        graph = new Graph(screenWidth/2, screenHeight/2);

        container.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createEmptyBorder(5, 5, 5, 5),
                container.getBorder()));

        revalidate();
        repaint();
    }

    public void startSim(int k){
        m.setVisible(false);
        remove(m);
        container.setVisible(true);
        graph.setVisible(true);

        switch (k){
            case 0:
                RampSimulator rs = new RampSimulator(Math.toRadians(50),700,.1,15,screenWidth,screenHeight,graph,9.8*70, this);
                rs.setMaximumSize(new Dimension((int)(screenWidth/2), (int)screenHeight));
                add(rs);
                container.add(graph);
                container.add(rs.op);
                break;
            case 1:
                SpringSimulator ss = new SpringSimulator(screenWidth,screenHeight,20,300,.1,screenWidth/4, graph);
                ss.setMaximumSize(new Dimension((int)(screenWidth/2), (int)screenHeight));
                add(ss);
                container.add(graph);
                container.add(ss.op);
                break;

            default: break;
        }
        container.setMaximumSize(new Dimension((int) (screenWidth/2), (int) screenHeight));
        add(container);
        this.repaint();
    }

    public void resetSim() {
        container.removeAll();
        this.removeAll();
        RampSimulator rs = new RampSimulator(Math.toRadians(50),700,.1,15,screenWidth,screenHeight,graph,9.8*70, this);
        rs.setMaximumSize(new Dimension((int)(screenWidth/2), (int)screenHeight));
        add(rs);
    }//

    public void enterFullscreenGraph() {

    }

    public double getScreenWidth(){
        return screenWidth;
    }

    public double getScreenHeight(){
        return screenHeight;
    }
}