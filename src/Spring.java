import java.awt.*;

/**
 * Created by Sam Noyes and Lucas Webb on 2/16/15.
 */

public class Spring extends Rectangle {
    SpringLogic sl;
    double length;
    double height;

    public Spring(double x, double y, double l, double h, double k, double d, double m, int fps) {
        super((int)x, (int)y, (int)l, (int)h);
        length = l;
        height = h;
        sl = new SpringLogic(l, k, d, m, fps);
    }

    public void updateLength(){
        length = sl.getLength();
        this.setSize((int)length, (int)height);
    }

    public double getLength(){
        return length;
    }

    public SpringLogic getSpringLogic(){
        return sl;
    }
}
