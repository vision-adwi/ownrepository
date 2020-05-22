package com.learning.java5.typesafeenum;

public class EnumTest {
	public static void main(String[] s) {
		//operationTest();
		dayTest();
	}
	private static void dayTest() {
		String dayName = "TUESDAY";
		
		Day day = Day.valueOf(dayName);
		//Day day = Day.SUNDAY;
		
		switch(day) {
		case MONDAY:
			System.out.println("Mondays are bad...");
			break;
		case FRIDAY:
			System.out.println("Fridays are good...");
			break;
		case SATURDAY:
		case SUNDAY:
			System.out.println("Weekends are best...");
			break;
		default:
			System.out.println("Midweek days are so-so...");
		}
		
		System.out.println("..and today is " + day.name() + ". In hindi it is called " + day.getHindiName() + ".");
	}

	private static void operationTest() {
		double operand1 = 10;
		double operand2 = 2;
		for(Operator op : Operator.values()) {
			System.out.printf("%f %s %f = %f%n", operand1, op, operand2, op.eval(operand1, operand2));
		}
	}

}

/*
-Enums are used when we know all possible values at compile time.
-Enum declaration can be done outside a Class or inside a Class but not inside a Method.
-First line inside enum should be list of constants and then other things like methods, variables and constructor.
-According to Java naming conventions, it is recommended that we name constant with all capital letters.
-Every enum constant is always implicitly public static final.
-We can declare main() method inside enum.
-enum can implement many interfaces.
*/