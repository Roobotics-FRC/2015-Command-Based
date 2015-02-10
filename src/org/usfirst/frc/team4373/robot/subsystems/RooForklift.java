package org.usfirst.frc.team4373.robot.subsystems;

import org.usfirst.frc.team4373.robot.Robot;
import org.usfirst.frc.team4373.robot.RobotMap;
import org.usfirst.frc.team4373.robot.commands.CommandBase;
import org.usfirst.frc.team4373.robot.commands.MoveForklift;
import org.usfirst.frc.team4373.robot.commands.RooIntakeCommand;

import util.RooMath;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class RooForklift extends Subsystem {
	private Talon motorPair;
	private boolean reversed = false;
	public static final int p1=1,p2=2,p3=3,p4=4;
	private static final double deadZone = 1;
	private static final double power = 0.5;
	
	public RooForklift() {
		motorPair = new Talon(RobotMap.forkliftMotorPairPort);
	}
	public void moveToPosition(int position) {
		int distanceFromTarget = CommandBase.getOI().getSchmencoderPosition() - position;
		if (Math.abs(distanceFromTarget) > deadZone) {
			CommandBase.getOI().rd.putNumber("Joystick move to position power: ", power * -1 * (RooMath.getSign(distanceFromTarget)));
			motorPair.set(power * -1 * (RooMath.getSign(distanceFromTarget)));
		}
		else {
			CommandBase.getOI().rd.putNumber("Joystick move to position power: ", 0.0D);
			motorPair.set(0.0D);
		}
			
	}
	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new MoveForklift());
		
	}
	public void set(double val) {
		motorPair.set(val);
	}
	
	public int getDirection(){
		return (int) motorPair.get();
	}
}
