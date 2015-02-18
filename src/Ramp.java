import java.awt.*;

/**
 * Created by smurphy on 2/18/15.
 */
public class Ramp extends Polygon {
    Color c;
    public Ramp(int[] xpoints, int[] ypoints, int npoints, Color color) {
        super(xpoints,ypoints,npoints);
        c = color;
    }
}
