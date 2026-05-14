import java.util.*;

class Node {
    int frequency;
    char data;
    Node left, right;

    Node(char data, int frequency) {
        this.data = data;
        this.frequency = frequency;
        left = right = null;
    }
}

public class Day_28 {

    // Function to decode Huffman encoded string
    void decode(String s, Node root) {

        StringBuilder ans = new StringBuilder();
        Node curr = root;

        for (int i = 0; i < s.length(); i++) {

            // Move left for 0
            if (s.charAt(i) == '0') {
                curr = curr.left;
            }
            // Move right for 1
            else {
                curr = curr.right;
            }

            // If leaf node is reached
            if (curr.left == null && curr.right == null) {
                ans.append(curr.data);
                curr = root;
            }
        }

        // Print decoded string
        System.out.print(ans.toString());
    }

    public static void main(String[] args) {

        /*
                 Root
                /    \
              A       *
                     / \
                    B   C

            Codes:
            A -> 0
            B -> 10
            C -> 11
        */

        Node root = new Node('\0', 0);

        root.left = new Node('A', 5);

        root.right = new Node('\0', 0);
        root.right.left = new Node('B', 2);
        root.right.right = new Node('C', 3);

        String encodedString = "0111010";

        Solution obj = new Solution();

        System.out.print("Decoded String: ");
        obj.decode(encodedString, root);
    }
}