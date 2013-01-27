package headrevision.HumanTimeApproximation;

import static junit.framework.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class DurationTest {

	protected Duration sut;

	protected long seconds;

	protected String duration;

	public DurationTest(long seconds, String duration) {
		this.seconds = seconds;
		this.duration = duration;
	}

	@Before
	public void setUp() throws Exception {
		sut = new Duration();
	}

	@Parameterized.Parameters
	public static Collection<Object[]> parameters() {
		return Arrays.asList(new Object[][] {
				{ getSeconds("0 0 0 0 00:00:00"), "a second" },
				{ getSeconds("0 0 0 0 00:00:01"), "a second" },
				{ getSeconds("0 0 0 0 00:00:02"), "2 seconds" },
				{ getSeconds("0 0 0 0 00:00:22"), "22 seconds" },
				{ getSeconds("0 0 0 0 00:00:23"), "half a minute" },
				{ getSeconds("0 0 0 0 00:00:45"), "half a minute" },
				{ getSeconds("0 0 0 0 00:00:46"), "a minute" },
				{ getSeconds("0 0 0 0 00:01:29"), "a minute" },
				{ getSeconds("0 0 0 0 00:01:30"), "2 minutes" },
				{ getSeconds("0 0 0 0 00:02:29"), "2 minutes" },
				{ getSeconds("0 0 0 0 00:02:30"), "3 minutes" },
				{ getSeconds("0 0 0 0 00:21:29"), "21 minutes" },
				{ getSeconds("0 0 0 0 00:21:30"), "22 minutes" },
				{ getSeconds("0 0 0 0 00:22:29"), "22 minutes" },
				{ getSeconds("0 0 0 0 00:22:30"), "23 minutes" },
				{ getSeconds("0 0 0 0 00:22:59"), "23 minutes" },
				{ getSeconds("0 0 0 0 00:23:00"), "half an hour" },
				{ getSeconds("0 0 0 0 00:45:59"), "half an hour" },
				{ getSeconds("0 0 0 0 00:46:00"), "an hour" },
				{ getSeconds("0 0 0 0 01:29:59"), "an hour" },
				{ getSeconds("0 0 0 0 01:30:00"), "2 hours" },
				{ getSeconds("0 0 0 0 02:29:59"), "2 hours" },
				{ getSeconds("0 0 0 0 02:30:00"), "3 hours" },
				{ getSeconds("0 0 0 0 08:29:59"), "8 hours" },
				{ getSeconds("0 0 0 0 08:30:00"), "9 hours" },
				{ getSeconds("0 0 0 0 08:59:59"), "9 hours" },
				{ getSeconds("0 0 0 0 09:00:00"), "half a day" },
				{ getSeconds("0 0 0 0 17:59:59"), "half a day" },
				{ getSeconds("0 0 0 0 18:00:00"), "a day" },
				{ getSeconds("0 0 0 1 11:59:59"), "a day" },
				{ getSeconds("0 0 0 1 12:00:00"), "2 days" },
				{ getSeconds("0 0 0 2 11:59:59"), "2 days" },
				{ getSeconds("0 0 0 2 12:00:00"), "half a week" },
				{ getSeconds("0 0 0 4 23:59:59"), "half a week" },
				{ getSeconds("0 0 0 5 00:00:00"), "a week" },
				{ getSeconds("0 0 1 2 23:59:59"), "a week" },
				{ getSeconds("0 0 1 3 00:00:00"), "half a month" },
				{ getSeconds("0 0 2 5 23:59:59"), "half a month" },
				{ getSeconds("0 0 2 6 00:00:00"), "a month" },
				{ getSeconds("0 1 1 6 23:59:59"), "a month" },
				{ getSeconds("0 1 2 0 00:00:00"), "2 months" },
				{ getSeconds("0 2 1 6 23:59:59"), "2 months" },
				{ getSeconds("0 2 2 0 00:00:00"), "3 months" },
				{ getSeconds("0 3 1 6 23:59:59"), "3 months" },
				{ getSeconds("0 3 2 0 00:00:00"), "4 months" },
				{ getSeconds("0 4 1 6 23:59:59"), "4 months" },
				{ getSeconds("0 4 2 0 00:00:00"), "half a year" },
				{ getSeconds("0 8 3 6 23:59:59"), "half a year" },
				{ getSeconds("0 9 0 0 00:00:00"), "a year" },
				{ getSeconds("1 5 3 6 23:59:59"), "a year" },
				{ getSeconds("1 6 0 0 00:00:00"), "2 years" },
				{ getSeconds("2 5 3 6 23:59:59"), "2 years" },
				{ getSeconds("2 6 0 0 00:00:00"), "3 years" } });
	}

	@Test
	public void testFromSeconds() {
		assertEquals(sut.fromSeconds(seconds), duration);
	}

	/**
	 * @param canonicalDuration
	 *            years months weeks days hours:minutes:seconds
	 */
	protected static long getSeconds(String canonicalDuration) {
		String[] parsedDuration = canonicalDuration.split(" |:");
		return getSecondsByYears(parsedDuration[0])
				+ getSecondsByMonths(parsedDuration[1])
				+ getSecondsByWeeks(parsedDuration[2])
				+ getSecondsByDays(parsedDuration[3])
				+ getSecondsByHours(parsedDuration[4])
				+ getSecondsByMinutes(parsedDuration[5])
				+ Long.valueOf(parsedDuration[6]);
	}

	protected static long getSecondsByYears(String numberOfYears) {
		return getSecondsByMonths(numberOfYears) * 12;
	}

	protected static long getSecondsByMonths(String numberOfMonths) {
		return getSecondsByWeeks(numberOfMonths) * 4;
	}

	protected static long getSecondsByWeeks(String numberOfWeeks) {
		return getSecondsByDays(numberOfWeeks) * 7;
	}

	protected static long getSecondsByDays(String numberOfDays) {
		return getSecondsByHours(numberOfDays) * 24;
	}

	protected static long getSecondsByHours(String numberOfHours) {
		return getSecondsByMinutes(numberOfHours) * 60;
	}

	protected static long getSecondsByMinutes(String numberOfMinutes) {
		return Long.valueOf(numberOfMinutes) * 60;
	}

}