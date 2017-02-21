//	Work No.1
public class StringTest1 {

	public static void main(String[] args) {

		String str1 = "AAA";
		String str2 = "AAA";
		
		System.out.println(str1 == str2 ? "같다" : "다르다");
		
		String str3 = new String("AAA");
		
		System.out.println(str1 == str3 ? "같다" : "다르다");
//		문자열을 비교하려면 "=="를 사용하면 안되고 equals() 메소드를 사용한다.
		System.out.println(str1.equals(str3) ? "같다" : "다르다");
	}

}
