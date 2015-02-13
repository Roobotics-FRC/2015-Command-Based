package org.usfirst.frc.team4373.robot.commands;

import org.usfirst.frc.team4373.robot.*;

import util.RooMath;
import edu.wpi.first.wpilibj.command.Command;


public class RooDriveLocked extends RooDrive {		
	
	private double tareAngle;
	
	@Override
	protected void execute() {

    	
    	
		
		// update the relevant variables
		stickF = oi.getForwardAxis();
		stickR = oi.getRightAxis();
		gyroAngle = oi.getGyroAngle();
		tareAngle = oi.getSavedAngleFromSavedAngle();
		
		oi.rd.putNumber("Tare Angle: ", tareAngle);
		
    	oi.rd.putString("Drive Mode: ", "Drive Straight");
		//Cook the Joystick inputs depending on whether or not we're going for aboslute direction
		//or robot-reletive direction
		//TODO: does this go here?
		if (oi.getDriveStickButton(RobotMap.absoluteDirectionModeEnable)){
			double newStickF = getForwardMagnitudeFromFieldwise (stickR, stickF, gyroAngle);
			stickR = getRightMagnitudeFromFieldwise (stickR, stickF, gyroAngle);
			stickF = newStickF;
		}
		//temporary drive disable for safe testing
		if (oi.rd.getBoolean("Disable Drive", false) == false){
			//while the yaw-enable button is held down, 
			//yawing the joystick should rotate the bot
			Robot.rooDrivetrain.setLeft((Math.sqrt(Math.abs(tareAngle/180)) * RooMath.getSign(tareAngle)) + stickF);
			Robot.rooDrivetrain.setRight(-(Math.sqrt(Math.abs(tareAngle/180)) * RooMath.getSign(tareAngle)) + stickF);
			oi.rd.putNumber ("giving motors power= ", (Math.sqrt(tareAngle/180)*RooMath.getSign(tareAngle)) + stickF);
			Robot.rooDrivetrain.setStrafe(stickR);
		}
		
		//We really need to get the SmartDashboard into it's officail home, would that be in OI?
		oi.rd.putNumber("Stick F", stickF);
		oi.rd.putNumber("Stick R", stickR);
		oi.rd.putNumber("Stick Yaw", stickYaw);
		oi.rd.putNumber("Gyro", gyroAngle);
	}
}
