import java.util.Scanner;

/**
 * Created by astralsky on 17. 3. 10.
 */
public class BinarySearch {

    public static void main(String[] args) {

        int arr[] = {1, 3, 4, 5, 6, 7, 10, 11, 14, 17};
        Scanner scanner = new Scanner(System.in);

        System.out.print("enter number : ");
        String target = scanner.nextLine();
        int temp = Integer.parseInt(target);

        int result = binarySearch(arr, temp);
        if(result == -1) {
            System.out.printf("%d not found", temp);
        } else {
            System.out.printf("target : %d\ntarget index : %d", temp, result);
        }

    }

    public static int binarySearch(int[] arr, int t) {
        System.out.println("function call");
        int start = 0, end = arr.length - 1;
        int index;

        while(start <= end) {
            index = (start + end) / 2;
            System.out.println("index :" + index);
            System.out.printf("start : %d, end : %d\n",start, end);
            if(arr[index] == t) {
                return index;
            } else {
                if(arr[index] < t) {
                    start = ++index;
                } else if(arr[index] > t) {
                    end = --index;
                }
            }
        }

        return -1;
    }

}