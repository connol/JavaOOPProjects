import java.util.*;
import javax.swing.*;
import java.awt.*;
import javax.swing.*;
import java.awt.geom.*;
/**
 * Creates a shape of a mushroom by combining an
 * arc and a rectangle and is capable of drawing the
 * mushroom to a JFrame
 *
 * @author Connor Lauerman
 * @version 10/30/2019
 */
public class Mushroom extends Shape
{
    private int length;
    private int width;
    private int radius;
    /**
     * The constructor for the mushroom which 
     * will initialize the x and y for the mushroom
     * and will intialize the length and width
     * 
     * input:
     * 
     * x: The x coordinate to start drawing the
     * mushroom
     * 
     * y: The y coordinate to start drawing the 
     * mushroom
     */
    public Mushroom(int x, int y)
    {
        super(x,y);
        this.length = 60;
        this.width = 20;

    }

    /**
     * Finds the area of the arc and rectangle
     * combined to get the total area of the
     * mushroom
     * 
     * output:
     * 
     * returns a double for the area of
     * the mushroom
     */
    public double getArea()
    {
        double area = Math.PI * 50 /2;
        area = area + (width * length);
        return area;
    }

    /**
     * Draws the mushroom to the screen by drawing an arc 
     * and a rectangle then adds circle inside the arc to
     * add to the mushroom
     * 
     * input:
     * 
     * g: The graphics object used to draw the
     * mushroom to the screen
     * 
     * output:
     * 
     * Draws a muhsroom to the screen
     * 
     */
    public void draw( Graphics g) {
        Color brown = new Color(51,0,0);
        Color white = new Color(255,255,255);
        g.setColor(brown);
        g.fillRect( getX(), getY(), width, length);
        g.setColor(Color.RED);
        g.fillArc(getX()-40,getY()-50,100,100,0,180);
        g.setColor(white);
        g.fillOval(getX(),getY()-10, 5,5);
        g.fillOval(getX(),getY()-20, 5,5);
        g.fillOval(getX()-10,getY()-25, 5,5);
        g.fillOval(getX()-15,getY()-10, 5,5);
        g.fillOval(getX()-20,getY()-25, 5,5);
        g.fillOval(getX()-17,getY()-12, 5,5);
        g.fillOval(getX()-31,getY()-8, 5,5);
        g.fillOval(getX()-14,getY()-40, 5,5);
        g.fillOval(getX()-10,getY()-25, 5,5);
        g.fillOval(getX()-25,getY()-25, 5,5);
        g.fillOval(getX()-21,getY()-15, 5,5);
        g.fillOval(getX()+10,getY()-25, 5,5);
        g.fillOval(getX()+15,getY()-10, 5,5);
        g.fillOval(getX()+20,getY()-25, 5,5);
        g.fillOval(getX()+17,getY()-12, 5,5);
        g.fillOval(getX()+31,getY()-8, 5,5);
        g.fillOval(getX()+14,getY()-40, 5,5);
        g.fillOval(getX()+10,getY()-25, 5,5);
        g.fillOval(getX()+25,getY()-25, 5,5);
        g.fillOval(getX()+21,getY()-15, 5,5);
        g.fillOval(getX()+34,getY()-24, 5,5);
        g.fillOval(getX()+36,getY()-11, 5,5);
        
    }

}
