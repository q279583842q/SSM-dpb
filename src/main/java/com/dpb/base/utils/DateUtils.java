package com.dpb.base.utils;

import java.text.*;
import java.util.*;

public class DateUtils {
	public static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd";
	public static final String DEFAULT_TIME_FORMAT = "HH:mm:ss";
	public static final String DEFAULT_DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
	public static final String ALIGN_DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

	private static final double[] LIMITS = { 0, 1, 2 };

	private static final String[] MINUTES_PART = { "", "1 minute ",
			"{0,number} minutes " };

	private static final String[] SECONDS_PART = { "0 seconds", "1 second",
			"{1,number} seconds" };

	private static final ChoiceFormat MINUTES_FORMAT = new ChoiceFormat(LIMITS,
			MINUTES_PART);

	private static final ChoiceFormat SECONDS_FORMAT = new ChoiceFormat(LIMITS,
			SECONDS_PART);

	private static final MessageFormat MINUTE_SECONDS = new MessageFormat(
			"{0}{1}");

	static {
		MINUTE_SECONDS.setFormat(0, MINUTES_FORMAT);
		MINUTE_SECONDS.setFormat(1, SECONDS_FORMAT);
	}

	public static final long ONE_SECOND = 1000;
	public static final long ONE_MINUTE = 60 * ONE_SECOND;
	public static final long ONE_HOUR = 60 * ONE_MINUTE;
	public static final long ONE_DAY = 24 * ONE_HOUR;
	public static final long ONE_WEEK = 7 * ONE_DAY;

	public static final SimpleDateFormat _defDateTimeFmt = new SimpleDateFormat(
			DEFAULT_DATETIME_FORMAT);

	public static final SimpleDateFormat _defDateFmt = new SimpleDateFormat(
			DEFAULT_DATE_FORMAT);

	public static String toString(Date date, String format) {

		SimpleDateFormat formatter;

		if ((date == null) || (format == null) || (format.length() == 0)) {
			return null;
		}
		formatter = new SimpleDateFormat(format);
		return formatter.format(date);
	}

	public static Date toDate(String str, String format) {
		if ((str == null) || (str.length() == 0) || (format == null)
				|| (format.length() == 0)) {
			return null;
		}

		SimpleDateFormat formatter = new SimpleDateFormat(format);
		formatter.setLenient(false);
		ParsePosition pos = new ParsePosition(0);
		return formatter.parse(str, pos);
	}

	public static boolean compare(Date date1, Date date2) {
		if (date1 == null && date2 == null) {
			return true;
		}
		if (date1 == null || date2 == null)
			return false;
		else
			return date1.getTime() == date2.getTime();
	}

	public static Date toDate(String str) {
		try {
			if (str.indexOf(':') > 0) {
				return toDate(str, DEFAULT_DATETIME_FORMAT);
			} else {
				return toDate(str, DEFAULT_DATE_FORMAT);
			}
		} catch (Exception ex) {
			return null;
		}
	}

	public static String currentDateToString(String format) {
		Date date = new Date();
		return toString(date, format);
	}

	public static String curDateStr() {
		return _defDateFmt.format(new Date());
	}

	public static String curDateTimeStr() {
		return _defDateTimeFmt.format(new Date());
	}

	public static String formatElapsedTime(long millis) {
		long seconds = millis / 1000;
		long minutes = seconds / 60;
		Object[] args = { new Long(minutes), new Long(seconds % 60) };
		return MINUTE_SECONDS.format(args);
	}

	public static class LocalTime {
		// year - 1900
		public int year;
		// 0 - 11
		public int month;
		// 1 - 31
		public int day;
		// 0 (SUN) - 6 (SAT)
		public int dayOfWeek;
		// 0 - 365
		public int dayOfYear;
		// 0 - 23
		public int hour;
		// 0 - 59
		public int minute;
		// 0 - 59
		public int second;
		// Daylight Saving Time indicator
		public boolean dst;
		// 1 - 31
		public int maxDayOfMonth;
	}

	public static LocalTime localtime() {
		return localtime((Date) null);
	}

	public static LocalTime localtime(Date date) {
		if (date == null) {
			date = new Date();
		}

		LocalTime ltime = new LocalTime();

		Calendar cal = Calendar.getInstance(TimeZone.getDefault());
		cal.setTime(date);

		ltime.year = cal.get(Calendar.YEAR) - 1900;
		ltime.month = cal.get(Calendar.MONTH);
		ltime.day = cal.get(Calendar.DAY_OF_MONTH);
		ltime.dayOfWeek = cal.get(Calendar.DAY_OF_WEEK) - 1;
		ltime.dayOfYear = cal.get(Calendar.DAY_OF_YEAR) - 1;
		ltime.hour = cal.get(Calendar.HOUR_OF_DAY);
		ltime.minute = cal.get(Calendar.MINUTE);
		ltime.second = cal.get(Calendar.SECOND);
		ltime.dst = cal.get(Calendar.DST_OFFSET) != 0;
		ltime.maxDayOfMonth = cal.getActualMaximum(Calendar.DAY_OF_MONTH);

		return ltime;
	}

	public static Date toDate(LocalTime ltime) {
		Calendar cal = Calendar.getInstance(TimeZone.getDefault());
		cal.set(ltime.year + 1900, ltime.month, ltime.day, ltime.hour,
				ltime.minute, ltime.second);
		return cal.getTime();
	}
}
