//	Works No.7
package kr.koreait.calendar;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CalendarTest1 {

	public static void main(String[] args) {

		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월");
		
		int year=calendar.get(Calendar.YEAR);
		int month=calendar.get(Calendar.MONTH)+1;

	
		System.out.println("          " + sdf.format(calendar.getTime()));
		System.out.println();
		System.out.println(" 일  월  화  수  목  금  토 ");
		
		int[][] calen = new int[6][7];
//		1일이 출력될 자리를 맞추기 위해 빈 칸을 출력한다.		
		int start = MyCalendar.weekDay(year, month, 1);
		start = start == 0 ? 7 : start;
		
//		배열에 전달 날짜를 채운다.
//		1월의 전달 전년도 12월이므로 전년도 12월의 마지막 날짜를 얻어오고 
//		나머지 달은 전달의 마지막 날짜를 얻어와서 계산한다.
		
		int count;
		if(month == 1) {
			count = MyCalendar.lastDay(year - 1, 12) - start + 1;
		} else {
			count = MyCalendar.lastDay(year, month - 1) - start + 1;
		}
		for(int i=0; i < start; i++) {
			calen[0][i] = count++;
		}
			
//		배열에 날짜를 넣는다.
//		2차원 배열에서 배열명 뒤에 length를 써주면 행의 개수를 얻어온다.
//		2차월 배열에서 배열명[행] 뒤에 length를 써주면 열의 개수를 얻어온다.
		
/*		int wd = MyCalendar.weekDay(year, month, 1)==0 ? 7 : MyCalendar.weekDay(year, month, 1);
		if(month == 1) {
			count = MyCalendar.lastDay(year-1, 12) - wd + 1;
		} else {
			count = MyCalendar.lastDay(year, month-1) - wd + 1;
		}
		for(int i=0; i < calen.length; i++) {
			for(int j=0; j < calen[i].length; j++) {
				calen[i][j] = count++;
				if(month != 1 && count == MyCalendar.lastDay(year, month-1)) {
					count = 1;
				} else if(month == 1 && count == MyCalendar.lastDay(year, 12)) {
					count = 1;
				}
			}
		}
*/		
		count = 1;
		for(int i=0; i < calen.length; i++) {
			for(int j=start; j < calen[i].length; j++) {
				if(count <= MyCalendar.lastDay(year, month)) {
					calen[i][j] = count++;
				} else {
					j--;
					count = 1;
				}
				
			}
			start = 0;
		}
			
//		날짜를 출력한다.		
		for(int i=0; i < calen.length; i++) {
			for(int j=0; j < calen[i].length; j++) {
				System.out.printf(" %2d ", calen[i][j]);
			}
			System.out.println();
		}
				
	}

}
