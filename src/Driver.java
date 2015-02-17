import javax.swing.*;
import java.awt.*;

/**
 * Created by Sam Noyes and Lucas Webb on 2/10/15.
 */
public class Driver extends JFrame {
    public static void main(String[] args) {
        Driver d = new Driver();
		Canvas c = new Canvas();
		c.setLayout(null);
		d.add(c);
		d.setTitle("Physics Simulator v. 1.0.0");
		d.setDefaultCloseOperation(EXIT_ON_CLOSE);
		d.setVisible(true);
		d.setSize(1275, 2000);
    }
}
