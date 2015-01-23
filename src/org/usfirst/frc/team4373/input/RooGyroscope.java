package org.usfirst.frc.team4373.input;

import edu.wpi.first.wpilibj.Gyro;

public class RooGyroscope extends Gyro {

	public RooGyroscope(int channel) {
		super(channel);
		// TODO Auto-generated constructor stub
	}
	
	public double rooGet (){
		return this.getAngle() % 360;
	}
	
	
}
