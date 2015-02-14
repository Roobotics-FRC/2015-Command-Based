package org.usfirst.frc.team4373.robot.subsystems;

import org.usfirst.frc.team4373.robot.RobotMap;
import org.usfirst.frc.team4373.robot.commands.RooMoveWings;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

public class RooWings extends Subsystem {

	Victor leftWing; //Commies
	Victor rightWing; //Fascists
	
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		setDefaultCommand(new RooMoveWings ());

	}
	
	public RooWings (){
		leftWing = new Victor (RobotMap.leftWingMotorPort);
		rightWing = new Victor (RobotMap.rightWingMotorPort);
	}
	
	public void setLeft (double speed){
		leftWing.set(speed);
	}
	
	public void setRight (double speed){
		rightWing.set(speed);
	}
	
	

}
