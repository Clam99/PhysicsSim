/**
 * Created by Lucas Webb on 2/16/15.
 */

public class SpringLogic {
    private double length;
    private double k;
    private double dampening;

    public SpringLogic(double l, double k, double d){
        length = l;
        this.k = k;
        dampening = d;
    }

    public void updateLength(){

    }

    public double getLength(){
        updateLength();
        return length;
    }
}
