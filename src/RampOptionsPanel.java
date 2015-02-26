import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by smurphy on 2/24/15.
 */
public class RampOptionsPanel extends OptionsPanel {
    JSlider sl;
    double angle;


    public RampOptionsPanel(RampSimulator rs, Canvas p){
        super(rs, new String[] {"Kinetic Energy", "Potential Energy", "Distance Travelled", "Time", "Velocity", "X Position", "Y Position", "Total Energy"});
        parent = p;

        final JLabel title3 = new JLabel("Choose steepness of ramp in degrees. Current = 45.0 degrees");
        title3.setVisible(true);
        this.add(title3);

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

    public void startSim(){

        int k = xdrop.getSelectedIndex();
        int k2 = ydrop.getSelectedIndex();
        double angle = sl.getValue();
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

    public void resetSim() {
        super.resetSim();
        sim.stop();
        parent.resetSim(this);
        System.out.println("Resetting");
    }
    @Override
    public int getID(){
       return 0;
    }
}

