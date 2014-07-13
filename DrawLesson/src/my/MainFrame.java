package my;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import my.controller.TrafficSignalController;
import my.gui.ColorCirclePanel;
import my.gui.TrafficSignal;

import javax.swing.JFrame;

public class MainFrame extends JFrame {

	public MainFrame() {
		// set JFrame properties
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("Main Frame");
		this.getContentPane().setLayout(new GridLayout(0, 1));
		
		// create and add ColorCirclePanel to content pane
		// this.getContentPane().add(new ColorCirclePanel(Color.GREEN));
		// this.getContentPane().add(new ColorCirclePanel(Color.RED));
		TrafficSignal tSignal1 = new TrafficSignal(); // red on
		this.getContentPane().add(tSignal1);
		// tSignal1.setGreenOn(); // turn green light on
		// create a TrafficSignalController to control tSignal1 TrafficSignal instance
		TrafficSignalController tsc = new TrafficSignalController(tSignal1);
		// start the controller thread
		tsc.start();
		
		TrafficSignal tSignal2 = new TrafficSignal();
		this.getContentPane().add(tSignal2);
		// create a second controller for the tSignal2
		TrafficSignalController tsc2 = new TrafficSignalController(tSignal2, 3000);
		// start the controller thread
		tsc2.start();
		
		// pack the frame and show
		this.pack();
		// this.setSize(300, 300);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		// create a GUI/Swing thread to create MainFrame
		javax.swing.SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				new MainFrame(); // create the MainFrame object
			}
			
		});
		
	}

}
