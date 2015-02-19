/**
 * Created by smurphy on 2/10/15.
 */
public class BallLogic extends PhysicsObjectLogic {
    private double rebound;//Percentage of energy conversion on rebound from zero to one
    private double radius;

    public BallLogic(double v, double d, double m, double x, double y, double r, double rb, double g) { super(v,d,m,x,y,g); radius = r; rebound = rb; }
    public BallLogic(double r, double rb) { super(); radius = r; rebound = rb; }
    public double getRadius() { return radius; }
    public double getRebound() { return rebound; }
}
