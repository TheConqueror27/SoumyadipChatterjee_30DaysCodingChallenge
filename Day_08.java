import java.util.Scanner;

public class Day_08 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        
        int t = sc.nextInt();
        while (t-- > 0) {
            int k = sc.nextInt();
            String s1 = sc.next();
            String s2 = sc.next();
            System.out.println(solve(k, s1, s2));
        }
        sc.close();
    }

    private static int solve(int k, String s1, String s2) {
        int n = s1.length();
        int maxLen = 0;
        for (int offset = 0; offset < n; offset++) {
            maxLen = Math.max(maxLen, getMaxForOffset(k, s1, s2, offset, 0));
        }
        
        for (int offset = 1; offset < n; offset++) {
            maxLen = Math.max(maxLen, getMaxForOffset(k, s1, s2, 0, offset));
        }

        return maxLen;
    }

    private static int getMaxForOffset(int k, String s1, String s2, int start1, int start2) {
        int n = s1.length();
        int maxWindow = 0;
        int currentMismatches = 0;
        int left = 0;

        for (int right = 0; (start1 + right < n) && (start2 + right < n); right++) {
            if (s1.charAt(start1 + right) != s2.charAt(start2 + right)) {
                currentMismatches++;
            }

            while (currentMismatches > k) {
                if (s1.charAt(start1 + left) != s2.charAt(start2 + left)) {
                    currentMismatches--;
                }
                left++;
            }

            maxWindow = Math.max(maxWindow, right - left + 1);
        }

        return maxWindow;
    }
}