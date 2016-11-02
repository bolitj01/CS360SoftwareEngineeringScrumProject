package src;

public final class TimeUtility {

	private TimeUtility() {

	}

	/**
	 * Takes a number of seconds and determines how many hours are in it
	 */
	public static int hours(double totalSeconds) {
		return (int) totalSeconds / 3600;

	}

	/**
	 * Converts hours minutes and seconds into seconds only
	 */

	public static double hMsToSeconds(double[] time) {

		double returnValue = (time[0] * 3600) + (time[1] * 60) + time[2];

		return returnValue;

	}

	/**
	 * returns the number of minutes within the number of seconds provided
	 */
	public static int minutes(double totalSeconds) {
		return (int) ((totalSeconds % 3600) / 60);

	}

	/**
	 * returns the number of seconds
	 */
	public static int seconds(double totalSeconds) {
		return (int) totalSeconds % 60;
	}
	
	/**
	 * 
	 */
	public static double[] parseAndValidateEntries(String[] timeStrings){
		double time[] = new double[3];
		
		if (timeInputValidation(timeStrings)){
			for (int i = 0; i < timeStrings.length; i++){
				if (!timeStrings[i].isEmpty()){
					time[i] = Double.parseDouble(timeStrings[i]);
				}
				else{
					time[i] = 0;
				}
			}
			return time;
		}
		else{
			return null;
		}
	}
	
	private static boolean timeInputValidation(String[] timeStrings){
		boolean valid = false;
		
		boolean aFieldIsPopulated = false;
		
		boolean segmentsAreValid = true;
		for (String time: timeStrings){
			if (!isEmptyOrPositiveNumeric(time)){
				 segmentsAreValid = false;
			}
			if (!time.isEmpty()){
				aFieldIsPopulated = true;
			}
		}
		
		if (segmentsAreValid && aFieldIsPopulated){
			valid = true;
		}
		
		return valid;
	}
	
	private static boolean isEmptyOrPositiveNumeric(String string){
		if (string.isEmpty()){
			return true;
		}
		//Check if numeric and then if positive
		try {
			if (Double.parseDouble(string) > 0){
				return true;
			}
		} catch (NumberFormatException e){
			return false;
		}
		
		return false;
	}

}
