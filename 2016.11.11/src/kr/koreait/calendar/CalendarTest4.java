//	Works No.8
package kr.koreait.calendar;

import java.util.Calendar;

public class CalendarTest4 {

	public static void main(String[] args) {

		Calendar calendar = Calendar.getInstance();
		
		int year=calendar.get(Calendar.YEAR);
		
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
		for(int k = 0; k < 24; k++) {
		     for(int i = 0; i < 3; i++) { // 월
		          System.out.printf("%4d년 %d월", year, i + 1);
		           for(int j = 0; j < calen[i][k%6].length; j++) { // inner: 0~6
		                // System.out.printf("(%d %d %d) ", i, k, j);
		                System.out.printf(" %2d ", calen[i][k%6][j]);
		           }
		           System.out.print("|");
		      }
		     System.out.println("");
		     if( (k+1)%6 == 0 ){
					System.out.println();
				}
		}
		

	}

}
