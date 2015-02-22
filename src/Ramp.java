import java.awt.*;

/**
 * Created by Sam Noyes on 2/18/15.
 */
public class Ramp extends Polygon {
    public Color c;
    private int[] xp;
    private int[] yp;
    private int np;
    private Surface surface;

    public Ramp(int[] xPoints, int[] yPoints, int nPoints, Color color) {
        super(xPoints,yPoints,nPoints);//In order from top left, bottom left, bottom right
        c = color;
        xp = xPoints;
        yp = yPoints;
        np = nPoints;
        surface = new Surface(xp[0], xp[2], yp[0], yp[2]);
    }

    public int[] getXPoints() {
        return xp;
    }
    public int[] getYPoints() {
        return yp;
    }
    public int getNpoints() {
        return np;
    }


    public double getRampLen() {
        return Math.sqrt(((double)xp[0]-(double)xp[2])*((double)xp[0]-(double)xp[2])+ ((double)yp[0]-(double)yp[2])*((double)yp[0]-(double)yp[2]));
    }
    public Surface getSurface() {
        return surface;
    }
}
