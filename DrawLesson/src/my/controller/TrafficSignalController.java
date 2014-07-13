package my.controller;

import my.gui.TrafficSignal;

public class TrafficSignalController extends Thread {

	// internal data model
	private TrafficSignal theSignal; // this is the signal to control
	private int sleepinterval; // sleep interval in milliseconds
	
	// The ctor needs to be told the TrafficSignal object to control
	public TrafficSignalController(TrafficSignal trSignal) {
		// initialize internal data variables
		System.out.println("ctor 1 called");
		theSignal = trSignal; // store the parameter value in theSignal
		sleepinterval = 2000; // sleep interval defaults to 2000 ms
	}
	
	// second ctor that takes a TrafficSignal and the sleep time in milliseconds
	public TrafficSignalController(TrafficSignal trSignal, int sleeptime) {
		// initialize internal data variables
		System.out.println("ctor 2 called");
		theSignal = trSignal; // store the input parameter in theSignal var
		sleepinterval = sleeptime; // store input param sleeptime in instance data
	}

	@Override
	public void run() {
		// Implement the logic to operate the signal
		
		// Logic description:
		// Turn red, green, and yellow lights on one after another
		// after sleeping for 2 seconds in between
		// Step 1: turn red light on
		// Step 2: sleep for 2 seconds
		// Step 3: turn green light on
		// Step 4: sleep for 2 seconds
		// Step 5: turn yellow light on
		// Step 6: sleep for 2 seconds
		// Step 7: loop back to step 1
		// The above is an infinite loop because it does not exit, break, or terminate

		while (true) {
			// turn the signal's red light on
			theSignal.setRedOn();
			// sleep for 2 seconds = 2000 milliseconds
			try {
				Thread.sleep(sleepinterval);
			} catch (Exception e) {
				System.out.println("Sleep got interrupted.");
			}
			
			// turn the signal's green light on
			theSignal.setGreenOn();
			// try to sleep for 2 seconds = 2000 milliseconds
			try {
				Thread.sleep(sleepinterval);
			} catch (Exception e) {
				System.out.println("Sleep got interrupted again.");
			}
			
			// turn the signal's yellow light on
			theSignal.setYellowOn();
			// try to sleep for 2 seconds = 2000 milliseconds
			try {
				Thread.sleep(sleepinterval);
			} catch (Exception e) {
				System.out.println("Sleep got interrupted again and again.");
			}
		} // end of while loop
	}
}
