package org.usfirst.frc.team4373.robot.commands;

import org.usfirst.frc.team4373.robot.OI;
import org.usfirst.frc.team4373.robot.Robot;

public class RooMoveBinGrabbers extends CommandBase{

	protected OI oi;
	
	@Override
	protected void initialize() {
		oi = CommandBase.getOI();
		
	}

	@Override
	protected void execute() {
		Robot.rooCanBurgler.setLeft(oi.getOperatorLeftBinGrabber());
		Robot.rooCanBurgler.setRight(oi.getOperatorRightBinGrabber());
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
