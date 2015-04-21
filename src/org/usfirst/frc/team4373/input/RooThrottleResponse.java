package org.usfirst.frc.team4373.input;

import util.RooMath;

/**
 * 
 * @author RJA
 *
 */
public class RooThrottleResponse {
	private final double D0 = 0.0, T0 = 0.0, D1 = 0.5, T1 = 0.6, D2 = 0.8, T2 = 0.9, D3 = 1.0, T3 = 1.0;
	private double M01 = 0.0, B01 = 0.0, M12 = 0.0, B12 = 0.0, M23 = 0.0, B23 = 0.0;
	public RooThrottleResponse() {
		// Piece 1
		M01 = (T1 - T0) / (D1 - D0);
		B01 = (T1 - (M01 * D1));
		// Piece 2
		M12 = (T2 - T1) / (D2 - D1);
		B12 = (T2 - (M12 * D2));
		// Piece 3
		M23 = (T3 - T2) / (D3 - D2);
		B23 = (T3 - (M23 * D3));
	}
	public double getThrottle(double joystickInput) {
		int sign = RooMath.getSign(joystickInput);
		joystickInput = Math.abs(joystickInput);
		double throttle = 0.0;
		// If within domain of piece 1
		if ((joystickInput >= D0) && (joystickInput < D1))
			throttle = (M01 * joystickInput) + B01;
		// If within domain of piece 2
		else if ((joystickInput >= D1) && (joystickInput < D2))
			throttle = (M12 * joystickInput) + B12;
		// If within domain of piece 3
		else if ((joystickInput >= D2) && (joystickInput <= D3))
			throttle = (M23 * joystickInput) + B23;
		// This most certainly should NOT happen... ever... if this happens we have a problem
		else
			throw new IllegalArgumentException("Range must be -1.0 to 1.0");
		return throttle * sign;
	}
}
