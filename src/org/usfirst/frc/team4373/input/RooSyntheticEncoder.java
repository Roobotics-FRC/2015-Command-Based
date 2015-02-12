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
		public State (DigitalInput hally){
			activated = hally.get();
			motorDirection = Robot.rooForkLift.getDirection();
			position = currentPosition;
		}
		public boolean isActivated() {
			return !activated;
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
	int i=0;
	public void iterate (){
		++i;
		CommandBase.getOI().rd.putNumber("Hally Position: ", currentPosition);
		CommandBase.getOI().rd.putBoolean("Hally activated: ", hally.get());
		if (previousState != null) { // If this is not the first iteration
			CommandBase.getOI().rd.putString("Previous state not null", "yep");
			if (hally.get()) {
				if (!previousState.isActivated()) {
					int direction = Robot.rooForkLift.getDirection();
					CommandBase.getOI().rd.putNumber("Incrementing by:", direction);
					currentPosition += direction;
				}
			}
		}
		CommandBase.getOI().rd.putNumber("RSE: ", currentPosition);
		previousState = new State(hally);
	}
	
	public int getPosition(){
		return currentPosition;
	}
	

}
