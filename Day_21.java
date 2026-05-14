public import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class Day_21 {

    static void swapAtK(Node root, int depth, int k) {
        if (root == null) return;

        if (depth % k == 0) {
            Node temp = root.left;
            root.left = root.right;
            root.right = temp;
        }

        swapAtK(root.left, depth + 1, k);
        swapAtK(root.right, depth + 1, k);
    }

    static void inorder(Node root, List<Integer> result) {
        if (root == null) return;

        inorder(root.left, result);
        result.add(root.data);
        inorder(root.right, result);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Node[] nodes = new Node[n + 1];
        for (int i = 1; i <= n; i++) {
            nodes[i] = new Node(i);
        }

        for (int i = 1; i <= n; i++) {
            int left = sc.nextInt();
            int right = sc.nextInt();

            if (left != -1) {
                nodes[i].left = nodes[left];
            }
            if (right != -1) {
                nodes[i].right = nodes[right];
            }
        }

        Node root = nodes[1];

        int t = sc.nextInt();

        while (t-- > 0) {
            int k = sc.nextInt();

            // Swap nodes
            swapAtK(root, 1, k);

            // Inorder traversal
            List<Integer> result = new ArrayList<>();
            inorder(root, result);

            // Print result
            for (int val : result) {
                System.out.print(val + " ");
            }
            System.out.println();
        }

        sc.close();
    }
} {
    
}
