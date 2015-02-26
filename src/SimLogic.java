/**
 * Created by Sam Noyes on 2/17/15.
 */
public class SimLogic {
    String toGraphX;
    String toGraphY;

    public SimLogic() {
    }

    public void start(String str, String str2) {
        toGraphX = str;
        toGraphY = str2;
        System.out.println("Starting in SimLogic.  toGraphX is '" + toGraphX + "'.");
    }

    public String getToGraphX() {
        return toGraphX;
    }

    public String getToGraphY() {
        return toGraphY;
    }

}
