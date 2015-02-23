import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;

/**
 * Created by lucaswebb on 2/20/15.
 */

public class Menu extends JPanel {
    JComboBox drop;
    Canvas parent;
    ArrayList<Simulator> simObjects;

    public Menu(Canvas p){

        parent = p;

        simObjects.add( new RampSimulator(Math.toRadians(50),700,20,15,p.getScreenWidth(),p.getScreenHeight(),new Graph(p.getScreenWidth()/2,p.getScreenHeight()/2),9.8) );

        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

        JLabel title = new JLabel("Welcome to PhysicsSim.  Please select a simulator.");
        title.setVisible(true);
        this.add(title);

        JButton selected = new JButton("OK");
        selected.setVisible(true);
        this.add(selected);

        String[] sims = {"RampSimulator"};
        drop = new JComboBox<String>(sims);
        drop.setVisible(true);
        this.add(drop);

        selected.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //Execute when button is pressed
                //System.out.println("You clicked the button");
                startSim();
            }
        });
    }

    private void startSim(){
        int k = drop.getSelectedIndex();
        //System.out.println(k);
        parent.startSim(k, simObjects.get(k));
    }
}
