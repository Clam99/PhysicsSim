/**
 * Created by Sam Noyes on 2/17/15.
 */

public class RampSimLogic extends SimLogic {
    Ball ball;
    Ramp ramp;
    double ballDistance = 0;
    double angle;
    double rampLen;
    int updateCount = 0;
    Graph graph;
    double initialBallX;
    double initialBallY;
    int fps;

    public RampSimLogic(Ball b, Ramp r, Graph g, double a, double l,double simWidth, double simHeight, int fps) {
        ball = b;
        ramp = r;
        angle = a;
        rampLen = l;
        graph = g;
        this.fps = fps;
        initialBallX = b.getBallLogic().getRadius()*Math.cos(Math.toRadians(90)-angle);
        initialBallY = simHeight-Math.sin(angle)*rampLen-b.getBallLogic().getRadius()*Math.sin(Math.toRadians(90)-angle);
    }

    public void updateDistance(double xi, double yi){
        ballDistance += Ball.getDistance(ball.getBallLogic().getX(), ball.getBallLogic().getY(), xi, yi);
    }

    public void update() {
        double xi = ball.getBallLogic().getX();
        double yi = ball.getBallLogic().getY();
        updateBallV();
        ball.getBallLogic().updatePos();
        updateDistance(xi, yi);
        updateCount++;
        //int[] toadd = {(int)ball.getBallLogic().getX(), (int)simHeight-(int)ball.getBallLogic().getY()};
        //int[] toadd = {updateCount, (int)ballDistance };
        //int[] toadd = {updateCount, (int)ball.getBallLogic().getV() };
        int[] toadd = {updateCount, (int)ball.getBallLogic().getKE() };
        graph.addPoint(toadd);
        //System.out.println("In updateGUI: " + toadd[0]);
    }

    public void updateBallV() {
        BallLogic bl = ball.getBallLogic();
        bl.setVy(9.8*(1000/fps));
        checkCollisions();
    }

    public void checkCollisions() {

    }

}
