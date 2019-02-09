
package integralmontecarlo.applet;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.lang.Math;
import java.awt.*;

/**
 *
 * @author hernan
 */

public class MonteCarloCanvas extends Canvas {

    // Keep an array of a thousand points around. If we calculate more
    // than that in between calls to update(), we throw the rest on the floor.
    private Point points[] = new Point[1000];
    private Color colors[] = new Color[1000];
    private Color lightBlue = new Color(150, 150, 255);
    private int curPoint = 0;

    // Set to true to clear the display and redraw the border.
    private boolean clear_p = true;

    public MonteCarloCanvas() {
        for (int i = 0; i < 1000; i++) {
            points[i] = new Point();
        }
    }

    // Returns true if point added was in the circle.
    public boolean addPoint() {
        Dimension size = getSize();
        int xoffset = 0;
        int yoffset = 0;

        // Center the square inside the drawing area, and leave space
        // for the border.
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
        boolean inUnitCircle = Math.sqrt(magX * magX + magY * magY) <= .5;

        // Synchronize on points so that the update thread doesn't come and
        // try to draw while we're updating it.
        synchronized (points) {
            if (curPoint < 1000) {
                if (inUnitCircle) {
                    colors[curPoint] = Color.blue;
                } else {
                    colors[curPoint] = lightBlue;
                }
                int xloc = (int) (x * size.width + xoffset);
                int yloc = (int) (y * size.height + yoffset);
                points[curPoint].setLocation(xloc, yloc);
                curPoint++;
            }
        }

        // Ask ourselves to redraw.
        repaint();
        return inUnitCircle;
    }

    public void clear() {
        clear_p = true;
    }

    // Drawing function. We override this instead of paint() since we
    // don't want to erase and redraw the whole screen (don't want to
    // keep around that much state anyway).
    public void update(Graphics g) {
        if (clear_p) {
            clear_p = false;
            g.setColor(getBackground());
            Dimension size = getSize();
            g.fillRect(0, 0, size.width, size.height);
            g.setColor(Color.black);

            // Calculate where to put the border.
            int xoffset = 0;
            int yoffset = 0;

            if (size.width > size.height) {
                xoffset = (size.width - size.height) / 2;
                size.width = size.height;
            } else if (size.height > size.width) {
                yoffset = (size.height - size.width) / 2;
                size.height = size.width;
            }
            // Draw the border.
            g.drawRect(xoffset, yoffset, size.width - 1, size.height - 1);
        }
        // Synchronized on points so we don't draw it and truncate it while
        // a point is being added.
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
