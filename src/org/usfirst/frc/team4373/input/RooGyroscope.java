package org.usfirst.frc.team4373.input;

import org.usfirst.frc.team4373.robot.commands.CommandBase;

import util.RooMath;
import edu.wpi.first.wpilibj.Gyro;

public class RooGyroscope extends Gyro {
	// Used to compensate for the fact the Gryo doesn't always start at zero
	private double initAngle;
	private double savedAngle;
	
	public RooGyroscope(int channel) {
		super(channel);
		initAngle = this.getAngle();
		rooSaveAngle();
	}
	
	public double rooGetAngle () {
//		CommandBase.getOI().rd.putNumber("Actual Gyro", this.getAngle());
		if (CommandBase.getOI().rd.rooGetBoolean("Reset Gyro", false)){
			reset ();
			return 0;
		}
		double angle = this.getAngle();
		angle = angle % (RooMath.getSign(angle)*360);
		if (angle < -180)
			return angle + 360;
		if (angle > 180)
			return angle - 360;
		return angle;
	}
	
	public void rooSaveAngle (){
		double angle = rooGetAngle();
//		CommandBase.getOI().rd.putNumber("Current saved angle: ", angle);
		savedAngle = angle;
	}
	
	public double rooGetSavedAngle (){
		return savedAngle;
	}
	
	public double rooGetAngleFromSavedAngle (){
		double angle = this.getAngle() - savedAngle;
		angle = angle % (RooMath.getSign(angle)*360);
		if (angle < -180)
			return angle + 360;
		if (angle > 180)
			return angle - 360;
		CommandBase.getOI().rd.putNumber("Saved angle: ", angle);
		return angle;
	}
	
}
