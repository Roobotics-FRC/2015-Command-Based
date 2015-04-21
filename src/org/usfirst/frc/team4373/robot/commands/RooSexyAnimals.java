package org.usfirst.frc.team4373.robot.commands;
import java.util.Random;

public class RooSexyAnimals extends RooAutonBase {
	private Random random;
	@Override
	public void execute() {
		oi.rd.putString("["+Integer.toString(random.nextInt())+"] SEXY ANIMALS!!!", "YEAH");
	}
}
