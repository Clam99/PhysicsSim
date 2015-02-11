/**
 * Created by smurphy on 2/10/15.
 */
public class PhysicsObjectLogic {
    private float vel;//velocity
    private float dir;//direction of travel in degrees counterclockwise from the horizontal
    private float mass;//mass of object
    private float x;//x coordinate in Cartesian
    private float y;//y coordinate

    public PhysicsObjectLogic(float v, float d, float m, float xPos, float yPos) {
        super();
        vel = v; dir = d; mass = m; x = xPos; y = yPos;
    }

    public void setV(float v) { vel = v; }
    public float getV() { return vel; }
    public void setDir(float d) { dir = d; }
    public float getDir() { return dir; }
    public void setMass(float m) { mass = m; }
    public float getMass() { return mass; }
    public void setX(float x) { this.x = x; }
    public float getX() { return x; }
    public float getY() { return y; }
    public void setY(float y) { this.y = y; }
    public void updatePos() {
        setX((float) (getX()+getV()*Math.cos(getDir())));
        setY((float) (getY()+getV()*Math.sin(getDir())));
    }

}
