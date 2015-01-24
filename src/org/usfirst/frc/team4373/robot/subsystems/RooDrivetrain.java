package org.usfirst.frc.team4373.robot.subsystems;

import org.usfirst.frc.team4373.robot.Robot;
import org.usfirst.frc.team4373.robot.RobotMap;
import org.usfirst.frc.team4373.robot.commands.*;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class RooDrivetrain extends Subsystem {
	Talon strafe;
	Talon left;
	Talon right;
	public RooDrivetrain(){
		super();
		strafe = new Talon (RobotMap.strafeMotorPort);
		left = new Talon (RobotMap.leftMotorPort);
		right = new Talon (RobotMap.rightMotorPort);
	}
	
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		setDefaultCommand(new RooDriveLocked());

	}
	
	public void setLeft (double foo){
		left.set(-1 * foo);
	}
	
	public void setRight (double foo){
		right.set(foo);
	}
	
	public void setTank (double foo){
		setLeft (foo);
		setRight (foo);
	}
	public void setStrafe(double foo) {
		strafe.set(foo);
	}
	public void stop (){
		setTank (0);
		setStrafe (0);
	}
	

}
