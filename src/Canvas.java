import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Sam Noyes and Lucas Webb on 2/10/15.
 */

public class Canvas extends JPanel{
    double screenHeight = 700;//Sets screen dimensions
    double screenWidth = 1250;
    Menu m;
    JPanel container;
    Driver d;
    Graph graph;

    public Canvas(Driver d){
        super();
        this.d = d;
        d.setTitle("Physics Simulator v. 1.0.0");//Sets window title
        d.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        d.setVisible(true);
        d.setSize((int) screenWidth, (int) screenHeight);//Sets frame size

        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));//Sets layout of canvas

        container = new JPanel();//Container to hold simulation elements
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));

        m = new Menu(this);//Creates menu and sets dimensions
        m.setVisible(true);
        m.setPreferredSize(new Dimension((int)screenWidth, (int)screenHeight));
        this.add(m);
        d.add(this);

        graph = new Graph(screenWidth/2, screenHeight/2);

        container.setBorder(BorderFactory.createCompoundBorder(//Creates border around container
                BorderFactory.createEmptyBorder(5, 5, 5, 5),
                container.getBorder()));

        revalidate();
        repaint();
    }

    public void startSim(int k){//Starts the selected simulation based on ID k
        m.setVisible(false);
        remove(m);
        container.setVisible(true);
        graph.setVisible(true);
        addNewSim(k);
        container.setMaximumSize(new Dimension((int) (screenWidth/2), (int) screenHeight));
        add(container);//Container is added and menu is removed
        this.repaint();
    }

    public void resetSim(final OptionsPanel sender) {//Called to end the current sim and show full screen graph
        container.removeAll();
        this.remove(sender.sim);
        graph.resizeGraph((int) screenWidth - 60, (int) screenHeight - 60, true);//Shows full screen graph
        add(graph);
        final JButton newSim = new JButton("Reset Current Sim");
        final JButton menu = new JButton("Go Back to the Main Menu");
        newSim.addActionListener(new ActionListener() {//Action listener to reset current sim
            @Override
            public void actionPerformed(ActionEvent e) {
                newSim.getParent().remove(menu);
                newSim.getParent().remove(newSim);
                addNewSim(sender.getID());
            }
        });
        menu.addActionListener(new ActionListener() {//Action listener to show menu
            @Override
            public void actionPerformed(ActionEvent e) {
                showMenu();
            }
        });
        graph.add(newSim);
        graph.add(menu);
        revalidate();
        repaint();
    }

    public void addNewSim(int k) {//Called to add a sim based on ID k
        this.remove(graph);
        graph.resetData();
        graph.resizeGraph((int)(screenWidth/2-20),(int)screenHeight/2-20, false);//Resizes graph to correct
        graph.removeAll();
        graph.validate();
        graph.repaint();

        if(k == 0) {//Ramp sim has ID 0
            RampSimulator rs = new RampSimulator(Math.toRadians(50), 700, 20, 15, screenWidth, screenHeight, graph, 9.8 * 70, this);
            rs.setMaximumSize(new Dimension((int) (screenWidth / 2), (int) screenHeight));
            add(rs);
            container.add(graph);
            container.add(rs.op);

        } else if(k == 1){//Spring sim has ID 1
            SpringSimulator ss = new SpringSimulator(screenWidth/2,screenHeight,20,3000,.1,screenWidth/4, graph, this);
            ss.setMaximumSize(new Dimension((int)(screenWidth/2), (int)screenHeight));
            add(ss);
            container.add(graph);
            container.add(ss.op);
        }

        container.validate();
        container.repaint();
        add(container);
        validate();
        repaint();
    }

    public void showMenu() {//Displays the menu screen
        removeAll();//removes anything that might be there
        add(m);
        m.setVisible(true);
        graph.resetData();
        graph.removeAll();
        graph.resizeGraph((int)(screenWidth/2-20),(int)screenHeight/2-20, false);
        validate();
        repaint();
    }

    public double getScreenWidth(){
        return screenWidth;
    }

    public double getScreenHeight(){
        return screenHeight;
    }
}