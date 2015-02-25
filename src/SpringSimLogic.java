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
    Graph graph;

    public SpringSimLogic(double width, double height, double m, double k, double l, double d, Spring s, double v, Graph g){
        super();
        mass = m;
        this.k = k;
        length = l;
        spring = s;
        this.d = d;
        graph = g;
    }

    public void update(){

    }
}
