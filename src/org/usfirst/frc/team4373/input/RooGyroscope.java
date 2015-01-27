package org.usfirst.frc.team4373.input;

import org.usfirst.frc.team4373.robot.commands.CommandBase;

import edu.wpi.first.wpilibj.Gyro;

public class RooGyroscope extends Gyro {

	public RooGyroscope(int channel) {
		super(channel);
		// TODO Auto-generated constructor stub
	}
	
	public double rooGetAngle () {
		CommandBase.getOI().rd.putNumber("Actual Gyro", this.getAngle());
		double angle = this.getAngle();
		angle = angle % ((Math.abs(angle)/angle)*360);
		if (angle < -180)
			return angle + 360;
		if (angle > 180)
			return angle - 360;
		return angle;
	}
	
	
}
