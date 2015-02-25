package org.usfirst.frc.team4373.robot.commands;

import org.usfirst.frc.team4373.robot.Robot;


public class RooAutonGrabBin extends RooAutonBase {

	public long time = 0;
	public boolean started = false;

	public void execute() {
		started = true;
		if (time == 0) {
			time = System.currentTimeMillis();
			Robot.rooForkLift.set(0.0D);
		}
		else if (Robot.wings.moveLeftUntilSwitch()) {
			
		}
	}



}
