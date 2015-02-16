package org.usfirst.frc.team4373.robot.commands;

public class RooAutonRight extends RooAutonBase {

	@Override
	protected void initialize() {
		// TODO Auto-generated method stub

	}

	int i=0;
	@Override
	protected void execute() {
		// TODO Auto-generated method stub
		++i;
		oi.rd.putNumber("Auton is Running:", i * 10);
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
