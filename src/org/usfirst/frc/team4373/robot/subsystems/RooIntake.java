package org.usfirst.frc.team4373.robot.subsystems;

import org.usfirst.frc.team4373.robot.RobotMap;
import org.usfirst.frc.team4373.robot.commands.RooIntakeCommand;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class RooIntake extends Subsystem {

	Talon intakeWheels;
	
	public static double IN = -1;
	public static double OUT = 1;
	public static double OFF = 0;
	
	public RooIntake (){
		intakeWheels = new Talon (RobotMap.IntakeMotorPort);
	}
	
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		setDefaultCommand(new RooIntakeCommand());

	}
	
	public void set (double foo){
		intakeWheels.set(foo);
	}
	
	
	

}
