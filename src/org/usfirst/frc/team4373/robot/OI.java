package org.usfirst.frc.team4373.robot;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.buttons.*;
import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team4373.input.*;
import org.usfirst.frc.team4373.robot.commands.RooBackBump;
import org.usfirst.frc.team4373.robot.commands.RooDriveFree;
import org.usfirst.frc.team4373.robot.commands.RooDriveLocked;
import org.usfirst.frc.team4373.robot.commands.RooFwBump;
import org.usfirst.frc.team4373.robot.commands.RooLeftBump;
import org.usfirst.frc.team4373.robot.commands.RooRightBump;
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
//	private USBCamera camera;
	private RooSyntheticEncoder schmencoder;
	private DigitalInput frontBumperLimitSwitch, leftCanBurglerLimitSwitch, rightCanBurglerLimitSwitch, forkLiftBottomSwitch;
	
	private Button bumpRight;
	private Button bumpBack;
	private Button bumpFw;
	private Button bumpLeft;
	
	private JoystickButton lockRotation;
	private JoystickButton stackTote;
	
	public OI() {
		driveStick = new RooJoystick(RobotMap.driveStickPort);
		operatorStick = new RooJoystick(RobotMap.operatorStickPort);
		frontBumperLimitSwitch = new DigitalInput(RobotMap.FRONT_BUMBER_PORT);
		leftCanBurglerLimitSwitch = new DigitalInput(RobotMap.LEFT_WING_SWITCH_PORT);
		rightCanBurglerLimitSwitch = new DigitalInput(RobotMap.RIGHT_WING_SWITCH_PORT);
		forkLiftBottomSwitch = new DigitalInput(RobotMap.FL_BOTTOM_SWITCH_PORT);
		rd = new RooDashboard();
		schmencoder = new RooSyntheticEncoder (RobotMap.HallyPort, 99, 0);

	}
	
	
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
	public boolean getLeftCanBurglerLimitSwitch() {
		return leftCanBurglerLimitSwitch.get();
	}
	public boolean getRightCanBurglerLimitSwitch() {
		return rightCanBurglerLimitSwitch.get();
	} 
	public boolean getForkLiftBottomLimitSwitch(){
		return forkLiftBottomSwitch.get();
	}
	
	
	
	
	
	public void init (){
		//This stuff has to happen outside the constructor because they reference OI
		lockRotation = new JoystickButton (driveStick, RobotMap.lockRotationButton[RobotMap.chipsDickType]);
		lockRotation.whenPressed(new RooSwitchDriveMode());
		lockRotation.toggleWhenPressed(new RooDriveLocked());
		gyro = new RooGyroscope(RobotMap.gyroPort);
		stackTote = new JoystickButton (driveStick, RobotMap.StackToteButton[RobotMap.chipsDickType]);
		stackTote.whenPressed(new RooStackTote());
		bumpRight = new JoystickButton (operatorStick, RobotMap.BumpRight);
		bumpRight.whenPressed(new RooRightBump ());
		bumpLeft = new JoystickButton (operatorStick, RobotMap.BumpLeft);
		bumpLeft.whenPressed(new RooLeftBump ());
		bumpBack = new JoystickButton (operatorStick, RobotMap.BumpBack);
		bumpBack.whenPressed(new RooBackBump ());
		bumpFw = new JoystickButton (operatorStick, RobotMap.BumpFw);
		bumpFw.whenPressed(new RooFwBump ());
		
		
	}
	//
	public void iterate (){
		schmencoder.iterate();
		rd.putBoolean("Forklift limit switch: ", this.getForkLiftBottomLimitSwitch());
		rd.putBoolean("Left wing limit switch: ", this.getLeftCanBurglerLimitSwitch());
		rd.putNumber("Yaw", getYaw());
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
	public double getOperatorLeftBinGrabber() {
		if (operatorStick.getRawButton(RobotMap.LEFT_CANBURGLER_FORWARDS))
			return 1.0D;
		else if (operatorStick.getRawButton(RobotMap.LEFT_CANBURGLER_FORWARDS))
			return -1.0D;
		return 0.0D;
	}
	public double getOperatorRightBinGrabber() {
		if (operatorStick.getRawButton(RobotMap.RIGHT_CANBURGLER_FORWARDS))
			return 1.0D;
		else if (operatorStick.getRawButton(RobotMap.RIGHT_CANBURGLER_BACKWARDS))
			return -1.0D;
		return 0.0D;
	}
}

