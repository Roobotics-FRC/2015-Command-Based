package org.usfirst.frc.team4373.robot.commands;

import org.usfirst.frc.team4373.robot.Robot;


public class RooAutonManuverTotes extends RooAutonBase {
	private long startTime=0,endTime,startDownTime=0,totalTime;
	private boolean lowerArm=false, shouldRaise=true, shouldTurn = false;
	private boolean hasLoweredArm = false, hasRaisedArm = false;
	private int savedthang;
	
	@Override
	public void initialize(){
		super.initialize();
		savedthang = oi.getSchmencoderPosition();
	}
	
	@Override 
	public void execute() {
		oi.iterate();
		if (shouldRaise) {
			if (Robot.rooForkLift.moveToPosition(savedthang+ 12)) {
				//saved schmencoder position.
				oi.rd.putNumber("Saved thang: ", savedthang);
//				oi.rd.putNumber(", value);
				shouldRaise = false;
				hasRaisedArm = true;
			}
			return;
		}
		if (hasRaisedArm & !(hasLoweredArm)){
			Robot.rooDrivetrain.setTank(0.4);
			try{
				Thread.sleep((long)oi.rd.rooGetNumber("Auton drive delay: ", 4000)); //make this shorter to automove to the inbound station
			}catch (InterruptedException e){
			}
			Robot.rooDrivetrain.setTank(0);
			shouldTurn = true;
		}
			
//		else if (oi.getFrontLimitSwitch()) {
//			Robot.rooDrivetrain.setTank(0.0);
//			lowerArm = true;
//		}
		if (shouldTurn) {
			// TUrn 90 degrees
			if (oi.rd.rooGetBoolean("Turn in Auton?", false)) {
				if (oi.getGyroAngle() <= 80) {
					Robot.rooDrivetrain.setLeft(-0.7);
					Robot.rooDrivetrain.setRight(0.7);
				}
				else {
					Robot.rooDrivetrain.setTank(0.0);
					lowerArm = true;
					shouldTurn = false;
				}
			}
			else {
				lowerArm = true;
				shouldTurn = false;
			}
		}
		if (lowerArm) {
			hasLoweredArm = true;
			Robot.rooForkLift.moveToPosition(savedthang);
		}
	}
}
