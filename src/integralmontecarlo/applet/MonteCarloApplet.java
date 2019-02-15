package integralmontecarlo.applet;

/**
 *
 * @author hernan
 */
import java.applet.Applet;
import java.text.DecimalFormat;
import java.awt.*;
import java.awt.event.*;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class MonteCarloApplet extends Applet implements Runnable, ActionListener {

    private Label count;
    private Label piApprox;
    private Label inicioLabel;
    private Button startButton;
    private Button stopButton;
    private MonteCarloCanvas drawArea;
    private Panel messageArea;
    private Panel messageArea2;
    private int numPoints = 0;
    private int pointsInCircle = 0;
    private DecimalFormat df = new DecimalFormat("0.000000000000");
    private String horaStr = "";

    // Si se establece en verdadero, reinicia el cálculo.    
    private boolean restart_p = false;
    private Thread monteCarloThread;

    public void init() {
        // Crea la UI.
        setLayout(new BorderLayout());
        drawArea = new MonteCarloCanvas();
        messageArea = makeMessageArea();
        add(makeButtonArea(), "East");
        add(drawArea, "Center");
        add(messageArea, "South");
        validate();
    }

    // Coloca el área del mensaje en la parte inferior.
    private Panel makeMessageArea() {
        messageArea = new Panel();
        messageArea2 = new Panel();
        GridBagLayout gb = new GridBagLayout();
        
        GridBagLayout gb2 = new GridBagLayout();
        
        GridBagConstraints gbc = new GridBagConstraints();
        
        GridBagConstraints gbc2 = new GridBagConstraints();
        
        messageArea.setLayout(gb);
        messageArea2.setLayout(gb2);
        
        Label countLabel = new Label("N", Label.CENTER);
        Label piLabel = new Label("pi (aprox)", Label.CENTER);
        count = new Label("00000000", Label.CENTER);
        piApprox = new Label("0.000000000000", Label.CENTER);
        inicioLabel = new Label("00:00:00", Label.CENTER);
       
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.gridwidth = GridBagConstraints.RELATIVE;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        
        gbc2.weightx = 1.0;
        gbc2.weighty = 1.0;
        gbc2.gridwidth = GridBagConstraints.RELATIVE;
        gbc2.fill = GridBagConstraints.HORIZONTAL;
        
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
        
        gbc2.gridwidth = GridBagConstraints.REMAINDER;
        gb2.setConstraints(inicioLabel, gbc2);
        messageArea.add(inicioLabel);
        
        return messageArea;
    }

    // Coloca los botones a la derecha.
    private Panel makeButtonArea() {
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

    // Llamado desde Thread.start (); parte de la interfaz Runnable.
    public void run() {
                hora();
                inicioLabel.setText(horaStr);

        while (Thread.currentThread() == monteCarloThread) {
            if (restart_p) {
                restart_p = false;
                drawArea.clear();
                pointsInCircle = 0;
                numPoints = 0;
            }
            // MonteCarloCanvas.addPoint () devuelve true si el punto agregado estaba dentro del círculo.
            if (drawArea.addPoint()) {
                pointsInCircle++;
            }
            numPoints++;
            count.setText("" + numPoints);
            piApprox.setText("" + df.format((double) pointsInCircle * 4 / numPoints));
            // En algunas plataformas (Netscape bajo Linux, por ejemplo),
            // es muy difícil dar el hilo de dibujo (el que
            // llama a update ()) una oportunidad para ejecutar. Se necesita dormir al menos 5
            // milisegundos para producirlo realmente, lo hacemos cada 100 puntos.
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
        if (monteCarloThread == null) {
            monteCarloThread = new Thread(this);
            monteCarloThread.setPriority(Thread.MIN_PRIORITY);
        }
        monteCarloThread.start();
        startButton.setLabel("Reiniciar");
    }

    public void stop() {
        monteCarloThread = null;
        startButton.setLabel("Comenzar");
    }

    // Manejar pulsadores de botones.
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
        if (cmd.equals("Parar")) {
            stop();
        } else if (cmd.equals("Comenzar")) {
            start();
        } else if (cmd.equals("Reiniciar")) {
            restart_p = true;
        }
    }

    private void hora() {
        Calendar calendario = new GregorianCalendar();
        int hora, minutos, segundos;
        hora = calendario.get(Calendar.HOUR_OF_DAY);
        minutos = calendario.get(Calendar.MINUTE);
        segundos = calendario.get(Calendar.SECOND);
        horaStr = String.valueOf(hora) + ":" + String.valueOf(minutos) + ":" + String.valueOf(segundos);
        System.out.println(horaStr);
    }
    
}
