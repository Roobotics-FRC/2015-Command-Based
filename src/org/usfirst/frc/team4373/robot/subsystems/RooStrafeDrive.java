package org.usfirst.frc.team4373.robot.subsystems;

import org.usfirst.frc.team4373.robot.Robot;
import org.usfirst.frc.team4373.robot.RobotMap;
import org.usfirst.frc.team4373.robot.commands.RooDrive;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class RooStrafeDrive extends Subsystem {
	
	Talon strafe;
	
	public RooStrafeDrive (){
		super();
		strafe = new Talon (RobotMap.strafeMotorPort);
	}
	
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		setDefaultCommand(Robot.rooDrive);

	}
	
	public void set (double foo){
		strafe.set(foo);
	}

}
