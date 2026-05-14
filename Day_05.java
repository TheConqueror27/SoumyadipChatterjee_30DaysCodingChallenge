import java.util.*;
public class Day_05 {
    static int simpleArraySum(int[] ar) {
        int sum = 0;

        for (int i = 0; i < ar.length; i++) {
            sum += ar[i];
        }

        return sum;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] ar = new int[n];
        for (int i = 0; i < n; i++) {
            ar[i] = sc.nextInt();
        }
        System.out.println(simpleArraySum(ar));

        sc.close();
    }
}