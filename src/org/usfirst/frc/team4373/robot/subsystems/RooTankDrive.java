package org.usfirst.frc.team4373.robot.subsystems;

import org.usfirst.frc.team4373.robot.RobotMap;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class RooTankDrive extends Subsystem {
	
	Talon left;
	Talon right;
	public RooTankDrive(){
		super();
		left = new Talon (RobotMap.leftMotorPort);
		right = new Talon (RobotMap.rightMotorPort);
	}
	
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub

	}
	
	public void setLeft (double foo){
		left.set(foo);
	}
	
	public void setRight (double foo){
		right.set(foo);
	}
	
	public void setBoth (double foo){
		setLeft (foo);
		setRight (foo);
	}
	
	public void stop (){
		setBoth (0);
	}
	

}
