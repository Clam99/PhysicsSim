/**
 * Created by Sam Noyes and Lucas Webb on 2/10/15.
 */

public abstract class PhysicsObjectLogic {
    private double vel;//velocity
    private double dir;//direction of travel in degrees counterclockwise from horizontal
    private double mass;//mass of object
    private double x;//x coordinate of center of object in Cartesian
    private double y;//y coordinate
    private double vx;
    private double vy;
    private double g;

    public PhysicsObjectLogic() {
        super();
        vel = 0; dir = 0; mass = 0; x = 0; y = 0;
    }

    public PhysicsObjectLogic(double v, double d, double m, double xPos, double yPos, double g) {
        super();
        vel = v; dir = d; mass = m; x = xPos; y = yPos; this.g = g;
    }

    public void setVx(double v) {
        vx = v;
        updatePolarVelocities();
    }
    public double getVx() {
        return vx;
    }
    public void setVy(double v) {
        vy = v;
        updatePolarVelocities();
    }
    public double getVy() {
        return vy;
    }
    public void setV(double v) {
        vel = v;
        updateCartesianVelocities();
    }
    public double getV() { return vel; }
    public void setDir(double d) {
        dir = d;
        updateCartesianVelocities();
    }
    public double getDir() { return dir; }
    public void setMass(double m) { mass = m; }
    public double getMass() { return mass; }
    public void setX(double x) { this.x = x; }
    public double getX() { return x; }
    public double getY() { return y; }
    public void setY(double y) { this.y = y; }

    public void updatePos() {
        setX((double) (getX() + getV() * Math.cos(getDir())));
        setY((double) (getY() - getV() * Math.sin(getDir())));
    }

    public void updateCartesianVelocities() {
        setVx(getV()*Math.cos(getDir()));
        setVy(getV()*Math.sin(getDir()));
    }

    public void updatePolarVelocities() {
        setDir(Math.tan(getVx() / getVy()));
        setV(Math.sqrt(getVx()*getVx() + getVy()*getVy()));
    }

    public double getKE() {
        return .5*getMass()*getV()*getV();
    }

    public double getPE() {
        return getHeight()*getMass()*getG();
    }

    public double getHeight() {
        return 0;//to be added to
    }

    public double getG() {
        return g;
    }
    public double setG(double newG) {
        g = newG;
    }

}
