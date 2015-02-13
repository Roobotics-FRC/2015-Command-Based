package org.usfirst.frc.team4373.robot.commands;

import org.usfirst.frc.team4373.robot.OI;

public class RooMoveWings extends CommandBase {
	private OI oi;
	private double power;
	public RooMoveWings() {
		requires(Robot.wings);
		oi = CommandBase.getOI();
		power = 0.5;
	}

	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void execute() {
		power = oi.rd.rooGetNumber("Wing power: ", power);
		if (oi.getDriveStickButton(6))
			Robot.wings.setLeft(power);
		else if (oi.getDriveStickButton(7))
			Robot.wings.setLeft(-power);
		else
			Robot.wings.setLeft(0.0D);
		if (oi.getDriveStickButton(11))
			Robot.wings.setRight(power);
		else if (oi.getDriveStickButton(10))
			Robot.wings.setRight(-power);
		else
			Robot.wings.setRight(0.0D);
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
