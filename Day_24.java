public import java.util.*;

public class Day_24 {

    public static long largestRectangle(List<Integer> h) {
        Stack<Integer> stack = new Stack<>();
        long maxArea = 0;
        int n = h.size();

        for (int i = 0; i <= n; i++) {

            long currentHeight = (i == n) ? 0 : h.get(i);

            while (!stack.isEmpty() && currentHeight < h.get(stack.peek())) {

                long height = h.get(stack.pop());

                int width;

                if (stack.isEmpty()) {
                    width = i;
                } else {
                    width = i - stack.peek() - 1;
                }

                long area = height * width;
                maxArea = Math.max(maxArea, area);
            }

            stack.push(i);
        }

        return maxArea;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        List<Integer> h = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            h.add(sc.nextInt());
        }

        System.out.println(largestRectangle(h));

        sc.close();
    }
} {
    
}
