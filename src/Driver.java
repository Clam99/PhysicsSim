import javax.swing.*;

/**
 * Created by smurphy on 2/10/15.
 */
public class Driver extends JFrame {
    public static void main(String[] args) {
        Driver d = new Driver();
        Canvas c = new Canvas();
        d.add(c);
        d.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
