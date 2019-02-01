package snowdayPredictor;

import java.util.Scanner;

public class mainDriver {
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
		settingInput();
		snowmonthChart();
		System.out.println(monthRatioPoints);
	}
	
	public static void settingInput() {
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
	
	//Also does not include snow/month chart
	public static void pointAdder() {
		//No 1 - Day of the Week
		if(day==1 || day==5) {
			totalPoints = totalPoints + 12;
		}
		//No 2 - Proximity to Break
		if (proxBreak==0) {
			totalPoints = totalPoints + 12;
		}
		else if (proxBreak==1) {
			totalPoints = totalPoints + 10;
		}
		//No 3 - Month/Snow Day ratio
		snowmonthChart();
		
	}
	
	public static void snowmonthChart() {
		//Month/Snow Day Ratio array
		int[][] monthsnowRatio = new int[4][3];
		/** Adding Value to array */
		//November
		monthsnowRatio[0][0] = 15;
		monthsnowRatio[0][1] = 10;
		monthsnowRatio[0][2] = 5;
		monthsnowRatio[0][3] = 0;
		//December
		monthsnowRatio[1][0] = 10;
		monthsnowRatio[1][1] = 7;
		monthsnowRatio[1][2] = 3;
		monthsnowRatio[1][3] = 2;
		//January
		monthsnowRatio[2][8] = 8;
		monthsnowRatio[2][6] = 6;
		monthsnowRatio[2][3] = 3;
		monthsnowRatio[2][2] = 2;
		//Feburary
		monthsnowRatio[3][0] = 10;
		monthsnowRatio[3][1] = 7;
		monthsnowRatio[3][2] = 5;
		monthsnowRatio[3][3] = 2;
		//March
		monthsnowRatio[4][0] = 15;
		monthsnowRatio[4][1] = 10;
		monthsnowRatio[4][2] = 6;
		monthsnowRatio[4][3] = 4;
		
		//Computation
		monthTranslation();
		monthsnowRatio[month][day] = monthRatioPoints;
		
	}
	
	public static void monthTranslation() {

		//Translation
		/**
		 * November = 0
		 * December = 1
		 * January = 2
		 * February = 3
		 * March = 4
		 */
		if(month!=11 || month!=12 || month!=1 || month!=2 || month!=3) {
			System.exit(0);
		}
		//November
		else if(month==11) {
			monthTranslator = 0;
		}
		//December
		else if (month==12) {
			monthTranslator = 1;
		}
		//Janurary
		else if (month==1) {
			monthTranslator = 2;
		}
		//Feburary
		else if (month==2) {
			monthTranslator = 3;
		}
		//March
		else if (month==3) {
			monthTranslator = 4;
		}
		
		month = monthTranslator;
	}

}
