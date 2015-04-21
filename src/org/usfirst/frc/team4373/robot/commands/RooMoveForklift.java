package org.usfirst.frc.team4373.robot.commands;

import org.usfirst.frc.team4373.robot.OI;
import org.usfirst.frc.team4373.robot.Robot;
import org.usfirst.frc.team4373.robot.RobotMap;
import org.usfirst.frc.team4373.robot.subsystems.RooForklift;

public class RooMoveForklift extends CommandBase {
	private OI oi;
	int lockPosition;
	
	public RooMoveForklift() {
		requires(Robot.rooForkLift);
		oi = CommandBase.getOI();
		lockPosition = 0;
	}

	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
		
	}
	@Override
	protected void execute() {
		//CommandBase.getOI().rd.putNumber("Forklift Up Power", CommandBase.getOI().getOperatorThrottle());
		
		if (oi.rd.rooGetBoolean("Reset Schmencoder", false)){
			oi.resetSchmencoder();
			lockPosition = 0;
			Robot.rooForkLift.moveToPosition(lockPosition);
		}
		else if (oi.getDriveStickButton(RobotMap.DriverLiftForkLift[RobotMap.chipsDickType])) {
			Robot.rooForkLift.set(CommandBase.getOI().rd.rooGetNumber("Forklift Up Power", 1));
			lockPosition = oi.getSchmencoderPosition();
		}
		else if (oi.getDriveStickButton(RobotMap.SlowUpButton[RobotMap.chipsDickType])) {
			Robot.rooForkLift.set(CommandBase.getOI().rd.rooGetNumber("Forklift Up Power", 1) * CommandBase.getOI().rd.rooGetNumber("Slow Up Multiplier", .75));
			lockPosition = oi.getSchmencoderPosition();
		}
		else if (oi.getDriveStickButton(RobotMap.DriverLowerForkLift[RobotMap.chipsDickType])) {
			Robot.rooForkLift.set(-1 * CommandBase.getOI().rd.rooGetNumber("Forklift Dn Power", 1));
			lockPosition = oi.getSchmencoderPosition();
		}
		else if (oi.getOperatorButton(RobotMap.OperatorLiftForkLift)) {
			Robot.rooForkLift.set(CommandBase.getOI().rd.rooGetNumber("Forklift Up Power", 1));
			lockPosition = oi.getSchmencoderPosition();
		}
		else if (oi.getOperatorButton(RobotMap.OperatorLowerForkLift)) {
			Robot.rooForkLift.set(-1 * CommandBase.getOI().rd.rooGetNumber("Forklift Dn Power", 1));
			lockPosition = oi.getSchmencoderPosition();
		}
		else{
			Robot.rooForkLift.set(0);
			//Robot.rooForkLift.moveToPosition(lockPosition);
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
