package resursion.factorial;

import java.util.Scanner;

public class Factorial {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n;
        System.out.printf("Input Factorial number : ");
        n = scanner.nextInt();
        scanner.nextLine();

        int result = recursiveFactorial(n);
        System.out.println("Factorial of " + n + " : " + result);

    }

    private static int recursiveFactorial(int n) {
        if(n == 0) {
            return 1;
        }

        return n * recursiveFactorial(n - 1);
    }
}