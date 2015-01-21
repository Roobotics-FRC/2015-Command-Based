
package org.usfirst.frc.team4373.robot.subsystems;

import org.usfirst.frc.team4373.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Gyro;

/**
 *
 */
public class ExampleSubsystem extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

	private Gyro gyro;
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void initialize () {
    	//please can we find out where this is actually supposed to go
    	gyro = new Gyro (RobotMap.gyroPort);
    }
    
    public double get(){
    	return (gyro.getAngle() % 360);
    }
}

