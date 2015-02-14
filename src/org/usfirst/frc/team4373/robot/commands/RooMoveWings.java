package org.usfirst.frc.team4373.robot.commands;

import org.usfirst.frc.team4373.robot.OI;
import org.usfirst.frc.team4373.robot.Robot;
import org.usfirst.frc.team4373.robot.RobotMap;

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
		if (oi.getOperatorButton(RobotMap.liftLeftWing))
			Robot.wings.setLeft(power);
		else if (oi.getOperatorButton(RobotMap.lowerLeftWing))
			Robot.wings.setLeft(-power);
		else
			Robot.wings.setLeft(0.0D);
		
		if (oi.getOperatorButton(RobotMap.liftRightWing))
			Robot.wings.setRight(power);
		else if (oi.getOperatorButton(RobotMap.lowerRightWing))
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
