/**
 * Created by smurphy on 2/22/15.
 */
public class Vector {
    double x;
    double y;

    public Vector(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double dotP(Vector v) {
        return v.getX()*getX()+v.getY()*getY();
    }

    public double getMagnitude() {
        return Math.sqrt(getX()*getX()+getY()*getY());
    }

    public Vector scale(double scalar) {
        return new Vector(getX()*scalar,getY() * scalar);
    }

    public Vector projectOnto(Vector v) {
        return v.scale(v.dotP(this)/(v.getMagnitude()*v.getMagnitude()));
    }

    public Vector addVector(Vector v) {
        return new Vector(getX()+v.getX(), getY()+v.getY());
    }

    public Vector leftNormal() {
        return new Vector(getY(), -getX());
    }

    public Vector rightNormal() {
        return new Vector(-getY(), getX());
    }

    public double dx() {
        return getX()/getMagnitude();
    }

    public double dy() {
        return getY()/getMagnitude();
    }
}
