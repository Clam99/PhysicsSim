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
 * Created by smurphy on 2/17/15.
 */
public class Simulator extends JPanel {
    JButton record;
    boolean recording = false;
    ArrayList<int[]> data;
    public Simulator(){
        record.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getID() == MouseEvent.MOUSE_RELEASED) {
                    startRecording();
                }
            }
        });
    }
    public void startRecording() {
        toggleButtons();
        recording = true;
    }
    public void toggleButtons() {

    }
    public void gameLoop()
    {
        Timer timer = new Timer();
        timer.schedule(new SimTask(), 0, 1000 / 60); //new timer at 60 fps, the timing mechanism
    }

    public void updateGUI() {

    }

    class SimTask extends TimerTask {
        @Override
        public void run() {
            updateGUI();
        }
    }

}

