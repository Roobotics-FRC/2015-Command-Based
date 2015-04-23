package org.usfirst.frc.team4373.robot.subsystems;

import org.usfirst.frc.team4373.robot.OI;
import org.usfirst.frc.team4373.robot.RobotMap;
import org.usfirst.frc.team4373.robot.commands.CommandBase;
import org.usfirst.frc.team4373.robot.commands.RooAutonCanBurgler;


import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

public class RooCanBurgler extends Subsystem {

	Victor left;
	Victor right;
	private OI oi;

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		setDefaultCommand(new RooAutonCanBurgler());

	}

	public RooCanBurgler () {
		oi = CommandBase.getOI();
		left = new Victor(RobotMap.leftCanBurglerPort);
		right = new Victor(RobotMap.rightCanBurglerPort);
	}

	public void setLeft (double speed){
		left.set(/*oi.rd.rooGetBoolean("reverse left wing", false) ? - speed : */speed);
	}

	public void setRight (double speed){
		right.set(/*oi.rd.rooGetBoolean("reverse right wing", false) ? -speed : */speed);
	}

	public void setBoth(double speed) {
		setLeft(speed);
		setRight(speed);
	}
	
	public boolean moveLeftUntilSwitch() {
		if(!oi.getLeftCanBurglerLimitSwitch()) {
			setLeft(1);
			return false;
		}
		setLeft(0);
		return true;
	}

	public boolean moveRightUntilSwitch() {
		if(!oi.getRightCanBurglerLimitSwitch()) {
			setRight(1);
			return false;
		}
		setRight(0);
		return true;
	}

	
	

}
