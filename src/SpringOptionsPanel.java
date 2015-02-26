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
        ((SpringSimulator)sim).startRecording(variables[k], variables[k2], k3);
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
