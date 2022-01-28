import java.util.*;
import javax.swing.*;
import java.awt.*;
import javax.swing.*;
import java.awt.geom.*;
/**
 * Creates a triangle that inherits from shape
 * is capable of drawin a triangle to a window
 * 
 * Lab shape replacing my square class from lab
 * because that was already done by an example
 *
 * @author Connor Lauerman
 * @version 10/30/2019
 */
public class Triangle extends Shape
{
    private int x,y,a,b,c,d;

    /**
     * The constructor for a Triangle that takes a coordinate
     * to create the triangle somewhere on a JFrame
     * 
     * input:
     * 
     * x:The coordinate that will be used for 
     * x and y then creates the rest of the
     * sides based off this coordinate
     */
    public Triangle(int x)
    {
        super(x,x);
        this.a = x;
        this.b = x*3/2;
        this.c = x*3/2;
        this.d= x*3/2;

    }

    /**
     * Gets the area of the trianlge that is drawn
     * to the screen
     */
    public double getArea()
    {
        double width =(b - x);
        double height = (c - x);
        return width * height / 2;
    }

    /**
     * Draws 3 lines in a way that will create a triangle 
     * on a JFrame
     * 
     * input:
     * 
     * g: The Graphics that will draw the lines to
     * the screen
     * 
     * output:
     * 
     * Draws a triangle to a JFrame
     * 
     */
    public void draw( Graphics g) {

        g.drawLine( getX(), getY(), a, b);
        g.drawLine( getX(), getY(), c, d);
        g.drawLine(c,d,a,b);

    }


}
