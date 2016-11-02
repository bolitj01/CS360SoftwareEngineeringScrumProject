package src;

/**
 * 
 * Utility class to calculate pace, time, distance. Also converts between units
 * declared final to prevent sub classing
 *
 */
public final class PaceCalculatorUtility {

	/**
	 * private constructor to prevent instantiation
	 */
	private PaceCalculatorUtility() {
		
	}

	/**
	 * determines how long it will take to travel a given distance when
	 * running/walking at a given pace
	 */
	public static double calculateTime(double pace, double distance) {
		return distance * pace;
	}

	/**
	 * calculates how far a user will travel while traveling at a given pace for
	 * a given amount of time
	 */
	public static double calculateDistance(double pace, double time) {
		return time / pace;
	}

	public static double calculatePace(double time, double distance) {
		return time / distance;
	}
	
	/**
	 * Convert miles to kilometers and vice versa
	 */
	public static double milesToKilometers(double miles) {
		return miles * 1.60934;
	}
	
	public static double kilometersToMiles(double kilometers){
		return kilometers / 1.60934;
	}

}
