/**
 * Created by Lucas Webb on 2/16/15.
 */

public class SpringLogic {
    private double equiLength;//length at equilibrium
    private double currentLength;
    private double k;
    private double dampening;
    private double mass;
    private double velocity;
    private int fps;
    private double KE;
    private double PE;
    private double startingStretch = 300;


    public SpringLogic(double l, double k, double d, double m, int fps){
        equiLength = l;
        currentLength = l+startingStretch;
        this.k = k;
        dampening = d;
        mass = m;
        this.fps = fps;
    }

    public void updateLength(){
        velocity+=getAcceleration()/(double)fps;
        currentLength+=velocity;
    }

    public double getLength(){
        updateLength();
        return currentLength;
    }

    public double getForce() {
        int constant = 10;
        return k*(equiLength-currentLength)*constant - dampening*velocity;
    }

    public double getAcceleration() {
        return getForce()/mass;
    }
}
