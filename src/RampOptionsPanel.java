import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by smurphy on 2/24/15.
 */
public class RampOptionsPanel extends OptionsPanel {
    JComboBox ydrop;
    JComboBox xdrop;
    RampSimulator rs;
    String[] variables = {"Kinetic Energy", "Potential Energy", "Distance Travelled", "Time", "Velocity", "X Position", "Y Position"};

    public RampOptionsPanel(RampSimulator rs){

        this.rs = rs;

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel title = new JLabel("Select a variable to graph on the y axis:");
        title.setVisible(true);
        this.add(title);

        ydrop = new JComboBox<String>(variables);
        ydrop.setVisible(true);
        ydrop.setMaximumSize(new Dimension((int)rs.simWidth/2, 50));
        this.add(ydrop);

        JLabel title2 = new JLabel("Select a variable to graph in the x axis:");
        title2.setVisible(true);
        this.add(title2);

        xdrop = new JComboBox<String>(variables);
        xdrop.setVisible(true);
        xdrop.setMaximumSize(new Dimension((int) rs.simWidth / 2, 50));
        this.add(xdrop);

        JButton selected = new JButton("Submit");
        selected.setVisible(true);
        this.add(selected);


        selected.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //Execute when button is pressed
                //System.out.println("You clicked the button");
                startSim();
            }
        });
    }

    private void startSim(){
        int k = xdrop.getSelectedIndex();
        int k2 = ydrop.getSelectedIndex();
        rs.startRecording(variables[k], variables[k2]);
    }
}

