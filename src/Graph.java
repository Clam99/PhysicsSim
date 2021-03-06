import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Lucas Webb on 2/16/15.
 */

public class Graph extends JPanel {
    private ArrayList<double[]> data = new ArrayList<double[]>();//The arraylist which stores all the points.  This is the data structure
    double xMax = 1;
    double yMax = 1;
    double xMin = 0;
    double yMin = 0;
    int graphWidth;
    int graphHeight;
    double dotRadius = 2;
    int freq = 0;
    int MAX_POINTS = 1000;//Sets maximum number of points to be graphed live
    boolean shouldDisplayAllData = false;//Boolean to ignore max points, set to true in fullscreen mode

    public Graph(double w, double h){
        //Set dimensions
        graphWidth = (int)w;
        graphHeight = (int)h;
    }

    public void paintComponent(Graphics g){//Paints everything
        double buffer = (dotRadius * 2 * 2 * 2);
        //Creates 'origin'
        Vector origin = new Vector(((0-xMin)/(xMax-xMin))*(graphWidth - buffer),graphHeight-((0-yMin)/(yMax-yMin))*graphHeight);

        //Draws axes
        g.drawRect((int) origin.getX(), 0, 2, graphHeight);
        g.drawRect(0,(int)origin.getY(),graphWidth,2);

        try {
            if (!shouldDisplayAllData) {
                if (data.size() < MAX_POINTS) {
                    //For each point, draws an oval
                    for (int i = 0; i < data.size(); i++) {
                        double[] point = data.get(i);
                        g.fillOval((int) (((point[0] - xMin) / (xMax - xMin)) * (graphWidth - buffer)),
                                (int) (graphHeight - ((point[1] - yMin) / (yMax - yMin)) * graphHeight), (int) (dotRadius * 2), (int) (dotRadius * 2));
                    }
                } else {
                    for (int i = data.size() - MAX_POINTS; i < data.size(); i++) {
                        double[] point = data.get(i);
                        g.fillOval((int) (((point[0] - xMin) / (xMax - xMin)) * (graphWidth - buffer)),
                                (int) (graphHeight - ((point[1] - yMin) / (yMax - yMin)) * graphHeight), (int) (dotRadius * 2), (int) (dotRadius * 2));
                    }
                }
            } else {
                //Draws all points stored in data
                for (int i = 0; i < data.size(); i++) {
                    double[] point = data.get(i);

                    g.fillOval((int) (((point[0] - xMin) / (xMax - xMin)) * (graphWidth - buffer)),
                            (int) (graphHeight - ((point[1] - yMin) / (yMax - yMin)) * graphHeight), (int) (dotRadius * 2), (int) (dotRadius * 2));
                }
            }
        }
        catch (NullPointerException e) {//For some reason this section was throwing a NullPointerException which didn't noticeably affect the simulator, but this is to prevent it

        }
    }

    //updates the dimensions and then repaints
    public void reGraph(){
        updateSize();
        repaint();
    }

    //Adds a point to the data arraylist
    public void addPoint(double[] toadd){
        data.add(toadd);
        reGraph();
    }

    //Scales the dimensions of the graph based on the data
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

    //Allows setting of the data, useful for testing
    public void setData(ArrayList<double[]> p)
    {
        data = p;
    }

    //Clears data arraylist and resets max and min values
    public void resetData() {
        data = new ArrayList<double[]>();
         xMax = 0;
         yMax = 0;
         xMin = 0;
         yMin = 0;
        freq = 0;
    }

    //Updates the dimensions
    public void resizeGraph(int w, int h, boolean b) {
        shouldDisplayAllData = b;
        graphWidth = w;
        graphHeight = h;
        reGraph();
    }
}
