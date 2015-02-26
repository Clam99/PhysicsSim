import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by smurphy on 2/24/15.
 */
public class OptionsPanel extends JPanel {
    Canvas parent;
    JButton submit;
    ActionListener al;
    Simulator sim;
    JComboBox ydrop;
    JComboBox xdrop;
    String[] variables = {"Kinetic Energy", "Potential Energy", "Time", "Velocity", "X Position", "Total Energy"};

    public OptionsPanel(Simulator sim) {
        this.sim = sim;
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel title = new JLabel("Select a variable to graph on the y axis:");
        title.setVisible(true);
        this.add(title);

        ydrop = new JComboBox<String>(variables);
        ydrop.setVisible(true);
        ydrop.setMaximumSize(new Dimension((int)sim.simWidth/2, 50));
        this.add(ydrop);

        JLabel title2 = new JLabel("Select a variable to graph in the x axis:");
        title2.setVisible(true);
        this.add(title2);

        xdrop = new JComboBox<String>(variables);
        xdrop.setVisible(true);
        xdrop.setMaximumSize(new Dimension((int) sim.simWidth / 2, 50));
        this.add(xdrop);

        submit = new JButton("Test");
        al = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //Execute when button is pressed
                startSim();
            }
        };
        submit.addActionListener(al);
    }
    public void startSim() {
        submit.setText("Reset");

    }
    public void resetSim() {

    }
}
