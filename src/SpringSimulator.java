import java.awt.*;

/**
 * Created by lucaswebb on 2/22/15.
 */

public class SpringSimulator extends Simulator {
    Spring spring;
    double simWidth;
    double simHeight;


    public SpringSimulator(double w, double h, double m, double k, double l, int fps){
        logic = new SpringSimLogic(w, h, m, k, l, fps);

    }

    public void paintComponent(Graphics g){

    }

    @Override
    public void updateGUI(){

    }
}
