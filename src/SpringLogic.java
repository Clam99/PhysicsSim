/**
 * Created by Lucas Webb on 2/16/15.
 */

public class SpringLogic {
    private double equiLength;//length at equilibrium
    private double currentLength;//current length
    private double k;//Spring constant
    private double dampening;
    private double mass;
    private double velocity;
    private int fps;
    private double KE;
    private double PE;
    private double startingStretch = -300;//Starting length of spring

    public SpringLogic(double l, double k, double d, double m, int fps, double ss){
        equiLength = l;
        startingStretch = ss;
        currentLength = l+startingStretch;
        this.k = k;
        dampening = d;
        mass = m;
        this.fps = fps;
    }

    public void updateLength(){//updates length of spring based on acceleration and velocity
        velocity+=getAcceleration()/(double)fps;
        currentLength+=velocity/fps;
    }

    public double getLength(){//updates and returns length
        updateLength();
        return currentLength;
    }

    public double getForce() {//Calculates force using: k*x-v*d
        return k*(equiLength-currentLength) - dampening*(velocity);
    }

    public double getAcceleration() {//Calculates acceleration based on force and mass using F=ma
        return getForce()/mass;
    }

    public double getVelocity(){
        return velocity;
    }

    public double getKE(){//Calculates kinetic energy using 1/2mv^2
        return .5*mass*velocity*velocity;
    }

    public double getPE(){//Calculates potential energy
        return .5*k*(currentLength-equiLength)*(currentLength-equiLength);
    }

    public double getTotalE(){//return kinetic energy + potential energy
        return this.getKE() + this.getPE();
    }

    public double getCompression(){//used for graphing compression of spring
        return equiLength - currentLength;
    }
}
