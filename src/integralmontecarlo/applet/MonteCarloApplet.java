
package integralmontecarlo.applet;

/**
 *
 * @author hernan
 */
import java.applet.Applet;
import java.text.DecimalFormat;
import java.awt.*;
import java.awt.event.*;

public class MonteCarloApplet extends Applet
        implements Runnable, ActionListener {

    private Label count;
    private Label piApprox;
    private Button startButton;
    private Button stopButton;
    private MonteCarloCanvas drawArea;
    private Panel messageArea;
    private int numPoints = 0;
    private int pointsInCircle = 0;
    private DecimalFormat df = new DecimalFormat("0.000000000000");

    // If set to true, restarts the calculation.
    private boolean restart_p = false;

    private Thread monteCarloThread;

    public void init() {
        System.out.println("init");

        // Create the UI.
        setLayout(new BorderLayout());

        drawArea = new MonteCarloCanvas();
        messageArea = makeMessageArea();

        add(makeButtonArea(), "East");
        add(drawArea, "Center");
        add(messageArea, "South");
        validate();
    }

    // Lay out the message area at the bottom.
    private Panel makeMessageArea() {
        System.out.println("makeMessageArea");
        messageArea = new Panel();
        GridBagLayout gb = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();

        messageArea.setLayout(gb);

        Label countLabel = new Label("N", Label.CENTER);
        Label piLabel = new Label("pi (aprox)", Label.CENTER);
        count = new Label("00000000", Label.CENTER);
        piApprox = new Label("0.000000000000", Label.CENTER);

        gbc.weightx = 1.0;
        gbc.weighty = 1.0;

        gbc.gridwidth = GridBagConstraints.RELATIVE;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gb.setConstraints(count, gbc);
        messageArea.add(count);

        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gb.setConstraints(piApprox, gbc);
        messageArea.add(piApprox);

        gbc.gridwidth = GridBagConstraints.RELATIVE;
        gb.setConstraints(countLabel, gbc);
        messageArea.add(countLabel);

        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gb.setConstraints(piLabel, gbc);
        messageArea.add(piLabel);

        return messageArea;
    }

    // Lay out the buttons on the right.
    private Panel makeButtonArea() {
        System.out.println("makeButtonArea");
        Panel buttonArea = new Panel();
        GridBagLayout gb = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        buttonArea.setLayout(gb);

        startButton = new Button("Reiniciar");
        stopButton = new Button("Parar");

        startButton.addActionListener(this);
        stopButton.addActionListener(this);

        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(1, 3, 1, 3);
        gb.setConstraints(startButton, gbc);
        buttonArea.add(startButton);

        gb.setConstraints(stopButton, gbc);
        buttonArea.add(stopButton);

        return buttonArea;
    }

    // Called from Thread.start(); part of the Runnable interface.
    public void run() {
        System.out.println("run");
        while (Thread.currentThread() == monteCarloThread) {
            if (restart_p) {
                restart_p = false;
                drawArea.clear();
                pointsInCircle = 0;
                numPoints = 0;
            }

            // MonteCarloCanvas.addPoint() returns true if the point added
            // was within the circle.
            if (drawArea.addPoint()) {
                pointsInCircle++;
            }
            numPoints++;
            count.setText("" + numPoints);
            piApprox.setText("" + df.format((double) pointsInCircle * 4 / numPoints));

            // Try really hard to yield execution to the drawing thread.
            // On some platforms (Netscape under Linux, for example),
            // it is really hard to give the drawing thread (the one that
            // calls update()) a chance to run. We need to sleep at least 5
            // milliseconds to actually yield it; less won't do. We don't
            // want to slow down our calculation too much, so we just do it
            // every 100 points.
            Thread.yield();
            if (numPoints % 100 == 0) {
                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                }
            }
        }
    }

    public void start() {
        System.out.println("start");
        if (monteCarloThread == null) {
            monteCarloThread = new Thread(this);
            monteCarloThread.setPriority(Thread.MIN_PRIORITY);
        }
        monteCarloThread.start();
        startButton.setLabel("Reiniciar");
    }

    public void stop() {
        System.out.println("stop");
        monteCarloThread = null;
        startButton.setLabel("Comenzar");
    }

    // Handle button presses.
    public void actionPerformed(ActionEvent e) {
        System.out.println("actionPerformed");
        String cmd = e.getActionCommand();
        if (cmd.equals("Parar")) {
            stop();
        } else if (cmd.equals("Comenzar")) {
            start();
        } else if (cmd.equals("Reiniciar")) {
            restart_p = true;
        }

    }
}
