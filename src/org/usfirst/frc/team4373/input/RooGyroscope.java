package org.usfirst.frc.team4373.input;

import edu.wpi.first.wpilibj.Gyro;

public class RooGyroscope extends Gyro {
	// Used to compensate for the fact the Gryo doesn't always start at zero
	private double initAngle;
	public RooGyroscope(int channel) {
		super(channel);
		initAngle = this.getAngle();
	}
	
	public double rooGetAngle () {
		double angle = this.getAngle()-initAngle;
		angle = angle % (Math.abs(angle)/angle)*360;
		if (angle < -180)
			return angle + 360;
		if (angle > 180)
			return angle - 360;
		return angle;
	}
	
	
}
