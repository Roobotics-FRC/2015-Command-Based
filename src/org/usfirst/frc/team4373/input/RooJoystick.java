package org.usfirst.frc.team4373.input;

import org.usfirst.frc.team4373.robot.RobotMap;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class RooJoystick extends Joystick {
	private double xThreshold, yThreshold, yawThreshold = 0.1;
	
	public RooJoystick(int port) {
		super(port);
	}
	
	public double getXThreshold() {
		return xThreshold;
	}
	public void setXThreshold(double threshold) {
		xThreshold = threshold;
	}
	public double getYThreshold() {
		return yThreshold;
	}
	public void setYThreshold(double threshold) {
		yThreshold = threshold;
	}
	public double getYawThreshold(){
		return yawThreshold;
	}
	public void setYawThreshold(double threshold){
		yawThreshold = threshold;
	}
	
	public double rooGetX() {
		double axis = this.getRawAxis(0);
		if (Math.abs(axis) > xThreshold) {
			return Math.pow(axis,3);
		}
		return 0;
	}
	
	public double rooGetY() {
		double axis = this.getRawAxis(1);
		if (Math.abs(axis) > yThreshold) {
			return Math.pow(axis,3);
		}
		return 0;
	}
	
	public double rooGetYaw(){
		double axis = this.getRawAxis(RobotMap.yawAxis[RobotMap.chipsDickType]);
		if(Math.abs(axis) >yawThreshold){
			return axis * 0.5;
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
	
//	public boolean needsCalibration() {
//		double xA
//	}
	
	
}
