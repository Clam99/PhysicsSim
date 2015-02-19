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
    private double height;
    private double KE;
    private double PE;


    public PhysicsObjectLogic() {
        super();
        vel = 0; dir = 0; mass = 0; x = 0; y = 0;
    }

    public PhysicsObjectLogic(double v, double d, double m, double xPos, double yPos) {
        super();
        vel = v; dir = d; mass = m; x = xPos; y = yPos;
    }

    public void setVx(double v) {

    }
    public double getVx() {
        return vx;
    }
    //pu
    public void setV(double v) { vel = v; }
    public double getV() { return vel; }
    public void setDir(double d) { dir = d; }
    public double getDir() { return dir; }
    public void setMass(double m) { mass = m; }
    public double getMass() { return mass; }
    public void setX(double x) { this.x = x; }
    public double getX() { return x; }
    public double getY() { return y; }
    public void setY(double y) { this.y = y; }

    public void updatePos() {
        setX((double) (getX()+getV()*Math.cos(getDir())));
        setY((double) (getY()-getV()*Math.sin(getDir())));
    }

}
