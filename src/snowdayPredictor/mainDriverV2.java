package snowdayPredictor;

import java.util.Scanner;

public class mainDriverV2 {
	/** Variables */
	//Points
	static int totalPoints;
	
	//Date
	static int day;
	static int year;
	static int month;
	
	//Conditions
	static int proxBreak;
	static int activitiesCancelled;
	static int stateTesting;
	static int prevSnow;	
	static int monthRatioPoints;
	
	//Other
	static int errorCode;
	static int monthTranslator = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		initialInput();
	}
	
	public static void initialInput() {
		/** Setting day, year, and month */
		Scanner reader = new Scanner(System.in);
		//Day
		System.out.println("What is the day (in a number(Sunday=0, Saturday=6))?");
		day = reader.nextInt();
		
		//Year
		System.out.println("What is the year (in a number)?");
		year = reader.nextInt();
		
		//Month
		System.out.println("What is the month (in a number)?");
		month = reader.nextInt();
		
		/** Other Conditions*/
		//Proximity to break
		System.out.println("Is the next day a day before a break (0), a day after (1), or neither (2)?");
		proxBreak = reader.nextInt();
		
		//Activities Cancelled day before
		System.out.println("Where after school activies cancelled the day before (1), not not (0)?");
		activitiesCancelled = reader.nextInt();
		
		//Are public schools doing state testing?
		System.out.println("Are public schools state testing (1), or not (0)?");
		stateTesting = reader.nextInt();
		
		//How many previous snow days?
		System.out.println("How many snow days have there been this year?");
		prevSnow = reader.nextInt();
	}
	
	public static void mainpointHandler() {
		/**Notes correspond with question numbers*/
		//N1
		N1();
		//N2
		N2();
		//N3
		//N4
		//N5
		//N6
		//N7
		//N8
		//N9
		//N10
		
	}
	
	/**Question Methods*/
	public static void N1() {
		if (day==1 || day==5) {
			totalPoints=totalPoints+1;
		}
	}
	
	public static void N2() {
		if (proxBreak==0) {
			totalPoints=totalPoints+12;
		}
		else if (proxBreak==1) {
			totalPoints=totalPoints+10;
		}
	}
	
	public static void N3() {
		
	}
}