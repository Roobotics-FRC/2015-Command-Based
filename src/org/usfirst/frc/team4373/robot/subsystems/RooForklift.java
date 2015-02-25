package org.usfirst.frc.team4373.robot.subsystems;

import org.usfirst.frc.team4373.robot.Robot;
import org.usfirst.frc.team4373.robot.RobotMap;
import org.usfirst.frc.team4373.robot.commands.CommandBase;
import org.usfirst.frc.team4373.robot.commands.RooMoveForklift;
import org.usfirst.frc.team4373.robot.commands.RooIntakeCommand;

import util.RooMath;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class RooForklift extends Subsystem {
	private Talon motorPair;
	private boolean reversed = false;
	public static final int p1=13,p2=2,p3=3,p4=4;
	private static final double deadZone = 0;
	
	public RooForklift() {
		motorPair = new Talon(RobotMap.forkliftMotorPairPort);
	}
	public void moveToPosition(int position) {
		int distanceFromTarget = CommandBase.getOI().getSchmencoderPosition() - position;
		if (Math.abs(distanceFromTarget) > deadZone)
			motorPair.set(-1 * CommandBase.getOI().rd.rooGetNumber("Forklift Up Power", 1) * (RooMath.getSign(distanceFromTarget)));
		else
			motorPair.set(0.0D);
	}
	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new RooMoveForklift());
		
	}
	public void set(double val) {
		motorPair.set(val);
	}
	
	public int getDirection(){
		return (int) RooMath.getSign(motorPair.get());
	}
}