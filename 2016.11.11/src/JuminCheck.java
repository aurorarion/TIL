//	Works No.3
import java.util.Scanner;

public class JuminCheck {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.print("주민번호를 '-'없이 입력하세요 : ");
		String jumin;
		while(true) {
			jumin = scanner.nextLine();
			boolean flag = true;
			for(int i=0; i < jumin.length(); i++) {
				if( jumin.charAt(i)-'0' > 9 || jumin.length() != 13) {
					System.out.print("정상적인 주민번호가 아닙니다. 다시 입력하세요 : ");
					flag = false;
					break;
				}
			}
			if(flag) {
				break;
			}
		}
//		String check = "234567892345";
		int total = 0;
		for(int i=0; i < jumin.length()-1; i++) {
//			total += (jumin.charAt(i) - '0') * (check.charAt(i) - '0');
//			total += (jumin.charAt(i) - '0') * (i % 8 + 2);
			
//			Interger.parseInt() : 괄호 안의 문자열을 숫자로 변환한다.
			total += Integer.parseInt(jumin.charAt(i) + "") * (i % 8 + 2);
		}

		if( (11 - (total%11)) % 10 == (jumin.charAt(jumin.length()-1))-'0') {
			System.out.println("정상");
		} else {
			System.out.println("거짓");
		}
		
		scanner.close();
	}

}
