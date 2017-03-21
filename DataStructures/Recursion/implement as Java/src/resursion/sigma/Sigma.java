package resursion.sigma;

import java.util.Scanner;

public class Sigma {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n;
        System.out.printf("Input Sigma number : ");
        n = scanner.nextInt();
        scanner.nextLine();

        int result = recursiveSigma(n);
        System.out.println("sigma of " + n + " : " + result);

    }

    private static int recursiveSigma(int n) {
        if(n == 1) {
            return 1;
        }

        return n + recursiveSigma(n-1);
    }

}
