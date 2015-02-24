/**
 * Created by lucaswebb on 2/23/15.
 */

public class SpringSimLogic extends SimLogic {
    double simWidth;
    double simHeight;
    double mass;
    double k;
    double length;
    Spring spring;
    double velocity;
    double acceleration;

    public SpringSimLogic(double width, double height, double m, double k, double l, Spring s){
        super();
        mass = m;
        this.k = k;
        length = l;
        spring = s;

    }

    public void update(){

    }
}
