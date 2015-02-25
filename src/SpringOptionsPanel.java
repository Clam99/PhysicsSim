import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by lucaswebb on 2/25/15.
 */
public class SpringOptionsPanel extends OptionsPanel {
    JComboBox ydrop;
    JComboBox xdrop;
    JSlider sl;
    SpringSimulator ss;
    String[] variables = {"Kinetic Energy", "Potential Energy", "Time", "Velocity", "X Position", "Total Energy"};

    public SpringOptionsPanel(SpringSimulator ss){

        this.ss = ss;

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel title = new JLabel("Select a variable to graph on the y axis:");
        title.setVisible(true);
        this.add(title);

        ydrop = new JComboBox<String>(variables);
        ydrop.setVisible(true);
        ydrop.setMaximumSize(new Dimension((int)ss.simWidth/2, 50));
        this.add(ydrop);

        JLabel title2 = new JLabel("Select a variable to graph in the x axis:");
        title2.setVisible(true);
        this.add(title2);

        xdrop = new JComboBox<String>(variables);
        xdrop.setVisible(true);
        xdrop.setMaximumSize(new Dimension((int) ss.simWidth / 2, 50));
        this.add(xdrop);

        JLabel title3 = new JLabel("Choose Spring Constant of spring:");
        title3.setVisible(true);
        this.add(title3);

        sl = new JSlider(1,15);
        sl.setMajorTickSpacing(1);
        sl.setMinorTickSpacing(1);
        sl.setPaintTicks(true);
        sl.setPaintLabels(true);
        sl.setVisible(true);
        sl.setMaximumSize(new Dimension(((int)ss.simWidth/2), 50));
        this.add(sl);

        JButton selected = new JButton("Submit");
        selected.setVisible(true);
        this.add(selected);


        selected.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //Execute when button is pressed
                startSim();
            }
        });
    }

    public void startSim(){
        int k = xdrop.getSelectedIndex();
        int k2 = ydrop.getSelectedIndex();
        double k3 = sl.getValue();
        ss.startRecording(variables[k], variables[k2], k3);
    }
}
