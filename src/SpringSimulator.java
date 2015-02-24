import java.awt.*;

/**
 * Created by lucaswebb on 2/22/15.
 */

public class SpringSimulator extends Simulator {
    Spring spring;
    double simWidth;
    double simHeight;
    Polygon mass;


    public SpringSimulator(double w, double h, double m, double k, double l, int fps){
        super();

        simWidth = w;
        simHeight = h;

        logic = new SpringSimLogic(w, h, m, k, l, fps);
        mass = new Polygon();
    }

    public void paintComponent(Graphics g){
        //g.fillRect(20, 500, 40, 10);
        //g.fillRect(spring);
        //g.fillPolygon(mass);
    }

    @Override
    public void updateGUI(){
        repaint();
    }
}
