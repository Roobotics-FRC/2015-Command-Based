package org.usfirst.frc.team4373.robot;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.buttons.*;
import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team4373.input.*;
import org.usfirst.frc.team4373.robot.commands.ExampleCommand;
import org.usfirst.frc.team4373.robot.commands.RooDriveFree;
import org.usfirst.frc.team4373.robot.commands.RooSwitchDriveMode;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	private RooJoystick stick;
	private RooGyroscope gyro;
	//screw the police i'm not making all of those gets and sets
	public RooDashboard rd;
	private RooEncoder encoder;
	private RooSyntheticEncoder schmencoder;
	
	private DigitalInput hally;
	
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
	
	public boolean getHally (){
		return hally.get();
	}
	
	//Gyro Functions:
	public double getGyroAngle(){
		return gyro.rooGetAngle();
	}
	public void saveGyroAngle(){
		gyro.rooSaveAngle();
	}
	public double getSavedAngleFromSavedAngle(){
		return gyro.rooGetAngleFromSavedAngle();
	}
	public double getEncoderPosition() {
		return encoder.rooGetAngle();
	}
	public int getSchmencoderPosition(){
		return schmencoder.getPosition();
	}
	
	public OI() {
		stick = new RooJoystick(RobotMap.joystickPort);
		gyro = new RooGyroscope(RobotMap.gyroPort);
		rd = new RooDashboard();
		encoder = new RooEncoder(RobotMap.encoderPort1, RobotMap.EncoderPort2);
		hally = new DigitalInput(RobotMap.HallyPort);
		schmencoder = new RooSyntheticEncoder (10, 99, 99);

	}
	
	
	public void init (){
		//This stuff has to happen ouside the constructor because they reference OI
		lockRotation = new JoystickButton (stick, RobotMap.lockRotationButton);
		lockRotation.whenPressed(new RooSwitchDriveMode());
		lockRotation.toggleWhenPressed(new RooDriveFree());
	}
	
	public void iterate (){
		schmencoder.iterate();
	}
}

