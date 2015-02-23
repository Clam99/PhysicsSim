/**
 * Created by Lucas Webb on 2/16/15.
 */

public class SpringLogic {
    private double k;
    private double length;
    private double compression;

    public SpringLogic(double k, double l){
        this.k = k;
        length = l;
        //compression = c;
    }

    public void setConstant(double s){
        k = s;
    }
    public double getConstant(){
        return k;
    }
    public void setLength(double l) {length = l;}
    public double getLength(){return length;}
    public void setCompression(double c){
        compression = c;
    }
    public double getCompression(){
        return compression;
    }
}
