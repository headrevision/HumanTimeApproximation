package headrevision.HumanTimeApproximation;

public class Duration {

	public String fromSeconds(long seconds) {
		if (seconds >= 1 * 12 * 4 * 7 * 24 * 60 * 60 + 6 * 4 * 7 * 24 * 60 * 60) {
			int years = (int) Math.floor((seconds + 6 * 4 * 7 * 24 * 60 * 60)
					/ (12 * 4 * 7 * 24 * 60 * 60));
			return String.format("%d years", years);
		} else if (seconds >= 9 * 4 * 7 * 24 * 60 * 60) {
			return "a year";
		} else if (seconds >= 4 * 4 * 7 * 24 * 60 * 60 + 2 * 7 * 24 * 60 * 60) {
			return "half a year";

		} else if (seconds >= 1 * 4 * 7 * 24 * 60 * 60 + 2 * 7 * 24 * 60 * 60) {
			int months = (int) Math.floor((seconds + 2 * 7 * 24 * 60 * 60)
					/ (4 * 7 * 24 * 60 * 60));
			return String.format("%d months", months);
		} else if (seconds >= 2 * 7 * 24 * 60 * 60 + 6 * 24 * 60 * 60) {
			return "a month";
		} else if (seconds >= 1 * 7 * 24 * 60 * 60 + 3 * 24 * 60 * 60) {
			return "half a month";

		} else if (seconds >= 5 * 24 * 60 * 60) {
			return "a week";
		} else if (seconds >= 2 * 24 * 60 * 60 + 12 * 60 * 60) {
			return "half a week";

		} else if (seconds >= 1 * 24 * 60 * 60 + 12 * 60 * 60) {
			int days = (int) Math.floor((seconds + 12 * 60 * 60)
					/ (24 * 60 * 60));
			return String.format("%d days", days);
		} else if (seconds >= 18 * 60 * 60) {
			return "a day";
		} else if (seconds >= 9 * 60 * 60) {
			return "half a day";

		} else if (seconds >= 1 * 60 * 60 + 30 * 60) {
			int hours = (int) Math.floor((seconds + 30 * 60) / (60 * 60));
			return String.format("%d hours", hours);
		} else if (seconds >= 46 * 60) {
			return "an hour";
		} else if (seconds >= 23 * 60) {
			return "half an hour";

		} else if (seconds >= 1 * 60 + 30) {
			int minutes = (int) Math.floor((seconds + 30) / (60));
			return String.format("%d minutes", minutes);
		} else if (seconds >= 46) {
			return "a minute";
		} else if (seconds >= 23) {
			return "half a minute";

		} else if (seconds >= 2) {
			return String.format("%d seconds", seconds);
		} else {
			return "a second";
		}
	}

}