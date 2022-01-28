import java.util.*;
import javax.swing.*;
import java.awt.*;
import javax.swing.*;
import java.awt.geom.*;
/**
 * Creates a SailBoat that inherits from shape
 * is capable of drawing a SailBoat to a window
 * using draw line, draw arc and, draw line to create
 * the SailBoat
 *
 * @author Connor Lauerman
 * @version 10/30/2019
 */
public class SailBoat extends Shape
{
    
    /**
     * Constructor for SailBoat which will set the location
     * where the SailBoat will be drawn to screen
     * 
     * input:
     * 
     * x: The x coordinate that the sail boat will
     * begin to draw
     * 
     * y: the y coordinate that the sail boat will 
     * begin to be drawn at
     */
    public SailBoat(int x, int y)
    {
        super(x,y);
        
        
    }

    /**
     * Does the drawing of the 3 shapes to create
     * the sail boat and sets color for each shape
     * First it draws a arc then a line then a rectangle
     * for the base, pole, and flag respectivley
     * 
     * input:
     * 
     * g: A graphics object that will be doing the 
     * drawing of the shapes
     */
    public void draw( Graphics g)
    {
        Color brown = new Color(102,51,0);
        
        g.setColor(brown);
        g.fillArc(getX(),getY(), 200,110,0, -180);
        g.drawLine(getX()+100, getY()+75, getX()+100, getY()-50);
        g.setColor(Color.RED);
        g.fillRect(getX()+100,getY()-50,20,10);
        
    }
    
    /**
     * Will inherit the get area from shpaes because the radius
     * of the arc is not constant
     */

    

}
