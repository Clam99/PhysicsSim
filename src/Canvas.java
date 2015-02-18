import javax.swing.*;
import java.awt.*;

/**
 * Created by Sam Noyes and Lucas Webb on 2/10/15.
 */

public class Canvas extends JPanel{

    RampSimulator rs;

    public Canvas(Driver d){
        super();
        d.setTitle("Physics Simulator v. 1.0.0");
        d.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        d.setVisible(true);
        d.setSize(1000, 500);
        d.add(this);
        rs = new RampSimulator(31,500,20, 15);
        d.add(rs);
        this.setBackground(Color.blue);
        //rs.setLocation(0,0);
        //rs.setSize(this.getWidth(),this.getHeight());
        //showChooseScreen();
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
