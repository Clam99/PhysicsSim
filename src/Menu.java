import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;

/**
 * Created by lucaswebb on 2/20/15.
 */

public class Menu extends JPanel {
    JComboBox drop;
    Canvas parent;

    public Menu(Canvas p){

        parent = p;

        //this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        JPanel container = new JPanel();
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
        container.setPreferredSize(new Dimension((int)parent.screenWidth/2, (int)parent.screenHeight/6));
        container.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        container.setAlignmentY(JComponent.CENTER_ALIGNMENT);

        JLabel title = new JLabel("Welcome to PhysicsSim!");
        title.setVisible(true);
        container.add(title);
        JLabel prompt = new JLabel ("Please select a simulator.");
        prompt.setVisible(true);
        container.add(title);
        container.add(prompt);

        String[] sims = {"RampSimulator", "SpringSimulator"};
        drop = new JComboBox<String>(sims);
        drop.setVisible(true);
        container.add(drop);

        JButton selected = new JButton("OK");
        selected.setVisible(true);
        container.add(selected);

        add(container);

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
        parent.startSim(k);
    }
}
