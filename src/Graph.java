import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Sam Noyes and Lucas Webb on 2/16/15.
 */

public class Graph extends JPanel {
    private ArrayList<int[]> points;
    int xMax;
    int yMax;
    int graphWidth;
    int graphHeight;


    public Graph(double w, double h){
        graphWidth = (int)w;
        graphHeight = (int)h;

    }

    public void paintComponent(Graphics g){
        g.drawRect(graphWidth/2,0,2,graphHeight);
        g.drawRect(0,graphHeight/2,graphWidth,2);
    }

    private void showAxes(){
        //p.drawRect(0,0,10,100);
    }



    public void reGraph(){

    }

    public void addPoint(int[] toadd){
        points.add(toadd);
        reGraph();
    }

    public void updateSize(){
        for(int i = 0; i < points.size();i++){
            if(points.get(i)[0] > xMax){
                xMax = points.get(i)[0];
            }
            if(points.get(i)[1] > yMax){
                yMax = points.get(i)[1];
            }
        }
        reGraph();
    }
}
