package org.usfirst.frc.team4373.robot.commands;

import org.usfirst.frc.team4373.robot.Robot;


public class RooAutonGrabBin extends RooAutonBase {
	private long startTime=0,endTime,startDownTime=0,totalTime;
	private boolean lowerArm=false, shouldRaise=false;
	private boolean hasLoweredArm = false, hasRaisedArm = false;
	
	public void execute() {
		if (shouldRaise) {
			if (Robot.wings.moveLeftUntilSwitch()) {
				totalTime = System.currentTimeMillis() - startTime;
				Robot.rooForkLift.set(0.0);
				shouldRaise = false;
				hasRaisedArm = true;
			}
			else if (startTime == 0)
				startTime = System.currentTimeMillis();
			else if (shouldRaise) {
				Robot.rooForkLift.set(1.0);
			}
			return;
		}
		if (hasRaisedArm & !(hasLoweredArm)){
			Robot.rooDrivetrain.setTank(0.4);
			try{
				Thread.sleep(4000);
			}catch (InterruptedException e){
			}
			Robot.rooDrivetrain.setTank (0);
		}
			
//		else if (oi.getFrontLimitSwitch()) {
//			Robot.rooDrivetrain.setTank(0.0);
//			lowerArm = true;
//		}
		if (lowerArm) {
			hasLoweredArm = true;
			if (startDownTime == 0) {
				startDownTime = System.currentTimeMillis();
				endTime = startDownTime + totalTime;
			}
			if (System.currentTimeMillis() < endTime)
				Robot.rooForkLift.set(-1.0);
			else
				Robot.rooForkLift.set(0.0);
		}
	}
}
