import java.util.ArrayList;
import java.math.BigDecimal;

/**
 * Created by Sam Noyes on 2/17/15.
 */

public class RampSimLogic extends SimLogic {
    Ball ball;//The ball object
    Ramp ramp;//Ramp that the ball rolls on
    double ballDistance = 0; //Distance the ball has traveled
    double angle; //Angle formed by the ramp and the ground
    double rampLen; //Length of ramp's hypotenuse
    Graph graph; //the graph object to graph the simulator's data
    double initialBallX; //Initial ball position
    double initialBallY;
    int fps; //frames per second of sim update
    Surface floor;//Surface along the bottom of the screen for the ball to bounce on
    Surface rightWall;//Doesn't let the ball bounce away - keeps it in view
    //Surface leftWall;  Not currently in use because it is impossible for the ball to go over the top of the ramp
    //Surface ceiling;  Also impossible to reach the ceiling - it would have to gain energy
    ArrayList<Surface> surfaces;//list of all surfaces
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

        //position ball so it is at the very top of the ramp but not above it
        initialBallX = b.getBallLogic().getRadius()*Math.cos(Math.toRadians(90)-angle);
        initialBallY = simHeight-Math.sin(angle)*rampLen-b.getBallLogic().getRadius()*Math.sin(Math.toRadians(90)-angle);

        floor = new Surface(0,simWidth,simHeight,simHeight);
        rightWall = new Surface(simWidth/2-10, simWidth/2-10,0,simHeight);
        //leftWall = new Surface(0,0,0,simHeight);
        //ceiling = new Surface(0,simWidth,0,0);

        surfaces = new ArrayList<Surface>();
        surfaces.add(ramp.getSurface());
        surfaces.add(floor);
        surfaces.add(rightWall);

        //surfaces.add(leftWall);
        //surfaces.add(ceiling);

    }

    public void updateDistance(double xi, double yi){//updates the ballDistance variable to keep track of distance the ball has travelled
        ballDistance += Ball.getDistance(ball.getBallLogic().getX(), ball.getBallLogic().getY(), xi, yi);
    }

    public void update() {
        super.update();
        double xi = ball.getBallLogic().getX();//keep track of where the ball was before to calculate the distance moved
        double yi = ball.getBallLogic().getY();

        //Go through the surfaces and see if the ball is intersecting any of them: if so, move them apart and reflect the ball's velocity over the surface's vector
        for (Surface f:surfaces) {
            if (f.intersectsBall(ball)) {
                collide(f);
                bounce(f);
            }
        }

        updateBallV();//Make ball accelerate down
        ball.getBallLogic().updatePos();//update ball's position based on velocity

        updateDistance(xi, yi);//keep track of distance travelled


        double[] toAdd = {0,0};//point to add to the graph

        //Given a string of the variable to graph, set the point to add to the graph
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
        catch(NullPointerException npe) {//Rarely, this method was throwing inexplicable Null Pointer Exceptions, so this is to catch that
            System.out.println("Crashed. graphX: " + toGraphX);
        }

    }

    public void updateBallV() {//Make the ball accelerate down depending on its gravitational field
        BallLogic bl = ball.getBallLogic();
        bl.setVy(bl.getVy() + ball.getBallLogic().getG()/((double)fps));
    }

    public void collide(Surface s) {//If the ball is intersecting a surface, move it so that the surface is tangent to it
        Vector collisionPoint = s.getCoordsCorrespondingToXAndYWithAngle(ball.getBallLogic().getX(),ball.getBallLogic().getY());//Gets point on surface closest to the ball
        if (ball.getBallLogic().getX()-collisionPoint.getX()>=0) {//if ball is on the right side of the surface, move right
            ball.getBallLogic().setX(collisionPoint.getX() + ball.getBallLogic().getRadius() * Math.cos(Math.toRadians(90)-s.angleFromPositiveHor()));
        }
        else {//otherwise, move left
            ball.getBallLogic().setX(collisionPoint.getX() - ball.getBallLogic().getRadius() * Math.cos(Math.toRadians(90)-s.angleFromPositiveHor()));
        }
        if (ball.getBallLogic().getY()-collisionPoint.getY()>=0) {//If ball is below, move down (to a higher y value)
            ball.getBallLogic().setY(collisionPoint.getY() + ball.getBallLogic().getRadius() * Math.sin(Math.toRadians(90) - s.angleFromPositiveHor()));
        }
        else {//otherwise, move up
            ball.getBallLogic().setY(collisionPoint.getY() - ball.getBallLogic().getRadius() * Math.sin(Math.toRadians(90) - s.angleFromPositiveHor()));
        }
    }

    public void bounce(Surface s) {//Reflect ball's velocity over the vector of the surface, using BigDecimals for more precision

        //Taken from here:http: //stackoverflow.com/questions/14885693/how-do-you-reflect-a-vector-over-another-vector

        Vector vec1 = new Vector(ball.getBallLogic().getVx(), ball.getBallLogic().getVy());
        Vector vec2 = s.getSurfaceVector();


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

        ball.getBallLogic().setVx(new_vx.doubleValue());//set ball velocities to the results
        ball.getBallLogic().setVy(new_vy.doubleValue());
    }

}
