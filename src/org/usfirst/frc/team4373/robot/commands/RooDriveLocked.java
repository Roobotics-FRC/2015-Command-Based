package org.usfirst.frc.team4373.robot.commands;

import org.usfirst.frc.team4373.robot.*;

import edu.wpi.first.wpilibj.command.Command;


public class RooDriveLocked extends RooDrive {		
	@Override
	protected void execute() {
		// update the relevant variables
		stickF = oi.getForwardAxis();
		stickR = oi.getRightAxis();
		gyroAngle = oi.getGyroAngle();
		
		//Cook the Joystick inputs depending on whether or not we're going for aboslute direction
		//or robot-reletive direction
		//TODO: does this go here?
		if (oi.getButton(RobotMap.absoluteDirectionModeEnable)){
			double newStickF = getForwardMagnitudeFromFieldwise (stickR, stickF, gyroAngle);
			stickR = getRightMagnitudeFromFieldwise (stickR, stickF, gyroAngle);
			stickF = newStickF;
		}
		//temporary drive disable for safe testing
		if (oi.rd.getBoolean("Disable Drive", false) == false){
			//while the yaw-enable button is held down, 
			//yawing the joystick should rotate the bot
			Robot.rooDrivetrain.setLeft((-gyroAngle/180) + stickF);
			Robot.rooDrivetrain.setRight((gyroAngle/180) + stickF);
			Robot.rooDrivetrain.setStrafe(stickR);
		}
		
		//We really need to get the SmartDashboard into it's officail home, would that be in OI?
		oi.rd.putNumber("Stick F", stickF);
		oi.rd.putNumber("Stick R", stickR);
		oi.rd.putNumber("Stick Yaw", stickYaw);
		oi.rd.putNumber("Gyro", gyroAngle);
	}
}
