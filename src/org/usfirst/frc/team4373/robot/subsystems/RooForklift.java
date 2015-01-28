package org.usfirst.frc.team4373.robot.subsystems;

import org.usfirst.frc.team4373.robot.Robot;
import org.usfirst.frc.team4373.robot.RobotMap;
import org.usfirst.frc.team4373.robot.commands.CommandBase;

import edu.wpi.first.wpilibj.Talon;

public class RooForklift {
	private Talon motorPair;
	private boolean reversed = false;
	public static final double p1=1,p2=2,p3=3,p4=4;
	private static final double deadZone = 1;
	private static final double power = 0.5;
	public RooForklift() {
		motorPair = new Talon(RobotMap.forkliftMotorPairPort);
	}
	public void moveToPosition(double position) {
		if (Math.abs(CommandBase.getOI().getEncoderPosition() - position) > deadZone) {
			while (CommandBase.getOI().getEncoderPosition() > position)
				motorPair.set(reversed ? power : -power);
			while (CommandBase.getOI().getEncoderPosition() < position)
				motorPair.set(reversed ? -power : power);
		}
		motorPair.set(0.0D);
	}
}
