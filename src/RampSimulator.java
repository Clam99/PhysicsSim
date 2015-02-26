import java.awt.*;

/**
 * Created by Sam Noyes on 2/17/15.
 */

public class RampSimulator extends Simulator {
    Ball ball;
    Ramp ramp;
    public Graph graph;
    double initialBallX;
    double initialBallY;
    double angle;
    double rampLen;
    double gF;//gravitational field
    double ballRadius;
    double ballMass;
   // RampSimLogic logic;

    public RampSimulator(double a, double rampLen, double ballMass, double ballRadius, double w, double h, Graph g, double gF, Canvas p) {
        //super();
        graph = g;
        simHeight = h;
        simWidth = w;
        angle = a;
        this.rampLen = rampLen;
        op = new RampOptionsPanel(this, p);
        this.gF = gF;
        this.ballRadius = ballRadius;
        this.ballMass = ballMass;
    }

    public void paintComponent(Graphics g) {
        if (recording) {
            g.setColor(ramp.c);
            g.fillPolygon(ramp);
            g.setColor(Color.blue);
            g.fillOval((int) (ball.getBallLogic().getX() - ball.getBallLogic().getRadius()), (int) (ball.getBallLogic().getY() - ball.getBallLogic().getRadius()), (int) ball.getBallLogic().getRadius() * 2, (int) ball.getBallLogic().getRadius() * 2);
            g.setColor(Color.black);
            g.fillRect((int) ((RampSimLogic) logic).floor.getX1(), (int) ((RampSimLogic) logic).floor.getY1(), (int) ((RampSimLogic) logic).floor.getX2() - (int) ((RampSimLogic) logic).floor.getX1(), 200);
            g.fillRect((int) ((RampSimLogic) logic).rightWall.getX1(), (int) ((RampSimLogic) logic).rightWall.getY1(), 200, (int) ((RampSimLogic) logic).rightWall.getY2() - (int) ((RampSimLogic) logic).rightWall.getY1());
        }
    }



    @Override
    public void updateGUI() {
        repaint();
        ((RampSimLogic)logic).update();
    }


    public void makeRamp() {
        int[] xpoints = {0,0, (int)(Math.cos(angle)*rampLen)};
        int[] ypoints = { (int)(-Math.sin(angle)*rampLen+simHeight), (int)simHeight, (int)simHeight};//In order from top left, bottom left, bottom right

        ramp = new Ramp(xpoints, ypoints, 3, Color.red);
        initialBallX = ballRadius*Math.cos(Math.toRadians(90)-angle);
        initialBallY = simHeight-Math.sin(angle)*rampLen-ballRadius*Math.sin(Math.toRadians(90)-angle);
        ball = new Ball(0,Math.toRadians(360)-angle,ballMass,initialBallX,initialBallY, ballRadius, 1, gF, fps);
    }

    public void startRecording(String str, String str2, double angle) {
        this.angle = Math.toRadians(angle);
        makeRamp();
        logic = new RampSimLogic(ball, ramp, graph, angle, rampLen, simWidth, simHeight, fps);

        repaint();
        super.startRecording(str, str2);
    }

}