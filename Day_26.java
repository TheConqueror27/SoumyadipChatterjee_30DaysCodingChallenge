import java.util.*;

public class Day_26 {

    public static int cookies(int k, int[] A) {

        PriorityQueue<Long> pq = new PriorityQueue<>();

        for (int x : A) {
            pq.add((long) x);
        }

        int operations = 0;

        while (pq.size() > 1 && pq.peek() < k) {

            long first = pq.poll();
            long second = pq.poll();

            long newSweetness = first + (2 * second);

            pq.add(newSweetness);

            operations++;
        }

        if (pq.peek() >= k) {
            return operations;
        }

        return -1;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] A = new int[n];

        for (int i = 0; i < n; i++) {
            A[i] = sc.nextInt();
        }

        System.out.println(cookies(k, A));

        sc.close();
    }
}