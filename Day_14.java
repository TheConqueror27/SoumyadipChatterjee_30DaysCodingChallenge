import java.util.*;

public class Day_14 {

    public static class MyQueue<T> {
        private Stack<T> stackInbox = new Stack<>();
        private Stack<T> stackOutbox = new Stack<>();

        public void enqueue(T value) {
            stackInbox.push(value);
        }

        public T dequeue() {
            prepareOutbox();
            return stackOutbox.pop();
        }

        public T peek() {
            prepareOutbox();
            return stackOutbox.peek();
        }

        private void prepareOutbox() {
            if (stackOutbox.isEmpty()) {
                while (!stackInbox.isEmpty()) {
                    stackOutbox.push(stackInbox.pop());
                }
            }
        }
    }

    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<>();
        Scanner scanner = new Scanner(System.in);
        
        int q = scanner.nextInt();

        for (int i = 0; i < q; i++) {
            int type = scanner.nextInt();
            if (type == 1) {
                int x = scanner.nextInt();
                queue.enqueue(x);
            } else if (type == 2) {
                queue.dequeue();
            } else if (type == 3) {
                System.out.println(queue.peek());
            }
        }
        scanner.close();
    }
}