import java.awt.*;

/**
 * Created by Sam Noyes on 2/17/15.
 */
public class RampSimulator extends Simulator {
    double angle;
    double rampLen;
    Ball ball;
    Ramp ramp;
    double simHeight;
    double simWidth;

    public RampSimulator(double a, double rampLen, double ballMass, double ballRadius, double w, double h) {
        super();
        simHeight = h;
        simWidth = w;
        angle = a;
        this.rampLen = rampLen;
        ball = new Ball(0,Math.toRadians(360)-angle,ballMass,ballRadius*Math.cos(Math.toRadians(90)-angle),simHeight-Math.sin(angle)*rampLen-ballRadius*Math.sin(Math.toRadians(90)-angle), ballRadius, 1);
        int[] xpoints = {0,0, (int)(Math.cos(angle)*rampLen)};
        int[] ypoints = { (int)(-Math.sin(angle)*rampLen+simHeight), (int)simHeight, (int)simHeight};
        System.out.println(simWidth);
        ramp = new Ramp(xpoints, ypoints, 3, Color.red);
        System.out.println("Making the ramp sim");
        repaint();
        startRecording();
        int[] toadd = {ball.getX(), ball.getY()};
    }

    public void paintComponent(Graphics g) {
        g.setColor(ramp.c);
        g.fillPolygon(ramp);
        g.setColor(Color.blue);
        g.fillOval((int)(ball.getBallLogic().getX()-ball.getBallLogic().getRadius()),(int)(ball.getBallLogic().getY()- ball.getBallLogic().getRadius()),(int)ball.getBallLogic().getRadius()*2,(int)ball.getBallLogic().getRadius()*2);
    }

    @Override
    public void updateGUI() {
        ball.getBallLogic().setV(ball.getBallLogic().getV()+Math.sin(angle)*9.8/fps);
        ball.getBallLogic().updatePos();
        repaint();
    }
}