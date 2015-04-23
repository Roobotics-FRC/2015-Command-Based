
package org.usfirst.frc.team4373.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;





import org.usfirst.frc.team4373.input.RooCamera;
import org.usfirst.frc.team4373.robot.commands.*;
import org.usfirst.frc.team4373.robot.subsystems.*;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
	private static String exceptionString = "";

	public static RooDrivetrain rooDrivetrain = new RooDrivetrain();
	public static RooForklift rooForkLift = new RooForklift();
	public static RooIntake rooIntake = new RooIntake ();
	public static RooCanBurgler rooCanBurgler = new RooCanBurgler();
//	public static RooWings wings = new RooWings ();
	public static RooCamera rooCamera;
    RooAutonBase autonomousCommand;

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
    	
        // instantiate the command used for the autonomous period jri
    	CommandBase.init();
//    	CommandBase.getOI().rd.putBoolean("mason sucks", true);
//    	rooCamera = new RooCamera("cam2");
//    	rooCamera.start();
    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
		CommandBase.getOI().iterate();
//		if (CommandBase.getOI().getOperatorButton(6))
//			new RooSexyAnimals().start();
//		CommandBase.getOI().rd.putBoolean("Forklift limit switch: ", CommandBase.getOI().getForkLiftBottomLimitSwitch());
	}

    public void autonomousInit() {
//    	rooCamera = new RooCamera();
//    	rooCamera.start();
        // schedule the autonomous command (example)
    	try{
    		
    	int mode = (int)CommandBase.getOI().rd.rooGetNumber("Auton mode: ", 3);
    	switch(mode) {
    	case 1:
    		autonomousCommand = new RooAutonGrabBinDriveBack();
    		break;
    	case 2:
    		autonomousCommand = new RooAutonGrabBinDriveRight();
    		break;
    	default:
    		autonomousCommand = new RooAutonMid();
    	}
        	if (autonomousCommand instanceof RooAutonBase) autonomousCommand.start();
    	}catch (Exception e){
//    		this.exceptionString += "\n" + e.getMessage();
    		e.printStackTrace();
    	}
        
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
    	try{
    		Scheduler.getInstance().run();
    		CommandBase.getOI().iterate();
    	}catch (Exception e){
    		e.printStackTrace();
    	}
    }

    public void teleopInit() {
//    	rooCamera = new RooCamera();
//    	rooCamera.start();
		// This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
    	CommandBase.getOI().resetGyro();
        if (autonomousCommand != null) autonomousCommand.cancel();
    }
    public boolean getEnabled() {
    	return this.isEnabled();
    }
    /**
     * This function is called when the disabled button is hit.
     * You can use it to reset subsystems before shutting down.
     */
    public void disabledInit(){
//    	rooCamera.c_stop();
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
//    	rooCamera.drawImage();
    	try{
    		Scheduler.getInstance().run();
    		CommandBase.getOI().iterate();
    	}catch (Exception e){
    		e.printStackTrace();
    	}
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
}
