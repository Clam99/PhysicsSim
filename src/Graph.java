import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Sam Noyes and Lucas Webb on 2/16/15.
 */

public class Graph extends JPanel {
    private ArrayList<int[]> data = new ArrayList<int[]>();
    //private ArrayList<> points
    int xMax = 0;
    int yMax = 0;
    int xMin = 0;
    int yMin = 0;
    int graphWidth;
    int graphHeight;


    public Graph(double w, double h){
        graphWidth = (int)w;
        graphHeight = (int)h;
    }

    public void paintComponent(Graphics g){
        g.drawRect(graphWidth/2,0,2,graphHeight);
        g.drawRect(0,graphHeight/2,graphWidth,2);

        for(int i = 0; i<data.size(); i++){
            int[] point = data.get(i);
            g.fillOval((int)(graphWidth*(double)((double)point[0]/((double)xMax-(double)xMin))), graphHeight/2-(int)(((double)graphHeight)/2.0*((double)point[1]/((double)yMax-(double)yMin))), 5, 5);
            //g.fillOval((graphWidth/2+point[0]), graphHeight/2-(point[1]), 5, 5);
            //System.out.println("Filling " + (graphWidth/2*(point[0]/xMax)));
        }
        //System.out.println(data.get(0)[0]);

    }


    public void reGraph(){
        updateSize();
        repaint();
    }

    public void addPoint(int[] toadd){
        data.add(toadd);
        reGraph();
    }

    public void updateSize(){
        for(int i = 0; i < data.size();i++){
            if(data.get(i)[0] > xMax){
                xMax = data.get(i)[0];
                //System.out.println("updating x max");
            }
            if(data.get(i)[1] > yMax){
                yMax = data.get(i)[1];
                //System.out.println("updating y max to " +yMax);
            }
            if(data.get(i)[0] < xMin){
                xMin = data.get(i)[0];
                //System.out.println("updating x max");
            }
            if(data.get(i)[1] < yMin){
                yMin = data.get(i)[1];
                //System.out.println("updating y min to " +yMin);
            }
        }
    }
    
    public void setData(ArrayList<int[]> p){
        data = p;
    }
}
