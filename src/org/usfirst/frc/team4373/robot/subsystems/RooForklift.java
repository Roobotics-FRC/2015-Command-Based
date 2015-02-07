package org.usfirst.frc.team4373.robot.subsystems;

import org.usfirst.frc.team4373.robot.Robot;
import org.usfirst.frc.team4373.robot.RobotMap;
import org.usfirst.frc.team4373.robot.commands.CommandBase;
import org.usfirst.frc.team4373.robot.commands.MoveForklift;
import org.usfirst.frc.team4373.robot.commands.RooIntakeCommand;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class RooForklift extends Subsystem {
	private Talon motorPair;
	private boolean reversed = false;
	public static final double p1=1,p2=2,p3=3,p4=4;
	private static final double deadZone = 1;
	private static final double power = 0.5;
	
	public RooForklift() {
		motorPair = new Talon(RobotMap.forkliftMotorPairPort);
	}
	public void moveToPosition(int position) {
		int distanceFromTarget = CommandBase.getOI().getSchmencoderPosition() - position;
		while (Math.abs(distanceFromTarget) > deadZone)
			motorPair.set(power * -1 * (Math.abs(distanceFromTarget)/distanceFromTarget));
		motorPair.set(0.0D);
	}
	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new MoveForklift());
		
	}
	
	public int getDirection(){
		return (int) motorPair.get();
	}
}
