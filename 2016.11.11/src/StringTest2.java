// Works No.2
import java.util.Scanner;

public class StringTest2 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		
		System.out.print("문자열 입력 : ");
		String str = scanner.nextLine();
		
//		length() : 문자열의 문자 개수를 얻어온다.
//		trim() : 문자열 앞, 뒤의 불필요한 빈 칸을 제거한다.	
		System.out.println("입력한 문자의 개수 : " + str.length());
		System.out.println("입력한 문자중에서 불필요한 빈카을 제거한 문자의 개수 : " + str.trim().length());
		
//		toUpperCase() : 영문자를 무조건 대문자로 변환한다.
//		toLowerCase() : 영문자를 무조건 소문자로 변환한다.
		System.out.println("무조건 대문자로 : " + str.toUpperCase());
		System.out.println("무조건 소문자로 : " + str.toLowerCase());

		String str1 = "KoreaIt Academy";
//		indexOf(문자열) : 문자열이 최초로 나타나는 위치를 출력
//		indexOf(문자열, 시작위치) : 문자열이 시작위치 이후에 최초로 나타나는 위치를 얻어온다.
//		lastIndexOf(문자열) : 뒤에서부터 index하여 문자열이 나타난 위치를 출력
		System.out.println("입력받은 문자의 최초 출현 위치 : " + str1.indexOf(str));
		System.out.println("입력받은 문자의 최초 출현 위치 : " + str1.indexOf(str, 5));
				
//		substring(a) : 문자열의 a번째 문자부터 끝까지 얻어온다.
//		substring(a, b) : 문자열의 a번째 문자부터 b-1번째 문자까지 얻어온다.
		System.out.println(str1.substring(8));
		System.out.println(str1.substring(5, 7));
		
		String str2 = "220-81-62537-12345";
		System.out.println(str2.substring(4, 6));
		
		int start = str2.indexOf("-") + 1;
		int end = str2.indexOf("-", start);
		System.out.println(str2.substring(start, end));
				
//		split(문자열) : 인자를 제외한 나머지 문자열을 인자를 기준으로 분할하여 배열로 만든다. 
//		str2.split("-")[0] = 220, str2.split("-")[1] = 81, str2.split("-")[2] = 62537, str2.split("-")[3] = 12345
		System.out.println(str2.split("-")[1]);
		
		int start1 = str2.indexOf("-") + 1;
		int end1 = str2.lastIndexOf("-");
		System.out.println(str2.substring(start1, end1));
		System.out.println(str2.substring(str2.indexOf("-") + 1, str2.lastIndexOf("-")));
		
		scanner.close();
	}

}
