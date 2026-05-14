import java.util.*;

public class Day_19 {

    public static int twoStacks(int maxSum, int[] a, int[] b) {
        int sum = 0;
        int i = 0, j = 0;
        int count = 0;
        while (i < a.length && sum + a[i] <= maxSum) {
            sum += a[i];
            i++;
        }

        count = i;

        while (j < b.length) {
            sum += b[j];
            j++;
            while (sum > maxSum && i > 0) {
                i--;
                sum -= a[i];
            }

            if (sum > maxSum) break;

            count = Math.max(count, i + j);
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int g = sc.nextInt(); // number of games

        while (g-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int maxSum = sc.nextInt();

            int[] a = new int[n];
            int[] b = new int[m];

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            for (int i = 0; i < m; i++) {
                b[i] = sc.nextInt();
            }

            System.out.println(twoStacks(maxSum, a, b));
        }

        sc.close();
    }
}