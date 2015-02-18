import java.awt.*;

/**
 * Created by Sam Noyes on 2/17/15.
 */
public class RampSimulator extends Simulator {
    double angle;
    double rampLen;
    Ball ball;
    Ramp ramp;
    public RampSimulator(double a, double rampLen, double ballMass, double ballRadius) {
        super();
        angle = a;
        ball = new Ball(0,360.0-angle,ballMass,ballRadius,Math.sin(angle)*rampLen+ballRadius, ballRadius, 1);
        int[] xpoints = {(int)ball.getBallLogic().getRadius(),(int)ball.getBallLogic().getRadius(), (int)(Math.cos(angle)*rampLen)};
        int[] ypoints = {this.getHeight()-(int)(Math.sin(angle)*rampLen), this.getHeight(), this.getHeight()};
        ramp = new Ramp(xpoints, ypoints, 3, Color.red);
        System.out.println("Making the ramp sim");
        this.setBackground(Color.black);
        repaint();
    }

    public void paintComponent(Graphics g) {
        g.setColor(ramp.c);
        g.fillPolygon(ramp);
        System.out.println("Drawing ramp");
    }

}