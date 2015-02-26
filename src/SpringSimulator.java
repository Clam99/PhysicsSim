import java.awt.*;

/**
 * Created by lucaswebb on 2/22/15.
 */

public class SpringSimulator extends Simulator {
    Spring spring;
    Rectangle block;
    double mx;
    double my;
    double velocity;
    double k;
    double mass;
    double length;
    double dampening = 0;
    Graph g;


    public SpringSimulator(double w, double h, double m, double k, double d, double l, Graph g, Canvas c){
        super();
        simWidth = w;
        simHeight = h;
        this.k = k;
        mass = m;
        length = l;
        dampening = d;
        this.g = g;

        spring = new Spring(0, (int)simHeight/2, l, 4, 1, 10, 10, fps, 0);
        mx = spring.getLength();
        my = (int)simHeight/2-23;
        block = new Rectangle();
        block.setBounds((int)mx, (int)my, 50, 50);

        velocity = 0;

        op = new SpringOptionsPanel(this, c);
    }

    public void paintComponent(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        g2.fill(block);
        g2.fill(spring);
    }

    @Override
    public void updateGUI(){
        spring.updateLength();
        block.setLocation((int)spring.getLength(), (int)simHeight/2-23);
        ((SpringSimLogic)logic).update();
        repaint();
    }

    public void startRecording(String str, String str2, double k, double k2, double k3){
        this.k = k;
        dampening = k2;
        System.out.println("In startRecording.  x = " + str + " and y = " + str2);
        spring = new Spring(0, (int)simHeight/2, spring.getLength(), 4, k, dampening, 10, fps, k3);
        logic = new SpringSimLogic(simWidth, simHeight, mass, k, length, dampening, spring, velocity, g, fps);
        repaint();
        super.startRecording(str, str2);
    }
}
