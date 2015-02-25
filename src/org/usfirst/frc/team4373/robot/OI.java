package org.usfirst.frc.team4373.robot;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.buttons.*;
import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team4373.input.*;
import org.usfirst.frc.team4373.robot.commands.RooDriveFree;
import org.usfirst.frc.team4373.robot.commands.RooDriveLocked;
import org.usfirst.frc.team4373.robot.commands.RooStackTote;
import org.usfirst.frc.team4373.robot.commands.RooSwitchDriveMode;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	//drive stick, aka chipstick, aka stick1 --> contains functionality that the driver themselves will need to wield
	private RooJoystick driveStick;
	//operatorStick, aka stick2 --> for brainy judgement calls like motorpowers and potentially the forklift or wings.
	private RooJoystick operatorStick;
	private RooGyroscope gyro;
	//screw the police i'm not making all of those gets and sets
	public RooDashboard rd;
	private RooSyntheticEncoder schmencoder;
	private DigitalInput frontBumperLimitSwitch, leftWingLimitSwitch, rightWingLimitSwitch;
	
	
	
	private JoystickButton lockRotation;
	private JoystickButton stackTote;
	
	public double getForwardAxis() {
		return driveStick.rooGetY();
	}
	public double getRightAxis() {
		return driveStick.rooGetX();
	}
	public double getYaw(){
		return driveStick.rooGetYaw();
	}
	public boolean getDriveStickButton(int button){
		return driveStick.getRawButton(button);
	}
	public boolean getOperatorButton(int button){
		return operatorStick.getRawButton(button);
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
	public int getSchmencoderPosition(){
		return schmencoder.getPosition();
	}
	public boolean getFrontLimitSwitch() {
		return frontBumperLimitSwitch.get();
	}
	public boolean getLeftWingLimitSwitch() {
		return leftWingLimitSwitch.get();
	}
	public boolean getRightWingLimitSwitch() {
		return rightWingLimitSwitch.get();
	}
	
	
	public OI() {
		driveStick = new RooJoystick(RobotMap.driveStickPort);
		operatorStick = new RooJoystick(RobotMap.operatorStickPort);
		frontBumperLimitSwitch = new DigitalInput(RobotMap.FRONT_BUMBER_PORT);
		leftWingLimitSwitch = new DigitalInput(RobotMap.LEFT_WING_SWITCH_PORT);
		rightWingLimitSwitch = new DigitalInput(RobotMap.RIGHT_WING_SWITCH_PORT);
		rd = new RooDashboard();
		schmencoder = new RooSyntheticEncoder (RobotMap.HallyPort, 99, 0);

	}
	
	
	public void init (){
		//This stuff has to happen ouside the constructor because they reference OI
		lockRotation = new JoystickButton (driveStick, RobotMap.lockRotationButton);
		lockRotation.whenPressed(new RooSwitchDriveMode());
		lockRotation.toggleWhenPressed(new RooDriveLocked());
		gyro = new RooGyroscope(RobotMap.gyroPort);
		stackTote = new JoystickButton (driveStick, RobotMap.StackToteButton);
		stackTote.whenPressed(new RooStackTote());
	}
	//
	public void iterate (){
		schmencoder.iterate();
	}
	public void resetSchmencoder() {
		schmencoder.reset();
		
	}
	
	public void resetGyro (){
		gyro.reset();
	}
	public double getOperatorThrottle() {
		double value = operatorStick.getRawAxis(2);
		//converts from {-1,1} to {1,0}
		value =  (1 - ((value + 1)/2)); 
		return value;
	}
}

