import java.awt.*;

/**
 * Created by Sam Noyes on 2/18/15.
 */
public class Ramp extends Polygon {
    public Color c;
    private int[] xp;
    private int[] yp;
    private int np;

    public Ramp(int[] xPoints, int[] yPoints, int nPoints, Color color) {
        super(xPoints,yPoints,nPoints);
        c = color;
        xp = xPoints;
        yp = yPoints;
        np = nPoints;
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
    public int getYCoordsOfSlopeGivenX(int x) {
        if (x>xp[2] || x<xp[0]) {
            return -1;//x isn't on the slope
        }
        return (int)((double)yp[2] + ((double)(yp[0]-yp[2])*((double)x/(double)(xp[2]-xp[0]))));
    }
}
