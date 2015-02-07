package org.usfirst.frc.team4373.input;

import org.usfirst.frc.team4373.robot.Robot;

import edu.wpi.first.wpilibj.DigitalInput;

public class RooSyntheticEncoder {
	//aka RooSchmencoder
	
	
	private DigitalInput hally;
	public static int numberOfPositions;
	private int currentPosition;
	private State previousState = null;
	
	class State {
		private boolean activated;
		private int motorDirection;
		private double position = 0;
		public State (DigitalInput hally){
			activated = hally.get();
			motorDirection = Robot.rooForkLift.getDirection();
			position = currentPosition;
		}
		public boolean isActivated() {
			return activated;
		}
		public int getMotorDirection() {
			return motorDirection;
		}
		public double getPosition() {
			return position;
		}
	}
	
	public RooSyntheticEncoder(int channel, int numberOfPositions, int startingPosition){
		hally = new DigitalInput(channel);
		this.numberOfPositions = numberOfPositions;
		this.currentPosition = startingPosition;
	}
	
	public void iterate (){
		if (previousState != null) { // If this is not the first iteration
			if (hally.get()) {
				if (!previousState.isActivated()) {
					if (Robot.rooForkLift.getDirection() == -1)
						--currentPosition;
					else if (Robot.rooForkLift.getDirection() == 1)
						++currentPosition;
				}
			}
		}
		previousState = new State(hally);
	}
	

}
