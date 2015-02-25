package org.usfirst.frc.team4373.robot.subsystems;

import org.usfirst.frc.team4373.robot.OI;
import org.usfirst.frc.team4373.robot.RobotMap;
import org.usfirst.frc.team4373.robot.commands.CommandBase;
import org.usfirst.frc.team4373.robot.commands.RooMoveWings;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

public class RooWings extends Subsystem {

	Victor leftWing; //Commies
	Victor rightWing; //Fascists
	private OI oi;

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		setDefaultCommand(new RooMoveWings ());

	}

	public RooWings (){
		oi = CommandBase.getOI();
		leftWing = new Victor (RobotMap.leftWingMotorPort);
		rightWing = new Victor (RobotMap.rightWingMotorPort);
	}

	public void setLeft (double speed){
		leftWing.set(oi.rd.rooGetBoolean("reverse left wing", false) ? - speed : speed);
	}

	public void setRight (double speed){
		rightWing.set(oi.rd.rooGetBoolean("reverse right wing", false) ? -speed : speed);
	}

	public boolean moveLeftUntilSwitch() {
		if(oi.getLeftWingLimitSwitch()) {
			setLeft(1);
			return false;
		}
		setLeft(0);
		return true;
	}

	public boolean moveRightUntilSwitch() {
		if(oi.getRightWingLimitSwitch()) {
			setRight(1);
			return false;
		}
		setRight(0);
		return true;
	}

	
	

}
