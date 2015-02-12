package util;

public class RooMath {
	public static int getSign (double a){
		return (int) ( a== 0.0D ? 0.0D : ( Math.abs(a)/a));
	}
}
