/**
 * Created by Sam Noyes and Lucas Webb on 2/10/15.
 */

public class BallLogic extends PhysicsObjectLogic {
    private double rebound;//Percentage of energy conversion on rebound from zero to one
    private double radius;

    public BallLogic(double v, double d, double m, double x, double y, double r, double rb, double g, int fps) {
        super(v,d,m,x,y,g, fps); radius = r; rebound = rb; //Creates physics object logic
        updateCartesianVelocities();//Updates velocity
    }
    public BallLogic(double r, double rb) { super(); radius = r; rebound = rb; }
    public double getRadius() { return radius; }
    public double getRebound() { return rebound; }
}
