import javax.swing.*;
import java.awt.*;

/**
 * Created by smurphy on 2/24/15.
 */
public class OptionsPanel extends JPanel {
    Canvas parent;
    String[] variables;
    JButton submit;

    public OptionsPanel() {

    }
    public void startSim() {
        submit.setText("Reset");
    }
}
