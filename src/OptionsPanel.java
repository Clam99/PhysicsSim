import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by smurphy on 2/24/15.
 */
public class OptionsPanel extends JPanel {
    Canvas parent;
    String[] variables;
    JButton submit;
    ActionListener al;

    public OptionsPanel() {
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
