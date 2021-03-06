package org.usfirst.frc.team4373.robot.commands;

import org.usfirst.frc.team4373.robot.*;

import util.RooMath;
import edu.wpi.first.wpilibj.command.Command;


public abstract class RooDrive extends CommandBase {
	
	//theoretical speed ratio between tank weels and strafe wheels, subject to experimental confirmation
	protected static final double TANK_STRAFE_SPEED_RATIO = 1.5088757396; // Dorian: sig figs you lose 3 points
	
	protected double stickF;
	protected double stickR;
	protected double stickYaw;
	protected double gyroAngle;
	protected OI oi;
	
	public RooDrive() {
		requires (Robot.rooDrivetrain);
		oi = CommandBase.getOI();
	}
	
	@Override
	protected void initialize() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void execute() {
		
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
	
	protected  double tankPowerFromAxes (double forwardAxis, double rightAxis){
		//at full forewards power, I think the shape we're looking for in terms of variation with the right axis
		//is a semi-elipse following the equation y=.509sqrt(1-xx) + 1
		//this function will take that result and multiply it by percentage foreward power in an attempt
		double motorPower;
		motorPower = 1 - Math.pow(rightAxis, 2);
		motorPower = (TANK_STRAFE_SPEED_RATIO-1) * Math.sqrt(motorPower);
		motorPower += 1;
		
		//here we multiply be the forward power so that we can go not full steam ahead
		motorPower *= forwardAxis;
		
		//now to get it back under 1
		motorPower /= TANK_STRAFE_SPEED_RATIO;
		return motorPower;
	}
	
	protected static double getForwardMagnitudeFromFieldwise (double x1, double y1, double gyroAngle){
		//Cici is a genius and made these
		//takes joystick axes and the angle the robot is at,
		//returns joystick output as if we were point the joysick in a way to get the bot
		//to drive in the direction we are pointing the legit joystick in
		double z1 = Math.sqrt((x1 * x1) + (y1 * y1));
		double b = Math.atan(y1/x1);
		gyroAngle = (gyroAngle * Math.PI)/180;
		double c = b+gyroAngle;
		double y2 = Math.sin(c) * z1;
		if (Math.abs(y2) < .001){
			y2 = 0;
		}
		return y2 * RooMath.getSign(y1);
	}
	
	protected static double getRightMagnitudeFromFieldwise (double x1, double y1, double gyroAngle){
		double z1 = Math.sqrt((x1 * x1) + (y1 * y1));
		double b = Math.atan(y1/x1);
		gyroAngle = (gyroAngle * Math.PI)/180;
		double c = b + gyroAngle;
		double x2 = Math.cos(c) * z1;
		if (Math.abs(x2) < .001){
			x2 = 0;
		}
		return x2 * RooMath.getSign(x1);
	}

}
