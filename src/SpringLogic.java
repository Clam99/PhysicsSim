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
    private double startingStretch = -300;


    public SpringLogic(double l, double k, double d, double m, int fps, double ss){
        equiLength = l;
        startingStretch = ss;
        currentLength = l+startingStretch;
        this.k = k;
        dampening = d;
        mass = m;
        this.fps = fps;
    }

    public void updateLength(){
        velocity+=getAcceleration()/(double)fps;
        currentLength+=velocity/fps;
    }

    public double getLength(){
        updateLength();
        return currentLength;
    }

    //public double getCurrentLength

    public double getForce() {
        return k*(equiLength-currentLength) - dampening*(velocity);
    }

    public double getAcceleration() {
        return getForce()/mass;
    }

    public double getVelocity(){
        return velocity;
    }

    public double getKE(){
        return .5*mass*velocity*velocity;
    }

    public double getPE(){
        return .5*k*(currentLength-equiLength)*(currentLength-equiLength);
    }

    public double getTotalE(){
        return this.getKE() + this.getPE();
    }

    public double getCompression(){
        return equiLength - currentLength;
    }
}
