package org.usfirst.frc.team4373.robot;

import edu.wpi.first.wpilibj.DigitalSource;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // For example to map the left and right motors, you could define the
    // following variables to use with your drivetrain subsystem.
    // public static int leftMotor = 1;
    // public static int rightMotor = 2;
	public static int leftMotorPort = 1;
	public static int rightMotorPort = 0;
	public static int strafeMotorPort = 2;
	public static final int IntakeMotorPort = 3;
	public static final int leftWingMotorPort = 6;
	public static final int forkliftMotorPairPort = 4;
	public static final int rightWingMotorPort = 5;
	public static final int FRONT_BUMBER_PORT = 2;
	public static final int LEFT_WING_SWITCH_PORT = 1;
	public static final int RIGHT_WING_SWITCH_PORT = 0;
	
	public static int yawAxis = 2;
	
	//Chipsdick buttons:
	public static final int lockRotationButton = 1;
	public static int absoluteDirectionModeEnable = 11;
	public static int intakeButton = 2;
	public static final int DriverLiftForkLift = 6;
	public static final int DriverLowerForkLift = 4;
	public static final int StackToteButton = 2;
	
	//OperatorStick buttons:
	public static final int FORKLIFT_P1 = 4;
	public static final int liftLeftWing = 6;
	public static final int lowerLeftWing = 7;
	public static final int liftRightWing = 11;
	public static final int lowerRightWing = 10;
	public static final int OperatorLiftForkLift = 3;
	public static final int OperatorLowerForkLift = 2;
	public static final int ResetForkliftSchmencoder = 1;
	
    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static int rangefinderPort = 1;
    // public static int rangefinderModule = 1;
	
	public static int gyroPort = 1;
	public static double driveMultiplier = .3;
	
	public static final int HallyPort = 3;
	public static final int operatorStickPort = 1;
	public static final int driveStickPort = 0;
	
	//Constants
	public static final int ForkliftStartingPosition = 6;
	
	
	
	
}
