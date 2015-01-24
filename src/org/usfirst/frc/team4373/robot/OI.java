package org.usfirst.frc.team4373.robot;

import edu.wpi.first.wpilibj.buttons.*;

import org.usfirst.frc.team4373.input.*;
import org.usfirst.frc.team4373.robot.commands.ExampleCommand;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	private RooJoystick stick;
	private RooGyroscope gyro;
	//screw the police i'm not making all of those gets and sets
	public RooDashboard rd;
	
	private JoystickButton lockRotation;
	
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
		rd = new RooDashboard();
		
		lockRotation = new JoystickButton (stick, RobotMap.lockRotationButton);
	}
}

