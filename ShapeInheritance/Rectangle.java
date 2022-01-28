import java.util.*;
import javax.swing.*;
import java.awt.*;
import javax.swing.*;
import java.awt.geom.*;
/**
 * When created can create a rectangle that is 
 * capable of being drawn in a window and 
 * getting the area of
 *
 *One of the Shapes from lab 5
 *
 * @author Connor Lauerman
 * @version 10/30/2019
 */
public class Rectangle extends Shape
{
    private int length;
    private int width;
    /**
     * Constructor for the rectangle object 
     * will intialize the data for the Rectangle
     * 
     * input:
     * 
     * x: The x coordinate to start drawing the rectangle
     * from
     * 
     * y: The y coordinate to start drawing the rectangle
     * from
     * 
     * length: The length of the rectangle
     * 
     * width: The width of the rectangle
     */
    public Rectangle(int x, int y, int length,int width)
    {
        super(x,y);
        this.length=length;
        this.width = width;
    }

    /**
     * Draws a rectangle to a JFrame
     * 
     * input:
     * 
     * g: The Graphics object that will draw
     * the rectangle to the screen
     * 
     * output:
     * 
     * Draws a rectangle to a JFrame
     */
    public void draw(Graphics g)
    {       
        g.drawRect( getX(), getY(), length,width);
    }

    /**
     * Returns the Width of the recntangle
     * 
     * output:
     * 
     * Returns an int for the width
     */
    public int getWidth()
    {
        return this.width;
    }

    /**
     * Returns the legnth of the recntangle
     * 
     * output:
     * 
     * Returns an int for the length
     */
    public int getLength()
    {
        return this.length;
    }
}
