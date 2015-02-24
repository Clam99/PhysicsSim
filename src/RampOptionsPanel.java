import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by smurphy on 2/24/15.
 */
public class RampOptionsPanel extends OptionsPanel {
    JComboBox drop;
    RampSimulator rs;

    public RampOptionsPanel(RampSimulator rs){

        this.rs = rs;

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel title = new JLabel("Select a variable to graph:");
        title.setVisible(true);
        this.add(title);

        String[] sims = {"Kinetic Energy", "Potential Energy"};
        drop = new JComboBox<String>(sims);
        drop.setVisible(true);
        this.add(drop);

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
        int k = drop.getSelectedIndex();
        System.out.println(k);
        //rs.startRecording(drop.get); To implement
    }
}
