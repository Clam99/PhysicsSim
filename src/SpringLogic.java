/**
 * Created by Lucas Webb on 2/16/15.
 */

public class SpringLogic {
    private double length;
    private double k;
    private double dampening;
    private double mass;

    public SpringLogic(double l, double k, double d, double m){
        length = l;
        this.k = k;
        dampening = d;
        mass = m;
    }

    public void updateLength(){

    }

    public double getLength(){
        updateLength();
        return length;
    }
}
