import javax.swing.*;
import java.awt.*;

/**
 * Created by smurphy on 2/10/15.
 */
public class Driver extends JFrame {

    public Driver(String str) {
        super(str);
    }

    public static void main(String[] args) {
        Driver d = new Driver("Simple GUI");
        d.setPreferredSize(new Dimension(600,400));
        Canvas c = new Canvas();

        JLabel label = new JLabel("test", SwingConstants.CENTER);
        label.setPreferredSize(new Dimension(300, 100));

        //c.add(label);
        d.getContentPane().add(c);
        d.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        d.setLocationRelativeTo(null);
        d.pack();
        d.setVisible(true);
    }
}
