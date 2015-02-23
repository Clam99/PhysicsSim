/**
 * Created by lucaswebb on 2/23/15.
 */

public class SpringSimLogic extends SimLogic {
    double simWidth;
    double simHeight;
    double mass;
    double k;
    double length;
    int fps;

    public SpringSimLogic(double width, double height, double m, double k, double l, int fps){
        mass = m;
        this.k = k;
        length = l;
        this.fps = fps;

    }

    public void update(){

    }
}
