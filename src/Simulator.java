import javax.swing.*;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Sam Noyes and Lucas Webb on 2/17/15.
 */

public class Simulator extends JPanel {//superclass of Ramp and Spring Simulators
    boolean recording = false;
    int fps = 200;
    SimLogic logic;
    OptionsPanel op;
    Timer timer;
    double simWidth;
    double simHeight;

    public Simulator(){
        super();
        logic = new SimLogic();
    }

    public void startRecording(String str, String str2) {
        if (!recording) {
            logic.start(str, str2);
            recording = true;
            gameLoop();
        }
    }

    public void gameLoop()//Creates game loop
    {
        timer = new Timer();
        timer.schedule(new SimTask(), 0,1000 / fps); //new timer at 60 fps, the timing mechanism
    }

    public void updateGUI() {//updates SimLogic object
        logic.update();
    }

    class SimTask extends TimerTask {//updates GUI
        @Override
        public void run() {
            updateGUI();
        }
    }

    public void stop() {//Stops the timer
        timer.cancel();
        timer.purge();
    }
}

