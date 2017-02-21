//	Works No.6
package kr.koreait.calendar;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

public class CalendarTest {

	public static void main(String[] args) {

//		일반 클래스의 객체를 생성해 메소드 실행하기
//		MyCalendar myCalendar = new MyCalendar();
//		System.out.println(myCalendar.isLeapYear(2016));
		
//		singleton 패턴으로 작성된 클래스의 객체를 얻어와서 메소드 실행하기
//		MyCalendar myCalendar = MyCalendar.getInstance();
//		System.out.println(myCalendar.isLeapYear(2016));
		
//		메소드를 static으로 만들어 클래스 이름에 "."을 찍어 실행하기
//		System.out.println(MyCalendar.isLeapYear(2016));
//		System.out.println(MyCalendar.lastDay(2016, 2));
//		System.out.println(MyCalendar.totalDay(2016, 11, 11));
//		System.out.println(MyCalendar.totalDay(2016, 11, 11)%7);
//		System.out.println(MyCalendar.weekDay(2016, 11, 11));
		
		int year, month;
		Scanner scanner = new Scanner(System.in);
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월");
		
		System.out.print("출력할 달력의 년, 월을 입력하세요 : ");
		String inputYear = scanner.next();
		String inputMonth;
		if(inputYear.charAt(0)-'0' > 0 && inputYear.charAt(0)-'0' <= 9) {
			inputMonth = scanner.next();
			year = Integer.parseInt(inputYear);
			month = Integer.parseInt(inputMonth);
			System.out.println("============================");
			System.out.printf ("          %d년 %2d월        \n", year, month);
		} else {
//			Date date = new Date();
//			int year = date.getYear() + 1900;
//			int month = date.getMonth() + 1;
			year=calendar.get(Calendar.YEAR);
			month=calendar.get(Calendar.MONTH)+1;
			System.out.println("============================");
			System.out.println("          " + sdf.format(calendar.getTime()));
		}

		System.out.println("============================");
		System.out.println(" 일  월  화  수  목  금  토 ");
		System.out.println("============================");
		
//		1일이 출력될 자리를 맞추기 위해 빈 칸을 출력한다.	
		for(int i=0; i < MyCalendar.weekDay(year, month, 1); i++) {
			System.out.print("    ");
		}
		
//		날짜를 출력한다.
		for(int i=1; i <= MyCalendar.lastDay(year, month); i++) {
			System.out.printf(" %2d ", i);
			if( MyCalendar.weekDay(year, month, i) == 6 && i != MyCalendar.lastDay(year, month)) {
				System.out.println();
			}
		}
		System.out.println();
		System.out.println("============================");
		
		scanner.close();
	}

}
