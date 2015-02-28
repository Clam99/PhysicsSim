import javax.swing.*;
import java.awt.*;

/**
 * Created by Sam Noyes and Lucas Webb on 2/10/15.
 */

public class Driver extends JFrame {//Driver is the Frame, so extends JFrame
    public static void main(String[] args) {
        Driver d = new Driver();
		new Canvas(d);//Creates new canvas and passes in driver so panels can be added
    }
}
