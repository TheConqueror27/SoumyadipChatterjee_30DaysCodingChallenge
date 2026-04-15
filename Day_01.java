import java.util.*;
public class Day_01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int d = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        d = d % n; 
        for (int i = 0; i < n; i++) {
            System.out.print(arr[(i + d) % n]);

            if (i != n - 1) {
                System.out.print(" ");
            }
        }
        sc.close();
    }
}