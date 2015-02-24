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

        m = new Menu(this);
        m.setVisible(true);
        this.add(m);


        graph = new Graph(screenWidth/2, screenHeight/2);

        //container.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5),container.getBorder()));

        revalidate();
        repaint();
    }

    public void startSim(int k){
        m.setVisible(false);
        container.setLayout(new GridBagLayout());

        GridBagConstraints c = new GridBagConstraints();

        c.fill = GridBagConstraints.BOTH;
        c.anchor = GridBagConstraints.NORTHWEST;
        c.gridx = 1;
        c.gridy = 0;
        c.gridheight=1;
        //container.add(new JButton("Button 5"),c);
        //System.out.println("works");
        c.weightx = .5;
        c.weighty = .25;
        container.add(graph, c);
        graph.setVisible(true);

        c.fill = GridBagConstraints.BOTH;
        c.anchor = GridBagConstraints.FIRST_LINE_START;
        c.weightx = 0.5;
        c.weighty = 0.5;
        c.gridx = 0;
        c.gridwidth = 1;   //1 columns wide
        c.gridheight = 2;   //2 rows tall
        c.gridy = 0;       //first row

        switch (k){
            case 0:
                RampSimulator rs = new RampSimulator(Math.toRadians(90),700,.1,15,screenWidth,screenHeight,graph,9.8*70);
                container.add(rs, c);

                break;
            case 1:
                SpringSimulator ss = new SpringSimulator(screenWidth,screenHeight,15,1.12,screenWidth/2);
                container.add(ss, c);
                ss.requestFocusInWindow();
                break;
            default: break;
        }
        //container.add(graph);
        d.add(container);
        container.setVisible(true);
    }

    public double getScreenWidth(){
        return screenWidth;
    }

    public double getScreenHeight(){
        return screenHeight;
    }
}
