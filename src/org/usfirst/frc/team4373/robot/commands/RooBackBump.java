package org.usfirst.frc.team4373.robot.commands;

import org.usfirst.frc.team4373.robot.OI;
import org.usfirst.frc.team4373.robot.Robot;

public class RooBackBump extends CommandBase {
	
	protected OI oi;
	private int iterations;
	
	public RooBackBump() {
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
		if (iterations < oi.rd.rooGetNumber("Tank Backwards Duration", 10)) {
			Robot.rooDrivetrain.setTank(oi.rd.rooGetNumber("Tank Bump Power", 0.5));
			++iterations;
		}
		else if (iterations < oi.rd.rooGetNumber("Tank Bump Duration", 30)+oi.rd.rooGetNumber("Tank Backwards Duration", 10)) {
			Robot.rooDrivetrain.setTank(oi.rd.rooGetNumber("Tank Bump Power", 0.5));
			++iterations;
		}
		else{
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
