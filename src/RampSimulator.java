import java.awt.*;

/**
 * Created by Sam Noyes and Lucas Webb on 2/17/15.
 */

public class RampSimulator extends Simulator {
    Ball ball;
    Ramp ramp;
    public Graph graph;
    double initialBallX;//Initial position of ball
    double initialBallY;
    double angle;//angle of ramp with the floor
    double rampLen;//length of ramp hypotenuse
    double gF;//gravitational field
    double ballRadius;
    double ballMass;

    public RampSimulator(double a, double rampLen, double ballMass, double ballRadius, double w, double h, Graph g, double gF, Canvas p) {
        super();
        graph = g;
        simHeight = h;
        simWidth = w;
        angle = a;
        this.rampLen = rampLen;
        op = new RampOptionsPanel(this, p);//Create the options panel
        this.gF = gF;
        this.ballRadius = ballRadius;
        this.ballMass = ballMass;
    }

    public void paintComponent(Graphics g) {
        if (recording) {
            g.setColor(ramp.c);
            g.fillPolygon(ramp);
            g.setColor(Color.blue);
            g.fillOval((int) (ball.getBallLogic().getX() - ball.getBallLogic().getRadius()), (int) (ball.getBallLogic().getY() - ball.getBallLogic().getRadius()), (int) ball.getBallLogic().getRadius() * 2, (int) ball.getBallLogic().getRadius() * 2);//draw and fill the ball centered at getX() and getY()
            g.setColor(Color.black);

            //fill the right wall and floor to make it obvious where they are
            g.fillRect((int) ((RampSimLogic) logic).floor.getX1(), (int) ((RampSimLogic) logic).floor.getY1(), (int) ((RampSimLogic) logic).floor.getX2() - (int) ((RampSimLogic) logic).floor.getX1(), 200);
            g.fillRect((int) ((RampSimLogic) logic).rightWall.getX1(), (int) ((RampSimLogic) logic).rightWall.getY1(), 200, (int) ((RampSimLogic) logic).rightWall.getY2() - (int) ((RampSimLogic) logic).rightWall.getY1());
        }
    }



    @Override
    public void updateGUI() {//update the GUI and call logic's update method as well
        repaint();
        ((RampSimLogic)logic).update();
    }


    public void makeRamp() {//create the ramp
        int[] xpoints = {0,0, (int)(Math.cos(angle)*rampLen)};//Vertices in order from top left, bottom left, bottom right
        int[] ypoints = { (int)(-Math.sin(angle)*rampLen+simHeight), (int)simHeight, (int)simHeight};

        ramp = new Ramp(xpoints, ypoints, 3, Color.red);
        initialBallX = ballRadius*Math.cos(Math.toRadians(90)-angle);//set the initial position of the ball based on the angle of the ramp
        initialBallY = simHeight-Math.sin(angle)*rampLen-ballRadius*Math.sin(Math.toRadians(90)-angle);
        ball = new Ball(0,Math.toRadians(360)-angle,ballMass,initialBallX,initialBallY, ballRadius, 1, gF, fps);//create the ball
    }

    public void startRecording(String str, String str2, double angle) {//Start the sim and begin graphing - takes the variables to graph and the angle of the ramp as parameters
        this.angle = Math.toRadians(angle);
        makeRamp();
        logic = new RampSimLogic(ball, ramp, graph, angle, rampLen, simWidth, simHeight, fps);//create the logic based on the angle and graphing variables that we now know

        repaint();
        super.startRecording(str, str2);//call the parent startRecording method and pass in the variables to graph
    }
}