/**
 * Created by Sam Noyes and Lucas Webb on 2/17/15.
 */

public class SimLogic {
    String toGraphX;
    String toGraphY;
    int updateCount = 0;

    public SimLogic() {
    }

    public void start(String str, String str2) {//Sets what to graph on axis
        toGraphX = str;
        toGraphY = str2;
    }

    public String getToGraphX() {
        return toGraphX;
    }

    public String getToGraphY() {
        return toGraphY;
    }

    public void update() {
        updateCount++;
    }
}
