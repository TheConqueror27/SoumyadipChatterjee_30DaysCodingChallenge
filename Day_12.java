import java.util.*;
class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}
class Pair {
    Node node;
    int hd;

    Pair(Node node, int hd) {
        this.node = node;
        this.hd = hd;
    }
}

public class Day_12 {
    public static Node insert(Node root, int data) {
        if (root == null) {
            return new Node(data);
        }

        if (data <= root.data) {
            root.left = insert(root.left, data);
        } else {
            root.right = insert(root.right, data);
        }

        return root;
    }
    public static void topView(Node root) {
        if (root == null) return;

        Queue<Pair> queue = new LinkedList<>();
        TreeMap<Integer, Integer> map = new TreeMap<>();

        queue.add(new Pair(root, 0));

        while (!queue.isEmpty()) {
            Pair current = queue.poll();

            Node temp = current.node;
            int hd = current.hd;

            if (!map.containsKey(hd)) {
                map.put(hd, temp.data);
            }

            if (temp.left != null) {
                queue.add(new Pair(temp.left, hd - 1));
            }

            if (temp.right != null) {
                queue.add(new Pair(temp.right, hd + 1));
            }
        }

        for (int value : map.values()) {
            System.out.print(value + " ");
        }
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();   
            Node root = null;

            for (int i = 0; i < n; i++) {
                int data = sc.nextInt();
                root = insert(root, data);
            }

            topView(root);
        }
    }
}