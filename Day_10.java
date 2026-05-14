import java.io.*;
import java.util.*;

class SinglyLinkedListNode {
    int data;
    SinglyLinkedListNode next;

    SinglyLinkedListNode(int data) {
        this.data = data;
        this.next = null;
    }
}

class SinglyLinkedList {
    SinglyLinkedListNode head;
    SinglyLinkedListNode tail;

    SinglyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    void insertNode(int data) {
        SinglyLinkedListNode node = new SinglyLinkedListNode(data);

        if (head == null) {
            head = node;
        } else {
            tail.next = node;
        }

        tail = node;
    }
}

public class Day_10 {

    static boolean hasCycle(SinglyLinkedListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        SinglyLinkedListNode slow = head;
        SinglyLinkedListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int tests = sc.nextInt();

        while (tests-- > 0) {
            SinglyLinkedList list = new SinglyLinkedList();

            int index = sc.nextInt();
            int n = sc.nextInt();

            for (int i = 0; i < n; i++) {
                int data = sc.nextInt();
                list.insertNode(data);
            }

            SinglyLinkedListNode extra = null;
            SinglyLinkedListNode temp = list.head;

            for (int i = 0; i < n; i++) {
                if (i == index) {
                    extra = temp;
                }
                if (i != n - 1) {
                    temp = temp.next;
                }
            }

            if (temp != null) {
                temp.next = extra;
            }

            System.out.println(hasCycle(list.head) ? 1 : 0);
        }

        sc.close();
    }
}