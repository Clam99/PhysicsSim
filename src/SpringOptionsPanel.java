import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by lucaswebb on 2/25/15.
 */
public class SpringOptionsPanel extends OptionsPanel {
    JSlider sl;
    private double k;
    JSlider ds;
    private double damping;
    JSlider st;
    private double startingStretch;

    public SpringOptionsPanel(SpringSimulator ss, Canvas c){
        super(ss,new String[]{"Potential Energy", "Kinetic Energy", "Acceleration", "Time", "Velocity", "Compression", "Force", "Total Energy"});

        parent = c;

        final JLabel title3 = new JLabel("Choose Spring Constant:");
        title3.setVisible(true);//
        this.add(title3);

        sl = new JSlider(0,3000);
        sl.setMajorTickSpacing(500);
        sl.setMinorTickSpacing(250);
        sl.setPaintTicks(true);
        sl.setPaintLabels(true);
        sl.setVisible(true);
        sl.setMaximumSize(new Dimension(((int) ss.simWidth / 2), 50));
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

        ds = new JSlider(0, 10);
        ds.setMajorTickSpacing(2);
        ds.setMinorTickSpacing(1);
        ds.setPaintTicks(true);
        ds.setPaintLabels(true);
        ds.setVisible(true);
        ds.setMaximumSize(new Dimension((int) ss.simWidth / 2, 50));
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

        st = new JSlider(-250, 250);
        st.setMajorTickSpacing(50);
        st.setMinorTickSpacing(10);
        st.setPaintTicks(true);
        st.setPaintLabels(true);
        st.setVisible(true);
        st.setMaximumSize(new Dimension((int) ss.simWidth / 2, 50));
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

        submit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                startSim();
            }
        });
    }

    public void startSim(){
        int k = xdrop.getSelectedIndex();
        int k2 = ydrop.getSelectedIndex();
        double k3 = sl.getValue();
        double k4 = ds.getValue();
        double k5 = st.getValue();
        ((SpringSimulator)sim).startRecording(variables[k], variables[k2], k3, k4, k5);
        System.out.println("Graph X should be " + variables[k]);
        System.out.println("Graph Y should be " + variables[k2]);
        super.startSim();
        submit.removeActionListener(al);
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetSim();
            }
        });
    }

    public void resetSim(){
        super.resetSim();
        sim.stop();
        parent.resetSim(this);
        System.out.println("Resetting");
    }

    @Override
    public int getID(){
        return 1;
    }
}
