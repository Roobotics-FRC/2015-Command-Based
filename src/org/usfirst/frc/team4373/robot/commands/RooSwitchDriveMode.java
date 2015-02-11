package org.usfirst.frc.team4373.robot.commands;

import org.usfirst.frc.team4373.robot.OI;

import edu.wpi.first.wpilibj.command.Command;

public class RooSwitchDriveMode extends CommandBase {

	protected OI oi;
	
	public RooSwitchDriveMode (){
		oi = CommandBase.getOI();
	}
	
	@Override
	protected void initialize() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void execute() {
		// TODO Auto-generated method stub
		oi.saveGyroAngle();
		oi.rd.putNumber("Debug String: (current angle)", oi.getGyroAngle());
		cancel();
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
