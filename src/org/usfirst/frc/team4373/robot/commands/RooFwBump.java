package org.usfirst.frc.team4373.robot.commands;

import org.usfirst.frc.team4373.robot.OI;
import org.usfirst.frc.team4373.robot.Robot;

public class RooFwBump extends CommandBase {
	
	protected OI oi;
	private int iterations;
	
	public RooFwBump() {
		requires (Robot.rooDrivetrain);
		oi = CommandBase.getOI();
	}
	
	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
		iterations = 0;
	}

	@Override
	protected void execute() {
		// TODO Auto-generated method stub
		if (iterations < oi.rd.rooGetNumber("Tank Bump Duration", 30)){
			Robot.rooDrivetrain.setTank(-1 * oi.rd.rooGetNumber("Tank Bump Power", 0.5));
			++iterations;
		}else{
			iterations = 0;
			Robot.rooDrivetrain.setStrafe(0);
			cancel();
		}

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
