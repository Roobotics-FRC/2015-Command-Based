package org.usfirst.frc.team4373.input;

import edu.wpi.first.wpilibj.Encoder;

public class RooEncoder extends Encoder {
	public RooEncoder(int channelA, int channelB) {
		super(channelA, channelB);
	}
	
	public boolean rooGetDirection() {
		return this.getDirection();
	}
	
	public double rooGetAngle() {
		return this.getDistance();
	}
	
	public void rooReset() {
		this.reset();
	}
}