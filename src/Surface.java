/**
 * Created by Sam Noyes on 2/22/15.
 */

public class Surface {
    private double x1;
    private double x2;
    private double y1;
    private double y2;

    public Surface(double x1, double x2, double y1, double y2) {
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
    }

    public double getX1() {
        return x1;
    }

    public double getX2() {
        return x2;
    }

    public double getY1() {
        return y1;
    }

    public double getY2() {
        return y2;
    }

    public Vector getSurfaceVector() {
        return new Vector(x2-x1, y2-y1);
    }

    public boolean intersectsBall(Ball b) {//Test whether b is intersecting the surface
        Vector sToB = new Vector(b.getBallLogic().getX()-getX1(), b.getBallLogic().getY()-getY1());//top of surface to ball vector
        double projLength = sToB.getMagnitude()*(sToB.dotP(getSurfaceVector())/(sToB.getMagnitude()*getSurfaceVector().getMagnitude()));//length of projection of sToB onto the surface

        if (projLength<-b.getBallLogic().getRadius() || projLength>getSurfaceVector().getMagnitude()+b.getBallLogic().getRadius()) {//Off to the side of the ramp
            return false;
        }
        else if (projLength>0&&projLength<getSurfaceVector().getMagnitude()) {//must be above ramp
            Vector surfacePoint = getCoordsCorrespondingToXAndYWithAngle(b.getBallLogic().getX(), b.getBallLogic().getY());
            Vector vectorToSurface = new Vector(surfacePoint.getX()-b.getBallLogic().getX(), surfacePoint.getY()-b.getBallLogic().getY());
            return vectorToSurface.getMagnitude()<b.getBallLogic().getRadius();
        }
        else {//Not directly above the ramp, but still might be within reach
            return (Ball.getDistance(getX2(),getY2(),b.getBallLogic().getX(), b.getBallLogic().getY()))<b.getBallLogic().getRadius() || (Ball.getDistance(getX1(),getY1(),b.getBallLogic().getX(), b.getBallLogic().getY()))<b.getBallLogic().getRadius();
        }
    }
    
    public Vector getCoordsCorrespondingToXAndYWithAngle(double x, double y) {
        Vector toProj = new Vector(x-getX1(),y-getY1());
        Vector proj = toProj.projectOnto(getSurfaceVector());
        return new Vector(getX1(), getY1()).addVector(proj);
    }

    public double angleFromPositiveHor() {//Returns angle from horizontal
        return  Math.atan((getY2()-getY1())/(getX2()-getX1()));
    }
}
