import javax.swing.*;
import java.awt.*;

/**
 * Created by Sam Noyes and Lucas Webb on 2/10/15.
 */

public class Canvas extends JPanel{

    public Canvas(){
        //JLabel label = new JLabel("test");
        //label.setPreferredSize(new Dimension(600, 400));
        //this.add(label);

        showChooseScreen();
    }

    public void showChooseScreen(){//Show the screen to choose the specific simulator
        showMessage("Spring",300,100,0,0);
        showMessage("Pendulum",300,100,0,200);
    }

    public void showMessage(String str, int width, int height, int x, int y){//show onscreen message
        JLabel label = new JLabel(str);
        label.setSize(new Dimension(width, height));
        label.setLocation(x,y);
        this.add(label);
    }

}
