import java.awt.*;

/**
 * Created by Sam Noyes on 2/10/15.
 */
public class Ball extends PhysicsObject {
    private BallLogic bl;
    public Ball(double r, double rb) {
        super();
        bl = new BallLogic(r, rb);//Creates logic object
    }
    public Ball(double v, double d, double m, double x, double y, double r, double rb, double g, int fps) { super(); bl = new BallLogic(v,d,m,x,y,r,rb,g, fps); }

    public BallLogic getBallLogic() {
        return bl;
    }

    public static double getDistance(double xi, double yi, double xf, double yf) {//Use the distance formula to calculate the distance between (xi,yi) and (xf,yf)
        return Math.sqrt((xi-xf)*(xi-xf)+(yi-yf)*(yi-yf));
    }

}
