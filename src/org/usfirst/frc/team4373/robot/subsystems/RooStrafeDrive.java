package org.usfirst.frc.team4373.robot.subsystems;

import org.usfirst.frc.team4373.robot.RobotMap;

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

	}
	
	public void set (double foo){
		strafe.set(foo);
	}

}
