import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int item) {
        data = item;
        left = right = null;
    }
}

public class Day_13 {

    static Node insert(Node root, int data) {
        if (root == null) {
            return new Node(data);
        }

        if (data <= root.data)
            root.left = insert(root.left, data);
        else
            root.right = insert(root.right, data);

        return root;
    }

    static Node lca(Node root, int v1, int v2) {
        while (root != null) {
            if (v1 < root.data && v2 < root.data)
                root = root.left;
            else if (v1 > root.data && v2 > root.data)
                root = root.right;
            else
                return root;
        }
        return null;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Node root = null;

        for (int i = 0; i < n; i++) {
            root = insert(root, sc.nextInt());
        }

        int v1 = sc.nextInt();
        int v2 = sc.nextInt();

        Node ans = lca(root, v1, v2);
        System.out.println(ans.data);

        sc.close();
    }
}