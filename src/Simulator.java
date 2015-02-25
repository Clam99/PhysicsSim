import javax.swing.*;
import javax.swing.event.MouseInputListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Sam Noyes on 2/17/15.
 */

public class Simulator extends JPanel {
    JButton record;
    boolean recording = false;
    int fps = 200;
    SimLogic logic;
    OptionsPanel op;

    public Simulator(){
        super();
        logic = new SimLogic();
    }
    public void startRecording(String str, String str2) {
        if (!recording) {
            logic.start(str, str2);
            System.out.println("Starting in Simulator");
            recording = true;
            gameLoop();
        }
    }
    public void gameLoop()
    {
        Timer timer = new Timer();
        timer.schedule(new SimTask(), 0,1000 / fps); //new timer at 60 fps, the timing mechanism
    }

    public void updateGUI() {
        System.out.println("Updating GUI");
    }

    class SimTask extends TimerTask {
        @Override
        public void run() {
            updateGUI();

        }
    }

}

