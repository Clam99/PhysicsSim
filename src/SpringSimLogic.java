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
    int fps;

    public SpringSimLogic(double width, double height, double m, double k, double l, double d, Spring s, double v, Graph g, int fps) {
        super();
        mass = m;
        this.k = k;
        length = l;
        spring = s;
        this.d = d;
        graph = g;
        this.fps = fps;
    }

    public void update() {
        super.update();
        double[] toAdd = {0, 0};

        try {
            if (getToGraphX().equals("Potential Energy")) {
                toAdd[0] = (spring.getSpringLogic().getPE());
            }
            if (getToGraphX().equals("Kinetic Energy")) {
                toAdd[0] = (spring.getSpringLogic().getKE());
            }
            if (getToGraphX().equals("Acceleration")) {
                toAdd[0] = (spring.getSpringLogic().getAcceleration());
            }
            if (getToGraphX().equals("Time")) {
                toAdd[0] = ((double)updateCount/(double)fps);
            }
            if (getToGraphX().equals("Velocity")) {
                toAdd[0] = (spring.getSpringLogic().getVelocity());
            }
            if (getToGraphX().equals("Compression")) {
                toAdd[0] = (spring.getSpringLogic().getCompression());
            }
            if (getToGraphX().equals("Force")) {
                toAdd[0] = spring.getSpringLogic().getForce();
            }
            if (getToGraphX().equals("Total Energy")) {
                toAdd[0] = (spring.getSpringLogic().getTotalE());
            }

            if (getToGraphY().equals("Potential Energy")) {
                toAdd[1] = (spring.getSpringLogic().getPE());
            }
            if (getToGraphY().equals("Kinetic Energy")) {
                toAdd[1] = (spring.getSpringLogic().getKE());
            }
            if (getToGraphY().equals("Acceleration")) {
                toAdd[1] = (spring.getSpringLogic().getAcceleration());
            }
            if (getToGraphY().equals("Time")) {
                toAdd[1] = (int)((double)updateCount/(double)fps);
            }
            if (getToGraphY().equals("Velocity")) {
                toAdd[1] = (spring.getSpringLogic().getVelocity());
            }
            if (getToGraphY().equals("Compression")) {
                toAdd[1] = (spring.getSpringLogic().getCompression());
            }
            if (getToGraphY().equals("Force")) {
                toAdd[1] = (spring.getSpringLogic().getForce());
            }
            if (getToGraphY().equals("Total Energy")) {
                toAdd[1] = (spring.getSpringLogic().getTotalE());
            }

            graph.addPoint(toAdd);

        } catch (NullPointerException npe) {
            System.out.println("Crashed. graphX: " + getToGraphX());
        }
    }
}
