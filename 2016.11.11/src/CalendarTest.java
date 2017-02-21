//	Works No.5
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CalendarTest {

	public static void main(String[] args) {

		Calendar calendar = Calendar.getInstance();				// singleton type class - private constructor
		System.out.println(calendar);

		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy/MM/dd(E) HH:mm:ss");
//		getTime() : calendar 클래스 객체에서 1970년 1월 1일 부터 지나온 시간을 밀리초 단위로 얻어온다.
		System.out.println(sdf1.format(calendar.getTime()));
		System.out.println("년 : " + calendar.get(Calendar.YEAR));
		System.out.println("월 : " + (calendar.get(Calendar.MONTH)+1));
		System.out.println("일 : " + calendar.get(Calendar.DATE));
		System.out.println("일 : " + calendar.get(Calendar.DAY_OF_MONTH));
		System.out.println("요일 : " + calendar.get(Calendar.DAY_OF_WEEK));		// 1 ~ 7
		System.out.println("시 : " + calendar.get(Calendar.HOUR));				// 12시각
		System.out.println("시 : " + calendar.get(Calendar.HOUR_OF_DAY));		// 24시각
		System.out.println("분 : " + calendar.get(Calendar.MINUTE));
		System.out.println("초 : " + calendar.get(Calendar.SECOND));		
		
	}

}
