//	Works No.6
package kr.koreait.calendar;

public class MyCalendar {

/*	메소드의 형식
	[접근 권한 지정자] 리턴타입 메소드이름([인수,...]) {
		메소드가 실행할 문장;
		...;
		[return 값;]			// return이 생략되면 리턴 타입에 void라 적는다.
	}	
*/
//	접근 권한 지정
//	private : 현재 클래스 외부에서 접근할 수 없다. 상속 불가능
//	protected : 현재 클래스와 현재 클래스를 상속받은 자식 클래스에서만 접근할 수 있다. 상속 가능
//	package(default, 생략시) : 현재 패키지에서 자유롭게 접근할 수 있다. 상속 가능
//	public : 모든 위치에서 자유롭게 접근할 수 있다. 상속 가능
	
/*	정적(static) 메소드
	메소드 선언시 static으로 선언하면 클래스의 객체를 생성하지 않고 클래스 이름에 "."을 찍어서
	자유롭게 접근 할 수 있다. ==> 자주 사용하는 메소드를 static으로 선언한다.	
*/	
//	singleton 패턴
//	프로그램에서 객체가 딱 1개만 필요할 경우 singleton 패턴으로 만들어 사용한다.
/*	singleton 패턴 코딩 방법
	1. 자기 자신의 객체를 정적 멤버로 만든다.
	private static MyCalendar instance = new MyCalendar();
	2. 클래스 외부에서 객체를 생성할 수 없도록 생성자의 접근 권한을 private로 변경한다.
	private MyCalendar() { }
	3. 자기 자신의 객체를 리턴하는 정적 메소드를 만든다.	
	public static MyCalendar getInstance() { return instance; }
	
	* 클래스가 sigleton 패턴으로 되면 클래스내 메소드들은 static메소드를 만들수 없다.
*/
	
//	년도를 넘겨받아 윤년, 평년을 판별해 윤년은 true, 평년은 false를 리턴하는 메소드
	public static boolean isLeapYear(int year) {
		return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
	}
	
//	년, 월을 넘겨받아 그 달의 마지막 날짜를 리턴하는 메소드
	public static int lastDay(int year, int month) {
		int[] m = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		m[1] = isLeapYear(year) ? 29 : 28;
		return m[month-1];
	}	

//	년, 월, 일을 념겨받아 1년 1월 1일 부터 지나온 날짜의 합계를 리턴하는 함수
	public static int totalDay(int year, int month, int day) {
		int total = (year-1)*365 + (year-1)/4 - (year-1)/100 + (year-1)/400;
		for(int i=1; i < month; i++) {
			total += lastDay(year, i);
		}
		total += day;
		return total;
	}
	
	public static int weekDay(int year, int month, int day) {
		return totalDay(year, month, day)%7;
	}
	
	
	
}