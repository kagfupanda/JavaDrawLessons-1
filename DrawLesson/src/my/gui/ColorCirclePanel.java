package my.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

import javax.swing.JPanel;

public class ColorCirclePanel extends JPanel {

	// private data properties
	private Color fillColor; // initialized by ctor
	
	// Pass in Color to use as argument to ctor
	public ColorCirclePanel(Color c) {
		// Save the color in our object
		fillColor = c; // store the color value passed
		this.setSize(200, 200);
	}

	@Override
	public void paint(Graphics g) {
		System.out.println("[3]paint method in ColorCirclePanel");
		super.paint(g);
		// draw the circle at the center of the panel
		int width = getWidth(); // width of the panel
		int height = getHeight(); // height of the panel
		System.out.println("Panel dimensions: " + width + " " + height);
		int centerx = width/2; // midpoint
		int centery = height/2; // midpoint
		System.out.println("Center: " + centerx + " " + centery);
		int circleWidth = 50; // 20 pixels
		int circleHeight = 50; // 20 pixels
		
		// use Ellipse2D to create (new) a circle
		// then use Graphics2D method draw to paint the ellipse
		
		// convert the Graphics type arg to Graphics2D
		Graphics2D g2d = (Graphics2D)g;
		double upperLeftX = centerx - circleWidth/2;
		double upperLeftY = centery - circleHeight/2;
		
		// set the paint color
		g2d.setPaint(fillColor);
		System.out.println("Values are: " + upperLeftX + " " + upperLeftY);
		System.out.println("Circle values: " + circleWidth + " " + circleHeight);
		
		g2d.draw(new Ellipse2D.Double(upperLeftX, upperLeftY, circleWidth, circleHeight));
	}

	@Override
	public Dimension getPreferredSize() {
		// TODO Auto-generated method stub
		return new Dimension(200, 200);
	}

}
