import java.awt.*;

/**
 * Created by Sam Noyes and Lucas Webb on 2/16/15.
 */

public class Spring extends Rectangle {
    public Spring(double w, double h, double k, double l) {
        super((int)w/2, (int)h/2, 20, 50);

        SpringLogic sl = new SpringLogic(k, l);
    }
}
