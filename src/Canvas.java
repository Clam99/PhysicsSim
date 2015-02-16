import javax.swing.*;
import java.awt.*;

/**
 * Created by Sam Noyes on 2/10/15.
 * Canvas is the limited-functionality drag and drop canvas
 */

public class Canvas extends JPanel {

    public Canvas() {
        JLabel label = new JLabel("test");
        label.setPreferredSize(new Dimension(600, 400));
        this.add(label);
    }

    public void showChooseScreen() {//Show the screen to choose the specific simulator
        showMessage("Spring");
        showMessage("Pendulum");
    }

    public void showMessage(String str) {//show onscreen message

    }

}
