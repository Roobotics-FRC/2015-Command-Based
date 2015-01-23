package org.usfirst.frc.team4373.robot;

import edu.wpi.first.wpilibj.buttons.Button;

import org.usfirst.frc.team4373.input.*;
import org.usfirst.frc.team4373.robot.commands.ExampleCommand;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	private RooJoystick stick;
	private RooGyroscope gyro;
	
	public double getForwardAxis() {
		return stick.rooGetY();
	}
	public double getRightAxis() {
		return stick.rooGetX();
	}
	public double getYaw(){
		return stick.rooGetYaw();
	}
	public boolean getButton(int button){
		return stick.getRawButton(button);
	}
	public double getGyroAngle(){
		return gyro.rooGet();
	}
	
	
	
	public OI() {
		stick = new RooJoystick(RobotMap.joystickPort);
		gyro = new RooGyroscope(RobotMap.gyroPort);
	}
}

