import java.util.*;
import java.io.*;

public class Day_07 {
    static TreeMap<Integer, Integer> left = new TreeMap<>();
    static TreeMap<Integer, Integer> right = new TreeMap<>();
    static int leftCount = 0;
    static int rightCount = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        
        String line = br.readLine();
        if (line == null) return;
        int N = Integer.parseInt(line.trim());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String op = st.nextToken();
            int x = Integer.parseInt(st.nextToken());

            if (op.equals("a")) {
                add(x);
                printMedian(out);
            } else {
                if (remove(x)) {
                    printMedian(out);
                } else {
                    out.println("Wrong!");
                }
            }
        }
        out.close();
    }

    private static void add(int x) {
        if (leftCount == 0 || x <= left.lastKey()) {
            left.put(x, left.getOrDefault(x, 0) + 1);
            leftCount++;
        } else {
            right.put(x, right.getOrDefault(x, 0) + 1);
            rightCount++;
        }
        balance();
    }

    private static boolean remove(int x) {
        if (left.containsKey(x)) {
            int count = left.get(x);
            if (count == 1) left.remove(x);
            else left.put(x, count - 1);
            leftCount--;
        } else if (right.containsKey(x)) {
            int count = right.get(x);
            if (count == 1) right.remove(x);
            else right.put(x, count - 1);
            rightCount--;
        } else {
            return false; 
        }
        balance();
        return true;
    }

    private static void balance() {
        if (leftCount > rightCount + 1) {
            int val = left.lastKey();
            removeOne(left, val);
            leftCount--;
            addOne(right, val);
            rightCount++;
        } else if (rightCount > leftCount) {
            int val = right.firstKey();
            removeOne(right, val);
            rightCount--;
            addOne(left, val);
            leftCount++;
        }
    }

    private static void addOne(TreeMap<Integer, Integer> map, int val) {
        map.put(val, map.getOrDefault(val, 0) + 1);
    }

    private static void removeOne(TreeMap<Integer, Integer> map, int val) {
        int count = map.get(val);
        if (count == 1) map.remove(val);
        else map.put(val, count - 1);
    }

    private static void printMedian(PrintWriter out) {
        if (leftCount == 0 && rightCount == 0) {
            out.println("Wrong!");
            return;
        }

        if ((leftCount + rightCount) % 2 != 0) {
            out.println(left.lastKey());
        } else {
            long val1 = left.lastKey();
            long val2 = right.firstKey();
            long sum = val1 + val2;
            
            if (sum % 2 == 0) {
                out.println(sum / 2);
            } else {
                long integral = sum / 2;
                if (sum < 0 && sum % 2 != 0 && integral == 0) {
                    out.println("-0.5");
                } else {
                    out.println(integral + ".5");
                }
            }
        }
    }
}