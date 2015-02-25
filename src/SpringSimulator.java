import java.awt.*;

/**
 * Created by lucaswebb on 2/22/15.
 */

public class SpringSimulator extends Simulator {
    Spring spring;
    SpringSimLogic logic;
    double simWidth;
    double simHeight;
    Rectangle block;
    double mx;
    double my;


    public SpringSimulator(double w, double h, double m, double k, double d, double l){
        super();
        simWidth = w;
        simHeight = h;

        spring = new Spring(0, (int)simHeight/2, l, 4, 1, 1, 10);
        mx = spring.getLength();
        my = (int)simHeight/2-23;
        block = new Rectangle();
        block.setBounds((int)mx, (int)my, 50, 50);

        logic = new SpringSimLogic(w, h, m, k, l, spring);

        op = new SpringOptionsPanel();
    }

    public void paintComponent(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        g2.fill(block);
        g2.fill(spring);
    }

    @Override
    public void updateGUI(){
        logic.update();
        spring.updateLength();
        block.setLocation((int)spring.getLength(), (int)simHeight/2-23);
        repaint();
    }
}
