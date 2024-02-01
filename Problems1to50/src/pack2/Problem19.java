package pack2;


import java.util.ArrayList;

public class Problem19 {
	ArrayList<String> days = new ArrayList<String>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Problem19 p = new Problem19();
		p.start();
	}
	
	
	public Problem19() {
		days.add("Monday");
		days.add("Tuesday");
		days.add("Thursday");
		days.add("Thursday");
		days.add("Friday");
		days.add("Saturday");
		days.add("Sunday");
		
	}
	
	private void start() {
		//Tuesday, January 1, 1901
		int dayCount = 0;
		int sundaysOnFirst = 0;
		
		for(int year = 1901; year <= 2000; year++) {
			int yearlyDayCount = dayCount;
			int leapDay = 0;
			if(year % 4 == 0) {
				leapDay = 1;
			}
			//Jan
			for(int d = 1; d <= 31; d++) {
				dayCount++;
				if(d == 1 && days.get(dayCount % 7).equals("Sunday")) {
					sundaysOnFirst++;
				}
			}
			
			//feb
			for(int d = 1; d <= 28 + leapDay; d++) {
				dayCount++;
				if(d == 1 && days.get(dayCount % 7).equals("Sunday")) {
					sundaysOnFirst++;
				}
			}
			
			//mar
			for(int d = 1; d <= 31; d++) {
				dayCount++;
				if(d == 1 && days.get(dayCount % 7).equals("Sunday")) {
					sundaysOnFirst++;
				}
			}
			
			//apr
			for(int d = 1; d <= 30; d++) {
				dayCount++;
				if(d == 1 && days.get(dayCount % 7).equals("Sunday")) {
					sundaysOnFirst++;
				}
			}
			
			//may
			for(int d = 1; d <= 31; d++) {
				dayCount++;
				if(d == 1 && days.get(dayCount % 7).equals("Sunday")) {
					sundaysOnFirst++;
				}
			}
			
			//jun
			for(int d = 1; d <= 30; d++) {
				dayCount++;
				if(d == 1 && days.get(dayCount % 7).equals("Sunday")) {
					sundaysOnFirst++;
				}
			}
			
			//july
			for(int d = 1; d <= 31; d++) {
				dayCount++;
				if(d == 1 && days.get(dayCount % 7).equals("Sunday")) {
					sundaysOnFirst++;
				}
			}
			
			//aug
			for(int d = 1; d <= 31; d++) {
				dayCount++;
				if(d == 1 && days.get(dayCount % 7).equals("Sunday")) {
					sundaysOnFirst++;
				}
			}
			
			//sep
			for(int d = 1; d <= 30; d++) {
				dayCount++;
				if(d == 1 && days.get(dayCount % 7).equals("Sunday")) {
					sundaysOnFirst++;
				}
			}
			
			//oct
			for(int d = 1; d <= 31; d++) {
				dayCount++;
				if(d == 1 && days.get(dayCount % 7).equals("Sunday")) {
					sundaysOnFirst++;
				}
			}
			
			//nov
			for(int d = 1; d <= 30; d++) {
				dayCount++;
				if(d == 1 && days.get(dayCount % 7).equals("Sunday")) {
					sundaysOnFirst++;
				}
			}
			
			//dec
			for(int d = 1; d <= 31; d++) {
				dayCount++;
				if(d == 1 && days.get(dayCount % 7).equals("Sunday")) {
					sundaysOnFirst++;
				}
			}
			
			System.out.println("The year " + year + " had " + (dayCount - yearlyDayCount) + " days");
			
		}
		System.out.println(sundaysOnFirst);
	}

	

}


//You are given the following information, but you may prefer to do some research for yourself.
//
//1 Jan 1900 was a Monday.
//Thirty days has September,
//April, June and November.
//All the rest have thirty-one,
//Saving February alone,
//Which has twenty-eight, rain or shine.
//And on leap years, twenty-nine.
//A leap year occurs on any year evenly divisible by 4, 
//but not on a century unless it is divisible by 400.
//How many Sundays fell on the first of the month during the twentieth century 
//(1 Jan 1901 to 31 Dec 2000)?