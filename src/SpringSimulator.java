import java.awt.*;

/**
 * Created by lucaswebb on 2/22/15.
 */

public class SpringSimulator extends Simulator {
    Spring spring;
    double simWidth;
    double simHeight;
    Rectangle block;
    double mx;
    double my;


    public SpringSimulator(double w, double h, double m, double k, double d, double l){
        super();

        simWidth = w;
        simHeight = h;

        logic = new SpringSimLogic(w, h, m, k, l, fps);



        block = new Rectangle();
        block.setBounds((int)mx, (int)my, 20, 20);

        spring = new Spring(0, (int)simHeight/2, l, 4, 1, 1);
    }

    public void paintComponent(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        g2.fill(block);
        g2.fill(spring);
    }

    @Override
    public void updateGUI(){

        repaint();
    }
}
