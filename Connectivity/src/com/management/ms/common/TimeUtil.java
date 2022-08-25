package com.management.ms.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Date;

public class TimeUtil {

	static SimpleDateFormat formater = new SimpleDateFormat(
			"dd-MMM-yyyy hh:mm:ss");

	public static String getCurrentTime() {
		Date add = new Date();
		return formater.format(add);
	}

	@SuppressWarnings({ "deprecation", "unused" })
	public static int getDayDiefference(String strdate1, String strdate2) {
		if (strdate1.isEmpty() || strdate2.isEmpty()) {
			return -1;
		}
		SimpleDateFormat dateFormatter = new SimpleDateFormat("dd-MMM,yyyy");
		Date date1 = null;
		try {
			date1 = formater.parse(strdate1);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Date date2 = null;
		try {
			date2 = formater.parse(strdate2);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		LocalDate dateone = LocalDate.of(date1.getYear(), date1.getMonth() + 1,
				date1.getDate());
		LocalDate datetwo = LocalDate.of(date2.getYear(), date2.getMonth() + 1,
				date2.getDate());

		Period diff = Period.between(dateone, datetwo);
		return Math.abs(diff.getDays());
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
