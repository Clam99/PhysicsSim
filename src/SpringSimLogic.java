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
    double d;

    public SpringSimLogic(double width, double height, double m, double k, double l, double d, Spring s, double v){
        super();
        mass = m;
        this.k = k;
        length = l;
        spring = s;
        this.d = d;
    }

    public double updateV(){
        velocity = ((-k/mass)*length)-((d/mass)*velocity);
        return velocity;
    }


}
