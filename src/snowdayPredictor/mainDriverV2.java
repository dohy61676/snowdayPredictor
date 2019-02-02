package snowdayPredictor;

import java.util.Scanner;

public class mainDriverV2 {
	
	/** Variables */
	//Points
	static int totalPoints=0;
	static int msnScore;
	
	//Date
	static int day;
	static int month;
	static int year=2019;
	static int transMonth;
	
	//Conditions
	static int proxBreak;
	static int activitiesCancelled;
	static int stateTesting;
	static int prevSnow;	
	static int monthRatioPoints;
	
	//Array
	//Format goes [month] [snowdays]
	static int[][] smA = new int[5][4];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		initialInput();
		mainpointHandler();
		System.out.println(totalPoints);
	}
	
	public static void initialInput() {
		/** Setting day, year, and month */
		Scanner reader = new Scanner(System.in);
		//Day
		System.out.println("What is the day (in a number(Sunday=0, Saturday=6))?");
		day = reader.nextInt();
		
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
		N3();
		//N4
		N4();
		//N5
		//N6
		//N7
		//N8
		//N9
		//N10
		
	}
	
	/**Question Methods*/
	//N1
	public static void N1() {
		if (day==1 || day==5) {
			totalPoints=totalPoints+12;
		}
	}
	//N2
	public static void N2() {
		if (proxBreak==0) {
			totalPoints=totalPoints+12;
		}
		else if (proxBreak==1) {
			totalPoints=totalPoints+10;
		}
	}
	//N3
	public static void N3() {
		monthTranslator();
		monthsnowArray();
		//Adding points
		totalPoints = totalPoints + msnScore;
	}
	//N4
	public static void N4() {
		if(activitiesCancelled==1) {
			totalPoints = totalPoints+10;
		}
	}
	//N5
	public static void N5() {
		if(stateTesting==1) {
			totalPoints = totalPoints - 40;
		}
	}
	/**Question Methods dependencies*/
	//Translates normal month values into those used by (MonthSnow) array
	public static void monthTranslator() {
		/**
		 * Typical values:
		 * Nov - 11
		 * Dec - 12
		 * Jan - 1
		 * Feb - 2
		 * Mar - 3
		 * New Values:
		 * Nov - 0
		 * Dec - 1
		 * Jan - 2
		 * Feb - 3
		 * Mar - 4
		 */
		
		/**Actual translation*/
		//Nov
		if(month==11) {
			transMonth=0;
		}
		//Dec
		else if(month==12) {
			transMonth=1;
		}
		//Jan
		else if(month==1) {
			transMonth=2;
		}
		//Feb
		else if(month==2) {
			transMonth=3;
		}
		//Mar
		else if(month==3) {
			transMonth=4;
		}
	}
	
	//Stores chart for values
	private static void monthsnowArray() {
		//Nov
		smA[0][0] = 15;
		smA[0][1] = 10;
		smA[0][2] = 5;
		smA[0][3] = 0;
		//Dec
		smA[1][0] = 10;
		smA[1][1] = 7;
		smA[1][2] = 3;
		smA[1][3] = 2;
		//Jan
		smA[2][0] = 8;
		smA[2][1] = 6;
		smA[2][2] = 3;
		smA[2][3] = 2;
		//Feb
		smA[3][0] = 10;
		smA[3][1] = 7;
		smA[3][2] = 5;
		smA[3][3] = 2;
		//Mar
		smA[4][0] = 15;
		smA[4][1] = 10;
		smA[4][2] = 6;
		smA[4][3] = 4;
		if((prevSnow>=4) || (prevSnow<0)) {
			System.exit(0);
		}
		msnScore = smA[transMonth][prevSnow];
	}
}