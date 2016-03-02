import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by gnuze on 24/02/2016.
 */


/**
 * A class derived from JPanel that allows user to draw simple graphs
 */
public class JGraph extends JPanel {
    private BufferedImage image = null;
    private Graphics2D graph = null;

    public void setBackground(Color background) {
        this.background = background;
    }

    public void setPencil(Color pencil) {
        this.pencil = pencil;
    }

    private Color background;
    private Color pencil;
    private int width;
    private int height;

    /**
     * Create a JGraph with given dimensions, setting the point at the upper left corner to (0,0).
     * It almost cleans it with a WHITE background color and sets a BLACK pencil
     * @param width
     * @param height
     */
    public JGraph(int width, int height) {
        image = new BufferedImage(300,300,BufferedImage.TYPE_INT_RGB);
        Graphics2D graph = image.createGraphics();
        background=Color.WHITE;
        pencil= Color.BLACK;
        this.width = width;
        this.height = height;
        clean();
    }

    /**
     * cleans the JGraph with the background color
     */
    public void clean() {
        Graphics2D graph = image.createGraphics();
        graph.setColor(pencil);
        graph.setBackground(background);
        graph.clearRect(0,0,width,height);
        repaint();
    }

    /**
     * draws a line using the pencil color
     * @param x1
     * @param y1
     * @param x2
     * @param y2
     */
    public void drawLine(int x1, int y1, int x2, int y2) {
        Graphics2D graph = image.createGraphics();
        graph.setColor(pencil);
        graph.drawLine(x1, y1, x2, y2);
        repaint();
    }

    /**
     * draws a rectangle using the pencil color
     * @param x1
     *
     */
    public void drawRect(int x1,int y1,int width,int height,boolean filled) {
        Graphics2D graph = image.createGraphics();
        graph.setColor(pencil);
        if (filled) graph.fillRect(x1,y1,width,height);
        else graph.drawRect(x1, y1, width, height);
        repaint();
    }
    /**
     * draws an ellipse using the pencil color
     * @param x1
     * @param y1
     * @param width
     * @param height
     * @param filled: set to true if you want to fill up the ellipse
     */
    public void drawEllipse(int x1,int y1,int width, int height, boolean filled) {
        Graphics2D graph = image.createGraphics();
        graph.setColor(pencil);
        if (filled) graph.fillOval(x1,y1,width,height);
        else graph.drawOval(x1, y1, width, height);
        repaint();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(image, 0, 0, null);
    }
}
