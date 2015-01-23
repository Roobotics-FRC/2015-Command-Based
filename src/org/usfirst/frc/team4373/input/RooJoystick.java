package org.usfirst.frc.team4373.input;

import org.usfirst.frc.team4373.robot.RobotMap;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class RooJoystick extends Joystick {
	private double xThreshold, yThreshold = 0.1;
	
	public RooJoystick(int port) {
		super(port);
		SmartDashboard.putNumber("X threshold", xThreshold);
		SmartDashboard.putNumber("Y threshold", yThreshold);
	}
	
	public double getXThreshold() {
		return xThreshold;
	}
	public void setXThreshold(double threshold) {
		xThreshold = threshold;
		SmartDashboard.putNumber("X threshold", xThreshold);
	}
	public double getYThreshold() {
		return yThreshold;
	}
	public void setYThreshold(double threshold) {
		yThreshold = threshold;
		SmartDashboard.putNumber("Y threshold", yThreshold);
	}
	
	public double rooGetX() {
		double axis = this.getRawAxis(0);
		if (axis > xThreshold) {
			return axis;
		}
		return 0;
	}
	
	public double rooGetY() {
		double axis = this.getRawAxis(1);
		if (axis > yThreshold) {
			return axis;
		}
		return 0;
	}
	
	public double getHypotenuse() {
		double xAxis = this.rooGetX();
		double yAxis = this.rooGetY();
		double squares = Math.pow(xAxis, 2) + Math.pow(yAxis, 2);
		return Math.sqrt(squares);
	}
	
	public double getAngle() {
		double xAxis = this.rooGetX();
		double yAxis = this.rooGetY();
		return Math.atan(yAxis / xAxis);
	}
	
}
