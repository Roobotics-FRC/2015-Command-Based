package org.usfirst.frc.team4373.robot.commands;

import org.usfirst.frc.team4373.robot.OI;
import org.usfirst.frc.team4373.robot.Robot;
import org.usfirst.frc.team4373.robot.RobotMap;
import org.usfirst.frc.team4373.robot.subsystems.RooForklift;

public class MoveForklift extends CommandBase {
	private OI oi;
	int lockPosition;
	
	public MoveForklift() {
		requires(Robot.rooForkLift);
		oi = CommandBase.getOI();
		lockPosition = RobotMap.ForkliftStartingPosition;
	}

	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
		
	}
	@Override
	protected void execute() {
		if (oi.getOperatorButton(RobotMap.FORKLIFT_P1)) { // Or something
			lockPosition = RooForklift.p1;
		}
		else if (oi.getOperatorButton(3)) {
			Robot.rooForkLift.set(CommandBase.getOI().rd.rooGetNumber("Forklift Up Power", 0.3));
			lockPosition = oi.getSchmencoderPosition();
		}
		else if (oi.getOperatorButton(2)) {
			Robot.rooForkLift.set(-0.2D);
			lockPosition = oi.getSchmencoderPosition();
		}
		else
			Robot.rooForkLift.moveToPosition(lockPosition);
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
