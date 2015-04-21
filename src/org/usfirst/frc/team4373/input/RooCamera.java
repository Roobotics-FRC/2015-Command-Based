package org.usfirst.frc.team4373.input;

import org.usfirst.frc.team4373.robot.Robot;
import org.usfirst.frc.team4373.robot.commands.CommandBase;

import com.ni.vision.NIVision;
import com.ni.vision.NIVision.DrawMode;
import com.ni.vision.NIVision.Image;
import com.ni.vision.NIVision.ShapeMode;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.Timer;

public class RooCamera extends Thread {
	int session;
	Image frame;
	boolean shouldStop = false;
	public RooCamera(String camName) {
		super();
		frame = NIVision.imaqCreateImage(NIVision.ImageType.IMAGE_RGB, 0);

        // the camera name (ex "cam0") can be found through the roborio web interface
        session = NIVision.IMAQdxOpenCamera(camName,
                NIVision.IMAQdxCameraControlMode.CameraControlModeController);
        NIVision.IMAQdxConfigureGrab(session);
        
//        NIVision.
	}
	public void drawImage() {
		CommandBase.getOI().rd.putString("camera debug", "mason sucks");
		NIVision.IMAQdxStartAcquisition(session);
//		NIVision.Rect rect = new NIVision.Rect(10, 10, 100, 100);
		NIVision.IMAQdxGrab(session, frame, 1);
//        NIVision.imaqDrawShapeOnImage(frame, frame, rect,
//                DrawMode.DRAW_VALUE, ShapeMode.SHAPE_OVAL, 0.0f);
        CameraServer.getInstance().setImage(frame);
        CameraServer.getInstance().setQuality(MIN_PRIORITY);
        Timer.delay(0.01);
        disable();
	}
	public void disable() {
		NIVision.IMAQdxStopAcquisition(session);
	}
	@Override
	public void run() {
		while (!shouldStop)
			drawImage();
	}
	public void c_stop() {
		this.shouldStop = false;
	}
}
