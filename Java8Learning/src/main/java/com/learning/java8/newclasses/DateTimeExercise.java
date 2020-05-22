package com.learning.java8.newclasses;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeExercise {

	public static void main(String[] args) {
		localDateTime();
		zoneAPI();
	}
	
	private static void localDateTime() {
		LocalDate date = LocalDate.now();
		LocalDate independenceDay = LocalDate.of(1947, 8, 15);
		System.out.println("Date: " + date);
		
		LocalTime time = LocalTime.now();
		System.out.println("Time: " + time);
		
		//This concatenates date and time
		LocalDateTime dateTime = LocalDateTime.now();
		System.out.println("Date and Time :" + dateTime);
		
		LocalDateTime bday = dateTime.withDayOfMonth(30).withYear(1979);
		System.out.println("My Birthday :" + bday);
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-dd-MM HH:MM");
		System.out.println("In format: " +  dateTime.format(formatter));
	}
	
	private static void zoneAPI() {
		ZonedDateTime dateTime = ZonedDateTime.now();
		System.out.println("(Zoned)Date and Time :" + dateTime);
		
		ZoneId zoneId = dateTime.getZone();
		ZoneOffset offset = dateTime.getOffset();
		System.out.println("Zone Id: " + zoneId + " Offset: " + offset);
		
		zoneId = ZoneId.of("Asia/Tokyo");
		ZonedDateTime tokyoDateTime = dateTime.withZoneSameInstant(zoneId);
		System.out.println("Tokyo date time: " + tokyoDateTime);
	}

}
