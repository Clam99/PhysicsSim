import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Sam Noyes and Lucas Webb on 2/24/15.
 */

public class RampOptionsPanel extends OptionsPanel {
    JSlider sl;
    double angle;


    public RampOptionsPanel(RampSimulator rs, Canvas p){
        super(rs, new String[] {"Kinetic Energy", "Potential Energy", "Distance Travelled", "Time", "Velocity", "X Position", "Y Position"});
        parent = p;

        final JLabel title3 = new JLabel("Choose steepness of ramp in degrees. Current = 45.0 degrees");
        title3.setVisible(true);
        this.add(title3);

        //Slider for ramp angle
        sl = new JSlider(10,80);
        sl.setMajorTickSpacing(10);
        sl.setMinorTickSpacing(1);
        sl.setPaintTicks(true);
        sl.setPaintLabels(true);
        sl.setVisible(true);
        sl.setMaximumSize(new Dimension(((int)rs.simWidth/2), 50));
        this.add(sl);
        sl.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                angle = sl.getValue();
                title3.setText("Choose steepness of ramp in degrees. Current = " + angle + " degrees");
            }
        });

        //Submit button
        submit = new JButton("Submit");
        submit.setVisible(true);
        this.add(submit);
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startSim();
            }
        });
    }

    public void startSim(){//Starts ramp sim with selected values
        int k = xdrop.getSelectedIndex();//What to graph on x axis
        int k2 = ydrop.getSelectedIndex();//y axis
        double angle = sl.getValue();//Gets current value of slider
        ((RampSimulator)sim).startRecording(variables[k], variables[k2], angle);
        super.startSim();
        submit.removeActionListener(al);
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetSim();
            }
        });
    }

    public void resetSim() {//Calls reset method of options panel and canvas and stops sim
        super.resetSim();
        sim.stop();
        parent.resetSim(this);
    }

    @Override
    public int getID(){//Returns ID
       return 0;
    }
}

