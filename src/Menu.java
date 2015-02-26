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

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel title = new JLabel("Welcome to PhysicsSim!");
        title.setVisible(true);
        add(title);
        JLabel prompt = new JLabel ("Please select a simulator.");
        prompt.setVisible(true);
        this.add(title);
        add(prompt);


        //JPanel slider = new JPanel();
        //slider.setLayout(new BoxLayout(slider, BoxLayout.X_AXIS));


        String[] sims = {"RampSimulator", "SpringSimulator"};
        drop = new JComboBox<String>(sims);
        drop.setMaximumSize(new Dimension((int)p.getScreenWidth()/2, 30));
        drop.setVisible(true);
        add(drop);
        //slider.add(drop);
        //slider.add(selected);

        JButton selected = new JButton("OK");
        selected.setVisible(true);
        add(selected);

        //this.add(slider);

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
        parent.startSim(k);
    }
}
