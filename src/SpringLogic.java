/**
 * Created by Sam Noyes and Lucas Webb on 2/16/15.
 */

public class SpringLogic {
    private double constant;
    private double length;
    private double compression;

    public SpringLogic(double k, double l){
        constant = k;
        length = l;
        //compression = c;
    }

    public void setConstant(double s){
        constant = s;
    }
    public double getConstant(){
        return constant;
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
