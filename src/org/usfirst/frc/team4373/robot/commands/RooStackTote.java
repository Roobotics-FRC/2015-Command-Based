package org.usfirst.frc.team4373.robot.commands;

import org.usfirst.frc.team4373.robot.OI;
import org.usfirst.frc.team4373.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class RooStackTote extends CommandBase {

	OI oi;
	
	public RooStackTote(){
		requires(Robot.rooForkLift);
		oi = CommandBase.getOI();
	}
	@Override
	protected void initialize() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void execute() {
		// TODO Auto-generated method stub
		int ToteTallness = (int) oi.rd.rooGetNumber("Hally Ticks per Tote", 3);
		int baseline = oi.getSchmencoderPosition();
		int target = baseline - ToteTallness;
		while (oi.getSchmencoderPosition() > target){
			CommandBase.getOI().iterate();
			Robot.rooForkLift.set(-1 * CommandBase.getOI().rd.rooGetNumber("Forklift Dn Power", 0.3));
		}
		while (oi.getSchmencoderPosition() < baseline){
			CommandBase.getOI().iterate();
			Robot.rooForkLift.set(CommandBase.getOI().rd.rooGetNumber("Forklift Up Power", 0.3));
		}
		Robot.rooForkLift.set (0.0);
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
