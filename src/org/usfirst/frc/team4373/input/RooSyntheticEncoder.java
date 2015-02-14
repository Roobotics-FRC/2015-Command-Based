package org.usfirst.frc.team4373.input;

import org.usfirst.frc.team4373.robot.Robot;
import org.usfirst.frc.team4373.robot.RobotMap;
import org.usfirst.frc.team4373.robot.commands.CommandBase;

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
		public State (boolean activated){
			this.activated = activated;
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
		hally = new DigitalInput(RobotMap.HallyPort);
		this.numberOfPositions = numberOfPositions;
		this.currentPosition = startingPosition;
	}
	protected int i=0;
	public void iterate (){
		++i;
		boolean activated = hally.get();
		if (previousState != null) { // If this is not the first iteration
//			CommandBase.getOI().rd.putString("Previous state not null", "yep");
			if (activated) {
				if (previousState.isActivated() != activated) {
					CommandBase.getOI().rd.putBoolean("Previous state enabled: ", previousState.isActivated());
					CommandBase.getOI().rd.putBoolean("Current state enabled: ", activated);
					if (Robot.rooForkLift.getDirection() == 1){
						++currentPosition;
					}else{
						--currentPosition;
					}
				}
				
				
			}
		}
		previousState = new State(activated);
		CommandBase.getOI().rd.putNumber("Schmencoder Position: ", getPosition());
	}
	
	public int getPosition(){
		return currentPosition;
	}
	 
	public void reset(){
		currentPosition = 0;
	}
	

}
