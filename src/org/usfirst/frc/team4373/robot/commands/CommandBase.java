package org.usfirst.frc.team4373.robot.commands;

import org.usfirst.frc.team4373.robot.OI;

import edu.wpi.first.wpilibj.command.Command;

public abstract class CommandBase extends Command {

	static OI oi;
	static RooDrive rooDrive;
	
	public static void init(){
		oi = new OI();
		rooDrive = new RooDrive ();
	}
	
	public static OI getOI (){
		return oi;
	}
	
	public static RooDrive getRooDrive (){
		return rooDrive;
	}

}
