package org.usfirst.frc.team4373.input;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.tables.TableKeyNotDefinedException;

public class RooDashboard extends SmartDashboard {
	
	//you know, just in case we need to do something fancy with the dash
	
	public RooDashboard (){
		super ();
	}
	
	public boolean rooGetBoolean (String key, boolean defaultValue){
		try{
			return this.getBoolean(key);
		}catch (TableKeyNotDefinedException e){
			this.putBoolean(key, defaultValue);
			return defaultValue;
		}
	}
	
	public double rooGetNumber (String key, double defaultValue){
		try{
			return this.getNumber(key);
		}catch (TableKeyNotDefinedException e){
			this.putNumber(key, defaultValue);
			return defaultValue;
		}
	}
	public double rooGetNumber (String key, int defaultValue){
		try{
			return this.getNumber(key);
		}catch (TableKeyNotDefinedException e){
			this.putNumber(key, defaultValue);
			return defaultValue;
		}
	}
	
	public String rooGetString (String key, String defaultValue){
		try{
			return this.getString(key);
		}catch (TableKeyNotDefinedException e){
			this.putString(key, defaultValue);
			return defaultValue;
		}
	}
	
}
