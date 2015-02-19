import java.awt.*;

/**
 * Created by smurphy on 2/10/15.
 */
public class Ball extends PhysicsObject {
    private BallLogic bl;
    public Ball(double r, double rb) {
        super();
        bl = new BallLogic(r, rb);
    }
    public Ball(double v, double d, double m, double x, double y, double r, double rb) { super(); bl = new BallLogic(v,d,m,x,y,r,rb); }

    public void paintComponent(Graphics g) {
        g.drawOval((int)(bl.getX()-bl.getRadius()), (int)(bl.getY()-bl.getRadius()), (int)(bl.getRadius()), (int)(bl.getRadius()));
    }

    public BallLogic getBallLogic() {
        return bl;
    }

    public static double getDistance(double xi, double yi, double xf, double yf) {
        return Math.sqrt((xi-xf)*(xi-xf)+(yi-yf)*(yi-yf));
    }

}
