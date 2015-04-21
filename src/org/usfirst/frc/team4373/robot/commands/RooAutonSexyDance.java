//package org.usfirst.frc.team4373.robot.commands;
//
//import org.usfirst.frc.team4373.robot.Robot;
//
//public class RooAutonSexyDance extends RooAutonBase {
//	int i=0;
//	@Override
//	public void execute() {
//		Robot.rooDrivetrain.setLeft(0.7);
//		Robot.rooDrivetrain.setRight(-0.7);
//		if (i>20)
//			i=0;
//		++i;
//		if (i>8)
//			Robot.rooForkLift.set(1.0);
//		else
//			Robot.rooForkLift.set(-1.0);
//	}
//	@Override
//	public void end() {
//		Robot.rooForkLift.set(0.0);
//		Robot.rooDrivetrain.setTank(0.0);
//		super.end();
//	}
//}
