package resursion.fibonacci;

import java.util.Scanner;

public class Fibonacci {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n;
        System.out.printf("Input Fibonacci number : ");
        n = scanner.nextInt();
        scanner.nextLine();

        for(int i = 1; i <= n; i++) {
            if(i > 1) {
                System.out.printf(", ");
            }
            System.out.print(recursiveFibonacci(i));
        }

    }

    private static int recursiveFibonacci(int n) {
        if(n < 3) {
            return 1;
        } else {
            return recursiveFibonacci(n - 1) + recursiveFibonacci(n - 2);
        }
    }
}