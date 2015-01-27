package org.usfirst.frc.team4373.input;

import org.usfirst.frc.team4373.robot.commands.CommandBase;

import edu.wpi.first.wpilibj.Gyro;

public class RooGyroscope extends Gyro {
	// Used to compensate for the fact the Gryo doesn't always start at zero
	private double initAngle;
	private double savedAngle;
	
	public RooGyroscope(int channel) {
		super(channel);
		initAngle = this.getAngle();
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
	
	public void rooSaveAngle (){
		savedAngle = rooGetAngle();
	}
	
	public double rooGetSavedAngle (){
		return savedAngle;
	}
	
	public double rooGetAngleFromSavedAngle (){
		double angle = this.getAngle() - savedAngle;
		angle = angle % ((Math.abs(angle)/angle)*360);
		if (angle < -180)
			return angle + 360;
		if (angle > 180)
			return angle - 360;
		return angle;
	}
	
}
