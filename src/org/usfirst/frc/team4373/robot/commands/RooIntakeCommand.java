package org.usfirst.frc.team4373.robot.commands;

import org.usfirst.frc.team4373.robot.Robot;
import org.usfirst.frc.team4373.robot.RobotMap;
import org.usfirst.frc.team4373.robot.subsystems.RooIntake;

public class RooIntakeCommand extends CommandBase {

	public RooIntakeCommand (){
		super();
		requires (Robot.rooIntake);
	}
	
	@Override
	protected void initialize() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void execute() {
		// TODO Auto-generated method stub
		if (oi.getButton(RobotMap.intakeButton)){
			Robot.rooIntake.set(RooIntake.IN);
		}else if (oi.getButton(3)){
			Robot.rooIntake.set(RooIntake.OUT);
		}else{
			Robot.rooIntake.set(RooIntake.OFF);
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
