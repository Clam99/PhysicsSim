import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Lucas Webb on 2/20/15.
 */

public class Menu extends JPanel {//Panel which serves as the menu screen
    JComboBox drop;
    Canvas parent;

    public Menu(Canvas p){
        parent = p;

        //Sets layout and creates container for alignment
        JPanel container = new JPanel();
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
        container.setPreferredSize(new Dimension((int)parent.screenWidth/2, (int)parent.screenHeight/6));
        container.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        container.setAlignmentY(JComponent.CENTER_ALIGNMENT);

        //Title JLabel
        JLabel title = new JLabel("Welcome to PhysicsSim!");
        title.setVisible(true);
        container.add(title);
        //Text Label
        JLabel prompt = new JLabel ("Please select a simulator.");
        prompt.setVisible(true);
        container.add(title);
        container.add(prompt);

        //Dropbox to select simulator
        String[] sims = {"RampSimulator", "SpringSimulator"};
        drop = new JComboBox<String>(sims);
        drop.setVisible(true);
        container.add(drop);

        JButton selected = new JButton("OK");
        selected.setVisible(true);
        container.add(selected);

        add(container);

        //Action listener for button
        selected.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                startSim();
            }
        });
    }

    private void startSim(){//Called when button is pressed to start sim
        int k = drop.getSelectedIndex();
        parent.startSim(k);//Calls canvas's start sim method
    }
}
