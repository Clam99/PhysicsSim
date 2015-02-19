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
    Graph graph;
    int updateCount = 0;
    double initialBallX;
    double initialBallY;
    double ballDistance = 0;

    public RampSimulator(double a, double rampLen, double ballMass, double ballRadius, double w, double h, Graph g) {
        super();
        graph = g;
        simHeight = h;
        simWidth = w;
        angle = a;
        this.rampLen = rampLen;
        initialBallX = ballRadius*Math.cos(Math.toRadians(90)-angle);
        initialBallY = simHeight-Math.sin(angle)*rampLen-ballRadius*Math.sin(Math.toRadians(90)-angle);
        ball = new Ball(0,Math.toRadians(360)-angle,ballMass,initialBallX,initialBallY, ballRadius, 1);
        int[] xpoints = {0,0, (int)(Math.cos(angle)*rampLen)};
        int[] ypoints = { (int)(-Math.sin(angle)*rampLen+simHeight), (int)simHeight, (int)simHeight};
        System.out.println(simWidth);
        ramp = new Ramp(xpoints, ypoints, 3, Color.red);
        System.out.println("Making the ramp sim");
        repaint();
        startRecording();
    }

    public void paintComponent(Graphics g) {
        g.setColor(ramp.c);
        g.fillPolygon(ramp);
        g.setColor(Color.blue);
        g.fillOval((int)(ball.getBallLogic().getX()-ball.getBallLogic().getRadius()),(int)(ball.getBallLogic().getY()- ball.getBallLogic().getRadius()),(int)ball.getBallLogic().getRadius()*2,(int)ball.getBallLogic().getRadius()*2);


        //System.out.println("it works");
    }

    public void updateDistance(double xi, double yi){
        ballDistance += Ball.getDistance(ball.getBallLogic().getX(), ball.getBallLogic().getY(), xi, yi);
    }

    @Override
    public void updateGUI() {
        double xi = ball.getBallLogic().getX();
        double yi = ball.getBallLogic().getY();
        ball.getBallLogic().setV(ball.getBallLogic().getV()+Math.sin(angle)*9.8/fps);
        ball.getBallLogic().updatePos();
        updateDistance(xi, yi);
        repaint();
        updateCount++;
        //int[] toadd = {(int)ball.getBallLogic().getX(), (int)simHeight-(int)ball.getBallLogic().getY()};
        int[] toadd = {updateCount, (int)ballDistance };
        //int[] toadd = {updateCount, (int)simHeight-(int)ball.getBallLogic().getV() };
        graph.addPoint(toadd);
        //System.out.println("In updateGUI: " + toadd[0]);
    }


}