import java.awt.*;

/**
 * Created by Sam Noyes and Lucas Webb on 2/16/15.
 */

public class Spring extends Rectangle {
    SpringLogic sl;
    double length;
    double height;

    public Spring(double w, double h, double l, double hh, double k, double d) {
        super((int)w, (int)h, (int)l, (int)hh);
        length = l;
        height = hh;
        sl = new SpringLogic(l, k, d);
    }

    public void updateLength(){
        length = sl.getLength();
        super.setSize((int)length, (int)height);
    }

    public double getLength(){
        return length;
    }
}
