import java.awt.*;

/**
 * Created by lucaswebb on 2/22/15.
 */

public class SpringSimulator extends Simulator {
    Spring spring;//The spring object
    Rectangle block;//the mass on the end of the spring
    double mx;//Location of mass x
    double my;//location of mass y
    double velocity;
    double k;
    double mass;
    double length;
    double damping = 0;
    int blockHeight = 50;
    int springHeight = blockHeight-30;
    Graph g;

    public SpringSimulator(double w, double h, double m, double k, double d, double l, Graph g, Canvas c){
        super();
        simWidth = w;
        simHeight = h;
        this.k = k;
        mass = m;
        length = l;
        damping = d;
        this.g = g;

        spring = new Spring(0, (int)simHeight/2-springHeight/2, l, springHeight, 1, 10, 10, fps, 0);
        //Sets mass location
        mx = spring.getLength();
        my = (int)simHeight/2-blockHeight/2;
        //Creates mass
        block = new Rectangle();
        block.setBounds((int)mx, (int)my, blockHeight, blockHeight);

        velocity = 0;

        op = new SpringOptionsPanel(this, c);//Creates option panel for spring sim
    }

    public void paintComponent(Graphics g){//Paints everything
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.blue);
        g2.fill(block);
        g2.setColor(Color.black);
        for (int i = 0; i<10; i++) {//Makes spring actually look like spring
            g2.fill(new Rectangle((int)(i*(spring.getWidth()/10)),(int)spring.getY(),10,(int)spring.getHeight()));
        }
        g2.draw(spring);
    }

    @Override
    public void updateGUI(){//Called every tick, updates spring length and mass position
        spring.updateLength();
        block.setLocation((int)spring.getLength(), (int)my);
        ((SpringSimLogic)logic).update();
        repaint();
    }

    public void startRecording(String str, String str2, double k, double k2, double k3){//Starts based on inputs from options panel
        this.k = k;
        damping = k2;
        spring = new Spring(0, (int)simHeight/2-springHeight/2, spring.getLength(), springHeight, k, damping, 10, fps, k3);
        logic = new SpringSimLogic(simWidth, simHeight, mass, k, length, damping, spring, velocity, g, fps);
        repaint();
        super.startRecording(str, str2);
    }
}
