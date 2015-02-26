import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by lucaswebb on 2/25/15.
 */
public class SpringOptionsPanel extends OptionsPanel {
    JSlider sl;

    public SpringOptionsPanel(SpringSimulator ss){
        super(ss);

        variables = new String[]{"Kinetic Energy", "Potential Energy", "Time", "Velocity", "X Position", "Total Energy"};



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

        submit = new JButton("Submit");
        submit.setVisible(true);
        this.add(submit);


        submit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //Execute when button is pressed
                startSim();
            }
        });
    }

    public void startSim(){
        super.startSim();
        int k = xdrop.getSelectedIndex();
        int k2 = ydrop.getSelectedIndex();
        double k3 = sl.getValue();
        ((SpringSimulator)sim).startRecording(variables[k], variables[k2], k3);
    }

    public void resetSim(){

    }
}
