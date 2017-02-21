//	Works No.8
package kr.koreait.calendar;

import java.util.Calendar;

public class CalendarTest2 {

	public static void main(String[] args) {

		Calendar calendar = Calendar.getInstance();
		
		int year=calendar.get(Calendar.YEAR);
//		int month=calendar.get(Calendar.MONTH)+1;
		
		int[][][] calen = new int[12][6][7];	
		
		for(int k=0; k < calen.length; k++) {
			int month = k+1;
			int start = MyCalendar.weekDay(year, month, 1);
			start = start == 0 ? 7 : start;
			int count;
			if(month == 1) {
				count = MyCalendar.lastDay(year - 1, 12) - start + 1;
			} else {
				count = MyCalendar.lastDay(year, month - 1) - start + 1;
			}
			for(int i=0; i < start; i++) {
				calen[k][0][i] = count++;
			}
			count = 1;
			for(int i=0; i < calen[k].length; i++) {
				for(int j=start; j < calen[i][i].length; j++) {
					if(count <= MyCalendar.lastDay(year, k + 1)) {
						calen[k][i][j] = count++;
					} else {
						j--;
						count = 1;
					}
				}
				start = 0;
			}
		}

//		날짜를 출력한다.
		for(int k=0; k < calen.length; k++) {
			System.out.printf ("        %d년 %2d월        \n", year, k+1);
			System.out.println(" 일  월  화  수  목  금  토 ");
			for(int i=0; i < calen[k].length; i++) {
				for(int j=0; j < calen[k][i].length; j++) {
					System.out.printf(" %2d ", calen[k][i][j]);
				}
				System.out.println();
			}
			System.out.println();
		}

	}

}
