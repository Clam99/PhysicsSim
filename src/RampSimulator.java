import java.awt.*;

/**
 * Created by Sam Noyes on 2/17/15.
 */

public class RampSimulator extends Simulator {
    Ball ball;
    Ramp ramp;
    double simHeight;
    double simWidth;
    public Graph graph;
    double initialBallX;
    double initialBallY;
    RampSimLogic logic;

    public RampSimulator(double a, double rampLen, double ballMass, double ballRadius, double w, double h, Graph g, double gF) {
        super();

        graph = g;
        simHeight = h;
        simWidth = w;
        initialBallX = ballRadius*Math.cos(Math.toRadians(90)-a);
        initialBallY = simHeight-Math.sin(a)*rampLen-ballRadius*Math.sin(Math.toRadians(90)-a);
        ball = new Ball(0,Math.toRadians(360)-a,ballMass,initialBallX,initialBallY, ballRadius, 1, gF, fps);
        int[] xpoints = {0,0, (int)(Math.cos(a)*rampLen)};
        int[] ypoints = { (int)(-Math.sin(a)*rampLen+simHeight), (int)simHeight, (int)simHeight};//In order from top left, bottom left, bottom right
        ramp = new Ramp(xpoints, ypoints, 3, Color.red);
        logic = new RampSimLogic(ball, ramp, graph, a, rampLen, simWidth, simHeight, fps);
        repaint();
        op = new OptionsPanel();
    }

    public void paintComponent(Graphics g) {
        g.setColor(ramp.c);
        g.fillPolygon(ramp);
        g.setColor(Color.blue);
        g.fillOval((int) (ball.getBallLogic().getX() - ball.getBallLogic().getRadius()), (int) (ball.getBallLogic().getY() - ball.getBallLogic().getRadius()), (int) ball.getBallLogic().getRadius() * 2, (int) ball.getBallLogic().getRadius() * 2);
        g.setColor(Color.black);
        g.fillRect((int) logic.floor.getX1(), (int) logic.floor.getY1(), (int) logic.floor.getX2() - (int) logic.floor.getX1(), 200);
        g.fillRect((int) logic.rightWall.getX1(), (int) logic.rightWall.getY1(), 200, (int) logic.rightWall.getY2() - (int) logic.rightWall.getY1());
    }



    @Override
    public void updateGUI() {
        repaint();
        logic.update();
    }


}