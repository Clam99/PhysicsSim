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

    public RampSimLogic(Ball b, Ramp r, Graph g, double a, double l,double sw, double sh, int fps) {
        super();
        this.simWidth = sw;
        this.simHeight = sh-35;
        ball = b;
        ramp = r;
        angle = a;
        rampLen = l;
        graph = g;
        this.fps = fps;
        initialBallX = b.getBallLogic().getRadius()*Math.cos(Math.toRadians(90)-angle);
        initialBallY = simHeight-Math.sin(angle)*rampLen-b.getBallLogic().getRadius()*Math.sin(Math.toRadians(90)-angle);
        floor = new Surface(0,simWidth,simHeight,simHeight);
        rightWall = new Surface(simWidth/2-10, simWidth/2-10,0,simHeight);
        leftWall = new Surface(0,0,0,simHeight);
        ceiling = new Surface(0,simWidth,0,0);
        surfaces = new ArrayList<Surface>();
        surfaces.add(ramp.getSurface());
        surfaces.add(floor);
        //surfaces.add(leftWall);
        surfaces.add(rightWall);
        //surfaces.add(ceiling);
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


        //String[] variables = {"Kinetic Energy", "Potential Energy", "Distance Travelled", "Time", "Velocity"};
        double[] toAdd = {0,0};
        try {
            if (getToGraphX().equals("Potential Energy")) {
                toAdd[0] = (ball.getBallLogic().getPE(simHeight));
            }
            if (getToGraphX().equals("Kinetic Energy")) {
                toAdd[0] =  (ball.getBallLogic().getKE());
            }
            if (getToGraphX().equals("Distance Travelled")) {
                toAdd[0] =  (ballDistance);
            }
            if (getToGraphX().equals("Time")) {
                toAdd[0] = ((double)updateCount/(double)fps);
            }
            if (getToGraphX().equals("Velocity")) {
                toAdd[0] =  (ball.getBallLogic().getV());
            }
            if (getToGraphX().equals("X Position")) {
                toAdd[0] = (ball.getBallLogic().getX());
            }
            if (getToGraphX().equals("Y Position")) {
                toAdd[0] = (simHeight-ball.getBallLogic().getY());
            }
            if (getToGraphX().equals("Total Energy")) {
                toAdd[0] = (ball.getBallLogic().getTotalE(simHeight));
            }

            if (getToGraphY().equals("Potential Energy")) {
                toAdd[1] = (ball.getBallLogic().getPE(simHeight));
            }
            if (getToGraphY().equals("Kinetic Energy")) {
                toAdd[1] =  (ball.getBallLogic().getKE());
            }
            if (getToGraphY().equals("Distance Travelled")) {
                toAdd[1] =  (ballDistance);
            }
            if (getToGraphY().equals("Time")) {
                toAdd[1] = ((double)updateCount/(double)fps);
            }
            if (getToGraphY().equals("Velocity")) {
                toAdd[1] = (ball.getBallLogic().getV());
            }
            if (getToGraphY().equals("X Position")) {
                toAdd[1] = (ball.getBallLogic().getX());
            }
            if (getToGraphY().equals("Y Position")) {
                toAdd[1] =  (simHeight-ball.getBallLogic().getY());
            }
            if (getToGraphY().equals("Total Energy")) {
                toAdd[1] = (ball.getBallLogic().getTotalE(simHeight));
            }

            graph.addPoint(toAdd);
        }
        catch(NullPointerException npe) {
            System.out.println("Crashed. graphX: " + toGraphX);
        }

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
        BigDecimal dpA = new BigDecimal(vec1.getX()).setScale(40, BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal(vec2.dx()).setScale(40, BigDecimal.ROUND_HALF_UP)).add(new BigDecimal(vec1.getY()).setScale(40, BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal(vec2.dy()).setScale(40, BigDecimal.ROUND_HALF_UP))).setScale(40, BigDecimal.ROUND_HALF_UP) ;

        // 2. Project vec1 over vec2
        BigDecimal prA_vx = dpA.multiply(new BigDecimal(vec2.dx()).setScale(40, BigDecimal.ROUND_HALF_UP));
        BigDecimal prA_vy = dpA.multiply(new BigDecimal(vec2.dy()).setScale(40, BigDecimal.ROUND_HALF_UP));

        // 3. Find the dot product of vec1 and vec2's normal
        // (left or right normal depending on line's direction, let's say left)
        BigDecimal dpB = new BigDecimal(vec1.getX()).setScale(40, BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal(vec2.leftNormal().dx()).setScale(40, BigDecimal.ROUND_HALF_UP)).add(new BigDecimal(vec1.getY()).setScale(40, BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal(vec2.leftNormal().dy()).setScale(40, BigDecimal.ROUND_HALF_UP)));

        // 4. Project vec1 over vec2's left normal
        BigDecimal prB_vx = dpB.multiply(new BigDecimal(vec2.leftNormal().dx()).setScale(40, BigDecimal.ROUND_HALF_UP));
        BigDecimal prB_vy = dpB.multiply(new BigDecimal(vec2.leftNormal().dy()).setScale(40, BigDecimal.ROUND_HALF_UP));

        // 5. Add the first projection prA to the reverse of the second -prB
        BigDecimal new_vx = prA_vx.subtract(prB_vx);
        BigDecimal new_vy = prA_vy.subtract(prB_vy);

      //  new_vx *= ball.getBallLogic().getRebound();
      //  new_vy *= ball.getBallLogic().getRebound();

        ball.getBallLogic().setVx(new_vx.doubleValue());
        ball.getBallLogic().setVy(new_vy.doubleValue());
        //System.out.println("Line 128: " + ball.getBallLogic().getTotalE(simHeight));
        //ball.getBallLogic().updatePos();
        //System.out.println("Line 130: " + ball.getBallLogic().getTotalE(simHeight) + "\n\n");
    }

}
