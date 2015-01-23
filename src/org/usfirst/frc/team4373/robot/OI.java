package org.usfirst.frc.team4373.robot;

import edu.wpi.first.wpilibj.buttons.Button;

import org.usfirst.frc.team4373.input.RooJoystick;
import org.usfirst.frc.team4373.robot.commands.ExampleCommand;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	private RooJoystick stick;
	
	public double getForwardAxis() {
		return stick.rooGetY();
	}
	public double getRightAxis() {
		return stick.rooGetX();
	}
	
	public OI() {
		stick = new RooJoystick(RobotMap.joystickPort);
	}
}

