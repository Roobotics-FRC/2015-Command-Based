package org.usfirst.frc.team4373.robot.commands;

import org.usfirst.frc.team4373.robot.Robot;

public class RooAutonCanBurgler extends RooAutonBase {
/* Set can burglers forwards 2 sec (full speed)
 * Drivetrain forwards x power y seconds (try for 10 ft.)
 * Canburglers forwards until switch pressed
 */
	
	long startE1 = 0L, startE2 = 0L;
	
	
	public RooAutonCanBurgler() {

	}
	
	@Override
	protected void initialize() {
		startE1 = System.currentTimeMillis();
	}
	
	@Override
	protected void execute() {
		
		boolean event1 = true, event2 = false, event3 = false;
		
		//check event 1 end
		if(System.currentTimeMillis()-startE1>=2000) {
			event1=false;
			event2=true;
			Robot.rooCanBurgler.setBoth(0.0);
			startE2 = System.currentTimeMillis();
		}
		//check event 2 end
		if(System.currentTimeMillis()-startE2>=this.oi.rd.rooGetNumber("DriveTrain Time", 3)) {
			event2=false;
		}
		
		if(event1) {
			Robot.rooCanBurgler.setBoth(1.0);
			
		} else if(event2) {
			Robot.rooDrivetrain.setTank(this.oi.rd.rooGetNumber("DriveTrain Power", 0.65));
		} else if(event3) {
			event3 = !Robot.rooCanBurgler.moveLeftUntilSwitch() && !Robot.rooCanBurgler.moveRightUntilSwitch();
		}
		
		

	}
	
}
