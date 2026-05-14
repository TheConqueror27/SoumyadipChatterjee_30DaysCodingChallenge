import java.util.*;

class SinglyLinkedListNode {
    int data;
    SinglyLinkedListNode next;

    SinglyLinkedListNode(int data) {
        this.data = data;
        this.next = null;
    }
}

public class Day_30 {

    static SinglyLinkedListNode insertNodeAtTail(SinglyLinkedListNode head, int data) {

        // Create new node
        SinglyLinkedListNode newNode = new SinglyLinkedListNode(data);

        // If list is empty
        if (head == null) {
            return newNode;
        }

        // Traverse to last node
        SinglyLinkedListNode temp = head;

        while (temp.next != null) {
            temp = temp.next;
        }

        // Insert at tail
        temp.next = newNode;

        return head;
    }

    // Function to print linked list
    static void printList(SinglyLinkedListNode head) {

        SinglyLinkedListNode temp = head;

        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        SinglyLinkedListNode head = null;

        // Insert elements
        for (int i = 0; i < n; i++) {
            int data = sc.nextInt();
            head = insertNodeAtTail(head, data);
        }

        // Print linked list
        printList(head);

        sc.close();
    }
}