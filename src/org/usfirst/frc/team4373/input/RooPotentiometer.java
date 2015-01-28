package org.usfirst.frc.team4373.input;
import edu.wpi.first.wpilibj.AnalogPotentiometer;
public class RooPotentiometer extends AnalogPotentiometer {

	public RooPotentiometer(int channel) {
		super(channel);
	}
	public double rooGetPosition() {
		return this.get();
	}

}
