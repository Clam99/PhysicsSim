import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Lucas Webb on 2/25/15.
 */

public class SpringOptionsPanel extends OptionsPanel {
    JSlider sl;
    private double k;
    JSlider ds;
    private double damping;
    JSlider st;
    private double startingStretch;

    public SpringOptionsPanel(SpringSimulator ss, Canvas c){
        super(ss,new String[]{"Potential Energy", "Kinetic Energy", "Acceleration", "Time", "Velocity", "Compression", "Force"});

        parent = c;

        final JLabel title3 = new JLabel("Choose Spring Constant:");
        title3.setVisible(true);//
        this.add(title3);

        //Slider for spring constant
        sl = new JSlider(0,3000);
        sl.setMajorTickSpacing(500);
        sl.setMinorTickSpacing(250);
        sl.setPaintTicks(true);
        sl.setPaintLabels(true);
        sl.setVisible(true);
        sl.setMaximumSize(new Dimension(((int) ss.simWidth), 50));
        sl.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                k = sl.getValue();
                title3.setText("Choose Spring Constant. Current = " + k);
            }
        });
        this.add(sl);

        final JLabel title4 = new JLabel("Choose Damping Value: ");
        title4.setVisible(true);
        this.add(title4);

        //Slider for damping value
        ds = new JSlider(0, 10);
        ds.setMajorTickSpacing(2);
        ds.setMinorTickSpacing(1);
        ds.setPaintTicks(true);
        ds.setPaintLabels(true);
        ds.setVisible(true);
        ds.setMaximumSize(new Dimension((int) ss.simWidth, 50));
        ds.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                damping = ds.getValue();
                title4.setText("Choose Damping Value. Current = " + damping);
            }
        });
        this.add(ds);

        final JLabel title5 = new JLabel("Choose Starting Position: ");
        title5.setVisible(true);
        this.add(title5);

        //Slider for starting position
        st = new JSlider(-250, 250);
        st.setMajorTickSpacing(50);
        st.setMinorTickSpacing(10);
        st.setPaintTicks(true);
        st.setPaintLabels(true);
        st.setVisible(true);
        st.setMaximumSize(new Dimension((int) ss.simWidth, 50));
        st.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                startingStretch = st.getValue();
                title5.setText("Choose Starting Position. Current = " + startingStretch);
            }
        });
        this.add(st);

        submit = new JButton("Submit");
        submit.setVisible(true);
        this.add(submit);

        //Starts the sim when submit button is pressed
        submit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                startSim();
            }
        });
    }

    public void startSim(){//Starts the sim based on the value of the sliders and the dropboxes
        int k = xdrop.getSelectedIndex();
        int k2 = ydrop.getSelectedIndex();
        double k3 = sl.getValue();
        double k4 = ds.getValue();
        double k5 = st.getValue();
        ((SpringSimulator)sim).startRecording(variables[k], variables[k2], k3, k4, k5);
        super.startSim();
        submit.removeActionListener(al);
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetSim();
            }
        });
    }

    public void resetSim(){//stops the sim calls parent resetSim
        sim.stop();
        parent.resetSim(this);
        super.resetSim();
    }

    @Override
    public int getID(){//Returns ID
        return 1;
    }
}
