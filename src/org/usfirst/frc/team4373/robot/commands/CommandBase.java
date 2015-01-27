package org.usfirst.frc.team4373.robot.commands;

import org.usfirst.frc.team4373.robot.OI;

import edu.wpi.first.wpilibj.command.Command;

public abstract class CommandBase extends Command {

	static protected OI oi;
	
	public static void init(){
		oi = new OI();
		oi.init();
	}
	
	public static OI getOI (){
		return oi;
	}

}
