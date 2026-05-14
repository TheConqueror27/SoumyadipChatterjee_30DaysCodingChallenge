import java.util.*;

public class Day_23 {

    static int MAX = 1000000;
    static int[] dp = new int[MAX + 1];

    public static void precompute() {
        dp[0] = 0;

        for (int i = 1; i <= MAX; i++) {

            dp[i] = dp[i - 1] + 1;

            for (int j = 2; j * j <= i; j++) {
                if (i % j == 0) {
                    int next = Math.max(j, i / j);
                    dp[i] = Math.min(dp[i], dp[next] + 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        precompute();

        int Q = sc.nextInt();

        while (Q-- > 0) {
            int N = sc.nextInt();
            System.out.println(dp[N]);
        }

        sc.close();
    }
}