//	Works No.4
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class DateTest {

	public static void main(String[] args) {

//		컴퓨터 시스템의 현재 날짜와 시간을 얻어온다.
		
		Date date1 = new Date();
		System.out.println(date1);
		
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy/MM/dd(E) HH:mm:ss");
		System.out.println(sdf1.format(date1));
//		Date 클래스로 만든 객체의 년도는 1900을 더해서, 월은 1을 더해서 얻어와야 한다.
		System.out.println("년 : " + (date1.getYear()+1900));
		System.out.println("월 : " + (date1.getMonth()+1));
		System.out.println("일 : " + date1.getDate());
		System.out.println("요일 : " + date1.getDay());
		String[] week = {"일요일", "월요일", "화요일", "수요일", "목요일", "금요일", "토요일"};
		System.out.println(week[date1.getDay()]);
		System.out.println("시 : " + date1.getHours());
		System.out.println("분 : " + date1.getMinutes());
		System.out.println("초 : " + date1.getSeconds());
			
//		Date 클래스로 만든 객체에 년도는 1900을 빼서, 월은 1을 빼서 넣어줘야 한다.
		Date date2 = new Date(2016, 12, 25);
		System.out.println(sdf1.format(date2));
		Date date3 = new Date(116, 11, 25);
		System.out.println(sdf1.format(date3));
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("년, 월, 일을 입력하세요 : ");
		int year = scanner.nextInt();
		int month = scanner.nextInt();
		int day = scanner.nextInt();
		Date date4 = new Date(year - 1900, month - 1, day);
		System.out.println(sdf1.format(date4));
		
	}

}
