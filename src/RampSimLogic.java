import java.util.ArrayList;
import java.math.BigDecimal;

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
    Surface floor;
    Surface rightWall;
    Surface leftWall;
    Surface ceiling;
    ArrayList<Surface> surfaces;
    double simHeight;
    double simWidth;

    public RampSimLogic(Ball b, Ramp r, Graph g, double a, double l,double simWidth, double simHeight, int fps) {
        ball = b;
        ramp = r;
        angle = a;
        rampLen = l;
        graph = g;
        this.fps = fps;
        initialBallX = b.getBallLogic().getRadius()*Math.cos(Math.toRadians(90)-angle);
        initialBallY = simHeight-Math.sin(angle)*rampLen-b.getBallLogic().getRadius()*Math.sin(Math.toRadians(90)-angle);
        floor = new Surface(0,simWidth,simHeight-35,simHeight-35);
        rightWall = new Surface(simWidth/2-10, simWidth/2-10,0,simHeight);
        leftWall = new Surface(0,0,0,simHeight);
        ceiling = new Surface(0,simWidth,0,0);
        surfaces = new ArrayList<Surface>();
        surfaces.add(ramp.getSurface());
        surfaces.add(floor);
        //surfaces.add(leftWall);
        surfaces.add(rightWall);
        //surfaces.add(ceiling);
        this.simWidth = simWidth;
        this.simHeight = simHeight;
    }

    public void updateDistance(double xi, double yi){
        ballDistance += Ball.getDistance(ball.getBallLogic().getX(), ball.getBallLogic().getY(), xi, yi);
    }

    public void update() {
        double xi = ball.getBallLogic().getX();
        double yi = ball.getBallLogic().getY();

        //
        for (Surface f:surfaces) {
            if (f.intersectsBall(ball)) {
                collide(f);
                bounce(f);
            }
        }
        updateBallV();
        ball.getBallLogic().updatePos();
        updateDistance(xi, yi);
        updateCount++;
        //int[] toadd = {(int)ball.getBallLogic().getX(), (int)simHeight-(int)ball.getBallLogic().getY()};
        //int[] toadd = {updateCount, (int)ballDistance };
        //int[] toadd = {updateCount, (int)ball.getBallLogic().getV() };
        int[] toAdd = {updateCount, (int)ball.getBallLogic().getTotalE(simHeight-35) };
        graph.addPoint(toAdd);
        //graph.addPoint(toAdd2);
        //System.out.println("In updateGUI: " + toadd[0]);
    }

    public void updateBallV() {
        BallLogic bl = ball.getBallLogic();
        bl.setVy(bl.getVy() + ball.getBallLogic().getG()/((double)fps));
    }

    public void collide(Surface s) {
        Vector collisionPoint = s.getCoordsCorrespondingToXAndYWithAngle(ball.getBallLogic().getX(),ball.getBallLogic().getY());
        if (ball.getBallLogic().getX()-collisionPoint.getX()>=0) {
            ball.getBallLogic().setX(collisionPoint.getX() + ball.getBallLogic().getRadius() * Math.cos(Math.toRadians(90)-s.angleFromPositiveHor()));
        }
        else {
            ball.getBallLogic().setX(collisionPoint.getX() - ball.getBallLogic().getRadius() * Math.cos(Math.toRadians(90)-s.angleFromPositiveHor()));
        }
        if (ball.getBallLogic().getY()-collisionPoint.getY()>=0) {
            ball.getBallLogic().setY(collisionPoint.getY() + ball.getBallLogic().getRadius() * Math.sin(Math.toRadians(90) - s.angleFromPositiveHor()));
        }
        else {
            ball.getBallLogic().setY(collisionPoint.getY() - ball.getBallLogic().getRadius() * Math.sin(Math.toRadians(90) - s.angleFromPositiveHor()));
        }
    }

    public void bounce(Surface s) {
        //Taken from here:http: //stackoverflow.com/questions/14885693/how-do-you-reflect-a-vector-over-another-vector

        //ball.getBallLogic().updatePos();
        Vector vec1 = new Vector(ball.getBallLogic().getVx(), ball.getBallLogic().getVy());
        Vector vec2 = s.getSurfaceVector();

        //System.out.println("Line 101 total E: " + ball.getBallLogic().getTotalE(simHeight-35));

        // 1. Find the dot product of vec1 and vec2
        // Note: dx and dy are vx and vy divided over the length of the vector (magnitude)
        double dpA = vec1.getX() * vec2.dx() + vec1.getY() * vec2.dy();

        // 2. Project vec1 over vec2
        double prA_vx = dpA * vec2.dx();
        double prA_vy = dpA * vec2.dy();

        // 3. Find the dot product of vec1 and vec2's normal
        // (left or right normal depending on line's direction, let's say left)
        double dpB = vec1.getX() * vec2.leftNormal().dx() + vec1.getY() * vec2.leftNormal().dy();

        // 4. Project vec1 over vec2's left normal
        double prB_vx = dpB * vec2.leftNormal().dx();
        double prB_vy = dpB * vec2.leftNormal().dy();

        // 5. Add the first projection prA to the reverse of the second -prB
        double new_vx = prA_vx - prB_vx;
        double new_vy = prA_vy - prB_vy;

        new_vx *= ball.getBallLogic().getRebound();
        new_vy *= ball.getBallLogic().getRebound();

        ball.getBallLogic().setVx(new_vx);
        ball.getBallLogic().setVy(new_vy);
        //System.out.println("Line 128: " + ball.getBallLogic().getTotalE(simHeight - 35));
       // ball.getBallLogic().updatePos();
        //System.out.println("Line 130: " + ball.getBallLogic().getTotalE(simHeight - 35) + "\n\n");
    }

}
