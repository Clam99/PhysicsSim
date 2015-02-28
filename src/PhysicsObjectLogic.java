/**
 * Created by Sam Noyes and Lucas Webb on 2/10/15.
 */

public abstract class PhysicsObjectLogic {
    private double vel;//velocity
    private double dir;//direction of travel in degrees counterclockwise from horizontal
    private double mass;//mass of object
    private double x;//x coordinate of center of object in Cartesian
    private double y;//y coordinate
    private double vx;//velocity x
    private double vy;//velocity y
    private double g;//gravitational constant
    private int fps;

    public PhysicsObjectLogic() {
        super();
        vel = 0; dir = 0; mass = 0; x = 0; y = 0;
    }

    public PhysicsObjectLogic(double v, double d, double m, double xPos, double yPos, double g, int f) {
        super();
        vel = v; dir = d; mass = m; x = xPos; y = yPos; this.g = g; fps = f;
    }

    public void setVx(double v) {//Sets velocity x
        vx = v;
        updatePolarVelocities();
    }

    public double getVx() {//returns velocity x
        return vx;
    }

    public void setVy(double v) {//Sets velocity y
        vy = v;
        updatePolarVelocities();
    }

    public double getVy() {//returns velocity y
        return vy;
    }

    public void setV(double v) {//sets velocity
        vel = v;
        updateCartesianVelocities();
    }

    public double getV() { return vel; }//returns velocity

    public void setDir(double d) {//sets direction
        dir = d;
        updateCartesianVelocities();
    }

    //Getters and setters for other values
    public double getDir() { return dir; }
    public void setMass(double m) { mass = m; }
    public double getMass() { return mass; }
    public void setX(double x) { this.x = x; }
    public double getX() { return x; }
    public double getY() { return y; }
    public void setY(double y) { this.y = y; }

    public void updatePos() {//Updates cartesian position
        setX((double) (getX() + getVx()/fps));
        setY((double) (getY() + getVy()/fps));
    }

    public void updateCartesianVelocities() {//updates cartesian velocities
        vx = getV()*Math.cos(getDir());
        vy = getV()*Math.sin(getDir());
    }

    public void updatePolarVelocities() {//updates polar velocities
        dir = Math.tan(getVx() / getVy());
        vel = Math.sqrt(getVx()*getVx() + getVy()*getVy());
    }

    //getters used in graphind
    public double getKE() {
        return .5*getMass()*getV()*getV();
    }

    public double getPE(double simHeight) {
        return getHeight(simHeight)*getMass()*getG();
    }

    public double getHeight(double simHeight) {
        return simHeight-getY();
    }

    //Getter and setter for gravitational constant
    public double getG() {
        return g;
    }
    public void setG(double newG) {
        g = newG;
    }

    public double getTotalE(double simHeight) {
        return getPE(simHeight) + getKE();
    }
}
