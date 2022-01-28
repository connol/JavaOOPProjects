import java.util.*;
import javax.swing.*;
import java.awt.*;

/**
 * Class PolyDemo (is a JFrame) and PolyDemoPanel (is a JPanel)
 * which will them print shapes to the JFrame
 * 
 * @Author: Connor Lauerman
 * @Version 10/30/2019
 **/

class PolyDemo extends JFrame {
    /**
     * Constructor for PolyDemo creats a JFrame that the shapes
     * can be drawn to then creates the Demo object which
     * will call all the methods to print the shapes to the 
     * screen
     */
    public PolyDemo() {
        getContentPane().add( new PolyDemoPanel() );
        //just some windowing stuff that must happen for all Frames
        setSize( 300,300 );
        setVisible( true );
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    }

    /**
     * Creates the the JFrame object 
     */
    public static void main( String args[] ) {
        PolyDemo myApp = new PolyDemo();
    }

    public class PolyDemoPanel extends JPanel {     
        Shape[] myShapes= new Shape[4];

        /**
         * Creates a Shape array that carries all
         * shapes to be prininted to screen
         */
        public PolyDemoPanel() {           
            for( int i = 0; i < myShapes.length; i++ ) {
                myShapes[i] =  getShape(i);
            }
        }

        /**
         * A method to draw to screen every shape in
         * the shape array 
         *          * 
         * Output:
         * 
         * Draws shapes to screen
         */
        public void paint( Graphics g ) {
            super.paint(g);
            for( int i = 0; i < myShapes.length; i++ ){
                myShapes[i].draw( g );  
            }   
        }

        /**
         * Gets the Shape object to be stored in
         * an array
         * 
         * input
         * 
         * i: the shape to be grabbed from the switch statement
         * 
         * output:
         * 
         * Returns a shape object
         */
        public Shape getShape(int i) {
            Shape retVal = null;

            switch(i) {
                case 0:     retVal = new Rectangle( 20,100,30,40 );
                i++;
                break;
                case 1:     retVal = new Triangle( 50);
                i++;
                break;
                case 2:     retVal = new SailBoat( 75,50);
                i++;
                break;
                case 3:     retVal = new Mushroom( 200,200);
                break;              
            }

            return retVal;
        }
    }   

}

