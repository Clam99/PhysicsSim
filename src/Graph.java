import javax.swing.*;
import java.util.ArrayList;

/**
 * Created by Sam Noyes and Lucas Webb on 2/16/15.
 */

public class Graph extends JPanel {
    private ArrayList<int[]> points;
    int x;
    int y;

    public void Graph(ArrayList<int[]> a){
        points = a;
    }

    public void reGraph(){

    }

    public void addPoint(int[] toadd){
        points.add(toadd);
        reGraph();
    }

    public void updateSize(){
        for(int i = 0; i < points.size();i++){
            if(points.get(i)[0] > x){
                x = points.get(i)[0];
            }
            if(points.get(i)[1] > y){
                y = points.get(i)[1];
            }
        }
        reGraph();
    }


}
