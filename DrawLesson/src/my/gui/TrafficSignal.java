package my.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

import javax.swing.JPanel;

// TrafficSignal is a JPanel with three circles
// drawn
public class TrafficSignal extends JPanel {

	// data model
	private final int defaultWidth = 50;
	private final int defaultHeight = 150;
	private final int circleMargin = 10; // 10 pixels margin around circle
	private final Dimension prefSize = new Dimension(defaultWidth, defaultHeight);
	// Flags to remember which color should be filled
	private boolean fillRed; // initialized in ctor
	private boolean fillYellow; // initialized in ctor
	private boolean fillGreen; // initialized in ctor
	
	// construct a default TrafficSignal
	public TrafficSignal() { // default ctor because no input arg
		fillRed = true; // only Red is filled when newly created
		fillYellow = false;
		fillGreen = false;
	}

	// Paint gets called whenever the object changes, not just when
	// it is newly created
	@Override
	public void paintComponent(Graphics g) { // called by the GUI Event Handler
		super.paintComponent(g);
		
		// This is where the traffic signals have to be painted/drawn
		// initialize the panel with the traffic signals
		int width = this.getWidth(); // returns panel's width
		int height = this.getHeight(); // save panel's height

		int adjust_x = 0; // initialize x adjustment to zero
		int delta_x = width - (height/3); // width > height/3?
		if (delta_x > 0) { // true means width is longer than height/3
			adjust_x = delta_x/2; // half of difference because we want
			// to horizontally center the circle
		}

		int adjust_y = 0; // initialize y adjustment to zero
		int delta_y = (height/3) - width; // height/3 > width
		if (delta_y > 0) { // true means height/3 is greater than width
			adjust_y = delta_y/2; // half of y difference because we want
			// to vertically center the circle
		}

		// compute circle's width and height
		// use the smaller of width or height/3
		int circleWidth = width;
		if (width < (height/3)) { // use if then else statement for checks
			circleWidth = width - circleMargin; // use width because it is smaller
		} else {
			circleWidth = height/3 - circleMargin; // use height/3 otherwise
		}

		// Let's draw the three circles for traffic lights
		// First circle: fill with Color.red
		// get the Graphics2D object from Graphics
		Graphics2D g2d = (Graphics2D)g; // cast g to Graphics2D type
		
		g2d.setPaint(Color.RED); // top signal
		int upperLeftX1 = 0 + adjust_x;
		int upperLeftY1 = 0 + adjust_y;
		if (fillRed == true) { // use if then else to check fillRed state
			g2d.fill(new Ellipse2D.Double(upperLeftX1, upperLeftY1, circleWidth, circleWidth));
		} else { // fillRed is false
			g2d.draw(new Ellipse2D.Double(upperLeftX1, upperLeftY1, circleWidth, circleWidth));
		}
		// second circle: fill with Color.yellow
		g2d.setPaint(Color.YELLOW);
		int upperLeftY2 = upperLeftY1 + height/3;
		if (fillYellow == true) {
			g2d.fill(new Ellipse2D.Double(upperLeftX1, upperLeftY2, circleWidth, circleWidth));	
		} else {
			g2d.draw(new Ellipse2D.Double(upperLeftX1, upperLeftY2, circleWidth, circleWidth));
		}
		
		// third cicle: fill with Color.green
		g2d.setPaint(Color.GREEN);
		int upperLeftY3 = upperLeftY2 + height/3;
		if (fillGreen == true) {
			g2d.fill(new Ellipse2D.Double(upperLeftX1, upperLeftY3, circleWidth, circleWidth));		
		} else {
			g2d.draw(new Ellipse2D.Double(upperLeftX1, upperLeftY3, circleWidth, circleWidth));
		}
	}

	@Override
	public Dimension getPreferredSize() { 
		return prefSize;
	}
	
	// Method to set Red light on
	public void setRedOn() {
		fillRed = true; // set fillRed flag to true
		fillYellow = false;
		fillGreen = false;
		repaint(); // this tells GUI manager to repaint the panel
	}
	
	// Method to set Yellow light on
	public void setYellowOn() {
		fillYellow = true; // set fillYellow flag to true
		fillRed = false;
		fillGreen = false;
		repaint();
	}
	
	// Method to set Green light on
	public void setGreenOn() {
		fillGreen = true; // set fillGreen flag to true
		fillRed = false;
		fillYellow = false;
		repaint();
	}

}
