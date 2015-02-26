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

    public SpringSimLogic(double width, double height, double m, double k, double l, double d, Spring s, double v, Graph g) {
        super();
        mass = m;
        this.k = k;
        length = l;
        spring = s;
        this.d = d;
        graph = g;
    }

    public void update() {
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
            //if (getToGraphX().equals("Time")) {
            //
            //}
            if (getToGraphX().equals("Velocity")) {
                toAdd[0] = (spring.getSpringLogic().getVelocity());
            }
            //if (getToGraphX().equals("Compression")) {
            //
            //}
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
            //if (getToGraphY().equals("Time")) {
            //
            //}
            if (getToGraphY().equals("Velocity")) {
                toAdd[1] = (spring.getSpringLogic().getVelocity());
            }
            //if (getToGraphY().equals("Compression")) {
            //
            //}
            if (getToGraphY().equals("Force")) {
                toAdd[1] = (spring.getSpringLogic().getForce());
            }
            if (getToGraphY().equals("Total Energy")) {
                toAdd[1] = (spring.getSpringLogic().getTotalE());
            }

            graph.addPoint(toAdd);

        } catch (NullPointerException npe) {
            System.out.println("Crashed. graphX: " + toGraphX);
        }
    }
}
