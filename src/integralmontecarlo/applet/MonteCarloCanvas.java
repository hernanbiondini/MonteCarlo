package integralmontecarlo.applet;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;

/**
 *
 * @author hernan
 */
public class MonteCarloCanvas extends Canvas {

    // Mantener una matriz de mil puntos alrededor. Si se calcula más
    // que entre las llamadas a update (), se rompe.
    private Point points[] = new Point[1000];
    private Color colors[] = new Color[1000];
    private Color lightBlue = new Color(150, 150, 255);
    private int curPoint = 0;

    // Establecerlo en verdadero para borrar la visualización y volver a dibujar el borde.   
    private boolean clear_p = true;

    public MonteCarloCanvas() {
        for (int i = 0; i < 1000; i++) {
            points[i] = new Point();
        }
    }

    // Devuelve verdadero si el punto agregado estaba en el círculo.    
    public boolean addPoint() {
        Dimension size = getSize();
        int xoffset = 0;
        int yoffset = 0;

        // Centra la plaza dentro del área de dibujo, y deja espacio
        // para la frontera.
        if (size.width > size.height) {
            xoffset = (size.width - size.height) / 2 + 1;
            yoffset = 1;
            size.height -= 2;
            size.width = size.height;
        } else if (size.height > size.width) {
            yoffset = (size.height - size.width) / 2 + 1;
            xoffset = 1;
            size.width -= 2;
            size.height = size.width;
        }

        double x = Math.random();
        double y = Math.random();

        double magX = .5 - x;
        double magY = .5 - y;
        boolean inUnitCircle = Math.sqrt(magX * magX + magY * magY) <= .5; // <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<

        // Sincronizar en puntos para que el hilo de actualización no llegue y
        // intenta dibujar mientras lo estamos actualizando.
        synchronized (points) {
            if (curPoint < 1000) {
                if (inUnitCircle) {
                    colors[curPoint] = Color.blue;
                } else {
                    colors[curPoint] = Color.RED;
                }
                int xloc = (int) (x * size.width + xoffset);
                int yloc = (int) (y * size.height + yoffset);
                points[curPoint].setLocation(xloc, yloc);
                curPoint++;
            }
        }

        // Redibujar.        
        repaint();
        return inUnitCircle;
    }

    public void clear() {
        clear_p = true;
    }

    // Función de dibujo. Anulamos esto en lugar de paint () ya que
    // no se quiere borrar y volver a dibujar toda la pantalla 
    // (no se quiere mantener alrededor de ese estado de todos modos).
    public void update(Graphics g) {
        if (clear_p) {
            clear_p = false;
            g.setColor(getBackground());
            Dimension size = getSize();
            g.fillRect(0, 0, size.width, size.height);
            g.setColor(Color.black);

            // Calcula donde poner el borde.            
            int xoffset = 0;
            int yoffset = 0;

            if (size.width > size.height) {
                xoffset = (size.width - size.height) / 2;
                size.width = size.height;
            } else if (size.height > size.width) {
                yoffset = (size.height - size.width) / 2;
                size.height = size.width;
            }
            // Dibuja el borde.
            g.drawRect(xoffset, yoffset, size.width - 1, size.height - 1);
        }
        // Sincronizado en puntos para que no lo dibujemos y lo trunquemos mientras se está agregando un punto.
        synchronized (points) {
            for (int i = 0; i < curPoint; i++) {
                Point p = points[i];
                g.setColor(colors[i]);
                g.fillRect(p.x, p.y, 1, 1);
            }
            curPoint = 0;
        }
    }
}
