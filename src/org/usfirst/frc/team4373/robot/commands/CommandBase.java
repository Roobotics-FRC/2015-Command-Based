package org.usfirst.frc.team4373.robot.commands;

import org.usfirst.frc.team4373.robot.OI;

import edu.wpi.first.wpilibj.command.Command;

public class CommandBase extends Command {

	static OI oi = new OI ();
	static RooDrive rooDrive = new RooDrive ();
	
	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
		
	}
	

	@Override
	protected void execute() {
		// TODO Auto-generated method stub

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
	
	public static OI getOI (){
		return oi;
	}
	
	public static RooDrive getRooDrive (){
		return rooDrive;
	}

}
