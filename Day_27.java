import java.util.*;

public class Day_27 {

    public static long arrayManipulation(int n, int[][] queries) {

        long[] arr = new long[n + 2];

        for (int[] q : queries) {
            int a = q[0];
            int b = q[1];
            int k = q[2];

            arr[a] += k;
            arr[b + 1] -= k;
        }

        long max = 0;
        long sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += arr[i];
            max = Math.max(max, sum);
        }

        return max;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int q = sc.nextInt();

        int[][] queries = new int[q][3];

        for (int i = 0; i < q; i++) {
            queries[i][0] = sc.nextInt();
            queries[i][1] = sc.nextInt();
            queries[i][2] = sc.nextInt();
        }

        System.out.println(arrayManipulation(n, queries));

        sc.close();
    }
}