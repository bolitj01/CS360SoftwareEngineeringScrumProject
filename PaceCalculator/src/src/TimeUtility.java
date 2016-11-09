package src;
/**
 * Utility class containing time related methods
 * @author Stan
 *
 */
public final class TimeUtility  {
/**
 * private constructor to prevent instantiaion.
 */
	private TimeUtility()  {

	}

	/**
	 * Converts hours minutes and seconds into seconds only.
	 */

	public static double hMsToSeconds(final double[] time)  {

		double returnValue = (time[0] * 3600) + (time[1] * 60) + time[2];

		return returnValue;

	}
	
	/**
	 * Takes a number of seconds and determines how many hours are in it.
	 */
	public static int hours(final double totalSeconds)  {
		return (int) totalSeconds / 3600;

	}

	/**
	 * returns the number of minutes within the number of seconds provided.
	 */
	public static int minutes(final double totalSeconds)  {
		return (int) ((totalSeconds % 3600) / 60);

	}

	/**
	 * returns the number of seconds.
	 */
	public static double seconds(final double totalSeconds)  {
		return totalSeconds % 60;
	}
	
	/**
	 * 
	 */
	public static double[] parseAndValidateEntries(final String[] timeStrings)  {
		double[] time = new double[3];
		
		if (timeInputValidation(timeStrings))  {
			for (int i = 0; i < timeStrings.length; i++)  {
				if (!timeStrings[i].isEmpty())  {
					time[i] = Double.parseDouble(timeStrings[i]);
				} else {
					time[i] = 0;
				}
			}
			return time;
		} else {
			return new double[]  {-1, -1, -1};
		}
	}
	/**
	 * checks to see if the time inputs are in a valid format.  
	 */
	private static boolean timeInputValidation(final String[] timeStrings) {
		boolean valid = true;
		
		//Check hours and minutes for integer value or empty
		for (int i = 0; i < 2; i++) {
			if (!isEmptyOrPositiveInteger(timeStrings[i])) {
				 valid = false;
			}
		}
		
		//Check seconds for decimal value or empty
		if (!isEmptyOrPositiveDecimal(timeStrings[2])) {
			valid = false;
		}
		
		return valid;
	}
	/**
	 * checks whether the user input is a double that is not negative or empty.
	 */
	private static boolean isEmptyOrPositiveDecimal(final String string) {
		if (string.isEmpty()) {
			return true;
		}
		//Check if decimal and then if positive
		try  {
			if (Double.parseDouble(string) >= 0) {
				return true;
			}
		} catch (NumberFormatException e) {
			return false;
		}
		
		return false;
	}
	/**
	 * makes sure a string given by the user is an integer and positive.
	 */
	private static boolean isEmptyOrPositiveInteger(final String string) {
		if (string.isEmpty()) {
			return true;
		}
		//Check if integer and then if positive
		try  {
			if (Integer.parseInt(string) >= 0) {
				return true;
			}
		} catch (NumberFormatException e) {
			return false;
		}
		
		return false;
	}

}
