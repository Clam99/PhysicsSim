import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Lucas Webb on 2/16/15.
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
    double dotRadius = 2;
    int freq = 0;


    public Graph(double w, double h){
        graphWidth = (int)w;
        graphHeight = (int)h;
    }

    public void paintComponent(Graphics g){
        g.drawRect(graphWidth/2,0,2,graphHeight);
        g.drawRect(0,graphHeight/2,graphWidth,2);

        freq = data.size()/2000;
       // System.out.println(freq);
        for(int i = 0; i<data.size(); i+=1+freq){
            int[] point = data.get(i);

            g.fillOval(graphWidth/2+(int)((graphWidth/2-dotRadius*2-5)*(double)((double)point[0]/((double)xMax-(double)xMin))),
                    graphHeight/2-(int)(((double)graphHeight/2)*((double)point[1]/((double)yMax-(double)yMin))), (int)(dotRadius*2), (int)(dotRadius*2));
        }

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
            }
            if(data.get(i)[1] > yMax){
                yMax = data.get(i)[1];
            }
            if(data.get(i)[0] < xMin){
                xMin = data.get(i)[0];
            }
            if(data.get(i)[1] < yMin){
                yMin = data.get(i)[1];
            }
        }
    }
    
    public void setData(ArrayList<int[]> p){
        data = p;
    }
}
