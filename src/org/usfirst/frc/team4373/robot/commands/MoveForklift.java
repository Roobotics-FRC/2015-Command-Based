package org.usfirst.frc.team4373.robot.commands;

import org.usfirst.frc.team4373.robot.OI;
import org.usfirst.frc.team4373.robot.Robot;
import org.usfirst.frc.team4373.robot.RobotMap;
import org.usfirst.frc.team4373.robot.subsystems.RooForklift;

public class MoveForklift extends CommandBase {
	private OI oi;
	public MoveForklift() {
		requires(Robot.rooForkLift);
		oi = CommandBase.getOI();
	}

	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void execute() {
		if (oi.getButton(RobotMap.FORKLIFT_P1)) // Or something
			Robot.rooForkLift.moveToPosition((int)RooForklift.p1);
		
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
