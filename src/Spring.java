import java.awt.*;

/**
 * Created by Sam Noyes and Lucas Webb on 2/16/15.
 */

public class Spring extends Rectangle {
    public Spring(double w, double h, double l, double hh, double k, double d) {
        super((int)w, (int)h, (int)l, (int)hh);
        SpringLogic sl = new SpringLogic(l, k, d);


    }
}
