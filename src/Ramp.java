import java.awt.*;

/**
 * Created by Sam Noyes on 2/18/15.
 */
public class Ramp extends Polygon {
    Color c;
    public Ramp(int[] xPoints, int[] yPoints, int nPoints, Color color) {
        super(xPoints,yPoints,nPoints);
        c = color;
    }
}
