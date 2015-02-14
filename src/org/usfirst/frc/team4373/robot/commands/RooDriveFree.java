package org.usfirst.frc.team4373.robot.commands;

import org.usfirst.frc.team4373.robot.*;

import edu.wpi.first.wpilibj.command.Command;


public class RooDriveFree extends RooDrive {
	
	//theoretical speed ratio between tank weels and strafe wheels, subject to experimental confirmation
	public static final double TANK_STRAFE_SPEED_RATIO = 1.5088757396;
	
	public RooDriveFree() {
		super ();
	}
	
	@Override
	protected void initialize() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void execute() {
		// update the relevant variables

    	CommandBase.getOI().rd.putString("Drive Mode: ", "Free Rotation");
		stickF = this.oi.getForwardAxis();
		stickR = this.oi.getRightAxis();
		stickYaw = this.oi.getYaw();
		gyroAngle = this.oi.getGyroAngle();
		
		//Cook the Joystick inputs depending on whether or not we're going for aboslute direction
		//or robot-reletive direction
		//TODO: does this go here?
		if (oi.getDriveStickButton(RobotMap.absoluteDirectionModeEnable)){
			double newStickF = getForwardMagnitudeFromFieldwise (stickR, stickF, gyroAngle);
			oi.rd.putNumber("Fudged Straight Value", newStickF);
			stickR = getRightMagnitudeFromFieldwise (stickR, stickF, gyroAngle);
			oi.rd.putNumber("Fudged Right Value", stickR);
			stickF = newStickF;
		}
		
		//temporary drive disable for safe testing
		if (oi.rd.rooGetBoolean("Disable Drive", false) == false){
			//while the yaw-enable button is held down, 
			//yawing the joystick should rotate the bot
				Robot.rooDrivetrain.setLeft(-stickYaw + stickF);
				Robot.rooDrivetrain.setRight(stickYaw + stickF);
				Robot.rooDrivetrain.setStrafe(stickR);
		}
		
		oi.rd.putNumber("Stick F", stickF);
		oi.rd.putNumber("Stick R", stickR);
		oi.rd.putNumber("Stick Yaw", stickYaw);
		oi.rd.putNumber("Gyro", gyroAngle);
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected void end() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub

	}
	
}
